package projekt05;
public class Projekt05 {    
    //tagváltozók (a projektben mindenhol láthatók)
    static String nevek []={"Gipsz Jakab", "Kelep Elek", "Kiss Géza", "Nagy Péter", "Kovács Éva"};
    static int pontok1 [] ={4, 9, 7, 7, 6}, 
               pontok2 [] ={5, 7, 5, 9, 8},
               pontok3 [] ={7, 7, 10, 8, 10},
               pontok4 [] ={10, 9, 10, 9, 10};
    
    static void waiting() {
        System.out.println();
        System.out.println();
        System.out.print(" A kilépéshez nyomjon Entert!"); // nem emel sort!
        System.console().readLine(); // várakozás, csak az Entert figyeli
    }//várakozás vége

    private static void f1() {        
        System.out.println();
        System.out.println(String.format("%12s","1. feladat"));  
        int N = nevek.length;
        for (int i=0;i<N-1;i++){
            if (pontok1[i]>pontok1[i+1]){
                System.out.println(String.format("%16s",nevek[i+1]));
            }
        }        
    }// f1 vége

    private static void f2() {
        int N = nevek.length;
        int t [] = new int[N];
        System.out.println();
        System.out.println(String.format("%12s","2. feladat"));
        for (int i =0;i<N;i++){
            if (pontok1[i]!=10){t[i]=t[i]+ pontok1[i];}
            if (pontok2[i]!=10){t[i]=t[i]+ pontok2[i];}
            if (pontok3[i]!=10){t[i]=t[i]+ pontok3[i];}
            if (pontok4[i]!=10){t[i]=t[i]+ pontok4[i];}            
        }
        for (int i=0;i<N;i++){
            System.out.println(String.format("%16s %3d", nevek[i], t[i]));
        }
    }// f2 vége

    private static void f3() {        
        System.out.println(String.format("%12s","3. feladat"));
        int N = nevek.length;
        int t [] = new int[N];
        for (int i =0;i<N;i++){
            if (pontok1[i]==10 && t[i]==0){t[i]=1;}
            if (pontok2[i]==10 && t[i]==0){t[i]=2;}
            if (pontok3[i]==10 && t[i]==0){t[i]=3;}
            if (pontok4[i]==10 && t[i]==0){t[i]=4;}            
        }
        for (int i=0;i<N;i++){
            if (t[i]!=0){
                System.out.println(String.format("%16s %3d", nevek[i], t[i]-1));
            }            
        }

    } //f3 vége

    private static void f4() {
        System.out.println(String.format("%12s","4. feladat"));
        String t [] = {" ", " ", " ", " ", " "};
        int N = nevek.length;
        for (int i =0;i<N;i++){
            if (pontok1[i]==9 ){t[i]=t[i]+" "+1;}
            if (pontok2[i]==9 ){t[i]=t[i]+" "+2;}
            if (pontok3[i]==9 ){t[i]=t[i]+" "+3;}
            if (pontok4[i]==9 ){t[i]=t[i]+" "+4;}            
        }
        for (int i=0;i<N;i++){
            if (t[i]!=" "){
                System.out.println(String.format("%16s %8s", nevek[i], t[i]));
            }            
        }
        
    } // f4 vége

    public static void main(String[] args) {
        f1();System.out.println();
        f2();System.out.println();
        f3();System.out.println();
        f4();System.out.println();
        waiting();
    }    
}
