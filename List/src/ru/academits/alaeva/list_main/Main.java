package ru.academits.alaeva.list_main;

import ru.academits.alaeva.list.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = new List<>();

        try {
            list1.getData(0); // exception
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        // тест - вставка элемента в начало
        list1.addFirst(0);
        list1.addFirst(-1);
        list1.addFirst(2);
        list1.addFirst(5);
        list1.addFirst(4);
        // тест toString
        System.out.println("Список " + list1);
        System.out.println("Размер списка: " + list1.getSize()); // 5

        // Тестируем getData
        System.out.println("getFirst(): " + list1.getFirst()); // 4
        System.out.println("getData(1): " + list1.getData(1)); // 5

        // Тестируем setData
        System.out.println("setData(1, 99): " + list1.setData(1, 99)); // 5
        System.out.println("После setData: " + list1);

        // Тестируем удаление первого
        System.out.println("removeFirst(): " + list1.removeFirst()); //4
        System.out.println("После removeFirst(): " + list1); // [99, 2, -1, 0]

        // Тестируем удаление по индексу
        System.out.println("remove(1): " + list1.remove(1)); // 2
        System.out.println("После remove: " + list1); // [99,-1,0]

        // Тестируем удаление по значению
        System.out.println("removeByValue(100): " + list1.removeByValue(100)); // false
        System.out.println("После removeByValue(1): " + list1); // [99,-1,0]
        System.out.println("removeByValue(99): " + list1.removeByValue(99)); // true

        List<Integer> testList = new List<>();
        testList.add(0, 1);
        testList.add(0, null);
        System.out.println("До удаления null - testList:" + testList);
        System.out.println("testList.removeByValue(null): " + testList.removeByValue(null)); // true
        System.out.println("После удаления null - testList:" + testList);

        // Тестируем разворот
        List<String> list2 = new List<>();
        list2.addFirst("a");
        list2.addFirst("s");
        list2.addFirst("d");
        list2.addFirst("f");
        System.out.println("До разворота " + list2);
        list2.reverse();
        System.out.println("После разворота " + list2);
        // разворот на пустом списке:
        List<Integer> list = new List<>();
        list.reverse();
        System.out.println("Пустой список (разворот): " + list);

        // Тестируем копирование
        List<Integer> copyList = list.copy(); // скопирируем пустой список
        System.out.println("Копия пустого списка list: " + copyList); // []
        List<String> copyList2 = list2.copy();
        System.out.println("Исходный список list2: " + list2);
        System.out.println("Копия list2: " + copyList2 + ", размер списка list2: " + list2.getSize()); // [a,s, d, f]
        list2.add(4, "w");
        System.out.println("Проверим, что списки независимы, поменяем list2: " + list2);
        System.out.println("Копия list2 не изменилась: " + copyList2);
    }
}