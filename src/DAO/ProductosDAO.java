/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.*;
import javax.swing.JOptionPane;
import modelo.Cliente;
import persistencia.ProductoJpaController;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Jarol
 */  
public class ProductosDAO implements IProductosDAO {
    
   ProductoJpaController control = new   ProductoJpaController();

    @Override
    public boolean agregar(Producto producto) {
        
        try
        {
        control.create(producto);
       return true;
      
      
        }  catch (Exception ex) 
   {
     Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
        return false;
   }
    
    
    }
    

    @Override
    public List<Producto> consultarTodos() {
            List<Producto> list= control.findProductoEntities();
    
   
        for(int i=0; i<list.size();i++){
            System.out.println(list.get(i));
            
        }
        
        return list;
      
    }

    @Override
    public Producto consultarProductoID(Integer idProducto) {
          Producto product= control.findProducto(idProducto);
        return product; 
      
    }

    @Override
    public boolean actualizar(Producto producto) {
      
       try {
           control.edit(producto);
           return true;
       } catch (Exception ex) {
           Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
       }
     return false;
    }

    @Override
    public boolean eliminar(Integer idProducto) {
       try {
           control.destroy(idProducto);
           return true;
       } catch (NonexistentEntityException ex) {
           Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
       }
       return false;
    }

    @Override
    public List<Producto> consultarProductosVenta(Venta venta) {
       return  control.consultarProductosVenta(venta);
    }

    
}
