/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.util;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Image;
import pe.unmsm.sistemaalmacen.estructuras.ListaDoble;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import pe.unmsm.sistemaalmacen.dominio.Configuracion;
import pe.unmsm.sistemaalmacen.dominio.DetalleRegistro;
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
    public static double redondear(double numero, int cantidadDecimales) {
        String val = numero + "";
        BigDecimal big = new BigDecimal(val);
        big = big.setScale(cantidadDecimales, RoundingMode.HALF_UP);
        return big.doubleValue();
    }

    //redondea un double a dos decimales de forma correcta y devuelve un string
    //formateado a 2 deciamels , ejm: 15.3 devuelve 15.30
    public static String redondearStr(double numero) {
        DecimalFormat df = new DecimalFormat("0.00");
        double num = redondear(numero, 2);
        return df.format(num).replace(",", ".");
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

    public static void llenarTabla(JTable jTable, ListaDoble<DetalleRegistro> miListaProductos) {

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
        for (DetalleRegistro p : miListaProductos) {
            
            registro[0] = String.valueOf(p.getProducto().getCodigo());
            registro[1] = p.getProducto().getNombre();
            registro[2] = p.getProducto().getMarca();
            registro[3] = p.getProducto().getModelo();
            registro[4] = df.format(p.getProducto().getPrecioUnitario()).replace(",", ".");
            registro[5] = String.valueOf(p.getCantidad());
            registro[6] = df.format(p.getMonto()).replace(",", ".");
            modelo.addRow(registro);
        }
        jTable.setModel(modelo);
        TableRowSorter<TableModel> ordenar = new TableRowSorter<>(modelo);
        jTable.setRowSorter(ordenar);

    }
    
    public static ImageIcon convertirBlobAImagen(java.sql.Blob blob){
        ImageIcon icono = null;
        if(blob != null){
           try{
          byte[] data = blob.getBytes(1, (int)blob.length());
          BufferedImage img = null;

          try{
            img = ImageIO.read(new ByteArrayInputStream(data));
          }
          catch(Exception ex){
          System.out.println(ex.getMessage());
          }

            icono = new ImageIcon(img);
         
          }catch(Exception ex){
           //No hay imagen
          }
        }
        else{
         //No hay imagen
        }
        
        return icono;
    }
    
    public static void createPDF(String titulo, File pdfNewFile, Configuracion configuracion, JTable tabla){
        Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
        Font configuracionFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);

        Font categoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD, BaseColor.GRAY);
        Font dateFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
        Font blueFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);    
        Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    
        try {
            com.itextpdf.text.Document document = new com.itextpdf.text.Document();
            try {
                PdfWriter.getInstance(document, new FileOutputStream(pdfNewFile));
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("No such file was found to generate the PDF "
                        + "(No se encontró el fichero para generar el pdf)" + fileNotFoundException);
            }
            document.open();

            // Añadimos los metadatos del PDF
            document.addTitle("Table export to PDF (Exportamos la tabla a PDF)");
            document.addSubject("Using iText (usando iText)");
            document.addKeywords("Java, PDF, iText");
            document.addAuthor("Código Xules");
            document.addCreator("Código Xules");
            
            // Primera página 
            Chunk chunk = new Chunk(titulo, chapterFont);
            chunk.setBackground(BaseColor.GRAY);
            // Let's create de first Chapter (Creemos el primer capítulo)
            Chapter chapter = new Chapter(new Paragraph(chunk), 1);
            chapter.setNumberDepth(0);
            chapter.add(new Paragraph(configuracion.getNombreEmpresa(), configuracionFont));
            chapter.add(new Paragraph("RUC: "+configuracion.getRUC(), configuracionFont));
            chapter.add(new Paragraph(configuracion.getDireccion(), configuracionFont));
            chapter.add(new Paragraph("Fecha de reporte: "+Utils.fechaActual(), dateFont));
            // We add an image (Añadimos una imagen)
            
            //SI QUEREMOS AÑADIR IMAGENES
//            Image image;
//            try {
//                image = Image.getInstance(iTextExampleImage);  
//                image.setAbsolutePosition(2, 150);
//                chapter.add(image);
//            } catch (BadElementException ex) {
//                System.out.println("Image BadElementException" +  ex);
//            } catch (IOException ex) {
//                System.out.println("Image IOException " +  ex);
//            }
            
            // Utilización de PdfPTable
 
            Section paragraphMore = chapter.addSection("");
            
            Integer numColumns = tabla.getColumnCount();
            Integer numRows = tabla.getRowCount();
            // We create the table (Creamos la tabla).
            PdfPTable table = new PdfPTable(numColumns); 
            // Now we fill the PDF table 
            // Ahora llenamos la tabla del PDF
            PdfPCell columnHeader;
            // Fill table rows (rellenamos las filas de la tabla).                
            for (int column = 0; column < numColumns; column++) {
                columnHeader = new PdfPCell(new Phrase(tabla.getColumnName(column)));
                columnHeader.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
                table.addCell(columnHeader);
            }
            table.setHeaderRows(1);
            // Fill table rows (rellenamos las filas de la tabla).
            
            for (int row = 0; row < numRows; row++) {
                for (int column = 0; column < numColumns; column++) {
                    table.addCell(tabla.getValueAt(row, column).toString());
                }
            }
            // We add the table (Añadimos la tabla)
            paragraphMore.add(table);
            // We add the paragraph with the table (Añadimos el elemento con la tabla).
            document.add(chapter);
            document.close();
            
            System.out.println("Your PDF file has been generated!(¡Se ha generado tu hoja PDF!");
        } catch (DocumentException documentException) {
            System.out.println("The file not exists (Se ha producido un error al generar un documento): " + documentException);
        }
        
    }
    
     public static String obtenerFechaDetallada(){
         Calendar c = Calendar.getInstance();
        int diaSemana = c.get(Calendar.DAY_OF_WEEK);
        int diaMes = c.get(Calendar.DAY_OF_MONTH);
        int mes = c.get(Calendar.MONTH)+1;;
        int anio = c.get(Calendar.YEAR);
        
        String cadFecha = "";
        
        switch(diaSemana){
            case 2:
                cadFecha+="Lunes";
                break;
            case 3:
                cadFecha+="Martes";
                break;
            case 4:
                cadFecha+="Miercoles";
                break;
            case 5:
                cadFecha+="Jueves";
                break;
            case 6:
                cadFecha+="Viernes";
                break;
            case 7:
                cadFecha+="Sabado";
                break;
            case 1:
                cadFecha+="Domingo";
                break;
        }
        cadFecha += " "+diaMes+" de ";
        switch(mes){
            case 1:
                cadFecha+="Enero";
                break;
            case 2:
                cadFecha+="Febrero";
                break;
            case 3:
                cadFecha+="Marzo";
                break;
            case 4:
                cadFecha+="Abril";
                break;
            case 5:
                cadFecha+="Mayo";
                break;
            case 6:
                cadFecha+="Junio";
                break;
            case 7:
                cadFecha+="Julio";
                break;
            case 8:
                cadFecha+="Agosto";
                break;
            case 9:
                cadFecha+="Setiembre";
                break;
            case 10:
                cadFecha+="Octubre";
                break;
            case 11:
                cadFecha+="Noviembre";
                break;
            case 12:
                cadFecha+="Diciembre";
                break;
        }
        cadFecha += ", "+anio;
        return cadFecha;
    }
 
}
