package javaapplication1;

import com.sun.org.apache.bcel.internal.generic.FieldOrMethod;

import java.io.*;
import java.util.IllformedLocaleException;

public class JavaApplication1 {
    
    // globális változó
    // deklarálás: elemtípus [][] tömbNév ;
    // létrehozás: new [sor][oszlop] elemtípus;
    static String aru[][]= new String [100][3];
    static int N=aru.length; 
    static int oszlop= 3;

    static void beolvas() {
        for ()
        RandomAccessFile f;
        String sor; 
        try {
            f= new RandomAccessFile("piac.txt","r");
            for (int v=0; v < N;v++) {
                // tömb feltöltése v1.0
                // segédváltozók: String tt[], sor;
                sor=f.readLine(); // egy sor beolvasása sor-ba;
                // sor szeletelése tt[]-be;
                String [] tt = sor.split(",");
                for (int i = 0; i < 3; i++) {
                     aru[v][i] = tt[i];
                }
                //egyből a tömb sorainak feltöltése v2.0
                //aru[sor] = f.readLine().split(",");
            }
            f.close();
        } catch(IOException e){
            System.out.println("Baj van piac olvasásnál");
        }
    }                            
    
    static void megnez() {
        System.out.println(String.format("%26s%8s%6s", "gyümölcs ", "Ft/kg", "kg" ));
        for (int v=0; v <N;v++) {
             System.out.println(String.format("%26s%8s%6s", aru[v][0], aru[v][1],aru[v][2] ));
        }
    }
    
    // Írja ki a szilva vásárlásokat a minta szerint
    // kiválogatás kiírásra
    static void szilva() {
        System.out.println(String.format("%-26s", "Szilva leválogatása "));
        System.out.println(String.format("%26s%8s%6s", "gyümölcs ", "Ft/kg", "kg" ));
        for (int v=0; v <N;v++) {
            if ("szilva".equals(aru[v][0])){
                 System.out.println(String.format("%26s%8s%6s", aru[v][0], aru[v][1],aru[v][2] ));
            }
        }
    }
    
    // Mennyit költött Karcsi körtére? 
    // kiválogatás (összegzés)
    static void korte() {
        System.out.println(String.format("%-26s", "körtére költés "));
        int osszeg=0;
        for (int v=0; v <N;v++) {
            if ("körte".equals(aru[v][0])){
              osszeg = (Integer.parseInt(aru[v][1])*Integer.parseInt(aru[v][2]))+osszeg;
            }
        }
         System.out.println(String.format("%26s%,8d Ft%6s", "Karcsi körtére", osszeg, " költött" ));
    }
    
    // Van-e 500 Ft/kg-nál drágább dinnye? 
    // lineáris keresés
    static void dinnye() {
        System.out.println(String.format("%-26s", "Dinnye van-e drága"));
        boolean van= false;
        int v=0;
        while (!("dinnye".equals(aru[v][0]) && Integer.parseInt(aru[v][1]) > 500)){
            van = false;   
            v++;
        }
        if (!van) {
            System.out.println(String.format("%36s", " van" ));
        } else {
            System.out.println(String.format("%36s", " nincs" ));
        }
    }
    
    // Mennyibe került a legdrágább barack? 
    // maximum kiválasztás
    static void dragabarack() {
        System.out.println(String.format("%-26s", "Legdrágább barack"));
        int max=0;
        for (int v=0; v <N;v++) {
            if ("barack".equals(aru[v][0])){
                if (Integer.parseInt(aru[v][1])> max) {
                    max = Integer.parseInt(aru[v][1]);
                }
            }
        }
        System.out.println(String.format("%26s%,8d Ft", "Legdrágább barack", max));
    }
    
    static void szilva2() {
        System.out.println(String.format("%-26s", "Szilva átlagnál drágább "));

        int atlag=0; 
        int db=0;
        
        for (int v=0; v <N;v++) {

            if ("szilva".equals(aru[v][0])){
                atlag=atlag+Integer.parseInt(aru[v][1]);
                db++;
            }
        }
        atlag=atlag/db;
        System.out.println(String.format("%26s%8s", "átlag: ", atlag));
        System.out.println(String.format("%26s%8s%6s", "gyümölcs ", "Ft/kg", "kg" ));

        for (int v=0; v <N;v++) {

            if ("szilva".equals(aru[v][0]) &&  Integer.parseInt(aru[v][1]) > atlag ){
                 System.out.println(String.format("%26s%8s%6s", aru[v][0], aru[v][1],aru[v][2] ));
            }
        }
        
  
 }       
     
    public static void main(String[] args) {

        beolvas();
        szilva();
        korte(); 
        dinnye();
        dragabarack();
        szilva2();
        // megnez();
    }
    
}
