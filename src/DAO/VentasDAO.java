/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import modelo.Producto;
import modelo.Venta;
import persistencia.ProductoJpaController;
import persistencia.VentaJpaController;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Jarol
 */
public class VentasDAO implements IVentasDAO {
    
       VentaJpaController control = new   VentaJpaController();

    @Override
    public boolean agregar(Venta venta) {
        try
        {
            control.create(venta);
            return true;
        }catch (Exception ex) 
   {
     Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
        return false;
   }
    
      
    }

    @Override
    public boolean actualizar(Venta venta) {
        
           try {
               control.edit(venta);
               return true;
           } catch (Exception ex) {
               Logger.getLogger(VentasDAO.class.getName()).log(Level.SEVERE, null, ex);
               return false;
           }
       
    }

    @Override
    public boolean eliminar(Integer idVenta) {
           try {
               control.destroy(idVenta);
               return true;
           } catch (NonexistentEntityException ex) {
               Logger.getLogger(VentasDAO.class.getName()).log(Level.SEVERE, null, ex);
               return false;
           }
    }

    @Override
    public Venta consultarID(Integer idVenta) {
      Venta venta=control.findVenta(idVenta);
      return venta;
    }

    @Override
    public List<Venta> consultarTodos() {
          List<Venta> list= control.findVentaEntities();
    
   
        for(int i=0; i<list.size();i++){
            System.out.println(list.get(i));
            
        }
        
        return list;
    }

    @Override
    public List<Venta> consultarPorFecha(String fechaInicio, String FechaFinal,String idCliente) {
      return  control.consultarPorFecha(fechaInicio, FechaFinal,idCliente);
    }

   
    
    
}
