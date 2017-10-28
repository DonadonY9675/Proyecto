/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.dominio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 *
 * @author Miguel
 */
public abstract class Constantes {

    public static double IGV = 0.183123;

    //redondea un double a 2 decimales readondeando al numero superior
    public static double redondear(double numero, int cantidad_decimales) {
        String val = numero + "";
        BigDecimal big = new BigDecimal(val);
        big = big.setScale(cantidad_decimales, RoundingMode.HALF_UP);
        return big.doubleValue();
    }
       
    //redondea un double a dos decimales de forma correcta y devuelve un string
    //formateado a 2 deciamels , ejm: 15.3 devuelve 15.30
    public static String redondearStr(double numero){
        DecimalFormat df = new DecimalFormat("0.00");
         double num = redondear(numero,2);
         return df.format(num);
    }
    
}
