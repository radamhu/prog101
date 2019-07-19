package apptarsalgo;

public class Adat {

    //tagváltozók

    private final String hova;
    private final int ora;
    private final int perc;
    private final int id;
    private int percben;
    
    //konstruktor  
    public Adat(String sor) {
        String[] t = sor.split(" ");
        this.ora = Integer.parseInt(t[0]);
        this.perc = Integer.parseInt(t[1]);
        this.id = Integer.parseInt(t[2]); 
        this.hova = t[3];
        setPercben();
    }     

    private int setPercben() {
        this.percben = (this.ora * 60 + this.perc);
        return this.percben;
    }
    
    public String getHova() {
        return hova;
    }

    public int getOra() {
        return ora;
    }

    public int getPerc() {
        return perc;
    }

    public int getId() {
        return id;
    }
    
    public int getPercben() {
        return this.percben;
    }
}
