package appvalasztasok;

public class Jelolt {
    
    //tagváltozók
    private int korzet;
    private int szavazatok;
    private String nev;
    private String part;
    
    // tagváltozók kijelöl + egér jobbklikk + INSERT CODE + getter ...
    public int getKorzet() {
        return korzet;
    }

    public int getSzavazatok() {
        return szavazatok;
    }

    public String getNev() {
        return nev;
    }

    public String getPart() {
        return part;
    }
        
    //konstruktor
    public Jelolt(String sor){
        String [] tmp = sor.split(" ");
        korzet = Integer.parseInt(tmp[0]);
        szavazatok = Integer.parseInt(tmp[1]);
        nev = tmp[2]+" "+tmp[3];
        part = setPart(tmp);
    }
    
    //private metódusok
    private String setPart(String tmp[] ) {
        part = tmp[4];
        if (part.equals("-") ) {
            part = "függetlenek";
        } 
        return part;
    }
}
