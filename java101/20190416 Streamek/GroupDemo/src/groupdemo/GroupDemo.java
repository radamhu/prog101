package groupdemo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Joe
 */
public class GroupDemo {

    public static void main(String[] args) throws IOException {
        Scanner be = new Scanner(new File("szavak.txt"));
        ArrayList<String> szolista = new ArrayList<>();
        while (be.hasNextLine())
            szolista.add(be.nextLine());
        be.close();
        // számolás kezdőbetűnként
        Map<String, Long> darabSzamok = szolista.stream()
            .collect(Collectors.groupingBy(
                s -> s.substring(0, 1),
                Collectors.counting())
            );
        for (String s : darabSzamok.keySet())
            System.out.println(s + ": " + darabSzamok.get(s));
        // leghosszabbak kezdőbetűnként
        Map<String, Optional<String>> leghosszabbak = szolista.stream()
            .collect(Collectors.groupingBy(
                s -> s.substring(0, 1),
                Collectors.maxBy((p,s) -> p.length()-s.length()))
            );
        for (String s : leghosszabbak.keySet())
            System.out.println(s + ": " + leghosszabbak.get(s).orElse(""));
    }
}
