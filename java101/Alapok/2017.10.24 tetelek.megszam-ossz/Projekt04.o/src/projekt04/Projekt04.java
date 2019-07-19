package projekt04;

public class Projekt04 {

    static void waiting() {
        System.out.println();
        System.out.println();
        System.out.print(" A kilépéshez nyomjon Entert!"); // nem emel sort!
        System.console().readLine(); // várakozás, csak az Entert figyeli
    }//várakozás vége

    private static void f1() {
        System.out.println(" " + "1. feladat");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("   " + "a= ");
        int a = sc.nextInt();
        System.out.print("   " + "b= ");
        int b = sc.nextInt();
        int N = b - a + 1;
        int t[] = new int[N];
        for (int i = 0; i < N; i++) {
            t[i] = a + i;
        }
        int s = 0;
        System.out.print("   ");
        for (int i = 0; i < N-1; i++) {
            System.out.print(t[i] + ", ");
            s = s + t[i];
        }
        System.out.println(t[N-1]);
        System.out.println();
        //formázások: https://www.webotlet.hu/?p=1372
        System.out.print("   " + "összeg: ");
        System.out.print(String.format("%,d", s));
        System.out.println();
    }// f1 vége

    private static void f2() {
        System.out.println(" " + "2. feladat");
        int t[] = {3, 5, 5, 6, 1, 4, 4, 1, 5, 3, 14};
        int N = t.length;
        int s = 0;
        System.out.print("   ");
        for (int i = 0; i < N-1; i++) {
            System.out.print(t[i] + ", ");
            s = s + t[i];
        }
        System.out.println(t[N-1]);
        System.out.println("0000000000 000000000");
        //System.out.println("   "+"összeg: "+s);
        System.out.println(
                String.format("%10s %6d", "összeg", s)
        );
        //System.out.print("   "+"átlag: ");System.out.println(String.format("%.2f",(double)s/N));
        System.out.println(
                String.format("%10s %9.2f", "átlag", (double) s / N)
        );
    }// f2 vége

    private static void f3() {
        System.out.println(" " + "3. feladat");
        int t[] = {3, 2, 5, -2, -5, -3};
        int N = t.length;
        int s = 0;
        System.out.print("   ");
        for (int i = 0; i < N; i++) {
            System.out.print(t[i] * t[i] + ", ");
            s = s + t[i] * t[i];
        }
        System.out.println(t[N-1] * t[N-1]);
        int d = t[0];
        for (int i = 1; i < N; i++) {
            d = d - t[i];
        }
        System.out.println();
        System.out.println(
                String.format("%18s %5d", "négyzetek összege",s)
        );
        System.out.println(
                String.format("%18s %5d", "különbség",d)
        );

    } //f3 vége

    private static void f4() {
        System.out.println(" " + "4. feladat");
        int t[] = {300, 200, 555, 7202, 4555, 1230};
        int N = t.length;
        int s = 0;
        System.out.print("   ");
        for (int i = 0; i < N; i++) {
            System.out.print(t[i] + ", ");
            s = s + t[i];
        }
        System.out.println(t[N-1]);
        System.out.print(
                String.format("%12s %,5d %2s", "hátralék:", 20000-s, "Ft")
        );        
    } // f4 vége

    public static void main(String[] args) {
        f1();System.out.println();
        f2();System.out.println();
        f3();System.out.println();
        f4();System.out.println();
        waiting();
    }
}
