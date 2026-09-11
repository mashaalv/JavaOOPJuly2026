package ru.academits.alaeva.array_list_home;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListHome {
    // 1. Прочитать в список все строки из файла
    public static List<String> readLinesFromFile(String fileName) throws IOException {
        // создаем список для строк из файла:
        List<String> lines = new ArrayList<>();
        // читаем построчно из файла:
        try (BufferedReader reader = Files.newBufferedReader(Path.of(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }

        return lines;
    }

    // 2. Есть список из целых чисел. Удалить из него все четные числа. В этой задаче новый список создавать нельзя
    public static void removeEvenNumbers(ArrayList<Integer> numbers) {
        for (int i = numbers.size() - 1; i >= 0; i--) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
            }
        }
    }

    // 3. Есть список из целых чисел, в нём некоторые числа могут повторяться.
    // Создать новый список, в котором будут элементы первого списка в таком же порядке, но без повторений
    public static <T> List<T> getUniqueElements(ArrayList<T> elements) {
        List<T> resultList = new ArrayList<>(elements.size());

        for (T element : elements) {
            if (!resultList.contains(element)) {
                resultList.add(element);
            }
        }

        return resultList;
    }

    public static void main(String[] args) {
        // 1. тест Часть1 =======
        try {
            List<String> lines = ArrayListHome.readLinesFromFile("input1.txt");
            System.out.println("Содержимое файла:");
            System.out.println(lines);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }

        // 2. тест Часть 2 ===========
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 54, -8, 10, 3, 4, 9, 5, 666, 667));
        System.out.println("Исходный список четных чисел:");
        System.out.println(numbers);
        ArrayListHome.removeEvenNumbers(numbers);
        System.out.println("Список после удаления четных чисел:");
        System.out.println(numbers);

        // 3. тест Часть 3 ===========
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(4, 52, 4, 89, -1, 1, 1, 2, 2, 2, 3, 4, 1, 2, 5, 4));
        System.out.println("Исходный список:");
        System.out.println(list);
        System.out.println("Новый список без повторений:");
        System.out.println(ArrayListHome.getUniqueElements(list));
    }
}