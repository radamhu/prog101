package apphelyjegy;

public class Utas {

    //tagváltozók    
    private int szek;
    private int mettol;
    private int meddig;
    private int km;
    private boolean vegig;
    private int ft; 
    
    //konstruktor    
    public Utas(String sor){
        String[] tmp = sor.split(" "); 
        this.szek = Integer.parseInt(tmp[0]);
        this.mettol = Integer.parseInt(tmp[1]);
        this.meddig = Integer.parseInt(tmp[2]);
        this.km = meddig - mettol;
        setVegig(); // eljárás: beállítja a végig mezőt
        setFt(); // eljárás: beállítja a Ft mezőt
    }

    //private metódusok
    private void setFt() {
        int km10 = km / 10;// egész, osztás, megkezdett 10 km-ek
        if (km % 10 != 0) { // maradékos osztás
            km10 = km10 + 1;
        }
        //kerekítés
        ft = km10 * 71;
        int mod = ft % 5; // 0,1,2,3,4        
        if (mod > 2) {
            ft = ft + 5 - mod;
        }else{
           ft = ft - mod; 
        }
    }
    
    private void setVegig() {
        vegig = (meddig - mettol == 172);
    }

    //public metódusok
    public int getSzek() {
        return szek;
    }
    
    public int getKm() {
        return km;
    }
    
    public int getFt() {
        return ft;
    }
    
    public boolean isVegig() {
        return vegig;
    }
}
