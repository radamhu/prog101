/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gepnaplo;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author adamr
 */
public class Seged {
    public static String datumido() {
        LocalDate d = LocalDate.now();
        LocalTime t = LocalTime.now();
        return d.toString() + " " + t.toString().substring(0, 8);
    }

    public  static  String gepnev() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException ex) {
            return "";
        }
    }

    static String levag(String s, int h) {
        if (s.length() > h)
            return  s.substring(0,h);
        else
            return s;
    }

    public static void main(String[] args) {
        System.out.println(datumido());
        System.out.println(gepnev());
        System.out.println(levag("0123456789", 5));
        System.out.println(levag("0123456789", 15));
    }
}
