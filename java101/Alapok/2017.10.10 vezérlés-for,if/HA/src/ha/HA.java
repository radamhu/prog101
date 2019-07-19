package ha;
public class HA {
    public static void main(String[] args) {
        int x, y;
        java.util.Scanner sc = new java.util.Scanner(System.in);//új példány létrehozása
        System.out.println("x osztható-e 2-vel, vagy 3-mal, vagy mind kettővel");
        System.out.print(" x = "); x = sc.nextInt(); //input az sc példánnyal
        
        if (x%6 == 0) {
            System.out.println("A(z) x osztható 2-vel és 3-mal");
        } else if (x%2 == 0) {
            System.out.println("A(z) x osztható 2-vel");
        } else if (x%3 == 0 ) {
            System.out.println("A(z) x osztható 3-mal");
        } else {
            System.out.println("A(z) x nem osztható 2-vel vagy  3-mal");
        }
        
        System.out.println("Melyik a nagyobb x, y vagy, egyenlő???");
        System.out.print(" x = "); x = sc.nextInt(); //input az sc példánnyal
        System.out.print(" y = "); y = sc.nextInt(); //input az sc példánnyal
        
        if (x>y) {
            System.out.println(x+" > "+y);
        } else if (x<y){
            System.out.println(y+" > "+x);
        } else {
            System.out.println(x+" = "+y);
        }
    }
    
}
