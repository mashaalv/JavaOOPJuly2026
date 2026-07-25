package ru.academits.alaeva.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double point) {
        return from <= point && point <= to;
    }


    public Range intersection(Range range) {
        // если нет пересечения, возвращаем null, иначе пересечение
        double left = Math.max(from, range.from);
        double right = Math.min(to, range.to);

        if (left >= right) {
            return null;
        }

        return new Range(left, right);
    }

    public Range[] union(Range range) {
        double left = Math.max(from, range.from);
        double right = Math.min(to, range.to);
        // если есть пересечение, возвращаем 1 интервала, иначе 2
        if (left <= right) {
            return new Range[]{new Range(Math.min(this.from, range.from), Math.max(this.to, range.to))};
        }
        if (from < range.from) {
            return new Range[]{new Range(from, to), new Range(range.from, range.to)};
        }

        return new Range[]{new Range(range.from, range.to), new Range(from, to)};
    }

    public Range[] difference(Range range) {
        double left = Math.max(from, range.from);
        double right = Math.min(to, range.to);
        // нет пересечений, возвращаем первый интервал
        if (left >= right) {
            return new Range[]{new Range(from, to)};
        }
        // есть пересечения a2>a1, b2>b1 -- [a1,a2]
        if (from < range.from && range.to >= to) {
            return new Range[]{new Range(from, range.from)};
        }

        // есть пересечения, a2<a1, b2<b1 -- [b2,b1]
        if (range.from <= from && range.to < to) {
            return new Range[]{new Range(range.to, to)};
        }

        // есть пересечения, a2>a1, b2<b1 --[a1,a2] и [b2,b1]
        if (range.from > from && range.to < to) {
            return new Range[]{new Range(from, range.from), new Range(range.to, to)};
        }

        // иначе второй интервал включает первый - пустой интервал
        return new Range[0];
    }

    //@Override
    public String toString() {
        return "[" + from + "," + to + "]";
    }
}