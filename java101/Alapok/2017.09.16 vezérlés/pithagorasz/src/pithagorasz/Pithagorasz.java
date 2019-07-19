package pithagorasz;

import java.util.Scanner;

public class Pithagorasz {

    public static void main(String[] args) {
        Scanner bill = new Scanner(System.in);
        double a = bill.nextDouble();
        double b = bill.nextDouble();
        double c;
        c = Math.sqrt((Math.pow(a, 2)+Math.pow(b,2)));
        System.out.println("a oldal: " + Math.round(a));
        System.out.println("b oldal: " + Math.round(b));
        System.out.println("c oldal: " + Math.round(c));
    }    
}
