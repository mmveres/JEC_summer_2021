package ua.univer.lesson03.arrExample;

public class Program {
    public static int getSum(int []mas){
        int sum = 0;
        for (int i = 0; i < mas.length; i++) {
            sum+=mas[i];
        }
        return sum;
    }
    public static double getAver(int [] mas){
        return (double)getSum(mas)/ mas.length;
    }
    public static void main(String[] args) {
        int[] mas = getMas();
       // int sum= getSum(mas);
        System.out.println("sum = "+getSum(mas)+", aver = "+ getAver(mas));
    }

    private static int[] getMas() {
        int [] mas = {1,2,3,4,54};
        return mas;
    }
}
