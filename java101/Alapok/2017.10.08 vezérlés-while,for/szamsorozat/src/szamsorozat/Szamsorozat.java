package szamsorozat;

public class Szamsorozat {

    public static void main(String[] args) {
        int i = 500;
        while (i >= 400) {            
            System.out.println(i + " ");
            i-=7;
        }
        System.out.println("\n" + i);
    }
}
