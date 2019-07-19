package iskola;

/**
 * Tanulo osztály tesztelése
 * @author Tóth József
 */
public class TanuloTeszt {
    public static void main(String[] args) {
        Tanulo t1 = new Tanulo("2016 e Hidas Reka");
        System.out.println(t1.getEv()+" "+t1.getOsztaly()+" "+t1.getNev());
        System.out.println(t1.getAzon());
    }
    
}
