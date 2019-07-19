/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorozatok;

/**
 *
 * @author adamr
 */
public class Sorozat {
    private String cim;
    private int evad;
    private int resz;
    
    public Sorozat() {
        this.cim = "";
        this.evad = 1;
        this.resz = 1;
    }
    
    public Sorozat(String sor) {
        String[] s = sor.split(";");
        this.cim = s[0];
        this.evad = Integer.parseInt(s[1]);
        this.resz = Integer.parseInt(s[2]);
    }
    
    public String getCim() {
        return cim;
    }
    
    public void setCim(String cim) {
        this.cim = cim;
    }
    
    public int getEvad() {
        return evad;
    }
    
    public void setEvad(int evad) {
        this.evad = evad;
    }
    
    public int getResz() {
        return resz;
    }
    
    public void setResz(int resz) {
        this.resz = resz;
    }
    
    @Override
    public String toString() {
        return cim + ";" + evad + ";" + resz;
    }
    
    public void novel() {
        this.resz++;
    }
}
