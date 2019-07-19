package utepites;

public class Auto {

    //tagváltozók

    private final int ora;
    private final int perc;
    private final int mperc;
    private final double sebesseg;
    private final String irany;
    private final int mp_ido;
    
    //konstruktor  
    public Auto(String sor) {
        String[] t = sor.split("\t");
        this.ora = Integer.parseInt(t[0]);
        this.perc = Integer.parseInt(t[1]);
        this.mperc = Integer.parseInt(t[2]); 
        this.sebesseg = Double.parseDouble(t[3]); 
        this.irany = t[4];
        this.mp_ido = ora*3600+perc*60+mperc; 
    }     
    
    public int getMp_ido() {
        return mp_ido;
    }

    public int getOra() {
        return ora;
    }

    public int getPerc() {
        return perc;
    }

    public int getMperc() {
        return mperc;
    }

    public double getSebesseg() {
        return sebesseg;
    }

    public String getIrany() {
        return irany;
    }

}
