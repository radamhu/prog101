package orszagok;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author tothj
 */
public class Orszagok {
    private static ArrayList<Orszag> lista;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
            throws IOException, ClassNotFoundException {
        // beolvasás vagy új lista
        File f = new File("foldrajz.dat");
        if (f.exists()) {
            ObjectInputStream be = new ObjectInputStream(
                                   new FileInputStream(f));
            lista = (ArrayList<Orszag>)be.readObject();
            be.close();
        } else {
            lista = new ArrayList<Orszag>();
        }
        // Adatok beírása
        while (true) {
            Scanner bill = new Scanner(System.in,"cp1250");
            System.out.print("Ország: ");
            String o = bill.nextLine();
            if (o.isEmpty())
                break;
            System.out.print("Főváros: ");
            String v = bill.nextLine();
            lista.add(new Orszag(o, v));
        }
        // Listázás
        for (Orszag o : lista) {
            System.out.println(o.getNev() + " " + o.getFovaros());
        }
        // Mentés
        ObjectOutputStream ki = new ObjectOutputStream(
                                new FileOutputStream(f));
        ki.writeObject(lista);
        ki.close();
    }
}
