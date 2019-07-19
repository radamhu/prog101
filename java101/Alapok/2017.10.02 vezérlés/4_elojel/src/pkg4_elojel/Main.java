package pkg4_elojel;
public class Main {
    public static void main(String[] args) {
        int a;
        java.util.Scanner sc = new java.util.Scanner(System.in);//új példány létrehozása
        System.out.println(); //soremelés
        System.out.println(" Egy egészszám előjele (+; 0; -) "); //soremeléssel
        System.out.println(); //soremelés
        System.out.print(" a = "); a = sc.nextInt();
        System.out.println(); //soremelés
        
        if ( a > 0) {
            System.out.print(" Pozitív "); 
        } else if (a == 0) {
            System.out.print(" Nulla "); 
        }
        else {
            System.out.print(" Negatív "); 
        }
  
        System.out.println(); //soremelés
        System.out.println("A kilépéshez nyomjon Enter-t"); //soremelés
        System.console().readLine(); //várakozás, csak az Entert figyeli csak
    }
    
}
