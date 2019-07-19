package fvi;
import java.util.Random;
public class Fvi {

    public static void main(String[] args) {
        Random vel = new Random();
        int dobas;
        int fej = 0;
        int iras = 0;
        for (int i = 0; i < 10; i++) {
            dobas = vel.nextInt(2);
            if (dobas == 0) {
                System.out.print("fej ");
                fej++;
            } else {
                System.out.print("írás ");
                iras++;
            }
        }
        System.out.println("\n" + fej + " fej " + iras + " írás");
    }
}
