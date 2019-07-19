package rekurzio;

public class Rekurzio {
    
    static void kiir(int n) {
        if (n > 0) {
            kiir(n-1);
            System.out.println(n);
        }
    }  
    
    public static void main(String[] args) {
        kiir(8);
    }
}
