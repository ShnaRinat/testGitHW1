package lesson4;

import java.util.*;

public class Phone {
    public static void main(String args[]) {

        Book pb = new Book();

        pb.add("Макаров", "87834431567");
        pb.add("Алексеев", "884278963452");
        pb.add("Горячев", "82358996683");
        pb.add("Иванов", "896258962471");
        pb.add("Журавлев", "898523498218");
        pb.add("Смирнов", "892587415821");
        pb.add("Кустов", "895218745631");
        pb.add("Попов", "895278745631");

        System.out.println("Макаров" + pb.get("Макаров"));
        System.out.println("Кустов" + pb.get("Кустов"));
        System.out.println("Смирнов" + pb.get("Смирнов"));
        System.out.println("Попов" + pb.get("Попов"));
    }

    static class Book {
        private Map<String, List<String>> mapBook = new HashMap<>();
        private List<String> phoneNumber;

        public void add(String lastName, String phone_number) {
            if (mapBook.containsKey(lastName)) {
                phoneNumber = mapBook.get(lastName);
                phoneNumber.add(phone_number);
                mapBook.put(lastName, phoneNumber);
            } else {
                phoneNumber = new ArrayList<>();
                phoneNumber.add(phone_number);
                mapBook.put(lastName, phoneNumber);
            }
        }
        public List<String> get(String lastName) {
            return mapBook.get(lastName);
        }
    }
}