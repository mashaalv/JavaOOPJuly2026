package ru.academits.alaeva.shapes_main;

import ru.academits.alaeva.comparators.ShapeAreaComparator;
import ru.academits.alaeva.comparators.ShapePerimeterComparator;
import ru.academits.alaeva.shapes.*;

import java.util.Arrays;

public class Main {
    public static Shape getMaxAreaShape(Shape[] shapes) {
        if (shapes == null || shapes.length == 0) {
            return null;
        }

        Shape[] shapesCopy = Arrays.copyOf(shapes, shapes.length);
        Arrays.sort(shapesCopy, new ShapeAreaComparator());
        return shapesCopy[shapesCopy.length - 1];
    }

    public static Shape getSecondMaxPerimeterShape(Shape[] shapes) {
        if (shapes == null || shapes.length < 2) {
            return null;
        }

        Shape[] shapesCopy = Arrays.copyOf(shapes, shapes.length);
        Arrays.sort(shapesCopy, new ShapePerimeterComparator());
        return shapesCopy[shapesCopy.length - 2];
    }

    public static void main(String[] args) {
        // triangle1!=triangle2
        Triangle triangle1 = new Triangle(1, 1, 4, 0, 2, 3);
        Triangle triangle2 = new Triangle(1, 1, 5, 1, 3, 4);

        // circle1 = circle2
        Circle circle1 = new Circle(4);
        Circle circle2 = new Circle(4);

        // rectangle1 = rectangle2
        Rectangle rectangle1 = new Rectangle(10, 20);
        Rectangle rectangle2 = new Rectangle(10, 20);

        // square1 !=square2
        Square square1 = new Square(15);
        Square square2 = new Square(3.5);

        // Проверка toString
        System.out.println("Окружность circle1 - " + circle1);
        System.out.println("Ширина = " + circle1.getWidth() + " высота = " + circle1.getHeight());

        System.out.println("Прямоугольник rectangle1 - " + rectangle1);
        System.out.println("Ширина = " + rectangle1.getWidth() + " высота = " + rectangle1.getHeight());

        System.out.println("Квадрат square1 - " + square1);
        System.out.println("Ширина = " + square1.getWidth() + " высота = " + square1.getHeight());

        System.out.println("Треугольник triangle1 - " + triangle1);
        System.out.println("Ширина = " + triangle1.getWidth() + " высота =" + triangle1.getHeight());

        System.out.printf("Площадь треугольника: triangle1, %.2f, периметр треугольника: %.2f%n", triangle1.getArea(), triangle1.getPerimeter());
        System.out.printf("Площадь треугольника: triangle2, %.2f, периметр треугольника: %.2f%n", triangle2.getArea(), triangle2.getPerimeter());
        System.out.printf("Площадь круга: circle1, %.2f, периметр окружности: %.2f%n", circle1.getArea(), circle1.getPerimeter());
        System.out.printf("Площадь прямоугольника: rectangle1, %.2f, периметр треугольника: %.2f%n", rectangle1.getArea(), rectangle1.getPerimeter());
        System.out.printf("Площадь квадрата: square1, %.2f, периметр квадрата: %.2f%n", square1.getArea(), square1.getPerimeter());

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

        // Часть 2: максимальная площадь и 2 макс. периметр
        Shape maxAreaShape = getMaxAreaShape(shapes);
        System.out.println("Фигура с максимальной площадью: " + (maxAreaShape != null ? maxAreaShape : "нет данных."));

        Shape secondMaxPerimeterShape = getSecondMaxPerimeterShape(shapes);
        System.out.println("Фигура с вторым по величине периметром: " + (secondMaxPerimeterShape != null ? secondMaxPerimeterShape : "нет данных."));

        Shape maxAreaShapeNull = getMaxAreaShape(null);
        System.out.println("getMaxAreaShape если передали null: " + (maxAreaShapeNull != null ? maxAreaShapeNull : "нет данных."));

        Shape maxAreaShapeEmpty = getMaxAreaShape(new Shape[0]);
        System.out.println("getMaxAreaShape для пустого массива: " + (maxAreaShapeEmpty != null ? maxAreaShapeEmpty : "нет данных."));

        Shape secondMaxPerimeterSingleElement = getSecondMaxPerimeterShape(new Shape[]{rectangle1});
        System.out.println("getSecondMaxPerimeterShape если передали массив из одного элемента: " + (secondMaxPerimeterSingleElement != null ? secondMaxPerimeterSingleElement : "нет данных."));
        // Часть 3: проверка хэш код и equals
        System.out.println("triangle1.equals(triangle2): " + triangle1.equals(triangle2));// false
        System.out.println("Хэш-коды triangle1 и triangle2 совпадают " + (triangle1.hashCode() == triangle2.hashCode()));

        System.out.println("rectangle1.equals(rectangle2): " + rectangle1.equals(rectangle2));// true
        System.out.println("Хэш-коды rectangle1 и rectangle2 совпадают " + (rectangle1.hashCode() == rectangle2.hashCode()));// 76547009

        System.out.println("circle1.equals(circle2): " + circle1.equals(circle2));// true
        System.out.println("Хэш-коды circle1 и circle2 совпадают " + (circle1.hashCode() == circle2.hashCode()));// 1074790437 через objects 1074790431. Без перегрузки false 1023892928

        System.out.println("square1.equals(square2): " + square1.equals(square2));// false
        System.out.println("Хэш-коды square1 и square2 совпадают " + (square1.hashCode() == square2.hashCode()));

        System.out.println("triangle1.equals(null): " + triangle1.equals(null));// false
        System.out.println("triangle1.equals(triangle1): " + triangle1.equals(triangle1));// true
    }
}