package projekt01;
public class Projekt01 {
    
    static void waiting() {
        System.err.println("Várakozás az ENTER-re");
        System.console().readLine();
    }
    
    static void f1() {
        int t [] =  {12, 34, -3, 45, 8, 100};
        int N = t.length;
        for (int i = 0; i < N; i++) {
            System.out.print(t[i]+" ");
        }
        System.out.println("");
        
        for (int i = N-1; i > 0; i--) {
            System.out.print(t[i]+" ");
        }
        
        System.out.println("");
        
        int db = 0;
        
        for (int i = 0; i < t.length; i++) {
            if (t[i] == 34 ) {
                db++;
            }
        }
        System.out.println("Hány db 34-es szám van: " + db);
        
        System.out.println("");
    }
    
    static void f2() {
        int t [] = new int[5];
        int N = t.length;
        for (int i = 0; i < N; i++) {
            java.util.Scanner sc = new java.util.Scanner(System.in);
            System.out.print("Bekérek 5 számot soronként: "); t[i] = sc.nextInt();
        }
        
        int s = 0;
        for (int i = 0; i < N; i++) {
            s=s+t[i];
        }
        System.out.println(s*5+" ");
    }
    
    static void f3() {
        int t [] = new int[10];
        int N = t.length;
        int fh=20; int ah=10;
        for (int i = 0; i < N; i++) {
            double x = Math.random()*(fh-ah+1)+ah;
            t[i] = (int)x;
        }
        for (int i = 0; i < N; i++) {
            System.out.print(t[i]+" ");
        }
        System.out.println("");
    }
    
    static void f4(){
        int t [] = new int[30];
        int N = t.length;
        int fh=80; int ah=1;
        for (int i = 0; i < N; i++) {
            double x = Math.random()*(fh-ah+1)+ah;
            t[i] = (int)x;
        }
        for (int i = 0; i < N; i++) {
            if (t[i] % 5 == 0 && t[i] %25 != 0 ) {
                System.out.print(t[i]+" ");
            }
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        f1();
        f2();
        f3();
        f4();
        waiting();
    }
    
}
