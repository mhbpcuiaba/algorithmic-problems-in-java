package br.com.mhbp.cache;

import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Supplier;

public class ReservedCachingScheme<K, V> {

    private  final V reserved;
    private Map<K, V> map = new ConcurrentHashMap<>();

    private class ReservedBlocker implements ForkJoinPool.ManagedBlocker {

        private V result;
        private final K n;

        private ReservedBlocker(K n) {
            this.n = n;
        }


        @Override
        public boolean block() throws InterruptedException {
            synchronized (map) {
                while (!isReleasable()) map.wait();
            }
            return true;
        }

        @Override
        public boolean isReleasable() {
            return !(result = map.get(n)).equals(reserved);
        }

        public void setResult(V result) {
            this.result = result;
        }
    }
    public ReservedCachingScheme(V reserved) {
        this.reserved = reserved;
    }

    public V calculate(K n, Supplier<V> supplier) {
        V result = map.putIfAbsent(n, supplier.get());

        if (result == null) {
            result = supplier.get();
            map.replace(n, reserved, result);

            synchronized (map) {
                map.notifyAll();
            }

        } else if (result.equals(reserved)) {

            try {
                ReservedBlocker blocker = new ReservedBlocker(n);
                blocker.block();
//                ForkJoinPool.managedBlock(blocker);
                result = blocker.result;
            } catch (InterruptedException e) {
                throw new CancellationException("interrupted ");
            }
        }
        return  result;
    }
}
