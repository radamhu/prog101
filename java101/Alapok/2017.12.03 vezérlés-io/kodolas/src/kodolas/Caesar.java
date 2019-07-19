/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kodolas;

/**
 *
 * @author t1
 */
class Caesar {
    String titkosit(String s, int tol) {
        // ékezetes betűk
        s = s.toUpperCase().replace(" ", "");
        s = s.replace("Á", "A").replace("É", "E").replace("Í", "I");
        s = s.replaceAll("[ÓÖŐ]", "O").replaceAll("[ÚÜŰ]", "U");
        // eltolás
        String uj = "";
        int hossz = 'Z' - 'A' + 1;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) + tol;
            if (c < 'A') {
                c += hossz;
            }
            uj += (char) c;
        }
        return uj;
    }
}
