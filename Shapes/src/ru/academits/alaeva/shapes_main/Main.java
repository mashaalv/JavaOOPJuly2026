package ru.academits.alaeva.shapes_main;

import ru.academits.alaeva.shapes.*;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static Shape getMaxArea(Shape[] shapes) {
        if (shapes == null || shapes.length == 0) {
            return null;
        }

        Shape[] shapesCopy = Arrays.copyOf(shapes, shapes.length);
        //ссылка на метод: shape -> shape.getArea()
        Arrays.sort(shapesCopy, Comparator.comparingDouble(Shape::getArea).reversed());
        return shapesCopy[0];
    }

    public static Shape getSecondMaxPerimeter(Shape[] shapes) {
        if (shapes == null || shapes.length < 2) {
            return null;
        }

        Shape[] shapesCopy = Arrays.copyOf(shapes, shapes.length);
        //через ссылку на метод: shape -> shape.getArea()
        Arrays.sort(shapesCopy, Comparator.comparingDouble(Shape::getPerimeter).reversed());
        return shapesCopy[1];
    }

    public static void main(String[] args) {
        // t1!=t2
        Triangle t1 = new Triangle(1, 1, 4, 0, 2, 3);
        Triangle t2 = new Triangle(1, 1, 5, 1, 3, 4);
        //c1 = c2
        Circle c1 = new Circle(4);
        Circle c2 = new Circle(4);
        // r1 = r2
        Rectangle r1 = new Rectangle(10, 20);
        Rectangle r2 = new Rectangle(10, 20);
        //s1 !=s2
        Square s1 = new Square(15);
        Square s2 = new Square(3.5);
        // Проверка toString
        System.out.println("Окружность c1 - " + c1);
        System.out.println("Ширина = " + c1.getWidth() + " высота = " + c1.getHeight());

        System.out.println("Прямоугольник r1 - " + r1);
        System.out.println("Ширина = " + r1.getWidth() + " высота = " + r1.getHeight());

        System.out.println("Квадрат s1 - " + s1);
        System.out.println("Ширина = " + s1.getWidth() + " высота = " + s1.getHeight());

        System.out.println("Треугольник t1 - " + t1);
        System.out.println("Ширина = " + t1.getWidth() + " высота =" + t1.getHeight());

        System.out.printf("Площадь треугольника: t1, %.2f, периметр треугольника: %.2f%n", t1.getArea(), t1.getPerimeter());
        System.out.printf("Площадь треугольника: t2, %.2f, периметр треугольника: %.2f%n", t2.getArea(), t2.getPerimeter());
        System.out.printf("Площадь круга: c1, %.2f, периметр окружности: %.2f%n", c1.getArea(), c1.getPerimeter());
        System.out.printf("Площадь прямоугольника: r1, %.2f, периметр треугольника: %.2f%n", r1.getArea(), r1.getPerimeter());
        System.out.printf("Площадь квадрата: s1, %.2f, периметр квадрата: %.2f%n", s1.getArea(), s1.getPerimeter());

        // массив фигур
        Shape[] shapes = {
                new Square(3),// P=12, S=9
                new Square(4.5),// P=18, S=20.25
                new Triangle(1, 1, 4, 0, 2, 3),// P=9, S=3,5
                new Triangle(1, 1, 5, 1, 3, 4),// P=11,21, S=6
                new Rectangle(5, 4), // P=18, S=20
                new Rectangle(2.5, 3.5),// P=12, S=8.75
                new Circle(2),// P>12, S>12
                new Circle(5)// P>30, S>75
        };
        // ===============Часть 2: максимальная площадь и 2 макс. периметр
        Shape maxAreaShape = getMaxArea(shapes);
        Shape maxPerimeter = getSecondMaxPerimeter(shapes);
        System.out.println("Фигура с максимальной площадью: " + maxAreaShape);
        System.out.println("Фигура с вторым по величине периметром: " + maxPerimeter);
        System.out.println("getMaxArea если передали null: " + getMaxArea(null));
        System.out.println("getMaxArea для пустого массива: " + getMaxArea(new Shape[0]));
        System.out.println("getSecondMaxPerimeter если передали массив из одного элемента: " + getSecondMaxPerimeter(new Shape[]{r1}));
        //==============Часть 3: проверка хэш код и equals
        System.out.println("t1.equals(t2): " + t1.equals(t2));//false
        System.out.println("Хэш-коды t1 и t2 совпадают " + (t1.hashCode() == t2.hashCode()));

        System.out.println("r1.equals(r2): " + r1.equals(r2));//true
        System.out.println("Хэш-коды r1 и r2 совпадают " + (r1.hashCode() == r2.hashCode()));

        System.out.println("c1.equals(c2): " + c1.equals(c2));//true
        System.out.println("Хэш-коды c1 и c2 совпадают " + (c1.hashCode() == c2.hashCode()));

        System.out.println("s1.equals(s2): " + s1.equals(s2));//false
        System.out.println("Хэш-коды s1 и s2 совпадают " + (s1.hashCode() == s2.hashCode()));

        System.out.println("t1.equals(null): " + t1.equals(null));//false
        System.out.println("t1.equals(t1): " + t1.equals(t1));//true
    }
}