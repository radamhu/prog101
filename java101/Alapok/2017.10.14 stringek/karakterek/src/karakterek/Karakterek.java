package karakterek;

public class Karakterek {

    public static void main(String[] args) {
        for (int i = 33; i < 128; i++) {
            System.out.print((char)i + " ");
            if ((i-32) % 20 == 0) {
                System.out.println("");
            }
        }
        System.out.println("");
        
        String mh = "íöüóőéáúűÍÖÜÓÉÁÚŰ";
        for (int i = 0; i < mh.length(); i++) {
            char c = mh.charAt(i);
            System.out.println(c + " " + (int)c);
        }
    }
}
