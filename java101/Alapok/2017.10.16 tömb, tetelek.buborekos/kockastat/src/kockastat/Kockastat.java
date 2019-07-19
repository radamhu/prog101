package kockastat;
import java.util.Random;
public class Kockastat {

    public static void main(String[] args) {
        System.out.println("Kockadobás statisztika");
        Random vg = new Random();
        int d;
        int[] dobas = new int[7];
        // dobások
        for (int i = 0; i < 10000; i++) {
            d = vg.nextInt(6) + 1;
            dobas[d]++;
        }
        // kiírás
        for (int i = 0; i < 6; i++) {
            System.out.println(i + ": " + dobas[i]);
        }
    }
}
