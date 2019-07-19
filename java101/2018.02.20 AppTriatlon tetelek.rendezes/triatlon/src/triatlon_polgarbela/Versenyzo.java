package triatlon_polgarbela;
public class Versenyzo {
    private String nev;
    private int [] pontok = new int[3];

    public Versenyzo(String[] tmp) {
        this.nev = tmp[0];
        this.pontok[0] = Integer.parseInt(tmp[1]);
        this.pontok[1] = Integer.parseInt(tmp[2]);
        this.pontok[2] = Integer.parseInt(tmp[3]);
    }
    
    public String getNev(){
        return nev;
    }
    
    public int getPontok(int i){
        return pontok[i];
    }
    
    public int getSzummaPontok(){
        int N = pontok.length;
        int s = 0;
        for (int i = 0; i < N; i++){
            s += pontok[i];
        }
        return s;
    }
    
    public String getKonvertal(){
        int x = getSzummaPontok();
        int ora = x / 3600;
        int perc = (x - ora *3600) / 60;
        int mperc = x - (ora * 3600) - (perc * 60);
        String s = String.format("%02d:%02d:%02d", ora,perc,mperc);
        return s;
    }
}
