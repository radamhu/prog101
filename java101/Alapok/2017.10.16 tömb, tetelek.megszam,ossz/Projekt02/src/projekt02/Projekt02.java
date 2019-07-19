package projekt02;
public class Projekt02 {
    static void waiting() {
        System.err.println("Várakozás az ENTER-re");
        System.console().readLine();
    }
    
    static void f1(){
        int t [] = new int[100];
        int N = t.length;
        int fh=2; int ah=1;
        for (int i = 0; i < N; i++) {
            double x = Math.random()*(fh-ah+1)+ah;
            t[i] = (int)x;
        }
        for (int i = 40; i < 50; i++) {
            System.out.print(t[i]+" ");
        }
        System.out.println("");
    }
    
        static void f2(){
        int t [] = {10, 15, 6, 21, 8, 1, 10, 5, 7};
        int N = t.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < t[i]; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        f1();
        f2();
        waiting();
    }
    
}
