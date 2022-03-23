/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

/**
 *
 * @author Jarol
 */
public class ProductosElegidos {
    
    int idProducto, cantidad=0;
    String nombreProducto;
    float precioActual,montoTotal;
    
    public ProductosElegidos()
    {}

    public ProductosElegidos(int idProducto, int cantidad, String nombreProducto, float precioActual, float montoTotal) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.nombreProducto = nombreProducto;
        this.precioActual = precioActual;
        this.montoTotal = montoTotal;
    }
    
    

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public float getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(float precioActual) {
        this.precioActual = precioActual;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }
    
    
    public List<ProductosElegidos> actualizar(ProductosElegidos producto,List<ProductosElegidos> lista,int cantidad)
    {
        for(int i=0;i<lista.size();i++)
        {
           if( lista.get(i).getIdProducto()==producto.getIdProducto())
           {
      //    &&
               producto.setCantidad(lista.get(i).getCantidad()+cantidad);
               producto.setMontoTotal(lista.get(i).getPrecioActual()*(lista.get(i).getCantidad()+cantidad));
               lista.set(i, producto);
           }
                    
        }
        
        return lista;
    }
    
     public List<ProductosElegidos> Eliminar(ProductosElegidos producto,List<ProductosElegidos> lista,int cantidad)
    {
        for(int i=0;i<lista.size();i++)
        {
           if( lista.get(i).getIdProducto()==producto.getIdProducto())
           {
          
               producto.setCantidad(lista.get(i).getCantidad()-cantidad);
               producto.setMontoTotal(lista.get(i).getPrecioActual()*(lista.get(i).getCantidad()-cantidad));
               lista.set(i, producto);
           }
                    
        }
        
        return lista;
    }
    
    
    
        
    public boolean buscar(ProductosElegidos producto,List<ProductosElegidos> lista)
    {
        for(int i=0;i<lista.size();i++)
        {
           if( lista.get(i).getIdProducto()==producto.getIdProducto())
           {
               return true;
           }
                    
        }
        
        return false;
    }
    
     public ProductosElegidos buscarProducto(ProductosElegidos producto,List<ProductosElegidos> lista)
    {
        for(int i=0;i<lista.size();i++)
        {
           if( lista.get(i).getIdProducto()==producto.getIdProducto())
           {
               return lista.get(i);
           }
                    
        }
        
        return null;
    }

    
    
}
