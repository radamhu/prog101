package iskola;

public class Tanulo {
    private String ev;
    private String osztaly;
    private String nev;
    private String azon;

    public Tanulo(String s) {
        String[] t = s.split(" ", 4);
        ev = t[0];
        osztaly = t[1];
        nev = t[2] + " " + t[3];
        azon = ev.charAt(3) + osztaly 
               + t[2].substring(0,3).toLowerCase()
               + t[3].substring(0,3).toLowerCase();
    }
    
    public String getEv() {
        return ev;
    }

    public String getOsztaly() {
        return osztaly;
    }
    
    public String getNev() {
        return nev;
    }
        
    public String getAzon() {
        return azon;
    }
}
