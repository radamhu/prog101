package appkultura;

public class Tanulo {
    
    //tagváltozók
    private String nev, evfolyam, osztaly;
    private int szinhaz, mozi, oldal;
    
    //konstruktor  
    public Tanulo(String sor) {
        String[] t = sor.split(", ");
        this.nev = t[0];
        this.evfolyam = t[1];
        this.osztaly = t[2]; 
        this.szinhaz = Integer.parseInt(t[3]);
        this.mozi = Integer.parseInt(t[4]);
        this.oldal = Integer.parseInt(t[5]);
    }      
    
    public String getNev() {
        return nev;
    }

    public String getEvfolyam() {
        return evfolyam;
    }

    public String getOsztaly() {
        return osztaly;
    }

    public int getSzinhaz() {
        return szinhaz;
    }

    public int getMozi() {
        return mozi;
    }
    
    public int getOldal() {
        return oldal;
    }
}
