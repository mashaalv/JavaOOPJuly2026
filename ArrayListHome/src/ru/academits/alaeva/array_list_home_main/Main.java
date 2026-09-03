package ru.academits.alaeva.array_list_home_main;

import ru.academits.alaeva.array_list_home.ArrayListHome;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. тест Часть1 =======
        try {
            List<String> lines = ArrayListHome.readLinesFromFile("input1.txt");
            System.out.println("Содержимое файла:");
            System.out.println(lines);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
        // 2. тест Часть 2 ===========
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 54, -8, 10, 3, 4, 9, 5, 666, 667));
        System.out.println("Список до удаления четных чисел:");
        System.out.println(numbers);
        ArrayListHome.removeEvenNumbers(numbers);
        System.out.println("Список после удаления четных чисел:");
        System.out.println(numbers);

        // 3. тест Часть 3 ===========
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(4, 52, 4, 89, -1, 1, 1, 2, 2, 2, 3, 4, 1, 2, 5, 4));
        System.out.println("Список до удаления повторений");
        System.out.println(list);

        System.out.println("Список после удаления повторений");
        System.out.println(ArrayListHome.getUniqueNumbers(list));
    }
}