package br.com.mhbp.desingpatterns.abstractclass;

import java.util.AbstractList;
import java.util.ArrayDeque;
import java.util.Objects;

public class ReadOnlyArrayList<E> extends AbstractList {

    private Object[] elements;

    public ReadOnlyArrayList(Object... elements) {

        this.elements = elements.clone();//bit type of Prototype Design Pattern
    }

    @Override
    public E get(int index) {
//        Objects.checkIndex(index, size());
        return (E) elements[index];
    }

    @Override
    public int size() {
        return elements.length;
    }

    ArrayDeque ad;
}


interface C {

    static int d () {
        return 1;
    }


    int p = 30;

    class CC {

    }
}