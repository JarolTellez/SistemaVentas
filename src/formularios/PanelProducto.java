/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import DAO.IProductosDAO;
import DAO.ProductosDAO;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;
import persistencia.ProductoJpaController;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Jarol
 */
public class PanelProducto extends javax.swing.JPanel {
    
       DefaultTableModel modelo;
    public IProductosDAO productosDAO=new ProductosDAO();
    
    ProductoJpaController control = new ProductoJpaController();


    /**
     * Creates new form Producto
     */
    public PanelProducto() {
        initComponents();
        modelo = new DefaultTableModel();
        modelo.addColumn("IdProducto");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio Actual");
        modelo.addColumn("Stock");
        this.tblProductos.setModel(modelo);
        consultarTodos();
        
        txtIdProducto.setEditable(false);
    }

    
       public void consultarTodos(){
        List<Producto> list=productosDAO.consultarTodos();
        DefaultTableModel model= (DefaultTableModel) tblProductos.getModel();
        int rowCount = model.getRowCount();
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
          model.removeRow(i);
        }
        Object rowData[]=new Object[4];
        for(int i=0; i<list.size();i++){
            rowData[0]=list.get(i).getIdProducto();
            rowData[1]=list.get(i).getNombre();
            rowData[2]=list.get(i).getPrecioActual();
            rowData[3]=list.get(i).getStock();
            model.addRow(rowData);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIdProducto = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtBuscarProducto = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        botonEditar = new javax.swing.JButton();
        botonMostrar = new javax.swing.JButton();

        jLabel1.setText("ID:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Precio:");

        jLabel4.setText("Stock:");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        txtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockKeyTyped(evt);
            }
        });

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductos);

        jLabel5.setText("ID");

        txtBuscarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarProductoKeyTyped(evt);
            }
        });

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel6.setText("Productos");

        botonEditar.setText("Editar");
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
            }
        });

        botonMostrar.setText("Mostrar todos");
        botonMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(txtStock))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtPrecio))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonGuardar)
                        .addGap(17, 17, 17)
                        .addComponent(botonCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(botonEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonEditar)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonBuscar)
                        .addGap(189, 189, 189))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonMostrar)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel6)
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonCancelar)
                            .addComponent(botonGuardar)
                            .addComponent(botonEliminar)
                            .addComponent(botonEditar))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(22, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(botonBuscar)
                                    .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(8, 8, 8)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(botonMostrar, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
      if(vacio()==false)
      {
        Producto producto = new Producto();
        
        if(buscarNombre(txtNombre.getText())==false)
        {
     
        producto.setNombre(txtNombre.getText());
       
        if( Integer.parseInt(txtStock.getText())>=0)
        {
           
          
        Float precioActual=Float.valueOf(txtPrecio.getText());
        producto.setPrecioActual(precioActual);
      
        
        producto.setStock(Integer.parseInt(txtStock.getText()));
          if(   productosDAO.agregar(producto)==true)
        {
               
        consultarTodos();
                limpiarTexto();
           JOptionPane.showMessageDialog(null, "Se agrego con exito");  
        
        }else
        {
            JOptionPane.showMessageDialog(null, "No se agrego el producto");  
        }
        }
        
      }else
      {
              JOptionPane.showMessageDialog(null, "Ya se encuentra agregado");
      }
      }else
      {
          JOptionPane.showMessageDialog(null, "Llenar todos los campos");
      }
      
    
    }//GEN-LAST:event_botonGuardarActionPerformed
    
    
    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
           
               if(txtIdProducto.getText().length()>0)
               {
              if(productosDAO.eliminar(Integer.parseInt(txtIdProducto.getText())))
              {
                  consultarTodos();
        limpiarTexto();
                    JOptionPane.showMessageDialog(null, "Eliminado con exito");
              }else
              {
                    JOptionPane.showMessageDialog(null, "No se pudo eliminar");
              }
               }else
               {
                     JOptionPane.showMessageDialog(null, "Seleccione producto a eliminar");
               }
        
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        // TODO add your handling code here:
        
           DefaultTableModel model= (DefaultTableModel) tblProductos.getModel();
        String idProducto=model.getValueAt(tblProductos.getSelectedRow(), 0).toString();
        String nombre=model.getValueAt(tblProductos.getSelectedRow(), 1).toString();
        String precioActual=model.getValueAt(tblProductos.getSelectedRow(), 2).toString();
        String stock=model.getValueAt(tblProductos.getSelectedRow(), 3).toString();
        txtIdProducto.setText(idProducto);
        txtNombre.setText(nombre);
        txtPrecio.setText(precioActual);
        txtStock.setText(stock);
    }//GEN-LAST:event_tblProductosMouseClicked

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed
      if(txtIdProducto.getText().length()>0)
      {
        Producto producto = new Producto();
      
       producto.setIdProducto(Integer.parseInt(txtIdProducto.getText()));
        
        producto.setNombre(txtNombre.getText());
        
      
        Float precioActual=Float.valueOf(txtPrecio.getText());
        producto.setPrecioActual(precioActual);
      
        producto.setStock(Integer.parseInt(txtStock.getText()));

        

        if(        productosDAO.actualizar(producto)==true)
        {
               
        consultarTodos();
                limpiarTexto();
                    JOptionPane.showMessageDialog(null, "Se edito con exito");  
        }else
        {
            JOptionPane.showMessageDialog(null, "No se edito");  
        }
      
      }else
      {
          JOptionPane.showMessageDialog(null, "Elegir producto a editar");  
      }
          
        
    }//GEN-LAST:event_botonEditarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
       
       limpiarTexto();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // TODO add your handling code here:
        int idProducto= (Integer.parseInt(txtBuscarProducto.getText()));
        Producto product=productosDAO.consultarProductoID(idProducto);
         if(product !=null)
       {
        DefaultTableModel model= (DefaultTableModel) tblProductos.getModel();
        int rowCount = model.getRowCount();
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
          model.removeRow(i);
        }
        Object rowData[]=new Object[4];
   
            rowData[0]=product.getIdProducto();
            rowData[1]=product.getNombre();
            rowData[2]=product.getPrecioActual();
            rowData[3]=product.getStock();
            model.addRow(rowData);
        }else
        {
                  JOptionPane.showMessageDialog(null, "No se encontro el producto");
                    txtBuscarProducto.setText("");
          consultarTodos();
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarActionPerformed
       consultarTodos();
    }//GEN-LAST:event_botonMostrarActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        soloTexto(evt);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
         numeroDecimal(evt);
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void txtStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_txtStockKeyTyped

    private void txtBuscarProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProductoKeyTyped
          soloNumeros(evt);
    }//GEN-LAST:event_txtBuscarProductoKeyTyped

    
    public void limpiarTexto()
    {
        txtIdProducto.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
    }
    
  public boolean vacio()
       {
           
           if(txtNombre.getText().length()!=0&& txtPrecio.getText().length()!=0&&  txtStock.getText().trim().length()!=0)
           {
               return false;
           }
           return true;
       }
  

 
 
 public boolean buscarNombre(String nombre)
 {
     List<Producto> productos= new ArrayList<>();
     
     productos=productosDAO.consultarTodos();
     
     for(int i=0;i<productos.size();i++)
     {
         if(nombre.equalsIgnoreCase(productos.get(i).getNombre()))
         {
             return true;
         }
        
     }
           return false;
     
 }
 
  /**
     * Solo permite ingresar letras
     * @param evt 
     */
    public void soloTexto(java.awt.event.KeyEvent evt)
    {
         char car = evt.getKeyChar();
        if(Character.isLetter(car) || car==' '){

}else{
evt.consume();
getToolkit().beep();
}
    }

    /**
     * Solo permite ingresar numeros
     * @param evt 
     */
     public void soloNumeros(java.awt.event.KeyEvent evt)
    {
         char car = evt.getKeyChar();
        if( Character.isDigit(car) ){

}else{
evt.consume();
getToolkit().beep();
}
    }
     
      public void numeroDecimal(java.awt.event.KeyEvent evt)
    {
         char car = evt.getKeyChar();

        if( Character.isDigit(car) || car=='.'){

}else{
evt.consume();
getToolkit().beep();
}
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonMostrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtBuscarProducto;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}