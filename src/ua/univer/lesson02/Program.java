package ua.univer.lesson02;
/*

* * * * *
*       *
*       *
* * * * *

 */
public class Program {
    public static void main(String[] args) {
      //  square();


        printMas(1,12,3,4,5);
    }

    private static void printMas(int... mas) {
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i]+", ");
        }
    }


    private static void square() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 0 || i == 9)
                    System.out.print("* ");
                else
                    if (j == 0 || j == 9)
                        System.out.print("* ");
                    else
                        System.out.print("  ");
            }
            System.out.print("\n");
        }
    }
}
