package feladat;

import java.util.ArrayList;

public class Feladat {
    
    static ArrayList<Adathordozo> adathordozok = new ArrayList<Adathordozo>();
    
    static void maxkival() {
        int N = adathordozok.size();
        int max = 0;
        for (int i = 0; i < N; i++) {
            if ((adathordozok.get(i).getKapacitas()) > max) {
                max = adathordozok.get(i).getKapacitas();
            }
        }
        System.out.println("Legnagyobb: " + max);
    }
    
    public static void main(String[] args) {
        Merevlemez a = new Merevlemez("Hitach", 500, 5400);
        Merevlemez b = new Merevlemez("Samsung", 1024, 7200);
        Pendrive c = new Pendrive("Kingston", 16, 2);
        Pendrive d = new Pendrive("Sony", 2048, 3);
             
        adathordozok.add(a);
        adathordozok.add(b);
        adathordozok.add(c);
        adathordozok.add(d);
          
        for (int i = 0; i < adathordozok.size(); i++) {
            System.out.println(adathordozok.get(i).toString());
        }
        
        maxkival();
        
        
    }
}
