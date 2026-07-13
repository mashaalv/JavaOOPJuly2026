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

    // вывод диапазона
    public static void printRange(Range range) {
        if (range == null) {
            System.out.println("Range is null.");
            return;
        }
        System.out.println("Диапазон [" + range.getFrom() + "," + range.getTo() + "]");
    }

    // вывод для массива диапазонов
    public static void printRanges(Range[] range) {
        if (range.length == 0) {
            System.out.println("[]");
            return;
        }
        for (int i = 0; i < range.length; i++) {
            printRange(range[i]);
        }
    }

    public static void main(String[] args) {
        // не пересекаются
        Range range1 = new Range(1.5, 10.3);
        Range range2 = new Range(-8, -3);
        //пересекаются
        Range range3 = new Range(1, 10);
        Range range4 = new Range(8, 12);
        //пересекаются по одной точке
        Range range5 = new Range(5, 10);
        Range range6 = new Range(10, 12);

        // тестирование с range1
        printLength(range1);
        printIfInside(-1, range1);
        range1.setFrom(-1);
        System.out.println("После изменения поля через сеттер:");
        printIfInside(-1, range1);
        printLength(range1);

        // тестирование с range 2
        printLength(range2);
        printIfInside(0, range2);
        range2.setTo(0);
        System.out.println("После изменения поля через сеттер:");
        printIfInside(0, range2);
        printLength(range2);

        // тестирование union
        System.out.println();
        System.out.println("Тестирование union:");

        Range[] unionRange3 = range3.union(range4);
        printRanges(unionRange3);
        Range[] unionRange5 = range5.union(range6);
        printRanges(unionRange5);

        // тестирование intersection
        System.out.println();
        System.out.println("Тестирование intersection:");
        Range intersectionRange3 = range3.intersection(range4);
        printRange(intersectionRange3);
        Range intersectionRange5 = range5.intersection(range6);
        printRange(intersectionRange5);

        // тестирование difference
        System.out.println();
        System.out.println("Тестирование difference:");
        Range differenceRange3 = range3.intersection(range4);
        printRange(differenceRange3);
        Range differenceRange5 = range5.intersection(range6);
        printRange(differenceRange5);


    }
}