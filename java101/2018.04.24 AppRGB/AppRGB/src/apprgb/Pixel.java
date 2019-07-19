package apprgb;

public class Pixel {

    //tagváltozók
    private String rgb;
    private int sor;
    private int oszlop;
    
    //konstruktor    
    public Pixel(String px, int s, int o){
        this.rgb = px;
        this.sor = s;
        this.oszlop = o;
    } 

    //public metódusok
    // tagváltozók kijelöl, jobb klikk, insert code, getter    
    public int getOszlop() {
        return oszlop;
    }

    public String getRgb() {
        return rgb;
    }

    public int getSor() {
        return sor;
    }

}
