/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuvar;

/**
 *
 * @author t1
 */
public class Taxis {
    private int taxi_id;
    private String indulas;
    private int idotartam;
    private double tavolsag;
    private double viteldíj;
    private double borravalo;
    private String fizetes_modja;

    public Taxis(int taxi_id, String indulas, int idotartam, double tavolsag, double viteldíj, double borravalo, String fizetes_modja) {
        this.taxi_id = taxi_id;
        this.indulas = indulas;
        this.idotartam = idotartam;
        this.tavolsag = tavolsag;
        this.viteldíj = viteldíj;
        this.borravalo = borravalo;
        this.fizetes_modja = fizetes_modja;
    }

    public int getTaxi_id() {
        return taxi_id;
    }

    public void setTaxi_id(int taxi_id) {
        this.taxi_id = taxi_id;
    }

    public String getIndulas() {
        return indulas;
    }

    public void setIndulas(String indulas) {
        this.indulas = indulas;
    }

    public int getIdotartam() {
        return idotartam;
    }

    public void setIdotartam(int idotartam) {
        this.idotartam = idotartam;
    }

    public double getTavolsag() {
        return tavolsag;
    }

    public void setTavolsag(double tavolsag) {
        this.tavolsag = tavolsag;
    }

    public double getViteldíj() {
        return viteldíj;
    }

    public void setViteldíj(double viteldíj) {
        this.viteldíj = viteldíj;
    }

    public double getBevetel() {
        return viteldíj+borravalo;
    }

        public double getBorravalo() {
        return borravalo;
    }
        
    public void setBorravalo(double borravalo) {
        this.borravalo = borravalo;
    }

    public String getFizetes_modja() {
        return fizetes_modja;
    }

    public void setFizetes_modja(String fizetes_modja) {
        this.fizetes_modja = fizetes_modja;
    }

   
}
