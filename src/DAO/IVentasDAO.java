/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import modelo.Cliente;
import modelo.Venta;

/**
 *
 * @author Jarol
 */
public interface IVentasDAO {
     boolean agregar (Venta venta);
    boolean actualizar (Venta venta);
    boolean eliminar (Integer idVenta);
    Venta consultarID (Integer idVenta);
    List<Venta> consultarTodos(); 
    List<Venta> consultarPorFecha(String fechaInicio,String FechaFinal,String idCliente); 
}
