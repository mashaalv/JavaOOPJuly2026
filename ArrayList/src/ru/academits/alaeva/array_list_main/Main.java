package ru.academits.alaeva.array_list_main;

import ru.academits.alaeva.array_list.ArrayList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>(2);

        list1.add("aa");
        list1.add("bb");
        list1.add("cc"); // увеличение capacity
        System.out.println("Длина списка " + list1.size());
        System.out.println("Нулевой элемент списка через get(0) " + list1.get(0));
        System.out.println("Установим нулевой элемент списка через set(0), старое значение:" + list1.set(0, "oo"));  // "aa"
        System.out.println("После изменений через set(0), значение элемента по индексу 1: " + list1.get(0)); // "ooo"

        //list1.set(-5);
        ArrayList<Integer> list2 = new ArrayList<>(0);
        list2.add(100);
        System.out.println("Размер list2: " + list2.size());
        list2.add(1,-8);
        // list2.add(5,-8); // некорректный индекс
        System.out.println("Добавили элемент по индексу 1 в список list2: "+list2.get(1));

        // метод remove
        System.out.println("Длина списка " + list1.size());
        System.out.println("Удаляем элементы по индексу 0: " + list1.remove(0));
        System.out.println("get(0): " + list1.get(0));
        System.out.println("Длина списка после удаления: " + list1.size());
        System.out.println("Удаляем элементы по индексу 1: " + list1.remove(1));
        //System.out.println("get(1): " + list1.get(1)); // некорректный индекс

        // toString
        ArrayList<String> listTestString = new ArrayList<>(100);
        System.out.println("Пустой массив: "+ listTestString);

        listTestString.add("q");
        listTestString.add("w");
        listTestString.add("e");
        System.out.println("массив [q, w, e]: "+ listTestString);
        listTestString.add(null);
        System.out.println("массив [q, w, e,null]: "+ listTestString);
        listTestString.remove(3);
        listTestString.add("r");
        listTestString.add("t");
        listTestString.add("y");
        listTestString.add("u");
        System.out.println("массив [q, w, e, r, t, y, u]: "+ listTestString);

        // trimToSize
        System.out.println("Capacity до trimToSize(): "+listTestString.capacity());
        listTestString.trimToSize();
        System.out.println("Capacity после trimToSize(): "+listTestString.capacity());

        // ensureCapacity
        System.out.println("Capacity до ensureCapacity(): "+listTestString.capacity());
        listTestString.ensureCapacity(20);
        System.out.println("Capacity после ensureCapacity(): "+listTestString.capacity());

        // clear
        System.out.println("Список до очистки:"+listTestString+", размер списка: "+listTestString.size());
        listTestString.clear();
        System.out.println(listTestString+", isEmpty(): "+listTestString.isEmpty());
        System.out.println(listTestString.size());
        listTestString.add("a");



    }
}
