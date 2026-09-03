package ru.academits.alaeva.array_list_home;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
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
        // итератор для списка
        Iterator<Integer> iterator = numbers.iterator();

        while (iterator.hasNext()) {
            Integer currentNumber = iterator.next();

            if (currentNumber % 2 == 0) {
                iterator.remove();
            }
        }
    }

    // 3.Есть список из целых чисел, в нём некоторые числа могут повторяться.
    // Cоздать новый список, в котором будут элементы первого списка в таком же порядке, но без повторений
    public static List<Integer> getUniqueNumbers(ArrayList<Integer> numbers) {
        List<Integer> resultList = new ArrayList<>();
        for (Integer number : numbers) {
            if (!resultList.contains(number)) {
                resultList.add(number);
            }
        }
        return resultList;
    }
}
