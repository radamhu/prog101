package vasmegye;

/**
 * Személyi szám kezelése
 * @author tothj
 */
public class Szam {
    private String szam;
    private int ev;

    public Szam(String sor) {
        this.szam = sor;
        if (szam.charAt(0)=='1' || szam.charAt(0)=='2')
            this.ev = 1900 + Integer.parseInt(szam.substring(2,4));
        else    
            this.ev = 2000 + Integer.parseInt(szam.substring(2,4));
    }
    
    public boolean cdvEll() {
        String s = szam.replace("-", "");
        int k = 0;
        for (int i = 0; i < 10; i++) {
            int c = s.charAt(i)-'0';
            k += (10-i)*c;
        }
        k = k % 11;
        return (k == (s.charAt(10)-'0'));
    }
    
    public String getSzam() {
        return szam;
    }
    
    public boolean getFiu() {
        return szam.charAt(0)=='1' || szam.charAt(0)=='3';
    }
    
    public int getEv() {
        return ev;
    }
    
    public String getDatum() {
        return szam.substring(4, 8);
    }
    
//    public static void main(String[] args) {
//        Szam sz1 = new Szam("3-000115-5882");
//        System.out.println(sz1.cdvEll());
//        System.out.println(sz1.ev);
//        Szam sz2 = new Szam("1-980227-1258");
//        System.out.println(sz2.cdvEll());
//        System.out.println(sz2.ev);
//    }
}
