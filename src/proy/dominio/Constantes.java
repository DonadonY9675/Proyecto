/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.dominio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.Calendar;

/**
 *
 * @author Miguel
 */
public abstract class Constantes {

    //USER SE INSTANCIÓ DE PRUEBA, BORRAR CUANDO SEA NECESARIO
    public static Usuario USER = new Usuario("Timoteo", "123456", true);
    public static String logo ;
    public static double IGV;

    
    //redondea un double a 2 decimales readondeando al numero superior
    public static double redondear(double numero, int cantidad_decimales) {
        String val = numero + "";
        BigDecimal big = new BigDecimal(val);
        big = big.setScale(cantidad_decimales, RoundingMode.HALF_UP);
        return big.doubleValue();
    }

    //redondea un double a dos decimales de forma correcta y devuelve un string
    //formateado a 2 deciamels , ejm: 15.3 devuelve 15.30
    public static String redondearStr(double numero) {
        DecimalFormat df = new DecimalFormat("0.00");
        double num = redondear(numero, 2);
        return df.format(num);
    }

    public static String fechaActual() {
        Calendar fechaActual = Calendar.getInstance();
        String cadenaFecha = String.format("%02d/%02d/%04d",
                fechaActual.get(Calendar.DAY_OF_MONTH),
                fechaActual.get(Calendar.MONTH) + 1,
                fechaActual.get(Calendar.YEAR));
        return cadenaFecha;

    }
    
    public FileCopy(String sourceFile, String destinationFile) {
		System.out.println("Desde: " + sourceFile);
		System.out.println("Hacia: " + destinationFile);

		try {
			File inFile = new File(sourceFile);
			File outFile = new File(destinationFile);

			FileInputStream in = new FileInputStream(inFile);
			FileOutputStream out = new FileOutputStream(outFile);

			int c;
			while( (c = in.read() ) != -1)
				out.write(c);

			in.close();
			out.close();
		} catch(IOException e) {
			System.err.println("Hubo un error de entrada/salida!!!");
		}
	} 

}
