/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import DAO.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author Jarol
 */
public class DetallesVentas extends javax.swing.JPanel {

    /**
     * Creates new form Producto
     */
      DefaultTableModel modelo;
      
            DefaultTableModel modelo2;
          public IProductosDAO productosDAO=new ProductosDAO();
            public IClientesDAO clientesDAO=new ClientesDAO();
            public IVentasDAO ventasDAO= new VentasDAO();
            public IRefProductoventas refProductoVentasDAO= new RefProductoVentasDAO();
              float subtotal = 0;
                     float total=0;
                      float descuento=0;
          
            List<ProductosElegidos> lista= new ArrayList<>();
    ProductosElegidos producto=new ProductosElegidos();
    
    
    public DetallesVentas() {
        initComponents();
        modelo = new DefaultTableModel();
        modelo.addColumn("IdProducto");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio Actual");
        modelo.addColumn("Stock");
        this.tblProductos.setModel(modelo);
       consultarTodosProductos();
       llenarComboBoxCliente();
       txtSubtotal.setEditable(false);
       txtTotal.setEditable(false);
       txtDescuento.setText("0");
       
       modelo2= new DefaultTableModel();
       modelo2.addColumn("Id Producto");
       modelo2.addColumn("Nombre");
       modelo2.addColumn("Precio Actual");
       modelo2.addColumn("Cantidad");
       modelo2.addColumn("Monto total");
       this.tblSeleccionados.setModel(modelo2);
       
  
       
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
        txtSubtotal = new javax.swing.JTextField();
        txtDescuento = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtBuscarProducto = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        comboBoxCliente = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSeleccionados = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        botonMostrarTodos = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtCantidadQuitar = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(907, 515));

        jLabel1.setText("ID Cliente:");

        jLabel2.setText("Subtotal:");

        jLabel3.setText("Descuento:");

        jLabel4.setText("Total:");

        txtDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyTyped(evt);
            }
        });

        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
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

        jLabel5.setText("ID:");

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

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel6.setText("Detalles Ventas ");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Buscar Producto");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Productos Elegidos");

        tblSeleccionados.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSeleccionados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSeleccionadosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSeleccionados);

        jLabel9.setText("Cantidad a agregar");

        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        botonMostrarTodos.setText("Mostrar todos");
        botonMostrarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarTodosActionPerformed(evt);
            }
        });

        jLabel10.setText("Cantidad a quitar");

        txtCantidadQuitar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadQuitarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnRegistrar)
                        .addGap(37, 37, 37)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(botonMostrarTodos)
                                            .addComponent(jLabel10)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(txtCantidadQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonBuscar)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(259, 259, 259))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel5)
                        .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botonBuscar))
                    .addComponent(jLabel6))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(botonMostrarTodos)
                        .addGap(77, 77, 77)
                        .addComponent(jLabel9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnCancelar)
                                    .addComponent(btnRegistrar)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txtCantidadQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(comboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

      public void consultarTodosProductos(){
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
      
       public void consultarTodosSeleccionados(){

        DefaultTableModel model= (DefaultTableModel) tblSeleccionados.getModel();
        int rowCount = model.getRowCount();
       
      subtotal=0;
        for (int i = rowCount - 1; i >= 0; i--) {
          model.removeRow(i);
        }
        Object rowData[]=new Object[5];
        for(int i=0; i<lista.size();i++){
            rowData[0]=lista.get(i).getIdProducto();
            rowData[1]=lista.get(i).getNombreProducto();
            rowData[2]=lista.get(i).getPrecioActual();
            rowData[3]=lista.get(i).getCantidad();
            rowData[4]=lista.get(i).getMontoTotal();
            model.addRow(rowData);
            subtotal=subtotal+lista.get(i).getMontoTotal();
        }
        
        txtSubtotal.setText(String.valueOf(subtotal));
         hacerDescuento();
      }
       
      public void llenarComboBoxCliente()
      {
           List<Cliente> list=clientesDAO.consultarTodos();
          for(Cliente c:list){
          comboBoxCliente.addItem(c.toString());
        }
      }
      
      
      
    
    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    
    
    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
         producto=new ProductosElegidos();

         int cantidad=0;
        DefaultTableModel model= (DefaultTableModel) tblProductos.getModel();
        String idProducto=model.getValueAt(tblProductos.getSelectedRow(), 0).toString();
        String nombre=model.getValueAt(tblProductos.getSelectedRow(), 1).toString();
         String precioActual=model.getValueAt(tblProductos.getSelectedRow(), 2).toString();
         
   
      producto.setIdProducto(Integer.parseInt(idProducto));
        producto.setIdProducto(Integer.parseInt(idProducto));
        producto.setNombreProducto(nombre);
        producto.setPrecioActual(Float.valueOf(precioActual));
        
        if(txtDescuento.getText().trim().length()>0)
        {
           // Busca el producto de la base de datos y la seleccion de ese producto para comparar que no seleccione mas del stock
         if( producto.buscar(producto, lista)==false || producto.buscarProducto(producto, lista).getCantidad()<productosDAO.consultarProductoID(Integer.parseInt(idProducto)).getStock() )
         {
   
             // verifica que no exista en la lista y lo agrega y si existe lo actualiza
         if(producto.buscar(producto, lista)==false  )
         {
             
           //Si el producto es nuevo en la lista el campo cantidad esta vacio se agrega 1 y si no se toma el numero que se haya ingresado
           if(txtCantidad.getText().length()==0)
           {
               if(productosDAO.consultarProductoID(producto.getIdProducto()).getStock()>0)
               {
                   producto.setCantidad(1);
                   producto.setMontoTotal(Float.valueOf(precioActual));
                   lista.add(producto);   
               }else
               {
                    JOptionPane.showMessageDialog(null, "No hay suficientes en stock");
               }
                             //Si es nuevo y en el campo de cantidad se agrego algo se verifica que este numero no sea mayor al stock
           }else if(Integer.parseInt(txtCantidad.getText())<=productosDAO.consultarProductoID(Integer.parseInt(idProducto)).getStock())
           {
               if(    productosDAO.consultarProductoID(producto.getIdProducto()).getStock()>0)
               {
               producto.setCantidad(Integer.parseInt(txtCantidad.getText()));
               producto.setMontoTotal(Float.valueOf(precioActual)*Integer.parseInt(txtCantidad.getText()));
               lista.add(producto);   
               }else
               {
                      JOptionPane.showMessageDialog(null, "No hay suficientes en stock");
               }
           }else
           {
               JOptionPane.showMessageDialog(null, "No hay suficientes en stock");
           }
        
        consultarTodosSeleccionados();
         }else 
         {
             // si el producto ya esta en la lista de seleccionados se actualiza la cantidad, si el campo cantidad esta vacio se agrega 1 y si no se toma el valor que este tenga
             if(txtCantidad.getText().length()==0)
           {
                   cantidad=1;
           }else
           {
               cantidad=(Integer.parseInt(txtCantidad.getText()));
           }
             
             // si existe y la cantidad no excede el stock se procede a verificar la suma de la cantidad nueva con la que ya tiene el producto
             if( cantidad<productosDAO.consultarProductoID(Integer.parseInt(idProducto)).getStock() &&productosDAO.consultarProductoID(producto.getIdProducto()).getStock()>0)
             {
                 // se hace la suma de la cantidad nueva a agregar con la que ya tenia el producto
                 if( (producto.buscarProducto(producto, lista).getCantidad()+cantidad)<=productosDAO.consultarProductoID(Integer.parseInt(idProducto)).getStock())
                 {
            producto.actualizar(producto, lista,cantidad);
                 }else
                 {
                      JOptionPane.showMessageDialog(null, "No hay suficiente en stock");
                 }
            consultarTodosSeleccionados();
             }else
             {
                    JOptionPane.showMessageDialog(null, "No hay suficiente en stock");
             }
         } 
         }else
         {
             JOptionPane.showMessageDialog(null, "No hay suficiente en stock");
         }
       
        }else
        {
            txtTotal.setText(String.valueOf(subtotal));
        }
        
    }//GEN-LAST:event_tblProductosMouseClicked

    private void botonMostrarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarTodosActionPerformed
     consultarTodosProductos();
   
    }//GEN-LAST:event_botonMostrarTodosActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
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
              txtBuscarProducto.setText("");
        }else
        {
                  JOptionPane.showMessageDialog(null, "No se encontro el producto");
                    txtBuscarProducto.setText("");
          consultarTodosProductos();
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        txtCantidad.setText("");
        txtSubtotal.setText("");
        txtTotal.setText("");
        txtDescuento.setText("0");
        // Quitar todo de la lista de seleccionados
          lista.clear();
          subtotal=0;
          total=0;
          descuento=0;
          
         DefaultTableModel model= (DefaultTableModel) tblSeleccionados.getModel();
        int rowCount = model.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
          model.removeRow(i);
        }
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    
    /**
     * Calcula el descuento conforme se va introduciendo la cantidad a descontar
     * @param evt 
     */
    private void txtDescuentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyReleased
         total=0;
    descuento=0;
   float porcentaje;

               if( txtDescuento.getText().trim().length()>0)
           {
       
       if( Integer.parseInt(txtDescuento.getText())<=100 && Integer.parseInt(txtDescuento.getText())>=0)
       {
          
       float datoDesc=Float.valueOf(txtDescuento.getText());
       porcentaje=datoDesc/100;
       
       descuento=porcentaje*Float.valueOf(txtSubtotal.getText());
        total=(Float.valueOf(txtSubtotal.getText())-descuento);
        
        txtTotal.setText(String.valueOf(total));
   }else 
   {
       JOptionPane.showMessageDialog(null, "Ingrese un numero entre 0-100");
       txtDescuento.setText("");
       txtTotal.setText("");
       descuento=0;
       total=0;
       
   }
  
           }else
               {
                   txtTotal.setText(String.valueOf(subtotal));
               }
   
    }//GEN-LAST:event_txtDescuentoKeyReleased

    private void tblSeleccionadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSeleccionadosMouseClicked
         //producto=new ProductosElegidos();
   
         int cantidad=0;
        DefaultTableModel model= (DefaultTableModel) tblSeleccionados.getModel();
        String idProducto=model.getValueAt(tblSeleccionados.getSelectedRow(), 0).toString();
        String nombre=model.getValueAt(tblSeleccionados.getSelectedRow(), 1).toString();
         String precioActual=model.getValueAt(tblSeleccionados.getSelectedRow(), 2).toString();
         
   
     // producto.setIdProducto(Integer.parseInt(idProducto));
        producto.setIdProducto(Integer.parseInt(idProducto));
        producto.setNombreProducto(nombre);
        producto.setPrecioActual(Float.valueOf(precioActual));
        
           // Busca el producto de la base de datos y la seleccion de ese producto para comparar que no seleccione mas del stock
     
           //Si el producto es nuevo en la lista el campo cantidad esta vacio se agrega 1 y si no se toma el numero que se haya ingresado
           if(txtCantidadQuitar.getText().length()==0)
           {
                
               cantidad=1;
              
           }else if(Integer.parseInt(txtCantidadQuitar.getText())>0)
           {
               cantidad=Integer.parseInt(txtCantidadQuitar.getText());
               
           }else
           {
               JOptionPane.showMessageDialog(null, "Ingrese numero positivo");
               txtCantidadQuitar.setText("");
           }
        
           if(cantidad<=producto.buscarProducto(producto, lista).getCantidad())
           {
              if(producto.buscarProducto(producto, lista).getCantidad()>0)
               {
               producto.Eliminar(producto, lista, cantidad);
               if(producto.buscarProducto(producto, lista).getCantidad()==0)
               {
                   lista.remove(producto);
               }
               consultarTodosSeleccionados();
               }else
               {
                   lista.remove(producto);
                       consultarTodosSeleccionados();
               }
        consultarTodosSeleccionados();
           }else
           {
               JOptionPane.showMessageDialog(null, "La cantidad a eliminar excede a la cantidad del producto");
               txtCantidadQuitar.setText("");
           }

    }//GEN-LAST:event_tblSeleccionadosMouseClicked

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
       if(lista.size()>0)
       {
        Venta venta= new Venta();
          Venta venta2  = new Venta();
          RefProductoventas refPV= new RefProductoventas();
       int idVenta;
       Cliente cliente = new Cliente();
       String idCliente;
      
      
       idCliente= comboBoxCliente.getSelectedItem().toString();
       cliente.setIdCliente(Integer.parseInt(idCliente));
       
       venta.setIdCliente(cliente);
       
       if(txtDescuento.getText().length()>0)
       {
       venta.setMontoTotal(total);
       venta.setDescuento(descuento);
       }else
       {
           venta.setDescuento(0);
           venta.setMontoTotal(subtotal);
       }
      
       Date fecha= new Date();
        
    //  SimpleDateFormat formater= new SimpleDateFormat("MM/dd/yy HH:mm:ss");
     
       venta.setFecha(fecha);
       
       ventasDAO.agregar(venta);
       
       // Obtener la ultima venta que se ha hecho
       venta2=ventasDAO.consultarID( ventasDAO.consultarTodos().get(ventasDAO.consultarTodos().size()-1).getIdVenta());
      
 
  
       // Se agregan ada uno de los productos de la venta a la tabla de referenciaProductoVentas
     for(int i=0;i<lista.size();i++)
     {
         refPV=new RefProductoventas();
              refPV.setCantidad(lista.get(i).getCantidad());
              
              Producto producto = new Producto();
          
              producto.setIdProducto(lista.get(i).getIdProducto());
              producto.setNombre(lista.get(i).getNombreProducto());
              producto.setPrecioActual(lista.get(i).getPrecioActual());
              //resta al stock del producto la cantidad comprada
              producto.setStock(productosDAO.consultarProductoID(producto.getIdProducto()).getStock()-lista.get(i).getCantidad());
            
              
              productosDAO.actualizar(producto);
              //Hasta aqui funciona 
              
              refPV.setIdProducto(producto);
              
              refPV.setIdVenta(venta2);
              refPV.setImporte(lista.get(i).getMontoTotal());
              refPV.setPrecio(lista.get(i).getPrecioActual());
         refProductoVentasDAO.agregar(refPV);
     }
        JOptionPane.showMessageDialog(null, "Se realizo con exito");
      consultarTodosProductos();
    limpiar();
       }else
       {
           JOptionPane.showMessageDialog(null, "No hay productos seleccionados");
           consultarTodosProductos();
           
       }
   
     
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtDescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_txtDescuentoKeyTyped

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
          soloNumeros(evt);
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtCantidadQuitarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadQuitarKeyTyped
          soloNumeros(evt);
    }//GEN-LAST:event_txtCantidadQuitarKeyTyped

    private void txtBuscarProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProductoKeyTyped
          soloNumeros(evt);
    }//GEN-LAST:event_txtBuscarProductoKeyTyped

    
    
    /**
     * Calcula el descuento solo que este se hizo para llamarlo cuando se necesite a diferencia del keyRealeased
     */
    public void hacerDescuento()
    {
        if(txtDescuento.getText().trim().length()>0 )
        {
           total=0;
    descuento=0;
   float porcentaje;
   //&& Integer.parseInt(txtDescuento.getText())<100&& Integer.parseInt(txtDescuento.getText())>0
   if(txtDescuento.getText().length()>0 )
   {
       float datoDesc=Float.valueOf(txtDescuento.getText());
       porcentaje=datoDesc/100;
       
       descuento=porcentaje*Float.valueOf(txtSubtotal.getText());
        total=(Float.valueOf(txtSubtotal.getText())-descuento);
        
        txtTotal.setText(String.valueOf(total));
   }else if( Integer.parseInt(txtDescuento.getText())<=100&& Integer.parseInt(txtDescuento.getText())>=0)
   {
       JOptionPane.showMessageDialog(null, "Ingrese un numero entre 0-100");
   }
        }
    }
    
   
     public void limpiar()
     {
          txtCantidad.setText("");
        txtSubtotal.setText("");
        txtTotal.setText("");
        txtDescuento.setText("0");
        // Quitar todo de la lista de seleccionados
        
         lista.clear();
         subtotal=0;
          total=0;
         descuento=0;

          
         DefaultTableModel model= (DefaultTableModel) tblSeleccionados.getModel();
        int rowCount = model.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
          model.removeRow(i);
        }
     }
     
     
      public void soloNumeros(java.awt.event.KeyEvent evt)
    {
         char car = evt.getKeyChar();
        if( Character.isDigit(car) ){

}else{
evt.consume();
getToolkit().beep();
}
    }

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonMostrarTodos;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> comboBoxCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTable tblSeleccionados;
    private javax.swing.JTextField txtBuscarProducto;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCantidadQuitar;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
