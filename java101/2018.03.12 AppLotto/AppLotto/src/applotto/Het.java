package applotto;

public class Het {
    //tagváltozók
    private int[] szamok = new int[5];
        
    //konstruktor
    public Het(String sor){
        String [] tmp = sor.split(" ");
        fillSzamok(tmp);
    }
    
    //private metódusok
    private void fillSzamok(String tmp[] ){
        int N = this.szamok.length;
        for (int i = 0; i < N; i++) {
            this.szamok[i] = Integer.parseInt(tmp[i]);
        }
        rendez();
    }
    
    private void rendez(){
        int N = this.szamok.length;
        for (int i = 0; i < N; i++) {
            int minIndex = i;
            for (int j = i; j < N; j++) {
                if (szamok[j] < szamok[minIndex]) {
                    minIndex = j;
                }
            }
            csere(minIndex, i);
        }
    }
    
    private void csere(int i, int j){
        int tmp = this.szamok[i];
        this.szamok[i] = this.szamok[j];
        this.szamok[j] = tmp;
    }
    
    public String getSzamok(){
        String s;
        s = Integer.toString(szamok[0]);
        for (int i = 1; i < 5; i++) {
            s = s+" "+Integer.toString(szamok[i]);
        }
        return s;
    }
}
