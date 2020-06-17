package br.com.mhbp.sorting;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

//https://github.com/ahmet-uyar/parallel-merge-sort/blob/master/src/main/java/auyar/pms/MergeSortWithForkJoinSTM2.java
public class ParallelMergeSortWithForkJoin extends RecursiveAction {

    private int threadID;
    private int start;
    private int length;
    private long[] array;
    private long[] aux;
    private int numberOfLeafThreads;

    public ParallelMergeSortWithForkJoin(int id, long[] array, long[] aux, int threads) {
        this.threadID = id;
        this.array = array;
        this.aux = aux;
        this.numberOfLeafThreads = threads;
    }

    public static void parallelMergeSort(long[] array, int numberOfThreads) {
        long[] aux = new long[array.length];
        ParallelMergeSortWithForkJoin parallelMerge = new ParallelMergeSortWithForkJoin(1, array, aux, numberOfThreads);
        ForkJoinPool.commonPool().invoke(parallelMerge);
    }

    @Override
    protected void compute() {

        if (threadID >= numberOfLeafThreads) {
            sortSequentially();
            return;
        }

        ParallelMergeSortWithForkJoin leftAction = new ParallelMergeSortWithForkJoin(2 * threadID, array, aux, numberOfLeafThreads);
        ParallelMergeSortWithForkJoin rightAction = new ParallelMergeSortWithForkJoin(2 * threadID + 1, array, aux, numberOfLeafThreads);
        invokeAll(leftAction, rightAction);
        merge(array, aux, leftAction.start, rightAction.start, rightAction.start + rightAction.length);
        start = leftAction.start;
        length = leftAction.length + rightAction.length;
    }

    private void merge(long[] array, long[] aux, int start, int start1, int i) {

    }

    private void sortSequentially() {


        int blockSize = array.length / numberOfLeafThreads; // the size of the sub array that will be sorted sequentially
        int firstLeafNode = numberOfLeafThreads;
        int lastNodeID = numberOfLeafThreads * 2 - 1;
        int treeHeight = (int) (Math.log(lastNodeID)/Math.log(2));
        int firstNodeOfLastLevel = (int) Math.pow(2, treeHeight);
        int nodesInLastLevel = lastNodeID - firstNodeOfLastLevel + 1;

        if (threadID >= firstNodeOfLastLevel)
            start = (threadID - firstNodeOfLastLevel) * blockSize;
        else
            start = (nodesInLastLevel + threadID - firstLeafNode) * blockSize;

        length = blockSize;

        if (checkPowerOfTwo(threadID + 1))
            length = array.length - start;

        Arrays.sort(array, start, start + length);
    }

    private boolean checkPowerOfTwo(int i) {
        return false;
    }
}
