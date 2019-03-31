package DoubleLinkedList;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list.get(2));
        list.add(10,0);
        System.out.println(list.get(0));
        list.forEach(System.out::print);

        System.out.println();
        list.add(20, 1);
        list.add(30);
        list.remove(20);
        list.forEach(System.out::print);
        System.out.println("\nLength = " + list.size());

        DoubleLinkedList clone = list.cloneList();
        System.out.println();
        clone.forEach(System.out::print);
        System.out.println();

        System.out.println(list.contains(10));
        System.out.println(list.contains(100));

        System.out.println();
        list.clear();
        list.add(100);
        list.add(50);
        list.forEach(System.out::print);

        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.
    }
}
