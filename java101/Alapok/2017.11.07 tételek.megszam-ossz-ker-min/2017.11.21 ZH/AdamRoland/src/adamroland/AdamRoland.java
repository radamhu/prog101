package adamroland;
public class AdamRoland {
    static String nevek[]={"Combos Edina","Elvegy Elek","Cserepes Virág",
        "Csinál Tamás","Gáz Rózsa","Csizma Dia","De Bella","Dezo Dóra",
        "Happy Endre"};
    static int liter[]={100,80,80,200,110,100,60,110,80};
    static int fo[]={2,4,10,4,6,3,9,7,1};
    
    static void waiting() {
        System.out.println();
        System.out.println();
        System.out.print(" A kilépéshez nyomjon Entert!"); 
        System.console().readLine(); 
    }
    
    static void f1() {
        System.out.println();
        System.out.println(String.format("%16s %10s %10s %10s %10s %10s","Szemeteskuka","Liter","Fő","Ft1","Ft2","Ft3"));  
        int N = nevek.length;
        for (int i=0;i<N;i++){
            int Ft1 = 300;
            if (liter[i] < 300) {
                Ft1 = 200;
            }
            int Ft2 = 200;
            if (liter[i] >= 100) {
                Ft2 = 3*liter[i];
            }
            int Ft3 = 300;
            if (fo[i] < 5) {
                Ft3 = 200;
            }
                System.out.println(String.format("%16s %10d %10d %10d %10d %10d",nevek[i], liter[i], fo[i], Ft1, Ft2, Ft3 ));
            }
        }
    
    public static void main(String[] args) {
        f1();
        // waiting();
    }
    
}
