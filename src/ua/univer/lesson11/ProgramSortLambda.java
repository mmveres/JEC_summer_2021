package ua.univer.lesson11;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Car implements Comparable<Car>{
    private String name;
    private int age;
    private String number;

    public Car(String name, int age, String number) {
        this.name = name;
        this.age = age;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", number='" + number + '\'' +
                '}';
    }

    @Override
    public int compareTo(Car o) {
        return name.compareTo(o.getName());
    }
}

public class ProgramSortLambda {
    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
                new Car("Ford1", 13, "AA1234"),
                new Car("Ford3", 12, "AA1231"),
                new Car("Ford2", 11, "AA1233")
        );
        Collections.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        System.out.println(cars);
        Collections.sort(cars, (o1, o2) -> o1.getNumber().compareTo(o2.getNumber()));
        System.out.println(cars);

        Collections.sort(cars, Comparator.comparing(Car::getNumber));
        System.out.println(cars);
    }
}
