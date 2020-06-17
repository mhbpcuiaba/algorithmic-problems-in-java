package br.com.mhbp.arrays_primitives_strings.arrays.circular;

import java.util.AbstractList;
import java.util.Collection;

public class CircularArrayList<E> extends AbstractList<E> {

    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size;
    private int head = 0;
    private int tail;//??

    public  CircularArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public CircularArrayList(int initialCapacity) {
        elements = new Object[initialCapacity];
        size = 0;
    }

    public CircularArrayList(Collection<? extends E> collection) {
        elements = collection.toArray();
        size = elements.length;
    }

    @Override
    public E get(int i) {
        checkIndexRange(i);
        int realIndex = calculateRealIndex(i);
        return (E) elements[realIndex];
    }

    //use  bit masking to become faster
    private int calculateRealIndex(int i) {
        return (head + i) % elements.length;
    }

    @Override
    public int size() {
        return size ;
    }

    @Override
    public E set(int index, E newElement) {
        checkIndexRange(index);
        int realIndex = calculateRealIndex(index);
        E old = (E) elements[realIndex];
        elements[realIndex] = newElement;
        return old;
    }

    @Override
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();

        ensureCapacity();

        int realIndex = calculateRealIndex(index);

        if (index != size) {

            if ( index == 0) {
                moveHead(-1);
                realIndex = calculateRealIndex(index);
            } else if (realIndex > head && head != 0) {
                System.arraycopy(elements, head, elements, head - 1, index);
                moveHead(-1);
            } else {
                System.arraycopy(elements, realIndex, elements, realIndex + 1, size - index);
            }
        }

        elements[realIndex] = e;
        size++;
        modCount++;
    }

    private void moveHead(int steps) {
        head += steps;
        head %= elements.length;
        if (head < 0) head += elements.length;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            Object[] newElements = new Object[(elements.length + 1) * 3 / 2];
            System.arraycopy(elements, head, newElements, 0, elements.length -head);
            System.arraycopy(elements, 0, newElements, elements.length - head, head);
        }
    }


    @Override
    public E remove(int index) {
        checkIndexRange(index);
        int realIndex = calculateRealIndex(index);

        E old = (E) elements[realIndex];

        if (index == size -1) {
            elements[realIndex] = null;
        } else if ( index == 0) {
            elements[realIndex] = null;
            moveHead(1);
        } else if (realIndex > head) {
            System.arraycopy(elements, head, elements, head + 1, index);
            elements[head] =null;
            moveHead(+1);
        } else {
            System.arraycopy(elements, realIndex + 1, elements, realIndex, size - index);
            elements[calculateRealIndex(size - 1)] = null;        elements[size - 1] = null;

        }

        size--;
        modCount++;
        return old;
    }

    private void checkIndexRange(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
    }
}
