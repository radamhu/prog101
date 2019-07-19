package oszt37;

public class Oszt37 {

    public static void main(String[] args) {
        int i = 200;
        while (i<=300) {            
            if (i%3 == 0 && i%7 == 0) {
                System.out.println(i + "");
            }
            i++;
        }
        System.out.println("\n");
    }
    
}
