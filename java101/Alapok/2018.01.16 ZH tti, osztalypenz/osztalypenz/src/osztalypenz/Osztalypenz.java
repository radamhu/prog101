package osztalypenz;

import java.io.*;
import java.util.Arrays;

public class Osztalypenz {

    static String t[][] = new String[37][4];
    static RandomAccessFile f;
    
    static void adatokBe(String f_neve){ // Paraméteres beolvasás
        try {
            f = new RandomAccessFile(f_neve, "r");
            int sorokN = t.length;
            for (int sor = 0; sor<sorokN; sor++) {
                t[sor] = f.readLine().split("\t"); 
            }
            f.close();
        } catch (IOException e) {
            System.out.println("Baj van babám");
        }
        System.out.println("    az adatok.txt beolvasás ... kész!");
        System.out.println();
    }
    
    // összegzés tétele
    static  int szumma (String t1[]) {
        int N = t1.length, s = 0;
        // a t1[0]. elem a tanuló neve ezért t[1]-től indul a ciklus
        for (int i = 1; i < N; i++) {
            s += Integer.parseInt(t1[i]);  // a t1[i]. elem string
        }
        return s;
    }
    
    // Írja ki az első 10 tanuló adatait a minta szerint ( minden mező mérete: "%12s" )!
    static void rekordok1_10(){
        int oszlopok = t[0].length;
        int sor = 11;
        for (int i = 0; i < sor; i++) {
            for (int j = 0; j < oszlopok; j++) {
                System.out.print(String.format("%12s", t[i][j]));
            }
            System.out.println("");
        }
    }
    
    // Akik 38 000 Ft-nál többet hoztak be az évben, azoknak a különbözetet vissza kell adni.
    // megszámlálás
    static void adatokKi(String f_neve){  
        try{
            f = new RandomAccessFile(f_neve,"rw");
            int N = t.length;
            for (int sor =1; sor<N; sor++){
                if (szumma(t[sor])>38000) {
                    f.writeBytes(String.format("%12s %5d",t[sor][0], szumma(t[sor])-38000) );
                }
            }
            f.close();
        }catch(IOException e){
            System.out.println("Baj van babám");
        }
        System.out.println("\t"+ f_neve+" írása ......"+" kész!");
    }
    
    // Mennyi volt a havonta osztálypénz bevétel
    // 
    static void op_havi() {
        String temp[] = new String[46];
        int oszlopokN = t[0].length;
        int sorokN=t.length;
        for (int oszlop = 1; oszlop < oszlopokN; oszlop++) {
            for (int sor = 1; sor < sorokN; sor++) {
                temp[sor] = t[sor][oszlop];  // havi adatok a temp[]-be
            }
        System.out.println(String.format("%12s %12d %12s", t[0][oszlop], szumma(temp), "Ft"));
        }
    }
    
    // Mennyi pénzt hozott be Vak Cina?
    // kiválasztás + összegzés
    static void vak_cina () {
        int sor = 0;
        while (!(t[sor][0].equals("Vak Cina"))) {            
            sor = sor+1;
        }
        System.out.println(String.format("%12s %12d %12s", t[sor][0], szumma(t[sor]), "Ft"));
    }
    
    // Írja ki a nevét és a hátralékát azoknak, akik legalább 10 000 Ft-al tartoznak.
    static void tartoznak (){
        int sorokN=t.length;
        for (int sor = 1; sor < sorokN; sor++) {
            if (38000-(szumma(t[sor]))>9999) {
                System.out.println(String.format("%12s %12d %12s", t[0][sor], (38000-szumma(t[sor])), "Ft"));
            }
        }
    }
    
    public static void main(String[] args) {
        adatokBe("adatok.txt");
        rekordok1_10();
        adatokKi("ft_vissza.txt");
        op_havi();
        vak_cina();
        tartoznak();
    }
}
