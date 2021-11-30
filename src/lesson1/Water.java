package lesson1.Obstacles;

import lesson1.Competitors;

public class Water extends Obstacle {

    int length;

    public Water(int length) {
        this.length = length;
    }

    @Override
    String doit(Competitors competitors) {
        return competitors.swim(length);
    }
}