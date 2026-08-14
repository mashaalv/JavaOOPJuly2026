package ru.academits.alaeva.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    //Vector(n) – размерность n, все компоненты равны 0

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора n должна быть >0, передано " + n);
        }
        components = new double[n];// уже заполнен нолями
    }

    public double[] getComponents() {
        return components;
    }

    //получение компоненты по индексу
    public double getComponent(int i) {
        if (i < 0 || i >= components.length) {
            throw new IndexOutOfBoundsException("Индекс должен быть в диапазоне [ 0, " + (components.length - 1) + "]");
        }
        return components[i];
    }

    //установка компоненты по индексу
    public void setComponent(int i, double value) {
        if (i < 0 || i >= components.length) {
            throw new IndexOutOfBoundsException("Индекс должен быть в диапазоне [0, " + (components.length - 1) + "]");
        }
        components[i] = value;
    }

    //Vector(Vector other) – конструктор копирования
    public Vector(Vector vector) {
        //вызов конструктора через this - Vector(n)
        int size = vector.getSize();
        this(size);
        for (int i = 0; i < size; i++) {
            components[i] = vector.components[i];
        }
    }

    //Vector(double[]) – заполнение вектора значениями из массива
    public Vector(double[] components) {
        if (components == null) {
            throw new IllegalArgumentException("Массив не может быть null!");
        }
        //вызов конструктора через this
        this(components.length);
        for (int i = 0; i < components.length; i++) {
            this.components[i] = components[i];
        }
    }

    //Vector(n, double[]) – заполнение вектора значениями из массива. Если длина массива меньше n, то считать что в остальных компонентах 0
    public Vector(int n, double[] components) {

        if (n <= 0) {
            throw new IllegalArgumentException("n должно быть положительным");
        }
        if (components == null) {
            throw new IllegalArgumentException("Массив не может быть null!");
        }
        //вызов конструктора через this, создаем вектор длины n
        this(n);

        for (int i = 0; i < (Math.min(n, components.length)); i++) {
            this.components[i] = components[i];
        }
    }


    //Метод getSize() для получения размерности вектора (через полe length массива components)
    public int getSize() {
        return components.length;
    }

    // метод toString(), чтобы выдавал информацию о векторе-- {1, 2, 3}
    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder("{");
        for (int i = 0; i < components.length; i++) {
            resultString.append(components[i]);
            if (i < components.length - 1) {
                resultString.append(", ");
            }
        }
        resultString.append("}");
        return resultString.toString();
    }

    ////////////////// Переопределение equals и hashCode

    //прибавление, если размерность нашего вектора больше -  то в другом векторе ноли
    public void add(Vector vector) {
        if (vector == null) {
            throw new IllegalArgumentException("Нельзя прибавить null-вектор.");
        }

        int newSize = Math.max(getSize(), vector.getSize());
        double[] newComponents = new double[newSize];

        for (int i = 0; i < components.length; i++) {

            double thisComponents = i < getSize() ? components[i] : 0.0;
            double vectorComponents = i < vector.getSize() ? vector.components[i] : 0.0;
            newComponents[i] = thisComponents + vectorComponents;

        }
        this.components = newComponents;
    }


}

