package vakacio;

public class Vakacio {

    public static void main(String[] args) {
        String s = "vakáció";
        for (int i = s.length()-1; i >=0; i--) {
            System.out.println(s.substring(i));
        }
        String s2 = "Európa Bajnokság";
        System.out.println(s2.substring(7,10));
    }
}
