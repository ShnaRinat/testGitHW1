package lesson3;

public class Main {
    public static void main(String[] args) {

        Apple app1 = new Apple();
        Orange orange1 = new Orange();
        System.out.println(app1.getWeight());
        System.out.println(orange1.getWeight());

        Box<Apple> appleBox = new Box<Apple>(app1, 3);
        System.out.println(appleBox.getWeight());
        Box<Orange> orangeBox = new Box<Orange>(orange1, 2);
        System.out.println(orangeBox.getWeight());

        System.out.println();
        System.out.println(orangeBox.compare(appleBox));
    }
}