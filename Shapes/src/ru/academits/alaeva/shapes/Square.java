package ru.academits.alaeva.shapes;

import java.util.Objects;

public class Square implements Shape {
    private double side;//Final??????

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getWidth() {
        return side;
    }

    @Override
    public double getHeight() {
        return side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(side = " + side + ")";
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
        // привели объект к Square
        Square square = (Square) o;
        // проверили равенство ссылок и полей
        return Double.compare(square.side, side) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(side);
    }
}