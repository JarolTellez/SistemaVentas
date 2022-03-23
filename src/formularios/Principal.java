/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import DAO.*;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;

/**
 *
 * @author Jarol
 */
public class Principal extends javax.swing.JFrame {
    public IClientesDAO clientesDAO=new ClientesDAO();
        public IProductosDAO productosDAO=new ProductosDAO();
              public IVentasDAO ventasDAO=new  VentasDAO();

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
       setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        panelPrincipal = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuPrincipal = new javax.swing.JMenu();
        clienteMenu = new javax.swing.JMenuItem();
        productoMenu = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        ventaMenu = new javax.swing.JMenuItem();
        menuConsultarVentas = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 522, Short.MAX_VALUE)
        );

        menuPrincipal.setText("Menú");
        menuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPrincipalActionPerformed(evt);
            }
        });

        clienteMenu.setText("Cliente");
        clienteMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteMenuActionPerformed(evt);
            }
        });
        menuPrincipal.add(clienteMenu);

        productoMenu.setText("Producto");
        productoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productoMenuActionPerformed(evt);
            }
        });
        menuPrincipal.add(productoMenu);

        jMenu2.setText("Venta");

        ventaMenu.setText("Realizar Venta");
        ventaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventaMenuActionPerformed(evt);
            }
        });
        jMenu2.add(ventaMenu);

        menuConsultarVentas.setText("Consultar Ventas");
        menuConsultarVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultarVentasActionPerformed(evt);
            }
        });
        jMenu2.add(menuConsultarVentas);

        menuPrincipal.add(jMenu2);

        jMenuBar1.add(menuPrincipal);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPrincipalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuPrincipalActionPerformed

    private void productoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productoMenuActionPerformed
        // TODO add your handling code here:
         panelProducto();
    }//GEN-LAST:event_productoMenuActionPerformed

    public void panelProducto()
    {
        PanelProducto pProducto= new PanelProducto();
        
        pProducto.setSize(1012, 492);// tamano del panel
        pProducto.setLocation(5,5);// posicion dentro del panel principal
        
        panelPrincipal.removeAll();
        panelPrincipal.add(pProducto,BorderLayout.CENTER);
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }
    
    private void clienteMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteMenuActionPerformed
      
         panelCliente();
    }//GEN-LAST:event_clienteMenuActionPerformed
public void panelCliente()
{
     PanelCliente pCliente= new PanelCliente();
        
        pCliente.setSize(1042, 502);// tamano del panel
        pCliente.setLocation(5,5);// posicion dentro del panel principal
        
        panelPrincipal.removeAll();
        panelPrincipal.add(pCliente,BorderLayout.CENTER);
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
}
    
    private void ventaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventaMenuActionPerformed

        panelVenta();
    }//GEN-LAST:event_ventaMenuActionPerformed

    public void panelVenta()
    {
        if(clientesDAO.consultarTodos().size()>0)
{
    if(productosDAO.consultarTodos().size()>0)
    {
        DetallesVentas detallesV= new DetallesVentas();
            detallesV.setSize(1042, 580);
            detallesV.setLocation(1, 1);
            
        panelPrincipal.removeAll();
        panelPrincipal.add(detallesV,BorderLayout.CENTER);
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }else
    {
         JOptionPane.showMessageDialog(null, "No hay productos agregados");
         panelProducto();
    }
}else
{
    JOptionPane.showMessageDialog(null, "No hay clientes agregados");
    panelCliente();
}
        
    }
    private void menuConsultarVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultarVentasActionPerformed
     if(ventasDAO.consultarTodos().size()>0)
     {
        BuscaVentas buscaVentas = new BuscaVentas();
       
       buscaVentas.setSize(1042,502);
       buscaVentas.setLocation(5,5);
       
       panelPrincipal.removeAll();
        panelPrincipal.add(buscaVentas,BorderLayout.CENTER);
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
     }else 
     {
         JOptionPane.showMessageDialog(null, "No hay ventas agregadas");
         panelVenta();
     }
     
    }//GEN-LAST:event_menuConsultarVentasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem clienteMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem menuConsultarVentas;
    private javax.swing.JMenu menuPrincipal;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JMenuItem productoMenu;
    private javax.swing.JMenuItem ventaMenu;
    // End of variables declaration//GEN-END:variables
}
