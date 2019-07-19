package alkalmazottDemo;

import java.util.Calendar;

/**
 * Alkalmazott osztály kipróbálása
 * @author Tóth József
 */
public class AlkalmazottDemo {

    static Calendar most = Calendar.getInstance();
    static int ev = most.get(Calendar.YEAR);
    
    public static void main(String[] args) {
        Alkalmazott.setEv(ev);
        Alkalmazott a = new Alkalmazott("Nagy János",300000,1965);
        System.out.println(a.adatok());
        a.novel(10000);
        System.out.println(a.adatok());
    }
}
