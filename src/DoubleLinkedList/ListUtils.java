package DoubleLinkedList;

import java.util.function.Consumer;

public interface ListUtils {

    int size();

    void add(Object o);

    void add(Object o, int index);

    void remove(Object o);

    boolean contains(Object o);

    boolean isEmpty();

    void clear();

    void forEach(Consumer<String> c);

    void sort();
}
