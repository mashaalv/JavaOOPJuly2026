package ru.academits.alaeva.vector;

public class Vector {
    private double[] components;

    // Vector(n) – размерность n, все компоненты равны 0
    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора n должна быть >0, передано " + n);
        }

        components = new double[n];// заполнен нолями
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

    // конструктор копирования
    public Vector(Vector vector) {
        // вызов конструктора через this - Vector(n)
        int size = vector.getSize();
        this(size);

        for (int i = 0; i < size; i++) {
            components[i] = vector.components[i];
        }
    }

    // Vector(double[]) – заполнение вектора значениями из массива
    public Vector(double[] components) {
        if (components == null) {
            throw new IllegalArgumentException("Массив не может быть null!");
        }
        // вызов конструктора через this
        this(components.length);

        for (int i = 0; i < components.length; i++) {
            this.components[i] = components[i];
        }
    }

    // Vector(n, double[]) – заполнение вектора значениями из массива. Если длина массива меньше n, то считать что в остальных компонентах 0
    public Vector(int n, double[] components) {
        if (n <= 0) {
            throw new IllegalArgumentException("n должно быть положительным");
        }

        if (components == null) {
            throw new IllegalArgumentException("Массив не может быть null!");
        }

        // вызов конструктора через this, создаем вектор длины n
        this(n);

        for (int i = 0; i < (Math.min(n, components.length)); i++) {
            this.components[i] = components[i];
        }
    }

    // Метод getSize() для получения размерности вектора (через полe length массива components)
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
            components[i] = scalarValue * components[i];
        }
    }

    public void reverse() {
        int size = getSize();
        for (int i = 0; i < size; i++) {
            components[i] = -components[i];
        }
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