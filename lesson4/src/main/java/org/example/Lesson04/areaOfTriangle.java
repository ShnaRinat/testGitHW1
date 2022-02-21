package org.example.Lesson04;

public class areaOfTriangle {

    public static double calculateT(double a, double b, double c){
        double p = 0;
        double S = 0;

        p = (a+b+c)/2;
        S = Math.sqrt((p*(p-a)*(p-b)*(p-c)));
        return S;
    }
}