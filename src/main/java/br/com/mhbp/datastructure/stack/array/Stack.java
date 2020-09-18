package br.com.mhbp.datastructure.stack.array;

public class Stack<T> {

    T[] array;
    int numOfItems;

    public Stack(){
        array = (T[]) new Object[10];
    }

    void push(T data) {

        if (numOfItems == array.length ) {
            resize(2 * array.length);
        }

        this.array[numOfItems++] = data;
    }

    T pop() {
        if (numOfItems == 0) throw new IllegalStateException("empty stack");
        T poped = array[numOfItems];
        array[numOfItems--] = null;

        if (numOfItems <= array.length/4) resize(array.length/2);

        return poped;
    }

    private void resize(int newSize) {
        T[] newArray = (T[]) new Object[newSize];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }
}
