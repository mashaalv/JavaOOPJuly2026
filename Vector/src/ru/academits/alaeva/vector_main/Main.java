package ru.academits.alaeva.vector_main;

import ru.academits.alaeva.vector.Vector;

public class Main {
    public static void main() {
        // обработка исключения, тест
        try {
            Vector vector1 = new Vector(-1);


        } catch (IllegalArgumentException e) {
            System.out.println("Поймали исключение: " + e.getMessage());

        }

        Vector vector2 = new Vector(5);
        System.out.println("Размерность вектора vector2 = " + vector2.getSize());

        double[] components3 = {1, 2, 3, 8, 5};
        double[] components4 = new double[6];
        Vector vector3 = new Vector(components3);
        System.out.println(vector3);

        vector3.setComponent(4, 666);
        System.out.println(vector3.getComponent(4));

        Vector v1 = new Vector(5, new double[]{1, 2, 3});
        System.out.println(v1); // {1.0, 2.0, 3.0, 0.0, 0.0}

        Vector v2 = new Vector(3, new double[]{1, 2, 3, 4, 5});
        System.out.println(v2); // {1.0, 2.0, 3.0}

        //Vector v3 = new Vector(-1, new double[]{1, 2}); // исключение
        //Vector v4 = new Vector(3, null); // исключение
        //Нетстатическое сложение веторов
        v1.add(v2);
        System.out.println(v1);
    }
}