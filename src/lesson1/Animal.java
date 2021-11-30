package lesson1;

public class Animal implements Competitors {

    String type;
    String name;

    int maxRunDistance;
    int maxJumpHeigth;
    int maxSwimDistance;

    boolean onDistance;

    public Animal(String type, String name, int maxRunDistance, int maxJumpHeigth, int maxSwimDistance) {

        this.type = type;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeigth = maxJumpHeigth;
        this.maxSwimDistance = maxSwimDistance;
        this.onDistance = true;
    }

    @Override
    public String run(int dist) {
        if (dist <= maxRunDistance) {
            return  (type + " " + name + " справился");
        } else {
            onDistance = false;
            return  (type + " " + name + " не справился");

        }
    }

    @Override
    public String swim(int dist) {
        if (dist <= maxSwimDistance) {
            return  (type + " " + name + " справился");
        } else {
            onDistance = false;
            return (type + " " + name + " не справился");

        }
    }

    @Override
    public String jump(int height) {
        if (height <= maxJumpHeigth) {
            return  (type + " " + name + " справился");
        } else {
            onDistance = false;
            return  (type + " " + name + " не справился");
        }
    }

    @Override
    public boolean isOnDistance() {
        return onDistance;
    }

    @Override
    public void info() {
        System.out.println(type + " " + name + " " + onDistance);
    }
}