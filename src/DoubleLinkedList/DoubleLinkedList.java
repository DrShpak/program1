package DoubleLinkedList;

import java.util.function.Consumer;

public class DoubleLinkedList implements Cloneable, ListUtils {

    private class ListElement {
        Object value;
        ListElement next;
        ListElement prev;

        ListElement(Object value, ListElement next, ListElement prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        ListElement(Object value) {
            this(value, null, null);
        }
    }

    private ListElement head = null;
    private ListElement last = null;

    public void add(Object o) {
        ListElement newElement = new ListElement(o);
        if (head == null || head.value == null) {
            head = newElement;
            last = head;
        } else {
            newElement.prev = last;
            last.next = newElement;
            last = newElement;
        }
    }

    @Override
    public void forEach(Consumer<String> print) {
        ListElement curr = head;
        while (curr != null) {
            print.accept(curr.value + " ");
            curr = curr.next;
        }
    }

    public int size() {
        int count = 0;
        try {
            for (ListElement element = head; element != null; element = element.next) {
                count++;
            }
            return count;
        } catch (NullPointerException e) {
            return 0;
        }
    }

    //удаляет 1-ое вхождение данного элемента
    public void remove(Object o) {
        if (isEmpty()) {
            System.out.println("Список пуст! Удаление невозможно!");
        } else {
            for (ListElement element = head; element != null; element = element.next) {
                if (element.value.equals(o)) {
                    if (element == head) {
                        head = head.next;
                        head.prev = null;
                    } else if (element == last) {
                        last = element.prev;
                        last.next = null;
                    } else {
                        element.prev.next = element.next;
                        element.next.prev = element.prev;
                    }
                }
            }
        }
    }

    @Override
    public boolean contains(Object o) {
        for (ListElement node = head; node != null; node = node.next) {
            if (node.value.equals(o)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Object get(int index) {
        /*if (index >= 0 && index < size()) {
            ListElement item = head;
            for (int i = 0; i < index; i++) {
                item = item.next;
            }
            return item.value;
        } else {
            System.out.println("Такого индекса не существует");
            return -1;
        }*/

//        if (index >= )
        rangeCheck(index);
        ListElement item = head;
        for (int i = 0; i < index; i++) {
            item = item.next;
        }
        return item.value;
    }

    private void rangeCheck(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size();
    }

    public void add(Object o, int index) {
        rangeCheck(index);

        ListElement newElement = new ListElement(o);
        ListElement item = head;
        for (int i = 0; i < index; i++) {
            item = item.next;
        }

        ListElement temp;
        if (item == head) {
            temp = head;
            head = newElement;
            head.next = temp;
            temp.prev = head;
        } else {
            newElement.next = item;
            newElement.prev = item.prev;
            item.prev.next = newElement;
        }
    }

    public DoubleLinkedList cloneList() {
        DoubleLinkedList clone = new DoubleLinkedList();
        ListElement curr = head;
        for (int i = 0; i < size(); i++) {
            clone.add(curr.value);
            curr = curr.next;
        }
        return clone;
    }

    public void clear() {
        head = null;
    }

    public void sort() {

    }
}