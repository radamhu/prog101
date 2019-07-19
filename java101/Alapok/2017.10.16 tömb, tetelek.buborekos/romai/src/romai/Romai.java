package romai;
import java.util.Scanner;
public class Romai {

    public static void main(String[] args) {
        Scanner bill = new Scanner(System.in);
        String[] egyesek  = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String[] tizesek  = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] szazasok = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] ezresek = {"","M","MM","MMM"};
        String romai;
        while (true) {            
            // beolvasás
            System.out.print("Az átváltandó szám: ");
            int szam = bill.nextInt();
            if (szam < 1 || szam > 3999)
                break;
            // ezresek
            romai = ezresek[szam/1000];
            szam %= 1000;
            // százasok
            romai += szazasok[szam/100];
            szam %= 1000;
            // tizesek
            romai += tizesek[szam/10];
            szam %= 10;
            // egyesek
            romai += egyesek[szam];
            // kiírás
            System.out.println("Rómain számmal: " + romai);
        }
    }
}
