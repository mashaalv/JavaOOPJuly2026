package ru.academits.alaeva.array_list_home;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListHome {

    // 2. Есть список из целых чисел. Удалить из него все четные числа. В этой задаче новый список создавать нельзя
    public static void removeEvenNumbers(ArrayList<Integer> numbers) {

       /* for (Integer number : numbers) {
            if(number%2==0){
                numbers.remove(number);
            }
        }//так делать нельзя*/

        // итератор для списка
        Iterator<Integer> iterator = numbers.iterator();


        while (iterator.hasNext()) {
            Integer currentNumber = iterator.next();

            if (currentNumber % 2 == 0) {
                iterator.remove();
            }
        }

    }

}
