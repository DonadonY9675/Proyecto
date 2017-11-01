/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.controlador.impl;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import proy.controlador.CConfiguracion;
import proy.dominio.Constantes;
import proy.service.impl.ConfiguracionServiceImpl;
import proy.vista.VentanaConfiguracion;
import proy.vista.VentanaMenuPrincipal;

/**
 *
 * @author Miguel
 */
public class CConfiguracionImpl implements CConfiguracion {

    VentanaConfiguracion vConf;
    VentanaMenuPrincipal vMenuPrincipal;
    ConfiguracionServiceImpl configService = new ConfiguracionServiceImpl();

    @Override
    public void setVConfiguracion(VentanaConfiguracion vConf, VentanaMenuPrincipal vPrincipal) {
        this.vMenuPrincipal = vPrincipal;
        this.vConf = vConf;
        vConf.btnExaminar.addActionListener(this::clickBtnExaminar);
        vConf.btnGuardar.addActionListener(this::clickBtnGuardar);
        vConf.btnSalir.addActionListener(this::clickBtnSalir);

    }

    @Override
    public void clickBtnGuardar(ActionEvent evt) {
        configService.modificar(vConf);
        Constantes.logo = vConf.txtLogo.getText();
        Constantes.cargarLogo(vMenuPrincipal, vMenuPrincipal.lblLogo);
        vConf.dispose();
    }

    @Override
    public void clickBtnSalir(ActionEvent evt) {
        vConf.dispose();
    }

    @Override
    public void clickBtnExaminar(ActionEvent evt) {

        FileNameExtensionFilter filtro
                = new FileNameExtensionFilter("Formatos de Archivos JPEG(*.JPG;*.JPEG; .png)",
                        "jpg", "jpeg", "png");

        JFileChooser archivo = new JFileChooser();

        archivo.addChoosableFileFilter(filtro);
        archivo.setFileFilter(filtro);
        archivo.setDialogTitle("Excojer Logotipo de Empresa");
        File ruta = new File("C:/");

        archivo.setCurrentDirectory(ruta);

        int ventana = archivo.showOpenDialog(vConf);

        if (ventana == JFileChooser.APPROVE_OPTION) {
            File file = archivo.getSelectedFile();

            vConf.txtLogo.setText(String.valueOf(file));
            Image logo = vConf.getToolkit().getImage(vConf.txtLogo.getText());
            logo = logo.getScaledInstance(110, 110, Image.SCALE_DEFAULT);
            vConf.lblLogo.setIcon(new ImageIcon(logo));
        }

    }

}
