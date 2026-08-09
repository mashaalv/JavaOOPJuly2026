package ru.academits.alaeva.shapes;

import java.util.Objects;

public class Rectangle implements Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {

        return "Rectangle(width = " + width + ", height = " + height + ")";
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

        Rectangle rectangle = (Rectangle) o;

        // проверили равенство ссылок и полей
        return rectangle.width == width && rectangle.height == height;
    }

    @Override
    public int hashCode() {
        // return Objects.hash(width, height);
        int hash = 1;
        final int prime = 37;
        hash = prime * hash + Double.hashCode(width);
        hash = prime * hash + Double.hashCode(height);
        return hash;
    }
}