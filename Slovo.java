package lesson4;

import java.util.*;

public class Slovo {
    public static void main(String args[]) {


        ArrayList<String> words = new ArrayList<>(Arrays.asList(
                "машина", "руль", "двигатель", "капот", "руль", "двигатель", "машина", "двигатель", "руль", "капот", "руль"));

        Map<String, Integer> countMap = new HashMap<>();

        for (String item : words) {

            if (countMap.containsKey(item))
                countMap.put(item, countMap.get(item) + 1);
            else
                countMap.put(item, 1);
        }
        System.out.println(countMap);
    }
}