package lotto;

public class Lotto {

    static long szorzat(int m, int n) {
        if (n - m > 1) {
            return m* szorzat(m+1, n);
        }else{
            return m*n;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("5-ös lottó:\t" + szorzat(86,90)/szorzat(1, 5));
        System.out.println("5-ös lottó:\t" + szorzat(40,45)/szorzat(1, 6));
        System.out.println("5-ös lottó:\t" + szorzat(29,35)/szorzat(1, 7));
    }
}
