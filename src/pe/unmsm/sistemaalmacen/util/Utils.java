/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.util;

import com.mysql.jdbc.Blob;
import java.awt.Graphics;
import java.awt.Image;
import pe.unmsm.sistemaalmacen.estructuras.ListaDoble;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import pe.unmsm.sistemaalmacen.dominio.EntradaSalida;
import pe.unmsm.sistemaalmacen.dominio.Usuario;

/**
 *
 * @author Miguel
 */
public abstract class Utils {

    /**
     * Esta clase guarda funciones estaticas que se utilizaran durante todo el programa,
     * Tambien guarda algunos valores globales que son necesarios durante toda la ejecucion,
     * y se los puso aqui para no estar pasando estos valores mediante los coordinadores.
     */
    
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
        TableRowSorter<TableModel> ordenar = new TableRowSorter<>(modelo);
        jTable.setRowSorter(ordenar);

    }
    
    public Image convertirBlobAImagen(java.sql.Blob b) throws SQLException, IOException{
        InputStream in = b.getBinaryStream();
        BufferedImage c = ImageIO.read(in);
        
        return c;
    }
    
    public static java.sql.Blob convertirImagenABlob ( Image imagen ) {

      java.sql.Blob imagenBlob = null;
      BufferedImage bi = new BufferedImage ( imagen.getWidth ( null ), imagen.getHeight ( null ), BufferedImage.TYPE_INT_ARGB );
      Graphics bg = bi.getGraphics ();
      bg.drawImage ( imagen, 0, 0, null );
      bg.dispose ();

      ByteArrayOutputStream baos = new ByteArrayOutputStream ();
      try {
         ImageIO.write (bi,".jpg", baos );
         baos.flush ();
         baos.close ();
      } catch ( IOException e ) {
         e.printStackTrace ();
      }

      byte [] imagenByte = baos.toByteArray ();

      try {
         imagenBlob = new SerialBlob ( imagenByte );
      } catch ( SerialException se ) {
         se.printStackTrace ();
      } catch ( SQLException sqle ) {
         sqle.printStackTrace ();
      }
      return imagenBlob;
   }
}
