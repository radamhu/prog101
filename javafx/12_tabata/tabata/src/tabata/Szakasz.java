/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabata;

/**
 *
 * @author adamr
 */
public class Szakasz {
    private char c;
    private int n;

    public Szakasz(char c, int n) {
        this.c = c;
        this.n = n;
    }

    public char getC() {
        return c;
    }

    public int getN() {
        return n--;
    }

}
