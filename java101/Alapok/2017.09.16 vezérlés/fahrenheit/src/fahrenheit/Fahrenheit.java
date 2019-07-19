package fahrenheit;

import java.util.Scanner;

public class Fahrenheit {

    public static void main(String[] args) {
        System.out.println("Fahrenheit 2 Celsus: ");
        System.out.print("Add meg a fahrenheit-et: ");
        Scanner bill = new Scanner(System.in);
        double temperature = bill.nextDouble();
        temperature = ((temperature - 32)*5)/9;
        System.out.printf("ennyi fok van: %.1f\n", temperature);
        
        System.out.println("Celus 2 Fahrenheit: ");
        System.out.print("Add meg a fok-ot: ");
        double temperature2 = bill.nextDouble();
        temperature2 = (9f/5) * temperature2 + 32;
        System.out.printf("ennyi fok van: %.1f\n", temperature2);
        
    }
}
