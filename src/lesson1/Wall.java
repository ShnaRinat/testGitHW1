package lesson1.Obstacles;

import lesson1.Competitors;

public class Wall extends Obstacle {

    int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    String doit(Competitors competitors) {
        return competitors.jump(height);
    }
}