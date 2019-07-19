package jelszo;
import java.util.Random;
public class Jelszo {

    public static void main(String[] args) {
        String kar = "abcdefghijklmnopqrstuvwxyz";
        kar += kar.toUpperCase();
        kar += "0123456789_()";
        Random vg = new Random();
        int vel;
        String jelszo;
        
        for (int i = 0; i < 5; i++) {
            jelszo = "";
            for (int j = 0; j < 16; j++) {
                vel = vg.nextInt(kar.length());
                jelszo += kar.charAt(vel);
            }
            System.out.println(jelszo);
        }
    }
}
