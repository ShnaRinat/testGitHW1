package lesson1;

import lesson1.Competitors;
import lesson1.Team;

public class Course {
    private Obstacle[] obstacles;

    public Course(Obstacle... obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team team) {
        Competitors[] competitors = team.getCompetitors();
        if(competitors.length == 0) {
            System.out.println("В команде никого");
            return;
        }
        for (Competitors c: competitors) {
            for (Obstacle o:obstacles) {
                team.setResult(o.doit(c));
                if(!c.isOnDistance()) {
                    break;
                }
            }
        }
    }}