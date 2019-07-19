package apptanc;

public class Elem {
    
    // tagváltozók
    private String tanc;
    private String lany;
    private String fiu;
    
    // konstruktor
    public Elem(String tanc, String lany, String fiu) {
        //String[] tmp = sor.split(" "); // mindenki a saját adatait szeleteli
        this.tanc = tanc;
        this.lany = lany;
        this.fiu = fiu;
    }
    
    public String getTanc() {
        return tanc;
    }

    public String getLany() {
        return lany;
    }
    
    public String getFiu() {
        return fiu;
    }
}
    
