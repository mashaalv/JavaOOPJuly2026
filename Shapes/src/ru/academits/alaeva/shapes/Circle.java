package ru.academits.alaeva.shapes;

public class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
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
        return "Circle(radius = " + radius + ")";
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
        return circle.radius == radius;
    }

    @Override
    public int hashCode() {
        // hashCode - нужно реализовать без использования Objects.hash(radius), т.к. этот метод создает массив
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(radius);
        return hash;
    }
}