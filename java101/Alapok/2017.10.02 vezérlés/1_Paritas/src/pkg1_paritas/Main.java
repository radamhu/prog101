package pkg1_paritas;
public class Main {
    public static void main(String[] args) {
        int x;
        java.util.Scanner sc = new java.util.Scanner(System.in);//új példány létrehozása
        System.out.println("Egészszám (x) paritás vizsgálata"); //soremeléssel
        System.out.println(); //soremelés
        System.out.print(" x = "); x = sc.nextInt(); //input az sc példánnyal
        if (x%2 == 0) {
            System.out.println(" páros"); //soremeléssel
        } else {
            System.out.println(" páratlan"); //soremeléssel
        }
        System.out.println(); //soremelés
        System.out.println("A kilépéshez nyomjon Enter-t"); //soremelés
        System.console().readLine(); //várakozás, csak az Entert figyeli csak
    }
    
}
