package lesson1;

import lesson1.Obstacles.Cross;
import lesson1.Obstacles.Wall;
import lesson1.Obstacles.Water;
import lesson1.Obstacles.Course;

public class Main {

    public static void main(String[] args) {

        Course c = new Course(new Cross(80), new Wall(5), new Water(100));
        Team team = new Team("Pride", new Human("Ринат"), new Cat("Барсик"), new Dog("Бобик"));
        c.doIt(team);
        team.showResults();
    }
}