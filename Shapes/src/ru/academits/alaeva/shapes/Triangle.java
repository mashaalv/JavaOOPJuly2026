package ru.academits.alaeva.shapes;

import java.util.Objects;

public class Triangle implements Shape {
    private double x1 = 0;
    private double y1 = 0;
    private double x2 = 0;
    private double y2 = 0;
    private double x3 = 0;
    private double y3 = 0;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    @Override
    public double getWidth() {
        return Math.max(x1, Math.max(x2, x3)) - Math.min(x1, Math.min(x2, x3));
    }

    @Override
    public double getHeight() {
        return Math.max(y1, Math.max(y2, y3)) - Math.min(y1, Math.min(y2, y3));
    }

    @Override
    public double getArea() {
        return 0.5 * Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
    }

    @Override
    public double getPerimeter() {
        double side1 = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        double side2 = Math.sqrt((x3 - x2) * (x3 - x2) + (y3 - y2) * (y3 - y2));
        double side3 = Math.sqrt((x3 - x1) * (x3 - x1) + (y3 - y1) * (y3 - y1));
        return side1 + side2 + side3;
    }

    @Override
    public String toString() {
        //return getClass().getSimpleName() + "(x1 = " + x1 + ", y1 = " + y1 + "), " + "(x2 = " + x2 + ", y2 = " + y2 + "), " + "(x3= " + x3 + ", y3 = " + y3 + ")";
        return getClass().getSimpleName() + "{(" + x1 + "," + y1 + "), (" + x2 + "," + y2 + "), (" + x3 + "," + y3 + ")}";
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
        Triangle triangle = (Triangle) o;

        // проверили равенство ссылок и полей
        return Double.compare(triangle.x1, x1) == 0 && Double.compare(triangle.y1, y1) == 0
                && Double.compare(triangle.x2, x2) == 0 && Double.compare(triangle.y2, y2) == 0
                && Double.compare(triangle.x3, x3) == 0 && Double.compare(triangle.y3, y3) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, y1, x2, y2, x3, y3);
        /* можно определить hash так
        int hash = 1;
        final int prime = 37;
        hash = prime * hash + Double.hashCode(x1);
        hash = prime * hash + Double.hashCode(y1);
        hash = prime * hash + Double.hashCode(x2);
        hash = prime * hash + Double.hashCode(y2);
        hash = prime * hash + Double.hashCode(x3);
        hash = prime * hash + Double.hashCode(y3);
        return hash;
            }       */
    }
}