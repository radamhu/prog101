package triatlon_polgarbela;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;


public class Triatlon_polgarbela {
static RandomAccessFile f;
static ArrayList<Versenyzo> versenyzok = new ArrayList<>();

static void adatokBe(String f_neve){
    String[] tmp = new String[4];
    
    try{
    f = new RandomAccessFile(f_neve,"r");
    int N = Integer.parseInt(f.readLine());
    for (int i = 0; i < N; i++){
        for(int j = 0; j < 4; j++) {
            tmp[j] = f.readLine();
        }
        versenyzok.add(new Versenyzo(tmp));
    }
    f.close();
    } catch (IOException e){
        System.out.println("hiba");
    }
}

static void teszt(){
    int N = versenyzok.size();
    for (int i = 0; i < N; i++){
        System.out.println(String.format("%20s %4d %4d %4d",versenyzok.get(i).getNev(),versenyzok.get(i).getPontok(0),versenyzok.get(i).getPontok(1),versenyzok.get(i).getPontok(2)));
    }
    
}

static void rendezes(){
    int N = versenyzok.size();
    for (int i = N-1; i > 1; i--){
        for (int j = 0; j < i-1 ; j++){
            if(versenyzok.get(j).getSzummaPontok() > versenyzok.get(j+1).getSzummaPontok())
                csere(j,j+1);
        }
    }
}

static void csere (int i,int j){
    Versenyzo tmp = versenyzok.get(i);
    versenyzok.set(i, versenyzok.get(j));
    versenyzok.set(j, tmp);
}

static void elsoHarom(){
    System.out.println("\nAz első három :");
    for (int i = 0; i < 3; i++){
        System.out.println(String.format("%20s %6d",versenyzok.get(i).getNev(),versenyzok.get(i).getSzummaPontok() ));
    }
}

static void sebessegek(){
    double uszas=(double)3.6*1500/(versenyzok.get(0).getPontok(0));
    double kerekparozas = (double)3.6*40000/(versenyzok.get(0).getPontok(1));
    double futas = (double)3.6*10000/(versenyzok.get(0).getPontok(2));
    System.out.println("\n Első helyezett " + versenyzok.get(0).getNev() +" átlagsebességei :");
    System.out.println(String.format("%15s %5.2f %4s", "Úszás :",uszas,"Km/h"));
    System.out.println(String.format("%15s %5.2f %4s", "Kerékpározás :",kerekparozas,"Km/h"));
    System.out.println(String.format("%15s %5.2f %4s", "Futás :",futas,"Km/h"));
}

static void konvertal(){
    System.out.println("\n Idők oo:pp:ss formátumban");
    int N = versenyzok.size();
    for (int i = 0; i < N; i++){
        System.out.println(String.format("%20s %8s",versenyzok.get(i).getNev(),versenyzok.get(i).getKonvertal()));
    }
    
}
  
public static void main(String[] args) {
        adatokBe("triatlon.txt");
        teszt();
        rendezes();
        elsoHarom();
        sebessegek();
        konvertal();
    }
    
}
