package ru.academits.alaeva.array_list_home_main;

import ru.academits.alaeva.array_list_home.ArrayListHome;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. тест Часть1 ======= Прочитать в список все строки из файла
        // создаем список для строк из файла:
        ArrayList<String> arraylistLines = new ArrayList<>();

        // читаем построчно из файла:
        try (BufferedReader reader = Files.newBufferedReader(Path.of("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                arraylistLines.add(line);
            }
            // Выводим результат
            System.out.println("Содержимое файла:");
            System.out.println(arraylistLines);

        } catch (IOException e) {
            //throw new RuntimeException(e);
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }

        // 2. тест Часть 2 ===========
        ArrayList<Integer> numbers=new ArrayList<>(Arrays.asList(1, 54, -8, 10, 3, 4,9,5,666,667));
        System.out.println("Список до удаления четных чисел:");
        System.out.println(numbers);
        ArrayListHome.removeEvenNumbers(numbers);
        System.out.println("Список после удаления четных чисел:");
        System.out.println(numbers);

    }
}
