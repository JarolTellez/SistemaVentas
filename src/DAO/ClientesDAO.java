/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;
import persistencia.ClienteJpaController;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 *  @author jarol
 */
public class ClientesDAO implements IClientesDAO
{
    ClienteJpaController control=new ClienteJpaController(); 

@Override
public boolean agregar (Cliente cliente){
  
    try
    {
      control.create(cliente);
      return true; 
    }catch(Exception ex)
    {
        Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
        return false;
    }
   
    
    }

@Override
public boolean actualizar (Cliente cliente){
   try
   {
     control.edit(cliente);
     return true;
   } 
   catch (Exception ex) 
   {
     Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
        return false;
   }
  
  }

@Override
 public boolean eliminar (Integer idCliente){   
  
     try 
      {
        control.destroy(idCliente);
        return true;
      } 
       catch (NonexistentEntityException ex) 
       {
        Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
        return false;
       }
  
       
   }
 
  @Override
    public Cliente consultarID(Integer idCliente) {
          Cliente client= control.findCliente(idCliente);
        return client;
      
    }         

    @Override
    public List<Cliente> consultarTodos() {
            List<Cliente> list= control.findClienteEntities();
    
   
        for(int i=0; i<list.size();i++){
            System.out.println(list.get(i));
            
        }
        
        return list;
      
    }
}
