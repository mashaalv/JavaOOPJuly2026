package ru.academits.alaeva.vector_main;

import ru.academits.alaeva.vector.Vector;

public class Main {
    public static void main(String[] args) {
        // тест - обработка исключения
        try {
            Vector vector = new Vector(-1);

        } catch (IllegalArgumentException e) {
            System.out.println("Поймали исключение: " + e.getMessage());
        }

        Vector vector1 = new Vector(2); // тест конструктор1
        System.out.println("Vector 1:  " + vector1);

        double[] components2 = {1, 2, 100};
        Vector vector2 = new Vector(components2);// тест конструктора 3
        Vector vector2Copy = new Vector(vector2);// тест конструктора 2
        System.out.println("Vector 2:  " + vector2);
        System.out.println("Vector 2 copy:  " + vector2Copy);

        vector2.setComponent(2, 3);// setComponent
        System.out.println("Вторая компонента vector2 после set: " + vector2.getComponent(2));// getComponent
        System.out.println("Vector 2:  " + vector2);

        Vector vector3 = new Vector(2, new double[]{1, 2});// тест конструктор 4
        System.out.println("Vector 3:  " + vector3);// {1.0, 2.0}

        // Vector v1 = new Vector(-1, components2); // тест исключение
        // Vector v2 = new Vector(3, null); // тест исключение

        // Нестатическое сложение векторов
        vector2.add(vector3);
        System.out.println("vector2.add(vector3) " + vector2);

        // Нестатическое вычитание векторов
        System.out.println("Vector 2:  " + vector2);
        vector3.subtract(vector2);
        System.out.println("vector3.substract(vector2): " + vector3);

        // Нестатический метод - умножение на скаляр
        System.out.println("Vector 2:  " + vector2);
        vector2.multiply(3.1);
        System.out.println("vector2.multiply(3): " + vector2);

        // Нестатический метод - reverse
        vector3.reverse();
        System.out.println("vector3.reverse(): " + vector3);

        // equals и hashCode
        Vector vector4 = new Vector(new double[]{1, 2, 3});
        Vector vector5 = new Vector(new double[]{1, 2});
        System.out.println(vector4.equals(vector3)); // true
        System.out.println(vector4.equals(vector5)); // false
        System.out.println(vector4.hashCode() == vector3.hashCode()); // true

        // статические методы
        System.out.println("vector4: " + vector4);
        System.out.println("Сумма векторов vector4 {1, 2, 3} и vector5 {1, 2}: " + Vector.sum(vector5, vector5));
        // System.out.println("Исключение: " + Vector.sum(vector5, null));
        System.out.println("Вычитание векторов vector4 {1, 2, 3} и vector5 {1, 2}: " + Vector.subtract(vector4, vector5));
        System.out.println("Скалярное произведение векторов vector4 {1, 2, 3} и vector5 {1, 2}: " + Vector.getScalarProduct(vector5, vector4));
    }
}