package pkg2_gombx;
public class Main {
    public static void main(String[] args) {
        int r1, r2;
        double V1, V2;
        java.util.Scanner sc = new java.util.Scanner(System.in);//új példány létrehozása
        System.out.println(); //soremelés
        System.out.println(" Gömbök térfogatának különbsége"); //soremeléssel
        System.out.println(); //soremelés
        System.out.print(" r1 = "); r1 = sc.nextInt();
        System.out.print(" r2 = "); r2 = sc.nextInt();
        System.out.println(); //soremelés
        V1 = 4*Math.pow(r1, 3)*Math.PI/3; V2 = 4*Math.pow(r2, 3)*Math.PI/3;
        if (V1 >V2) {
            System.out.println(" V1 - V2 = "+(V1-V2)+" cm3"); 
            System.out.println(" V1 - V2 = "+(V1-V2)+" cm3"); 
        } else {
            System.out.println(" V2 - V1 = "+(V2-V1)+" cm3"); 
            System.out.println(" V2 - V1 = "+(V2-V1)+" cm3"); 
        }
        System.out.println(); //soremelés
        System.out.println("A kilépéshez nyomjon Enter-t"); //soremelés
        System.console().readLine(); //várakozás, csak az Entert figyeli csak
    }
}
