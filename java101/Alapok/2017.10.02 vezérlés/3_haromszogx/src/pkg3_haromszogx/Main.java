package pkg3_haromszogx;
public class Main {
    public static void main(String[] args) {
        int a, b, c;
        java.util.Scanner sc = new java.util.Scanner(System.in);//új példány létrehozása
        System.out.println(); //soremelés
        System.out.println(" Háromszög szerkeszthetőség vizsgálata "); //soremeléssel
        System.out.println(); //soremelés
        System.out.print(" a = "); a = sc.nextInt();
        System.out.print(" b = "); b = sc.nextInt();
        System.out.print(" c = "); c = sc.nextInt();
        System.out.println(); //soremelés
        
        if ((a+b)>c && (a+c)>b && (c+b)>a) {
            System.out.println(); //soremelés
            System.out.println(" k = "+(a+b+c)+" cm");
            double s = (a+b+c)/2;
            double t = Math.sqrt(s*(s-a)*(s-b)*(s-c));
            System.out.println(" t = "+t+" cm2");
            System.out.println(" t = "+t+" cm2");
        } else {
            System.out.println("nem szerkeszthető");
        }
        System.out.println(); //soremelés
        System.out.println("A kilépéshez nyomjon Enter-t"); //soremelés
        System.console().readLine(); //várakozás, csak az Entert figyeli csak
    }

    private static double s(double d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
