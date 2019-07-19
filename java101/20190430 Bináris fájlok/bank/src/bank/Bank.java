package bank;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.Scanner;

public class Bank {
    
    public static void main(String[] args) throws IOException {
        Scanner bill = new Scanner(System.in,"cp1250");
        Random vg = new Random();
        final int REKORD_MERET = 8;
        // megnyitás, és új fájl esetén feltöltés
        File f = new File("bank.dat");
        RandomAccessFile adatok = new RandomAccessFile(f, "rw");
        if (f.length() == 0) {
            for (int i = 100; i < 1000; i++) {
                int v = vg.nextInt(1000);
                adatok.writeInt(i);
                adatok.writeInt(v);
            }
        } 
        // lekérdezés, betét/kivét
        while (true) {
            System.out.print("Számlaszám (100-999): ");
            int sz = bill.nextInt();
            if (sz < 100 || sz >999)
                break;
            adatok.seek((sz-100)*REKORD_MERET);
            System.out.println("Számlaszám: " + adatok.readInt());
            int egyenleg = adatok.readInt();
            System.out.println("Egyenleg:   " + egyenleg);
            adatok.seek(adatok.getFilePointer()-4);
            System.out.print("Betét/kivét:  ");
            int betet = bill.nextInt();
            System.out.println("Új egyenleg: " + (egyenleg + betet));
            adatok.writeInt(egyenleg + betet);
        }
        adatok.close();
    }
}
