package appszem;

public class Szemely {
    String nev;
    String szemelyiszam;
    String szuletesidatum;
    char neme;
    
    public Szemely(String sor ) {
        String [] tmp = sor.split("\t");
        this.nev = tmp[0];
        this.szemelyiszam = tmp[1];
        setSzuletesidatum(szemelyiszam);
        setNeme(szemelyiszam);
    }
    
    public String getNev() {
        return nev;
    }
    
    private char setNeme(String szemelyiszam) {
        neme = 'n';
        char c = szemelyiszam.charAt(0);
        if (c == '1' || c == '3') {
            neme = 'f';
        }
        return neme;
    }
    
    public char getNeme() {
        return neme;
    }
        
    private String setSzuletesidatum(String szemelyiszam) {
        szuletesidatum = "19";
        char c = szemelyiszam.charAt(0);
        if (c =='3' || c =='4') {
            szuletesidatum = "20";
        }
        String ev = szuletesidatum + szemelyiszam.substring(2,3) + ".";
        String ho = szemelyiszam.substring(4,5) + ".";
        String nap = szemelyiszam.substring(6,7);
        szuletesidatum = ev + ho + nap;
        return szuletesidatum;
    }
    
    public String getSzuletesidatum() {
        return szuletesidatum;
    }
    
    public String getKor() {
        return this.szuletesidatum + this.szemelyiszam.substring(7, 10);
    }
  
    public String getKiiras() {
        return String.format("%15s %10s", new Object[] { this.nev, this.szuletesidatum });
    }
}
