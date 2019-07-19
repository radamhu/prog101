package gyumolcsok;
import java.io.*;
public class Gyumolcsok {
    
    static String t[][] = new String[20][8];
    static RandomAccessFile f;
    
    static void f1() {
        String f_neve="adatok.txt";
        try {
            f = new RandomAccessFile(f_neve, "r");
            int sorokN = t.length;
            for (int sor = 0; sor<sorokN; sor++) {
                t[sor] = f.readLine().split(","); //egyből a tömb sorainak feltöltése
            }
            f.close();
        } catch (IOException e) {
            System.out.println("Baj van babám");
        }
        System.out.println("\t" + f_neve+" beolvasása ......" + " kész!");
    } //input vége
    
    static void f2() {
        int sorokN = t.length;
        for(int sor=0; sor< sorokN; sor++){
            int oszlopokN=t[0].length;
            for (int oszlop=0; oszlop<oszlopokN; oszlop++){
                if (sor ==0){System.out.print( String.format("%25s", t[sor][oszlop] ));}
                else{System.out.print( String.format("%25s", t[sor][oszlop] ));}
            }
            System.out.println();
        }
    } //táblázat kiírásának vége
    
    // Számítsa ki a megyékben termelt gyümölcsök mennyiségét
    // összegzés tétele
    static void f3() {
        int s;
        int sorokN = t.length;
        for(int sor=1; sor< sorokN; sor++){
            s = 0;
            int oszlopokN=t[0].length;
            for (int oszlop=1; oszlop<oszlopokN; oszlop++){
                s = s + Integer.parseInt(t[sor][oszlop]);
            }
            System.out.println(String.format("%25s %10s", t[sor][0], s));
        }
    }
    
    // Számítsa ki azt, hogy az egyes gyümölcsökből mennyi termett az országban összesen
    // összegzés tétele
    static void f4() {
        int s;
        int oszlopokN=t[0].length;
        int sorokN = t.length;
        for(int oszlop=1; oszlop< oszlopokN; oszlop++){
            s = 0;    
            for (int sor=1; sor<sorokN; sor++){
                s = s + Integer.parseInt(t[sor][oszlop]);
            }
            System.out.println(String.format("%25s %10s", t[0][oszlop], s));
        }
    }
    
    // A gy_ki.txt állományba:
    // kiiratás
    static void f5() {
        String f_neve="gy_ki.txt";
        File f1 = new File(f_neve); // ha létezik törlöm
        if (f1.exists()) {
            f1.delete();
        }
        try{
            f = new RandomAccessFile(f_neve,"rw");
            int sorokN=t.length;
            for (int sor =0; sor<sorokN; sor++){
                f.writeBytes(t[sor][0]+"\n"); // fájl írása
            }
            f.close();
        }catch(IOException e){
            System.out.println("Baj van babám");
        }
        System.out.println("\t"+ f_neve+" írása ......"+" kész!");
    } //fájlba írás vége
    
    public static void main(String[] args) {
        System.out.println(" " + "1. feladat"); f1(); //input
        System.out.println(" " + "2. feladat"); f2(); //táblázat kiírása
        System.out.println(" " + "3. feladat"); f3(); //táblázat kiírása
        System.out.println(" " + "4. feladat"); f4(); //táblázat kiírása
        System.out.println(" " + "5. feladat"); f5(); //fájlba írás
    }
    
}
