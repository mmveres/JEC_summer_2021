package ua.univer.lesson02.oop;

import java.util.Objects;

public class ColorPoint extends Point{
    private String color;

    public ColorPoint(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ColorPoint that = (ColorPoint) o;
        return color.equals(that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }

    @Override
    public String toString() {
        return "ColorPoint{" +
                "color='" + color + '\'' +
                "} " + super.toString();
    }
}
