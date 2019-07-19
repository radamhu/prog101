package applotto;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AppLotto {

    //Globális változók
    private static ArrayList<Het> hetek = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    
    //1. feladat
    private static void adatokBe(String fileNev) {
        System.out.printf("1. Az adatok beolvasása a(z) %s fileból\n", fileNev);
        try {
            System.out.print("  A fájl beolvasása ... kész! ");
            RandomAccessFile file = new RandomAccessFile(fileNev, "r");
            String sor;
            while ((sor = file.readLine()) != null) {
                hetek.add(new Het(sor));
            }

            file.close();
            System.out.println("sikeres!");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();
    }

    //2. feladat
    private static void het52() {
        System.out.println("2. Az 52. hét adatai");
        System.out.print("  Kérem a hét számait szóközzel elválasztva: ");
        String szamok = sc.nextLine();
        hetek.add(new Het(szamok));        
        System.out.println();
        System.out.println("" + hetek.get(51).getSzamok());
    }

    //3. feladat
    private static void melyikHet() {
        System.out.println("3. Tetszőleges hét számai: ");
        System.out.print("  Melyik hét számait kéred (1-51): ");
        int het = sc.nextInt();
        System.out.println("" + hetek.get(het).getSzamok());
        System.out.println();
        
    }
    
    static void teszt(){
        int N=hetek.size();
        for(int i=0;i<N;i++){
            System.out.println(hetek.get(i).getSzamok());
        }
    }
    
    public static void main(String[] args) {
        adatokBe("lottosz.txt");
        het52();
        // teszt();
        melyikHet();
    }
}
