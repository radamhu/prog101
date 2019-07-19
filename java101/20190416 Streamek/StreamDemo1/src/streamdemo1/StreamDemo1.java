package streamdemo1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Joe
 */
public class StreamDemo1 {

    /**
     * @param args the command line arguments
     * throws ioexception van, nem try, tehát be kell zárni a fájlt, hogy továbbmenjünk
     */
    public static void main(String[] args) throws IOException {
        Scanner be = new Scanner(new File("szavak.txt"));
        ArrayList<String> szolista = new ArrayList<>();
        while (be.hasNextLine())
            szolista.add(be.nextLine());
        be.close();
        
        // hagyományos módszer
        long db = 0;
        for (String szo : szolista)
            if (szo.length() > 10)
                db++;
        System.out.println("Hosszú szavak száma: " + db);
        
        // stream
        db = szolista.stream()
            .filter(s -> s.length() > 10)
            .count();
        System.out.println("Hosszú szavak száma: " + db);
    }
}
