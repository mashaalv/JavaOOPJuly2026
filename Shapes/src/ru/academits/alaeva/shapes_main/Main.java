package ru.academits.alaeva.shapes_main;

import ru.academits.alaeva.shapes.*;

import java.util.Arrays;
import java.util.Comparator;

class AreaComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape s1, Shape s2) {
        if (s1.getArea() < s2.getArea()) {
            return 1;
        } else if (s1.getArea() > s2.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }
}

class PerimetrComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape s1, Shape s2) {
        if (s1.getPerimeter() < s2.getPerimeter()) {
            return 1;
        } else if (s1.getPerimeter() > s2.getPerimeter()) {
            return -1;
        } else {
            return 0;
        }
    }
}

public class Main {
    public static Shape getMaxAreaShape(Shape[] shapes) {
        if (shapes == null || shapes.length == 0) {
            return null;
        }
        Shape[] shapesCopy = Arrays.copyOf(shapes, shapes.length);
        Arrays.sort(shapesCopy, new AreaComparator());
        return shapesCopy[0];
    }

    public static Shape getSecondMaxPerimeterShape(Shape[] shapes) {
        if (shapes == null || shapes.length < 2) {
            return null;
        }
        Shape[] shapesCopy = Arrays.copyOf(shapes, shapes.length);
        Arrays.sort(shapesCopy, new PerimetrComparator());
        return shapesCopy[1];
    }

    public static void main(String[] args) {
        // t1!=t2
        Triangle t1 = new Triangle(1, 1, 4, 0, 2, 3);
        Triangle t2 = new Triangle(1, 1, 5, 1, 3, 4);
        // c1 = c2
        Circle c1 = new Circle(4);
        Circle c2 = new Circle(4);
        // r1 = r2
        Rectangle r1 = new Rectangle(10, 20);
        Rectangle r2 = new Rectangle(10, 20);
        // s1 !=s2
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
        System.out.println("Фигура с максимальной площадью: " + (getMaxAreaShape(shapes) != null ? getMaxAreaShape(shapes) : "нет данных."));
        System.out.println("Фигура с вторым по величине периметром: " + (getSecondMaxPerimeterShape(shapes) != null ? getSecondMaxPerimeterShape(shapes) : "нет данных."));
        System.out.println("getMaxAreaShape если передали null: " + (getMaxAreaShape(null) != null ? getMaxAreaShape(null) : "нет данных."));
        System.out.println("getMaxAreaShape для пустого массива: " + (getMaxAreaShape(new Shape[0]) != null ? getMaxAreaShape(new Shape[0]) : "нет данных."));
        System.out.println("getSecondMaxPerimeterShape если передали массив из одного элемента: " + (getSecondMaxPerimeterShape(new Shape[]{r1}) != null ? getSecondMaxPerimeterShape(new Shape[]{r1}) : "нет данных."));

        //  ==============Часть 3: проверка хэш код и equals
        System.out.println("t1.equals(t2): " + t1.equals(t2));// false
        System.out.println("Хэш-коды t1 и t2 совпадают " + (t1.hashCode() == t2.hashCode()));

        System.out.println("r1.equals(r2): " + r1.equals(r2));// true
        System.out.println("Хэш-коды r1 и r2 совпадают " + (r1.hashCode() == r2.hashCode()));// 76547009

        System.out.println("c1.equals(c2): " + c1.equals(c2));// true
        System.out.println("Хэш-коды c1 и c2 совпадают " + (c1.hashCode() == c2.hashCode()));// 1074790437 через objects 1074790431. Без перегрузки false 1023892928

        System.out.println("s1.equals(s2): " + s1.equals(s2));// false
        System.out.println("Хэш-коды s1 и s2 совпадают " + (s1.hashCode() == s2.hashCode()));

        System.out.println("t1.equals(null): " + t1.equals(null));// false
        System.out.println("t1.equals(t1): " + t1.equals(t1));// true
    }
}