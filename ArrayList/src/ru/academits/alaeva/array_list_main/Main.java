package ru.academits.alaeva.array_list_main;

import ru.academits.alaeva.array_list.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>(2);

        list1.add("aa");
        list1.add("bb");
        list1.add("cc"); // увеличение capacity
        System.out.println("Длина списка " + list1.size());
        System.out.println("Нулевой элемент списка через get(0) " + list1.get(0));
        System.out.println("Установим нулевой элемент списка через set(0), значение:" + list1.set(0, "oo"));  // "aa"
        System.out.println("После set(0): " + list1.get(0)); // "ooo"


        //list1.set(-5);
        // System.out.println(list1);
        ArrayList<Integer> list2 = new ArrayList<>(0);
        list2.add(100);
        System.out.println("Размер list2: " + list2.size());


    }
}
