package ru.academits.alaeva.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    // Vector(size) – размерность size, все компоненты равны 0
    public Vector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Размерность вектора size должна быть >0, передано " + size);
        }

        components = new double[size];// заполнен нолями
    }

    // конструктор копирования
    public Vector(Vector vector) {
        if (vector == null) {
            throw new IllegalArgumentException("Копируемы вектор не может быть null, передано " + vector);
        }

        components = Arrays.copyOf(vector.components, vector.components.length);
    }

    // Vector(double[]) – заполнение вектора значениями из массива
    public Vector(double[] components) {
        if (components == null) {
            throw new IllegalArgumentException("Массив не может быть null, передано " + Arrays.toString(components));
        }

        this.components = Arrays.copyOf(components, components.length);
    }

    // Vector(size, double[]) – заполнение вектора значениями из массива. Если длина массива меньше size, то считать что в остальных компонентах 0
    public Vector(int size, double[] components) {
        if (size <= 0) {
            throw new IllegalArgumentException("size должно быть положительным" + size);
        }

        if (components == null) {
            throw new IllegalArgumentException("Массив не может быть null!" + Arrays.toString(components));
        }

        this.components = new double[size];

        System.arraycopy(components, 0, this.components, 0, Math.min(size, components.length));
    }

    // получение компоненты по индексу
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

    // Метод getSize() для получения размерности вектора (через полe length массива components)
    public int getSize() {
        return components.length;
    }

    // метод toString(), чтобы выдавал информацию о векторе-- {1, 2, 3}
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');

        if (components.length > 0) {
            stringBuilder.append(components[0]);
        }

        for (int i = 1; i < components.length; i++) {
            stringBuilder.append(',').append(' ').append(components[i]);
        }

        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    // прибавление нестатическое, добавляем ноли в тек. вектор, если разная размерность
    public void add(Vector vector) {
        if (vector == null) {
            throw new IllegalArgumentException("Нельзя прибавить null-вектор.");
        }

        int size = getSize();
        int vectorSize = vector.getSize();
        int newSize = Math.max(size, vectorSize);
        double[] newComponents = new double[newSize];

        for (int i = 0; i < newSize; i++) {
            double thisComponents = i < size ? components[i] : 0.0;
            double vectorComponents = i < vectorSize ? vector.components[i] : 0.0;
            newComponents[i] = thisComponents + vectorComponents;
        }

        this.components = newComponents;
    }

    public void subtract(Vector vector) {
        if (vector == null) {
            throw new IllegalArgumentException("Нельзя вычесть null-вектор.");
        }

        int size = getSize();
        int vectorSize = vector.getSize();
        int newSize = Math.max(size, vectorSize);
        double[] newComponents = new double[newSize];

        for (int i = 0; i < newSize; i++) {
            double thisComponents = i < size ? components[i] : 0.0;
            double vectorComponents = i < vectorSize ? vector.components[i] : 0.0;
            newComponents[i] = thisComponents - vectorComponents;
        }

        this.components = newComponents;
    }

    public void multiply(double scalarValue) {
        int size = getSize();
        for (int i = 0; i < size; i++) {
            components[i] *= scalarValue;
        }
    }

    public void reverse() {
        int size = getSize();
        for (int i = 0; i < size; i++) {
            components[i] = -components[i];
        }
    }

    // Получение длины вектора
    public double getLength() {
        double sum = 0.0;
        for (double component : components) {
            sum += component * component;
        }
        return Math.sqrt(sum);
    }

    // переопределить equals и hashcode
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        // отсеяли null и объекты других классов
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        // привели объект к Vector
        Vector vector = (Vector) o;

        if (components.length != vector.components.length) {
            return false;
        }

        // проверили равенство ссылок и полей
        for (int i = 0; i < components.length; i++) {
            if (Double.compare(components[i], vector.components[i]) != 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        for (double component : components) {
            hash = prime * hash + Double.hashCode(component);
        }
        return hash;
    }

    // Статический метод - сложение двух векторов
    public static Vector sum(Vector vectorA, Vector vectorB) {
        if (vectorA == null || vectorB == null) {
            throw new IllegalArgumentException("Векторы не могут быть null.");
        }

        int vectorAsize = vectorA.getSize();
        int vectorBsize = vectorB.getSize();
        int maxSize = Math.max(vectorAsize, vectorBsize);
        double[] newComponents = new double[maxSize];

        for (int i = 0; i < maxSize; i++) {
            double vectorAComponents = i < vectorAsize ? vectorA.components[i] : 0.0;
            double vectorBComponents = i < vectorBsize ? vectorB.components[i] : 0.0;
            newComponents[i] = vectorAComponents + vectorBComponents;
        }

        return new Vector(newComponents);
    }

    //Статический метод - вычитание двух векторов
    public static Vector subtract(Vector vectorA, Vector vectorB) {
        if (vectorA == null || vectorB == null) {
            throw new IllegalArgumentException("Векторы не могут быть null.");
        }

        int vectorAsize = vectorA.getSize();
        int vectorBsize = vectorB.getSize();
        int maxSize = Math.max(vectorAsize, vectorBsize);
        double[] newComponents = new double[maxSize];

        for (int i = 0; i < maxSize; i++) {
            double vectorAComponents = i < vectorAsize ? vectorA.components[i] : 0.0;
            double vectorBComponents = i < vectorBsize ? vectorB.components[i] : 0.0;
            newComponents[i] = vectorAComponents - vectorBComponents;
        }

        return new Vector(newComponents);
    }

    // Скалярное произведение векторов: x1x2+y1y2
    public static double getScalarProduct(Vector vectorA, Vector vectorB) {
        if (vectorA == null || vectorB == null) {
            throw new IllegalArgumentException("Векторы не могут быть null.");
        }

        double sum = 0.0;
        int vectorASize = vectorA.getSize();
        int vectorBSize = vectorB.getSize();
        int maxSize = Math.max(vectorASize, vectorBSize);

        for (int i = 0; i < maxSize; i++) {
            double vectorAComponents = i < vectorASize ? vectorA.components[i] : 0.0;
            double vectorBComponents = i < vectorBSize ? vectorB.components[i] : 0.0;
            sum += vectorAComponents * vectorBComponents;
        }

        return sum;
    }
}