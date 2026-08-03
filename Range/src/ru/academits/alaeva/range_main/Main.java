package ru.academits.alaeva.range_main;

import ru.academits.alaeva.range.Range;

import java.util.Arrays;

public class Main {
    public static void printIfInside(double point, Range range) {
        if (range.isInside(point)) {
            System.out.println("Точка " + point + " принадлежит диапазону " + range);
        } else {
            System.out.println("Точка " + point + " не принадлежит диапазону " + range);
        }
    }

    public static void printLength(Range range) {
        System.out.println("Длина диапазона " + range + " = " + range.getLength());
    }

    public static void main(String[] args) {
        // интервалы не пересекаются
        Range range1 = new Range(1.5, 10.3);
        Range range2 = new Range(-8, -3);

        //интервалы пересекаются
        Range range3 = new Range(1, 10);
        Range range4 = new Range(8, 12);

        //интервалы касаются в одной точке
        Range range5 = new Range(5, 10);
        Range range6 = new Range(10, 12);

        //интервалы один внутри другого
        Range range7 = new Range(1, 10);
        Range range8 = new Range(4, 6);

        //равные диапазоны
        Range range9 = new Range(4, 6);

        // тестирование длины, сеттеров и точки внутри диапазона
        System.out.println("=== Тестирование задачи Range ===");
        printLength(range1);
        printIfInside(-1, range1);
        range1.setFrom(-1);
        System.out.println("После изменения поля через сеттер:");
        printIfInside(-1, range1);
        printLength(range1);
        range1.setFrom(1.5);
        System.out.println("Вернем диапазон в начальное состояние:");
        System.out.println(range1);

        // тестирование с range 2
        printLength(range2);
        printIfInside(0, range2);
        range2.setTo(0);
        System.out.println("После изменения поля через сеттер:");
        printIfInside(0, range2);
        printLength(range2);
        range2.setTo(-3);
        System.out.println("Вернем диапазон в начальное состояние:");
        System.out.println(range2);

        System.out.println("=== Тестирование задачи Range* ===");
        System.out.println("--- Тестирование union: ---");
        // интервалы не пересекаются -> (-8, -3) и (1.5, 10.3)
        System.out.println(Arrays.toString(range1.union(range2)));
        // интервалы пересекаются (1,10), (8,12) -> (1,12)
        System.out.println(Arrays.toString(range3.union(range4)));
        // касаются в одной точке (5,10), (10,12) -> (5,12)
        System.out.println(Arrays.toString(range5.union(range6)));
        // один внутри другого (1,10), (4,6) -> (1,10)
        System.out.println(Arrays.toString(range7.union(range8)));
        // равные интервалы -> один интервал (4,6)
        System.out.println(Arrays.toString(range8.union(range9)));

        System.out.println("--- Тестирование intersection ---");
        // интервалы не пересекаются -> null
        System.out.println(range1.intersection(range2));
        // пересекаются -> (8,10)
        System.out.println(range3.intersection(range4));
        // касаются в одной точке -> null
        System.out.println(range5.intersection(range6));
        // один внутри другого -> (4,6)
        System.out.println(range7.intersection(range8));
        // равные диапазоны -> (4,6)
        System.out.println(range8.intersection(range9));

        System.out.println("--- Тестирование difference ---");
        // интервалы пересекаются (1,10), (8,12) -> (1,8)
        System.out.println(Arrays.toString(range3.difference(range4)));
        // интервалы пересекаются (8,12), (1,10) -> (10,12)
        System.out.println(Arrays.toString(range4.difference(range3)));
        // интервалы касаются в одной точке (5,10), (10,12) -> (5,10)
        System.out.println(Arrays.toString(range5.difference(range6)));
        // второй внутри первого (1,10), (4,6) -> (1,4) и (6,10)
        System.out.println(Arrays.toString(range7.difference(range8)));
        // первый внутри второго (4,6), (1,10) -> пусто
        System.out.println(Arrays.toString(range8.difference(range7)));
        // равные диапазоны (4,6), (4,6) -> пусто
        System.out.println(Arrays.toString(range9.difference(range8)));
    }
}