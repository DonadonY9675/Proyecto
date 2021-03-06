/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.vista;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import pe.unmsm.sistemaalmacen.util.Utils;

/**
 *
 */
public class VentanaMenuPrincipal extends javax.swing.JFrame implements Runnable{

    /**
     * Creates new form VentanaMenuPrincipal
     */
    public VentanaMenuPrincipal() {
        initComponents();
        iniciarComponentes();
        lblFecha.setText(Utils.obtenerFechaDetallada());
    }

    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        while(true) {   
            Date ahora = new Date();
                
            SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss");
            lblHora.setText(formateador.format(ahora));
            try {
               Thread.sleep(1000);
              }
            catch(InterruptedException e) {}
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblUsuarioActual = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblP = new javax.swing.JLabel();
        lblPermisos = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnNuevaEntrada = new javax.swing.JButton();
        btnMiInventario = new javax.swing.JButton();
        btnReportesDeEntrada = new javax.swing.JButton();
        btnReportesDeSalida = new javax.swing.JButton();
        btnNuevaSalida = new javax.swing.JButton();
        lblHora = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        mnBarPrincipal = new javax.swing.JMenuBar();
        mnClientes = new javax.swing.JMenu();
        mnItmRegistroClientes = new javax.swing.JMenuItem();
        mnProveedores = new javax.swing.JMenu();
        mnItmProveedores = new javax.swing.JMenuItem();
        mnUsuarios = new javax.swing.JMenu();
        mnItmRegistroUsuarios = new javax.swing.JMenuItem();
        mnArchivos = new javax.swing.JMenu();
        mnItmSalir = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        mnConfiguracion = new javax.swing.JMenu();
        mnItmDatos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblLogo.setText("Logo");

        lblUsuarioActual.setText("user");

        lblUsuario.setText("Usuario Actual:");

        lblP.setText("Permisos:");

        lblPermisos.setText("permisos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario)
                    .addComponent(lblP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuarioActual)
                    .addComponent(lblPermisos))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(lblUsuarioActual, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblP)
                    .addComponent(lblPermisos, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnNuevaEntrada.setText("Nueva Entrada");
        btnNuevaEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaEntradaActionPerformed(evt);
            }
        });

        btnMiInventario.setText("Mi inventario");

        btnReportesDeEntrada.setText("Reportes de entrada");

        btnReportesDeSalida.setText("Reportes de salida");

        btnNuevaSalida.setText("Nueva Salida");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnNuevaEntrada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNuevaSalida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMiInventario))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnReportesDeEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReportesDeSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMiInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReportesDeEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReportesDeSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblHora.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblHora.setText("HORA");

        lblFecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblFecha.setText("FEcha");

        mnClientes.setText("Clientes");

        mnItmRegistroClientes.setText("Registro de clientes");
        mnClientes.add(mnItmRegistroClientes);

        mnBarPrincipal.add(mnClientes);

        mnProveedores.setText("Proveedores");

        mnItmProveedores.setText("Registro de proveedores");
        mnProveedores.add(mnItmProveedores);

        mnBarPrincipal.add(mnProveedores);

        mnUsuarios.setText("Usuarios");

        mnItmRegistroUsuarios.setText("Registro de usuarios");
        mnUsuarios.add(mnItmRegistroUsuarios);

        mnBarPrincipal.add(mnUsuarios);

        mnArchivos.setText("Archivo");

        mnItmSalir.setText("Cerrar sesión");
        mnArchivos.add(mnItmSalir);

        jMenuItem2.setText("Salir");
        mnArchivos.add(jMenuItem2);

        mnBarPrincipal.add(mnArchivos);

        mnConfiguracion.setText("Configuracion");

        mnItmDatos.setText("Datos de empresa");
        mnConfiguracion.add(mnItmDatos);

        mnBarPrincipal.add(mnConfiguracion);

        setJMenuBar(mnBarPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevaEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevaEntradaActionPerformed

    /**
     * Inicia componentes de MenuPrincipal Da el nombre al lblUsuarioActual
     * Carga el logotipo de la empresa Centra el formulario al inciar
     */
    public void iniciarComponentes() {
        setLocationRelativeTo(null);

        //cargando lbl
        lblUsuarioActual.setText(Utils.USER.getNombre());
        lblPermisos.setText((Utils.USER.isEsAdmin()) ? "Administrador" : "Usuario");

        //cargando el icono
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/pe/unmsm/sistemaalmacen/images/logo.png"));
        setIconImage(icon);

        //cargando logo
        Utils.cargarLogo(this, lblLogo);
        
        //getClass().getResource("/proy/images/logo.png")
//ImageIcon(getClass().getResource("/proy/images/pass.png"))

//  vConf.txtLogo.setText(String.valueOf(file));
//            Image logo = vConf.getToolkit().getImage(vConf.txtLogo.getText());
//            logo = logo.getScaledInstance(110, 110, Image.SCALE_DEFAULT);
//            vConf.lblLogo.setIcon(new ImageIcon(logo));
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnMiInventario;
    public javax.swing.JButton btnNuevaEntrada;
    public javax.swing.JButton btnNuevaSalida;
    public javax.swing.JButton btnReportesDeEntrada;
    public javax.swing.JButton btnReportesDeSalida;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JLabel lblFecha;
    public javax.swing.JLabel lblHora;
    public javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblP;
    private javax.swing.JLabel lblPermisos;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuarioActual;
    private javax.swing.JMenu mnArchivos;
    private javax.swing.JMenuBar mnBarPrincipal;
    private javax.swing.JMenu mnClientes;
    private javax.swing.JMenu mnConfiguracion;
    public javax.swing.JMenuItem mnItmDatos;
    private javax.swing.JMenuItem mnItmProveedores;
    private javax.swing.JMenuItem mnItmRegistroClientes;
    public javax.swing.JMenuItem mnItmRegistroUsuarios;
    private javax.swing.JMenuItem mnItmSalir;
    private javax.swing.JMenu mnProveedores;
    private javax.swing.JMenu mnUsuarios;
    // End of variables declaration//GEN-END:variables
}
