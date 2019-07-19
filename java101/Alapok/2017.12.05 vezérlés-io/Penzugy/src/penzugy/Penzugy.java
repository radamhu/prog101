package penzugy;
import java.io.*;
public class Penzugy {
 static String nev[]= new String[12];
 static String oszt[]= new String[12];
 static int fizetes[]= new int [12];
 static int jutalom[]= new int [12];
 static String szam[]= new String[12];


    static void f3(){
        
            int N=nev.length; 

            RandomAccessFile f; String sor; 
                try {
                    f= new RandomAccessFile("adatok.txt","r");
                    for (int v=0; v <12;v++) {
 
                    sor=f.readLine();
                    String [] tt = sor.split(",");
                    nev[v] = tt[0];
                    oszt[v] = tt[1];
                   
                    fizetes[v] = Integer.parseInt(tt[2]);
                    jutalom [v] = Integer.parseInt(tt[3]);
                    szam [v] = tt[4];
                    }
                    

                    f.close();
                } catch(IOException e){
                    System.out.println("Baj van");
                }
    }
    static void f4(){
      int min= fizetes[0]; int magjut=0; int ossz=0;
            for (int v=0;v<12;v++) {
                ossz=ossz+jutalom[v];
                
                if (min > fizetes[v]) {
                    min = fizetes[v];
                }
                if (magjut < jutalom[v]) {
                 magjut = jutalom[v];   
                }
                }
            
            System.out.println(String.format("%26s%,10d Ft", "Összes kifizetett jutalom: ", ossz ));
            System.out.println(String.format("%27s%,10d Ft", "Legmagasabb jutalom: ", magjut ));
            System.out.println(String.format("%27s%,10d Ft", "Legalacsonyabb fizetés: ", min ));


                    
                            System.out.println();

            }
        
    public static void main(String[] args) {
        f3();
        f4();
    }
    
}

