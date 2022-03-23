/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import modelo.Cliente;
import modelo.*;

/**
 *
 * @author Jarol
 */
public interface IProductosDAO {
      boolean agregar(Producto producto);
    List<Producto> consultarTodos();
    Producto  consultarProductoID(Integer idProducto);
    boolean actualizar(Producto producto);
    boolean eliminar(Integer  idProducto);
     List<Producto> consultarProductosVenta(Venta venta);

   
    
 
}
