package ua.univer.lesson03;
abstract class Animal extends Object{

}
class Dog extends Animal{
    @Override
    public String toString() {
        return "Dog{} " + super.toString();
    }
    public void bark(){
        System.out.println("Bark");
    }
}
class WildDog extends Dog{

}
class Cat extends Animal{
    @Override
    public String toString() {
        return "Cat{} " + super.toString();
    }
    public void myau(){
        System.out.println("MYAU");
    }
}
public class Program {
    public static void main(String[] args) {
      //  Animal a1 = new Animal();
        Animal d1 = new Dog();
        Animal c1 = new Cat();
        Animal d2 = d1;
    //    System.out.println(d1);
    //    System.out.println(c1);
        Animal [] animals = {d1,d2,c1, new Dog(), new Cat(), new WildDog() };
        for (Animal animal: animals) {
            System.out.println(animal.hashCode());

            if (animal instanceof Dog){ System.out.println("****1");
            ((Dog)animal).bark();
            }

            if (animal.getClass().getSimpleName().equals("Dog")){ System.out.println("****2");
                ((Dog)animal).bark();}

            if (animal.getClass().equals(Dog.class)){ System.out.println("****3");
                ((Dog)animal).bark();}
        }
    }
}
