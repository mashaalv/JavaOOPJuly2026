package ru.academits.alaeva.shapes;

import ru.academits.alaeva.shapes_main.Main;

import java.util.Objects;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getWidth() {
        return 2 * radius;
    }

    @Override
    public double getHeight() {
        return 2 * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(radius = " + radius + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        // отсеяли null и объекты других классов
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        // привели объект к Circle
        Circle circle = (Circle) o;
        // проверили равенство ссылок и полей
        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
        /* можно определить hash так
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(radius);    */
    }
}