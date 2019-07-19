package matek_01;
public class Matek_01 {
    public static void main(String[] args) {
        
        int a,b;
        double c;
        
        java.util.Scanner sc = new java.util.Scanner(System.in);//új példány létrehozása
        System.out.println(""); //soremeléssel
        System.out.println("Számtani és mértani közép (a, b)");
        System.out.println(""); //soremeléssel
        System.out.print("    a ="); a = sc.nextInt(); 
        System.out.print("    b ="); b = sc.nextInt(); 
        System.out.println(""); //soremeléssel
        System.out.println("    számtani közép = " +(a+b)/2); 
        c = Math.sqrt(a*b);
        System.out.println("    mértani közép = " +c); 
        c = Math.round(c*100)/100.0;
        System.out.println("    mértani közép = " +c); 
        System.out.println(""); //soremeléssel
        
        System.out.println("Kilépéshez nyomjon ENTER-t");
        System.console().readLine(); // várakozás csak az ENTER-t figyeli
    }
}
