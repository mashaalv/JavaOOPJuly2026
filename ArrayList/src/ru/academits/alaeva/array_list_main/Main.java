package ru.academits.alaeva.array_list_main;

import ru.academits.alaeva.array_list.ArrayList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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
        list2.add(1, -8);
        // list2.add(5,-8); // некорректный индекс
        System.out.println("Добавили элемент по индексу 1 в список list2: " + list2.get(1));

        // метод remove
        System.out.println("Длина списка " + list1.size());
        System.out.println("Удаляем элементы по индексу 0: " + list1.remove(0));
        System.out.println("get(0): " + list1.get(0));
        System.out.println("Длина списка после удаления: " + list1.size());
        System.out.println("Удаляем элементы по индексу 1: " + list1.remove(1));
        //System.out.println("get(1): " + list1.get(1)); // некорректный индекс

        // toString
        ArrayList<String> stringList = new ArrayList<>(100);
        System.out.println("Пустой список: " + stringList);

        stringList.add("q");
        stringList.add("w");
        stringList.add("e");
        System.out.println("Ожидаемый результат: список [q, w, e], фактический результат: " + stringList);
        stringList.add(null);
        System.out.println("Ожидаемый результат [q, w, e,null]: " + stringList);
        stringList.remove(3);
        stringList.add("r");
        stringList.add("t");
        stringList.add("y");
        stringList.add("u");
        System.out.println("Ожидаемый результат [q, w, e, r, t, y, u]: " + stringList);

        // trimToSize
        System.out.println("Capacity до trimToSize(): " + stringList.capacity());
        stringList.trimToSize();
        System.out.println("Capacity после trimToSize(): " + stringList.capacity());

        // ensureCapacity
        System.out.println("Capacity до ensureCapacity(): " + stringList.capacity());
        stringList.ensureCapacity(20);
        System.out.println("Capacity после ensureCapacity(): " + stringList.capacity());

        // clear
        System.out.println("Список до очистки:" + stringList + ", размер списка: " + stringList.size());
        stringList.clear();
        System.out.println(stringList + ", isEmpty(): " + stringList.isEmpty());
        System.out.println(stringList.size());
        stringList.add("q");
        stringList.add("w");
        stringList.add("e");
        stringList.add("r");
        stringList.add("u");
        stringList.add("t");
        stringList.add("y");
        stringList.add("u");
        stringList.add("q");

        // contains, remove, indexOf, lastIndexOf
        System.out.println("Список:" + stringList + ", размер списка: " + stringList.size());
        System.out.println("indexOf q: " + stringList.indexOf("q"));
        System.out.println("contains q? " + stringList.contains("q"));
        System.out.println("contains null? " + stringList.contains(null));
        System.out.println("remove q? " + stringList.remove("q"));
        System.out.println("Список: " + stringList + ", размер списка: " + stringList.size());
        System.out.println("lastIndexOf u: " + stringList.lastIndexOf("u"));
        System.out.println("lastIndexOf l (элемента нет в списке): " + stringList.lastIndexOf("l"));

        // toArray()
        Object[] testStringArray = stringList.toArray();
        System.out.println("stringList.toArray(): " + Arrays.toString(testStringArray));

        //  containsAll(Collection<?> c)
        String[] subArray = new String[]{"w", "e"};
        List<String> subList = Arrays.asList(subArray);
        System.out.println("containsAll [\"w\", \"e\"]: " + stringList.containsAll(subList));

        // adAll
        stringList.addAll(subList);
        System.out.println("Список [w, e, r, u, t, y, u, q] после addAll: " + stringList);

        System.out.println("Cписок list2 до addAll: " + list2);
        List<Integer> list3 = Arrays.asList(1, 2, 3);
        list2.addAll(1, list3);
        System.out.println("Cписок list2 после addAll: " + list2);

        // remove all
        stringList.removeAll(subList);
        System.out.println("Список [w, e, r, u, t, y, u, q, w, e] после removeAll [\"w\", \"e\"]: " + stringList);

        // retain all
        stringList.add(2, "w");
        stringList.add(5, "e");
        System.out.println("subList: " + subList + ", stringList до retainAll: " + stringList);
        stringList.retainAll(subList);
        System.out.println("Список после retainAll [\"w\", \"e\"]: " + stringList);

        // итератор
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Абрикос");
        fruits.add("Банан");
        fruits.add("Хурма");
        fruits.add("Вишня");
        System.out.println("Список fruits: " + fruits);

        Iterator<String> iterator = fruits.iterator();

        while (iterator.hasNext()) {
            String string = iterator.next();

            if (string.equals("Хурма")) {
                iterator.remove();
            }
        }

        // for-each
        System.out.println("Список после удаления элемента черeз iterator:");

        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}