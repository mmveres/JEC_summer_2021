package ua.univer.lesson05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

class Kmda{
    private String name;
    private double oklad;

    public Kmda(String name, double oklad) {
        this.name = name;
        this.oklad = oklad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getOklad() {
        return oklad;
    }

    public void setOklad(double oklad) {
        this.oklad = oklad;
    }

    @Override
    public String toString() {
        return "Kmda{" +
                "name='" + name + '\'' +
                ", oklad=" + oklad +
                '}';
    }
}
public class ProgramString {
    public static void main(String[] args) throws IOException {
      //  testString();
      //Scanner sc = new Scanner(System.in);
      //  String str = getStrFromConsole();
        String str ="";
      //  str = getStrFromFile("text.txt");
        String urlKMDA = "https://data.gov.ua/dataset/770cc750-4333-424f-b6e9-6e6c5c76aec9/resource/59cb6066-1fac-41ed-a571-811db551c75b/download/zp-lupen-2019.csv";
        String urlStackOver = "https://stackoverflow.com/questions/4328711/read-url-to-string-in-few-lines-of-java-code";
       // str = getStrFromUrl(urlKMDA);
        Kmda [] users = getUsersFromUrlKMDA(urlKMDA);

        System.out.println(Arrays.toString(users));
    }

    private static Kmda[] getUsersFromUrlKMDA(String url) throws IOException {
        URL website = new URL(url);
        URLConnection connection = website.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(),"CP1251"));
     //   StringBuilder stringBuilder =new StringBuilder();
        String inputLine;
        String titleStr = br.readLine();
        String[] title = titleStr.split(";");
        System.out.println(Arrays.toString(title));
        Kmda [] users = new Kmda[9];
        int i = 0;
        while ((inputLine = br.readLine()) != null) {
            String [] paramKMDA = inputLine.split(";");
            users[i++] =new Kmda(paramKMDA[0],Double.parseDouble(paramKMDA[2].replace(",",".")));
        }
        br.close();
        return users;
    }

    private static String getStrFromUrl(String url) throws IOException {
        URL website = new URL(url);
        URLConnection connection = website.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(),"CP1251"));
        StringBuilder stringBuilder =new StringBuilder();
        String inputLine;
        while ((inputLine = br.readLine()) != null) {
            stringBuilder.append(inputLine);
        }
        br.close();
        return stringBuilder.toString();
    }

    private static String getStrFromFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        StringBuilder stringBuilder =new StringBuilder();
        while (br.ready()){
        stringBuilder.append(br.readLine());
        }
        return stringBuilder.toString();
    }

    private static String getStrFromConsole() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder =new StringBuilder();
        for (int i = 0; i < 10; i++) {
           stringBuilder.append(br.readLine());
        }
        return stringBuilder.toString();
    }



    private static void testString() {
        int [] mas = {1,2,3,4};
        int [] mas1 = new int[]{1,2,3,4};
        System.out.println(mas.length);
        mas[1] = 5;
        System.out.println(Arrays.toString(mas));
        String str = "mama mila ramu ramu mila mama";
        str = "1234asfh";
        System.out.println(str.length());
        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer;
        for (int i = 0; i < 100; i++) {
            stringBuilder.append(i);
            System.out.println(stringBuilder.length()+"/"+stringBuilder.capacity());
        }
        System.out.println(stringBuilder.toString());
        String str1="";
        for (int i = 0; i < 100; i++) {
            str1+=i;
            System.out.println(str1.length());
        }
        System.out.println(str1);
    }
}
