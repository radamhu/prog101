package appkekesteto;

public class Adat {
    
    //tagváltozók
    private final String idokep;
    private final int homerseklet;
    private String szelirany; // beállítani
    private final int szelerosseg;
    private final int legnyomas;
    private String paratartalom; // %
    private final int ora; // a rekord száma
    private String napszak;
    
    //konstruktor  
    public Adat(String sor, int i) {
        String[] t = sor.split("\t");
        this.ora = i;
        this.idokep = t[0];
        this.homerseklet = Integer.parseInt(t[1]);
        this.szelirany = setSzelirany(t[2]);
        this.szelerosseg = Integer.parseInt(t[3]);
        this.legnyomas = Integer.parseInt(t[4]);
        setNapszak();
        setParatartalom(Double.parseDouble(t[5]));
    }
    
    //public metódusok
    // tagváltozók kijelöl, jobb klikk, insert code, getter  
    private String setSzelirany(String t) {
        String irany = null;
        int fok = Integer.parseInt(t);
        if (fok == 0) {
            irany = "É";
        } else if (fok > 0 && fok < 90) {
            irany = "ÉK";
        } else if (fok == 90) {
            irany = "K";
        } else if (fok > 90 && fok < 180) {
            irany = "DK";
        } else if (fok == 180) {
            irany = "D";
        } else if (fok > 180 && fok < 270) {
            irany = "DNY";
        } else if (fok == 270) {
            irany = "NY";
        } else if (fok > 270 && fok < 360) {
            irany = "ÉNY";
        }

        return irany;
    }

    private void setParatartalom(double x) {
        int x1 = (int)Math.round(x * 100.0D);
        String s = Integer.toString(x1);
        this.paratartalom = (x1 + "%");
    }

    private void setNapszak() {
        this.napszak = "éjjel";
        if ((this.ora > 7) && (this.ora < 17)) {
            this.napszak = "nappal";
        }
    }
    
    public String getNapszak() {
        return this.napszak;
    }
    
    public int getHomerseklet() {
        return homerseklet;
    }
    
    public int getSzelerosseg() {
        return szelerosseg;
    }
    
    public String getSzelirany() {
        return szelirany;
    }
    
    public String getIdokep() {
        return idokep;
    }
    
    public String getParatartalom() {
        return this.paratartalom;
    }        
    
    public int getLegnyomas() {
        return this.legnyomas;
    }
}
