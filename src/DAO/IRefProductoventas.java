/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import modelo.RefProductoventas;
import modelo.Venta;

/**
 *
 * @author Jarol
 */
public interface IRefProductoventas {
       boolean agregar (RefProductoventas refProductoventas);
    boolean actualizar (RefProductoventas refProductoventas);
    boolean eliminar (Integer idRefProductoventas);
    RefProductoventas  consultarID (Integer idRefProductoVentas);
    List<RefProductoventas > consultarTodos(); 
    List<RefProductoventas> consultarRefProductosVenta(Venta venta);
    
}
