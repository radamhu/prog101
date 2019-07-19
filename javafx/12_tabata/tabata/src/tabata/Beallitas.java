/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabata;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author adamr
 */
public class Beallitas {
    private Integer tabata, ciklus, gyak, pihen;
    Properties p = new Properties();
    
    public Beallitas() {
        try (FileInputStream be = new FileInputStream("tabata.ini")) {
            p.load(be);
            tabata=Integer.parseInt(p.getProperty("tabata"));
            ciklus=Integer.parseInt(p.getProperty("ciklus"));
            gyak=Integer.parseInt(p.getProperty("gyak"));
            pihen=Integer.parseInt(p.getProperty("pihen"));
        } catch (IOException ex) {
            tabata = 1;
            ciklus = 8;
            gyak = 20;
            pihen = 10;
        }
    }
    
    public boolean ment() {
        try (FileOutputStream ki = new FileOutputStream("tabata.ini")) {
            p.setProperty("tabata", tabata.toString());
            p.setProperty("ciklus", ciklus.toString());
            p.setProperty("gyak", gyak.toString());
            p.setProperty("pihen", pihen.toString());
            p.store(ki, "Tabata beállítások");
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public Integer getTabata() {
        return tabata;
    }

    public Integer getCiklus() {
        return ciklus;
    }

    public Integer getGyak() {
        return gyak;
    }

    public Integer getPihen() {
        return pihen;
    }

    public void setTabata(Integer tabata) {
        this.tabata = tabata;
    }

    public void setCiklus(Integer ciklus) {
        this.ciklus = ciklus;
    }

    public void setGyak(Integer gyak) {
        this.gyak = gyak;
    }

    public void setPihen(Integer pihen) {
        this.pihen = pihen;
    }

}
