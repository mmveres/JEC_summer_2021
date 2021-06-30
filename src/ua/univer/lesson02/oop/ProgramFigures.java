package ua.univer.lesson02.oop;

public class ProgramFigures {
    public static void main(String[] args) {
        Point p1 = new Point(1,2);
        System.out.println(p1);
        Point p2 = new Point(1,2);
        System.out.println(p2);

        System.out.println(p1==p2);
        System.out.println(p1.equals(p2));

        String s1 = "hi";
        String s2 = "hi";
        String s3 = new String("hi");
        System.out.println("******************");
        System.out.println(s1==s3);
        System.out.println(s1.equals(s3));

        ColorPoint cp1 = new ColorPoint(1,2,"RED");
        System.out.println(cp1);

        System.out.println(p1.equals(cp1));
    }
}
