package ru.academits.alaeva.range_main;

import ru.academits.alaeva.range.Range;

public class Main {
    public static void printIfInside(double pointX, Range range) {

        if (range.isInside(pointX)) {
            System.out.println("Точка " + pointX + " принадлежит диапазону [" + range.getFrom() + "," + range.getTo() + "]");

        } else {
            System.out.println("Точка " + pointX + " не принадлежит диапазону [" + range.getFrom() + "," + range.getTo() + "]");
        }
    }

    public static void printLength(Range range) {
        System.out.println("Длина диапазона [" + range.getFrom() + "," + range.getTo() + "] = " + range.getLength());
    }

    // Вывод одного интервала
    public static void printRange(Range range) {
        System.out.println("Диапазон " + rangeToString(range));
    }

    public static String rangeToString(Range range) {
        if (range == null) {
            return "null";
        }
        return "[" + range.getFrom() + "," + range.getTo() + "]";
    }

    // вывод массива интервалов
    public static void printRanges(Range[] ranges) {
        if (ranges == null) {
            System.out.println("Range is null.");
        }
        if (ranges.length == 0) {
            System.out.println("[]");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();// ffffffffffffff
        for (int i = 0; i < ranges.length; i++) {
            stringBuilder.append(rangeToString(ranges[i]));
            if (i < ranges.length - 1) {
                stringBuilder.append(", ");
            }
        }
        System.out.println(stringBuilder.toString());
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
        printRange(range1);
        // тестирование с range 2
        printLength(range2);
        printIfInside(0, range2);
        range2.setTo(0);
        System.out.println("После изменения поля через сеттер:");
        printIfInside(0, range2);
        printLength(range2);
        range2.setTo(-3);
        System.out.println("Вернем диапазон в начальное состояние:");
        printRange(range2);
        // === Тестирование задачи Range* ===
        System.out.println("=== Тестирование задачи Range* ===");
        // тестирование union
        System.out.println("--- Тестирование union: ---");
        // интервалы не пересекаются-> два отдельных (-8,-3) и (1.5, 10.3)
        Range[] unionRange1 = range1.union(range2);
        printRanges(unionRange1);
        // интервалы пересекаются (1,10), (8,12) -> (1,12)
        Range[] unionRange3 = range3.union(range4);
        printRanges(unionRange3);
        //касаются в одной точке (5,10), (10,12) -> (5,12)
        Range[] unionRange5 = range5.union(range6);
        printRanges(unionRange5);
        // один внутри другого (1,10), (4,6)-> (1,10)
        Range[] unionRange7 = range7.union(range8);
        printRanges(unionRange7);
        // равные интервалы-> один интервал (4,6)
        Range[] unionRange8 = range8.union(range9);
        printRanges(unionRange8);

        // тестирование intersection
        System.out.println("--- Тестирование intersection ---");
        // интервалы не пересекаются(-8,-3) и (1.5, 10.3)-> null
        Range intersectionRange1 = range1.intersection(range2);
        printRange(intersectionRange1);
        //пересекаются -> (8,10)
        Range intersectionRange3 = range3.intersection(range4);
        printRange(intersectionRange3);
        //касаются в одной точке (5,10), (10,12) -> null
        Range intersectionRange5 = range5.intersection(range6);
        printRange(intersectionRange5);
        // один внутри другого (1,10), (4,6)-> (4,6)
        Range intersectionRange7 = range7.intersection(range8);
        printRange(intersectionRange7);
        // равные диапазоны -> (4,6)
        Range intersectionRange8 = range8.intersection(range9);
        printRange(intersectionRange8);

        // тестирование difference
        System.out.println("--- Тестирование difference ---");
        //интервалы пересекаются (1,10), (8,12) -> (1,8)
        Range[] differenceRange3 = range3.difference(range4);
        printRanges(differenceRange3);
        //интервалы пересекаются (8,12), (1,10) -> (10,12)
        Range[] differenceRange4 = range4.difference(range3);
        printRanges(differenceRange4);
        //интервалы касаются в одной точке (5,10), (10,12) -> (5,10)
        Range[] differenceRange5 = range5.difference(range6);
        printRanges(differenceRange5);
        //второй внутри первого (1,10), (4,6) -> (1, 4) и (6,10)
        Range[] differenceRange7 = range7.difference(range8);
        printRanges(differenceRange7);
        //первый внутри второго (4,6), (1,10) -> пусто
        Range[] differenceRange8 = range8.difference(range7);
        printRanges(differenceRange8);
        //равные диапазоны (4,6), (4,6) -> пусто
        Range[] differenceRange9 = range9.difference(range8);
        printRanges(differenceRange9);
    }
}