package pkgfor;
public class FOR {
    public static void main(String[] args) {
        System.out.println("1. Az [1, 10] intervallum számai");
        for (int i = 0; i <= 10; i++) {
            System.out.print(" "+i);
        }
        System.out.println("");
        System.out.println("");
        
        System.out.println("2. Tíz véletlenszám az [1, 50] intervallumból");
        for (int i = 0; i < 10; i++) {
            double x = Math.random()*50 +1;
            System.out.print(" "+(int)x);
        }
        System.out.println("");
        System.out.println("");
        
        System.out.println("3. Az első N<11 négyzetszáma");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print(" N = "); int N = sc.nextInt();
        for (int i = 1; i < N; i++) {
            System.out.println(i*i+"");
        }
        System.out.println("");
        System.out.println("");
        
        System.out.println("4. Az N2<23 nem nagyobb páratlan számok");
        System.out.print(" N2 = "); int N2 = sc.nextInt();
        for (int i = 1; i <= N2; i=i+2) {
            System.out.println(i + "");
        }
        System.out.println("");
        System.out.println("");
        
        System.out.println("5. Az N3<23-tól csökkenő sorrendben a páros számok");
        System.out.print(" N3 = "); int N3 = sc.nextInt();
        if (N%2 != 0) {
            N3=N3-1;
        } 
        for (int i = N3; i > 0; i=i-2) {
            System.out.println(i+"");
        }
    }
    
}
