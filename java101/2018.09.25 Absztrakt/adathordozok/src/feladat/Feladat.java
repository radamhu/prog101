package feladat;

/**
 * Öröklődés gyakorlő feladat
 * @author Tóth József
 */
public class Feladat {

    public static void main(String[] args) {
        Adathordozo[] tomb = new Adathordozo[4];
        tomb[0] = new Merevlemez(320, 5400);
        tomb[1] = new Merevlemez(1000, 7200);
        tomb[2] = new Pendrive(32, 2);
        tomb[3] = new Pendrive(64, 3);

        for (Adathordozo a : tomb) {
            System.out.println(a.toString());
        }
        
        Adathordozo max = tomb[0];
        for (int j = 1; j < tomb.length; j++) {
            if (tomb[j].nagyobbMint(max)) {
                max = tomb[j];
            }
        }
        System.out.println("A legnagyobb kapacitású: " + max.toString());

        System.out.println("A pendrive-ok: ");
        for (Adathordozo a : tomb) {
            if (a instanceof Pendrive) {
                System.out.println(a.toString());
            }
        }
    }
}
