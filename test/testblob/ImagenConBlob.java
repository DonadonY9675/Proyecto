/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testblob;

import com.mysql.jdbc.Blob;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import javax.imageio.ImageIO;

/**
 *
 * @author Josecarlos
 */
public class ImagenConBlob {
    public Image convertirAImagen(Blob b) throws SQLException, IOException{
        InputStream in = b.getBinaryStream();
        BufferedImage c = ImageIO.read(in);
        
        return c;
    }
}
