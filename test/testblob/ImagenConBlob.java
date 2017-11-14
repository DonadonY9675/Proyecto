/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testblob;

import java.sql.Blob;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import pe.unmsm.sistemaalmacen.util.Utils;

/**
 *
 * @author Josecarlos
 */
public class ImagenConBlob {
    public Image convertirBlobAImagen(Blob b) throws SQLException, IOException{
        InputStream in = b.getBinaryStream();
        BufferedImage c = ImageIO.read(in);
        
        return c;
    }
    
    public static Blob convertirImagenABlob ( Image imagen ) {

      Blob imagenBlob = null;
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
    
    public static void main(String[] args) {
        NewJFrame v = new NewJFrame();
        v.setVisible(true);
        FileNameExtensionFilter filtro
                = new FileNameExtensionFilter("Formatos de Archivos JPEG(*.JPG;*.JPEG; .png)",
                        "jpg", "jpeg", "png");

        JFileChooser archivo = new JFileChooser();

        archivo.addChoosableFileFilter(filtro);
        archivo.setFileFilter(filtro);
        archivo.setDialogTitle("Escoger Logotipo de Empresa");
        File ruta = new File("C:/");

        archivo.setCurrentDirectory(ruta);

        int ventana = archivo.showOpenDialog(v);

        if (ventana == JFileChooser.APPROVE_OPTION) {
            File file = archivo.getSelectedFile();
            Image logo = v.getToolkit().getImage(String.valueOf(file));
            logo.getScaledInstance(100, 100, 100);
            logo.flush();
            System.out.println(logo.getWidth(null));
            Blob blob = Utils.convertirImagenABlob(logo);
            
            v.jLabel1.setIcon(new ImageIcon(logo));
        }
        
    }
}
