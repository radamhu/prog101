package bolygok;
public class Bolygok {
    static String[] b = {"Merkúr","Vénusz","Föld","Mars","Jupiter",
     "Szaturnusz","Uránusz","Neptunusz"};
    
    static void kiir() {
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println("");
    }
    
    static void csere(int n) {
        String seged = b[n];
        b[n] = b [n+1];
        b[n+1] = seged;
    }
    
    static void rendez() {
        for (int i = b.length-1; i > 0; i--)    
            for (int j = 0; j < i; j++) 
                if (b[j].compareTo(b[j+1]) > 0 ) 
                    csere(j);
    }
    
    public static void main(String[] args) {
        kiir();
        rendez();
        kiir();
    }
}
