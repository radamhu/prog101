package ádámroland;
public class ÁdámRoland {
    // struktúrált programozás
    // második évben jön az objektum orientált
    
    // tagváltozó, mindenki látja
    static String hegyek[] ={"Zár-hegy", "Sváb-hegy", "Lótusz-hegy", 
        "Gumi-hegy", "Kár-hegy", "Lágy-hegy", "Fekete-hegy", "Erő-hegy", 
        "Dandár-hegy", "Golgota-hegy", "Rétes-hegy"
    };
    static int fa_irtas[] ={500,862,701,652,703,600,700,1500,850,860,970};
    
    static void waiting() {
        System.out.println();
        System.out.println();
        System.out.print(" A kilépéshez nyomjon Entert!"); // nem emel sort!
        System.console().readLine(); // várakozás, csak az Entert figyeli
    }//várakozás vége
    
    // blokkok; ezen belüli x-et nem látja senki
    // megszámlálás tétele, először kiszámoljuk az összegét, majd átlagát
    static void f1(){
        int s=0; 
        int N = hegyek.length;
        java.util.Scanner sc= new java.util.Scanner(System.in);
        System.out.print(" "+"x% = ");double x=sc.nextDouble();
        
        System.out.println(
            // macskaköröm, 15 karakter, decimális 3 helyre
            String.format("%15s %10s %10s %10s","Terület", "Írtás", "Pótlás", "Ültetendő")
        );
        
        System.out.println();
        
        for (int i = 0; i < N; i++) {
            System.out.println(
                String.format("%15s %10d %10.0f %10.0f",hegyek[i], fa_irtas[i], (fa_irtas[i]/x), (fa_irtas[i]+fa_irtas[i]/x))
            );
        }
    }
    
    static void f2(){
        int N = hegyek.length;
    }
    
    public static void main(String[] args) {
        f1();System.out.println();
        //10waiting();
    }
}
