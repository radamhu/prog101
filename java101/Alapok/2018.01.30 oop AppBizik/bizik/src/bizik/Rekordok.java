package bizik;

public class Rekordok {

    private final String nev;
    private final int irodalom;
    private final int nyelvtan;
    private final int matematika;
    private final int fizika;
    private final int informatika;
    private final int angol;
    
    private final double avgTanulo;
    private final String ertekeles;
    private final int db5;
    private final String nincs3;

    public Rekordok(String[] t) {
        this.nev = t[0];
        this.irodalom = Integer.parseInt(t[1]);
        this.nyelvtan = Integer.parseInt(t[2]);
        this.matematika = Integer.parseInt(t[3]);
        this.fizika = Integer.parseInt(t[4]);
        this.informatika = Integer.parseInt(t[5]);
        this.angol = Integer.parseInt(t[6]);
        
        this.avgTanulo = avgTanulo(t);
        this.ertekeles = ertekeles(t);
        this.db5 = db5(t);
        this.nincs3 = nincs3(t);
    }
    
    private double avgTanulo(String t[]) {
        int N=t.length;
        double x = 0;
        for (int i = 1; i < N; i++) {
            x = x + Integer.parseInt(t[i]);
        }
        return (Double)x/(N-1);
    }
    
    private String ertekeles(String t[]) {
        String s = "jó";
        if (avgTanulo(t)>3.9) {
            s = "jeles";
        }
        return s;
    }
    
    private int db5( String t[]) {
        int s = 0;
        for (int i = 1; i < t.length; i++) {
            if (t[i].equals("5")) {
                s++;
            }
        }
        return s;
    }
    
    private String nincs3( String t[]) {
        int i = 1;
        String van3as = "";
        while (i < t.length && !t[i].equals("3")) {
            i++;
        }
        if (i >= t.length ) {
            van3as = "van";
        }
        return van3as;
    }
    
    @Override
    public String toString() {
        String s;
        s = String.format(
                "%16s %5d %5d %5d %5d "
                    + "%5d %5d %6.2f    %-8s %3d %5s",
                nev, irodalom, nyelvtan, matematika,
                fizika, informatika, angol,
                avgTanulo, ertekeles, db5, nincs3
        );
        return s;
    }
    
    
}
