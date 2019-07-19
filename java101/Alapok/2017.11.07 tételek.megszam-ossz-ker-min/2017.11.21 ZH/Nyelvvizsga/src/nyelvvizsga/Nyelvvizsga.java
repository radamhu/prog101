package nyelvvizsga;
public class Nyelvvizsga {
    
    static String nevek[]={"Buchern Lajosné","Bujdosó Lászlóné","Czeglédi Ferenc",
        "Csürke György","Demjén Zoltán","Dobsa Ottóné","Dózsa Ferenc","Egedi József",
        "Fazekas Gabriella","Gerlecz Krisztián"};
    static String ID[]={"6397","7047","6358","6458","6423","7026","6415","7041","6482","4774"};
    static String szint[]={"alapfok","középfok","alapfok","középfok","középfok",
        "alapfok","alapfok","alapfok","középfok","alapfok"};
    static int pontok[]={125,149,132,148,145,145,120,135,121,141,};
    
    static void waiting() {
        System.out.println();
        System.out.println();
        System.out.print(" A kilépéshez nyomjon Entert!"); 
        System.console().readLine(); 
    }
    
    static void f1() { 
        System.out.println();
        System.out.println(String.format("%20s %10s %10s %10s","Nevek","ID","Szint","pont"));  
        int N = nevek.length;
        for (int i=0;i<N;i++){
            System.out.println(String.format("%20s %10s %10s %10d",nevek[i], ID[i], szint[i], pontok[i]));
            }
        System.out.println();
        }
    
    // //megszámlálás tétele
    static void f2(){
        System.out.println();
        System.out.println(String.format("%20s ", "Vizsgázók száma:"));
        int db1=0, db2=0;
        int N = nevek.length;
        for (int i=0;i<N;i++) {
            if (szint[i] == "alapfok") {
                db1++;
            } else {
                db2++;
            }
        }
        System.out.println(String.format("%20s %10d", "alapfok", db1));
        System.out.println(String.format("%20s %10d", "középfok", db2));
        System.out.println("");
    }
    
    //kiválogatás tétele
    static void f3(){
        System.out.println();
        System.out.println(String.format("%20s ", "Alapfokon vizsgázók:"));
        int N = nevek.length;
        for (int i=0;i<N;i++) {
            if (szint[i] == "alapfok") {
                System.out.println(String.format("%20s %10s %10s %10d", nevek[i], ID[i], szint[i], pontok[i]));
            }
        }
        System.out.println("");
    }
    
    //kiválogatás tétele
    static void f4(){
        System.out.println();
        System.out.println(String.format("%35s ", "Középfokon elérték a 146 pontot:"));
        int N = nevek.length;
            for (int i=0;i<N;i++) {
                if (szint[i] == "középfok" && pontok[i]>145) {
                    System.out.println(String.format("%20s %10s %10s %10d", nevek[i], ID[i], szint[i], pontok[i]));
                }
            }
        System.out.println("");
    }
    
    //keresés tétele
    static void f5(){
        System.out.println();
        System.out.println(String.format("%35s ", "Van-e 149 pont feletti középfokon:"));
        int i=0, N=nevek.length;
        while (i<N && !(szint[i] == "középfok" && pontok[i]>149)){
            i++;
        }
        if(i<N){ 
            System.out.println(String.format("%10s","van"));
        } else { 
            System.out.println(String.format("%10s","nincs"));
        }
    }
    
    public static void main(String[] args) {
        f1(); //a String.format utasítással a táblázat kiírása
        f2(); //megszámlálás tétele
        f3(); //kiválogatás tétele
        f4(); //kiválogatás tétele
        f5(); //keresés tétele
        // waiting();;
    }
    
}
