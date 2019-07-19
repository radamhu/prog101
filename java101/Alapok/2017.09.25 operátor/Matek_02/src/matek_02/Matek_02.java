package matek_02;
public class Matek_02 {

    public static void main(String[] args) {
        int a, b;
        java.util.Scanner sc = new java.util.Scanner(System.in);//új példány létrehozása
        System.out.println(""); //soremeléssel
        System.out.println("Kétjegyű szám számjegyeinek összege"); 
        System.out.println("");
        System.out.print("    a = "); a = sc.nextInt(); 
        System.out.println("");
        b = a/10; a = a%10;
        System.out.println("    a = " +a);  
        System.out.println("    b = " +b);
        System.out.println("    a + b = "+(a+b));  
        System.out.println("");
        System.out.println("Kilépéshez nyomjon ENTER-t");
        System.console().readLine(); // várakozás csak az ENTER-t figyeli
    }
    
}
