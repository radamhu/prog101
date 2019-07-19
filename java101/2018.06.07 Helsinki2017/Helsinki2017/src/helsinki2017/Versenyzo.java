package helsinki2017;

import org.omg.CORBA.DefinitionKind;

public class Versenyzo {
    
    // változók
    private String nev;
    private String orszag;
    private double rovtech;
    private double rovkomp;
    private int rovhiba;
    private double dontotech;
    private double dontokomp;
    private int dontohiba;
    private boolean bejutott;
    
    // konstruktor
    public Versenyzo(String sor) {
        String s[] = sor.split(";");
        nev = s[0];
        orszag = s[1];
        rovtech = Double.parseDouble(s[2]);
        rovkomp = Double.parseDouble(s[3]);
        rovhiba = Integer.parseInt(s[4]);
        dontotech = 0.0;
        dontokomp = 0.0;
        dontohiba = 0;
        bejutott = false;
    }
    
    /* 
    * Az adatokat később ki kell egészíteni a döntő pontszámaival 
    * paraméterként kapja meg a döntőbeli pontszámokat
    */
    public void hozzaad(String dt, String dk, String dh) {
        dontotech = Double.parseDouble(dt);
        dontokomp = Double.parseDouble(dk);
        dontohiba = Integer.parseInt(dh);
        bejutott = true;
    }
    
    public double Osszpontszam() {
        return rovtech + rovkomp - rovhiba + dontotech + dontokomp -dontohiba;
    }
    
    public String getEredmeny() {
        return String.format("%s;%s;%.2f", nev, orszag, Osszpontszam());
    }
    
    public String getNev() {
        return nev;
    }

    public String getOrszag() {
        return orszag;
    }

    public double getRovtech() {
        return rovtech;
    }

    public double getRovkomp() {
        return rovkomp;
    }

    public int getRovhiba() {
        return rovhiba;
    }

    public double getDontotech() {
        return dontotech;
    }

    public double getDontokomp() {
        return dontokomp;
    }

    public int getDontohiba() {
        return dontohiba;
    }

    public boolean isBejutott() {
        return bejutott;
    }
}
