/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.utils;

import java.text.DateFormat;
import java.util.Date;

/**
 *
 * @author MATHEUS-PC
 */
public class Utils {
    public static String pegarDataAtual(){
        Date d = new Date();
        return java.text.DateFormat.getDateInstance(DateFormat.DATE_FIELD).format(d);
    }
}
