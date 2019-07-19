package kocka2;
import java.util.Random;

public class Kocka2 {

    public static void main(String[] args) {
        Random vg = new Random();
        int[][] dobasok = new int[7][7];
        int sor, oszlop;
        for (int i = 0; i < 1000; i++) {
            sor = vg.nextInt(6)+1;
            oszlop = vg.nextInt(6)+1;
            dobasok[sor][oszlop]++;
        }
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                System.out.print(dobasok[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
