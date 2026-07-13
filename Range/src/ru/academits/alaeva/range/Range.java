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

    public boolean isInside(double pointX) {
        return from <= pointX && pointX <= to;
    }


    public double max(double number1, double number2) {
        return number2 > number1 ? number2 : number1;
    }

    public double min(double number1, double number2) {
        return number2 < number1 ? number2 : number1;
    }

    public Range intersection(Range anotherRange) {
        // если нет пересечения, возвращаем null, иначе пересечение
        if (max(this.from, anotherRange.from) >= min(this.to, anotherRange.to)) {
            return null;
        }
        return new Range(max(this.from, anotherRange.from), min(this.to, anotherRange.to));
    }

    public Range[] union(Range anotherRange) {
        // если нет пересечения, возвращаем 2 интервала, иначе 1
        if (max(this.from, anotherRange.from) > min(this.to, anotherRange.to)) {

            if (this.from < anotherRange.from) {
                return new Range[]{this, anotherRange};
            } else {
                return new Range[]{anotherRange, this};
            }
        }
        return new Range[]{new Range(min(this.from, anotherRange.from), max(this.to, anotherRange.to))};
    }

    public Range[] difference(Range anotherRange) {
        // нет пересечений, возвращаем первый интервал
        if (max(this.from, anotherRange.from) > min(this.to, anotherRange.to)) {
            return new Range[]{this};
        }
        // есть пересечения, a1<a2, b2>b1 -- [a1,a2]
        if (anotherRange.from > this.from && anotherRange.to > this.to) {
            return new Range[]{new Range(this.from, anotherRange.from)};
        }
        //есть пересечения, a2<a1, b2<b1 -- [b2,b1]
        if (anotherRange.from < this.from && anotherRange.to < this.to) {
            return new Range[]{new Range(anotherRange.to, this.to)};
        }
        //есть пересечения, a2>a1, b2<b1 --[a1,a2] и [b2,b1]
        if (anotherRange.from > this.from && anotherRange.to < this.to) {
            return new Range[]{new Range(this.to, anotherRange.to), new Range(anotherRange.from, this.from)};
        }
        // иначе второй интервал включает первый - ноль
        return new Range[0];
    }
}
