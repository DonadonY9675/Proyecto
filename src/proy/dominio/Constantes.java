/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.dominio;

import estructuras.ListaDoble;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Miguel
 */
public abstract class Constantes {

    //USER SE INSTANCIÓ DE PRUEBA, BORRAR CUANDO SEA NECESARIO
    public static Usuario USER = new Usuario("Timoteo", "123456", true);
    public static String logo;
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

    /**
     * @return retorna la fecha actual convertida en String dd/mm/aaaa
     */
    public static String fechaActual() {
        DateTimeFormatter fechaFormateada = DateTimeFormatter.ofPattern("dd/LL/yyyy");
        return fechaFormateada.format(LocalDate.now());
    }

    /**
     * convierte un string en un java.sql.Date
     * @param fecha: fecha formateada dd/mm/aa, ejm 01/01/1999
     * @return fecha convertida en java.sql.Date
     */
    public static Date convertirFechaAdateSQL(String fecha) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/LL/yyyy");
        LocalDate ld = LocalDate.parse(fecha, dtf);
        Date fechaSQL = Date.valueOf(ld);
        return fechaSQL;
    }
    
    public static String convertirDateSQLaString(java.sql.Date date){
        LocalDate ld = date.toLocalDate();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/LL/yyyy");
        return dtf.format(ld);
    }

    public static void cargarLogo(java.awt.Component fm, JLabel lblLogo) {
        lblLogo.setText("");

        Image imagen = fm.getToolkit().getImage(logo);

        imagen = imagen.getScaledInstance(lblLogo.getWidth(), -1, Image.SCALE_AREA_AVERAGING);

        lblLogo.setIcon(new ImageIcon(imagen));
    }

    public static void llenarTabla(JTable jTable, ListaDoble<EntradaSalida> miListaProductos) {

        String Titulo[] = {"Código", "Nombre", "Marca", "Modelo",
            "Precio Unitario", "Cantidad", "Total"};
        String registro[] = new String[7];
        DefaultTableModel modelo = new DefaultTableModel(null, Titulo) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        DecimalFormat df = new DecimalFormat("0.00");
        for (EntradaSalida p : miListaProductos) {
            registro[0] = String.valueOf(p.getProducto().getCodigo());
            registro[1] = p.getProducto().getNombre();
            registro[2] = p.getProducto().getMarca();
            registro[3] = p.getProducto().getModelo();
            registro[4] = df.format(p.getProducto().getPrecioUnitario());
            registro[5] = String.valueOf(p.getCantidad());
            registro[6] = df.format(p.getTotal());
            modelo.addRow(registro);
        }
        jTable.setModel(modelo);

    }

}
