/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;
import modelo.RefProductoventas;
import modelo.Venta;
import persistencia.RefProductoventasJpaController;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Jarol
 */
public class RefProductoVentasDAO implements IRefProductoventas {
    RefProductoventasJpaController control = new    RefProductoventasJpaController();
    
    @Override
    public boolean agregar(RefProductoventas refProductoventas) {
        try
        {
            control.create(refProductoventas);
            return true;
        }catch(Exception ex)
    {
        Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
        return false;
    }
    }

    @Override
    public boolean actualizar(RefProductoventas refProductoventas) {
        try {
            control.edit(refProductoventas);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(RefProductoVentasDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean eliminar(Integer idRefProductoventas) {
        try {
            control.destroy(idRefProductoventas);
            return true;
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(RefProductoVentasDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public RefProductoventas consultarID(Integer idRefProductoVentas) {
       RefProductoventas refProductoventas=control.findRefProductoventas(idRefProductoVentas);
       return refProductoventas;
       
    }

    @Override
    public List<RefProductoventas> consultarTodos() {
         List<RefProductoventas> list= control.findRefProductoventasEntities();
    
   
        for(int i=0; i<list.size();i++){
            System.out.println(list.get(i));
            
        }
        
        return list;
    }

    @Override
    public List<RefProductoventas> consultarRefProductosVenta(Venta venta) {
     return  control.consultarRefProductosVenta(venta);
    }
    
}
