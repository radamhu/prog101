package kozoskoltseg;

public class Lako {
    String nev;
    int [] fogyasztas = new int [3];
    
    public Lako(String sor ) {
        String [] tmp = sor.split("\t"); // mindenki a saját adatait szeleteli a tmp[]-be
        this.nev = tmp[0]; // a név a tmp[0] eleme
        this.fillFogyasztas(tmp); // a fillFogyasztás(tmp)feltölti a fogyasztás[]-t
    }

    
    private void fillFogyasztas(String tmp[]) {
        // for (int i = 0; i < 3; i++) {
        //    fogyasztas[i]=Integer.parseInt(tmp[i*2+2]) - Integer.parseInt(tmp[i*2+1]);
        //}
        // ez ugyanaz mint a for ciklusos
        fogyasztas[0] = Integer.parseInt(tmp[2])-Integer.parseInt(tmp[1]);
        fogyasztas[1] = Integer.parseInt(tmp[4])-Integer.parseInt(tmp[3]);
        fogyasztas[2] = Integer.parseInt(tmp[6])-Integer.parseInt(tmp[5]);

    }
    
    
    // kommunikáció a főprogrammal
    public String getNev() {
        return nev;
    }
    
    public int [] getFogyasztas() {
        return fogyasztas;
    }
    
    public String getSzamla () {
        String fmelegviz = String.format("%15s %6d m3 %10d Ft ", "melegvíz: ", fogyasztas[0], fogyasztas[0]*10);
        String fhidegviz = String.format("%15s %6d m3 %10d Ft ", "hidegviz: ", fogyasztas[1] ,fogyasztas [1] *8);
        String fvillany = String.format("%15s %6d kwh %10d Ft ", "villany: ", fogyasztas[2] ,fogyasztas[2] *3);
        String fTV = String.format("%15s %20d Ft ", "TV: ", 3800);
        String fKozos = String.format("%15s %20d Ft ", "Közös: ", 3500);
        String vonal = " ############# ";
        int szumma = fogyasztas[0] * 10 + fogyasztas[1] * 8 + fogyasztas[2] *3 + 3800 + 3500;
        String fOsszes = String.format("%15s %20d Ft ", "Összesen: ", szumma);
        String s = fmelegviz + "\n" + fhidegviz + "\n" + fvillany + "\n" + fTV + "\n" + fKozos + "\n" + fOsszes + "\n";
        return s;
    }
}