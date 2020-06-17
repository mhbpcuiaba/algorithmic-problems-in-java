package br.com.mhbp.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapSort<E extends Comparable<E>> {

    List<E> elements = new ArrayList<>();

    public static <E extends Comparable<E>> List<E> sort(Iterable<E> elements) {

        HeapSort<E> heap = of(elements);

        List<E> result = new ArrayList<>();

        while (!heap.isEmpty()) {
            result.add(heap.pop());
        }

        return result;
    }

    public static <E extends Comparable<E>> HeapSort<E> of(E... elements) {
        return of(Arrays.asList(elements));
    }

    public static <E extends Comparable<E>> HeapSort<E> of(Iterable<E> elements) {
        HeapSort<E> result = new HeapSort<>();
        for (E element : elements) {
            result.add(element);
        }
        return result;
    }
    public void add(E e) {
        elements.add(e);
        int elementIndex = elements.size() - 1;
        while (!isRoot(elementIndex) && !isCorrectChild(elementIndex)) {
            int parentIndex = parentIndex(elementIndex);
            swap(elementIndex, parentIndex);
            elementIndex = parentIndex;
        }
    }
    public E pop() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty!!!");
        E result = elementAt(0);

        int lastElementIndex = elements.size() - 1;
        swap(0, lastElementIndex);
        elements.remove(lastElementIndex);

        int elementIndex = 0;

        while (!isLeaf(elementIndex) && !isCorrectParent(elementIndex)) {
            int smallerChildIndex = smallerChildIndex(elementIndex);
            swap(elementIndex, smallerChildIndex);
            elementIndex = smallerChildIndex;
        }

        return result;
    }
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    private boolean isRoot(int index) {
        return index == 0;
    }

    private boolean isLeaf(int index) {
        return !isValidIndex(leftChildIndex(index));
    }

    private boolean isValidIndex(int index) {
        return  index < elements.size();
    }

    private E elementAt(int index) {
        return elements.get(index);
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int rightChildIndex(int index) {
//      return index * 2 + 2;
        return leftChildIndex(index) + 1;
    }

    private void swap(int index1, int index2) {
        E tmp1 = elementAt(index1);
        E tmp2 = elementAt(index2);
        elements.set(index1, tmp2);
        elements.set(index2, tmp1);
    }

    private boolean isCorrect(int parentindex, int childIndex) {
        if (!isValidIndex(parentindex) || !isValidIndex(childIndex)) {
            return true;
        }

        return elementAt(parentindex).compareTo(elementAt(childIndex)) < 0;
    }

    private boolean isCorrectChild(int index) {
        return isCorrect(parentIndex(index), index);
    }

    private boolean isCorrectParent(int index) {
        return isCorrect(index, leftChildIndex(index)) && isCorrect(index, rightChildIndex(index));
    }

    private int smallerChildIndex(int index) {
        int leftChildIndex = leftChildIndex(index);
        int rightChildIndex = rightChildIndex(index);

        if (!isValidIndex(rightChildIndex)) return leftChildIndex;

        if (elementAt(leftChildIndex).compareTo(elementAt(rightChildIndex)) < 0) return leftChildIndex;

        return rightChildIndex;
    }
}
