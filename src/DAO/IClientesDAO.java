/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import modelo.Cliente;
import java.util.List;

/**
 *
 * @author cyt88
 */
public interface IClientesDAO 
{
    boolean agregar (Cliente cliente);
    boolean actualizar (Cliente cliente);
    boolean eliminar (Integer idCliente);
    Cliente consultarID (Integer idCliente);
    List<Cliente> consultarTodos(); 
}
