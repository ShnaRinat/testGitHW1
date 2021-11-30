package lesson1;

public class Human implements Competitors{

    String name;

    int maxRunDistance;
    int maxJumpHeigth;
    int maxSwimDistance;

    private boolean active;

    public Human(String name) {

        this.name = name;
        this.maxRunDistance = 5000;
        this.maxJumpHeigth = 300;
        this.maxSwimDistance = 20;
        this.active = true;
    }

    @Override
    public String run(int dist) {
        if (dist <= maxRunDistance) {
            return (name + " справился ");
        } else {
            active = false;
            return (name + " не справился ");

        }
    }

    @Override
    public String swim(int dist) {
        if (dist <= maxSwimDistance) {
            return (name + " справился ");
        } else {
            active = false;
            return (name + " не справился ");

        }
    }

    @Override
    public String jump(int height) {
        if (height <= maxJumpHeigth) {
            return (name + " справился ");
        } else {
            active = false;
            return (name + " не справился ");
        }
    }

    @Override
    public boolean isOnDistance() {
        return active;
    }

    @Override
    public void info() {
        System.out.println(name + " " + active);
    }
}