package paritas;
public class Paritas {

    public static void main(String[] args) {       
        int x; 
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("Egészszám (x) parítás vizsgálata");
        System.out.println();
        System.out.print("  x = "); x = sc.nextInt();//input az sc példánnyal
        if(x %2 == 0){  
            System.out.println("  páros");  
        } else{
            System.out.println("  páratlan");
        }
        System.out.println();
        System.out.print("A kilépéshez nyomjon Entert!"); // nem emel sort!
        System.console().readLine(); // várakozás, csak az Entert figyeli
    }
    
}
