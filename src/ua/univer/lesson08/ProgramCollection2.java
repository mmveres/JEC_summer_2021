package ua.univer.lesson08;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
class Ship{
    private String name;
    private int x;
    private int y;

    public Ship(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return x == ship.x && y == ship.y && Objects.equals(name, ship.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, x, y);
    }

    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", hash=" + hashCode() +
                '}';
    }
}
public class ProgramCollection2 {
    public static void main(String[] args) throws IOException {
        Hashtable ht;
        HashMap hm;
        ConcurrentHashMap chm;
        HashSet hs;

        Set<Object> set = new LinkedHashSet<>();
        set.add(11);
        set.add("1");
        set.add(new Object());
        set.add(new Ship("A", 1, 1));
        set.add(new Ship("A", 1, 2));
        System.out.println(set);

        System.out.println(set.contains(new Ship("A", 1, 2)));

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 1, 6, 3, 6, 7);
        list = getUniqValueList(list);
        System.out.println(list);


        // String str = "mama mila ramu ramu mila mama rima";

        //  String str = getStringFromFile("words.txt");
        Map<String, Map<String, Integer>> mapUrlFreq = new HashMap<>();
        for (int i = 1; i < 154; i++) {


        String url = "https://www.stihi-rus.ru/World/Shekspir/" + i + ".htm";
        String str = getStrFromUrl(url);

        Map<String, Integer> freqMap = getFreqMap(str);
        //  System.out.println(freqMap);


        for (String word : freqMap.keySet()) {
            if (!mapUrlFreq.containsKey(word)) {
                mapUrlFreq.put(word, new HashMap<>());
            }
                Map<String, Integer> mapUrl = mapUrlFreq.get(word);
                mapUrl.put(url, freqMap.get(word));


        }

        }
        System.out.println(mapUrlFreq);
}
        private static String getStrFromUrl (String url) throws IOException {
            URL website = new URL(url);
            URLConnection connection = website.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "CP1251"));
            StringBuilder sb = new StringBuilder();
            while (br.ready()) sb.append(br.readLine()).append(" ");
            return sb.toString();
        }

        private static String getStringFromFile (String fileName) throws IOException {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            StringBuilder sb = new StringBuilder();
            while (br.ready()) sb.append(br.readLine()).append(" ");
            return sb.toString();
        }

        private static List<Integer> getUniqValueList (List < Integer > list) {
            return new ArrayList<>(new HashSet<>(list));
        }

        private static Map<String, Integer> getFreqMap (String str){
            Map<String, Integer> freqMap = new HashMap<>();

            String[] words = str.split("\\s");
            for (String word : words) {
                if (!freqMap.containsKey(word))
                    freqMap.put(word, 1);
                else
                    freqMap.put(word, freqMap.get(word) + 1);
            }
            return freqMap;
        }
    }

