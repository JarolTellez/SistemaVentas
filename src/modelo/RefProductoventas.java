/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jaro, carlos valle
 */
@Entity
@Table(name = "ref_productoventas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefProductoventas.findAll", query = "SELECT r FROM RefProductoventas r")
    , @NamedQuery(name = "RefProductoventas.findByIdRef", query = "SELECT r FROM RefProductoventas r WHERE r.idRef = :idRef")
    , @NamedQuery(name = "RefProductoventas.findByCantidad", query = "SELECT r FROM RefProductoventas r WHERE r.cantidad = :cantidad")
    , @NamedQuery(name = "RefProductoventas.findByPrecio", query = "SELECT r FROM RefProductoventas r WHERE r.precio = :precio")
   , @NamedQuery(name = "RefProductoventas.consultarProductosVenta",query="SELECT p FROM Producto p inner join RefProductoventas r on p.idProducto=r.idProducto inner join Venta v on r.idVenta=v.idVenta "+
                   "where r.idVenta= :idVenta")
    , @NamedQuery(name = "RefProductoventas.findByImporte", query = "SELECT r FROM RefProductoventas r WHERE r.importe = :importe")})
public class RefProductoventas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRef")
    private Integer idRef;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "precio")
    private float precio;
    @Basic(optional = false)
    @Column(name = "importe")
    private float importe;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    @ManyToOne
    private Producto idProducto;
    @JoinColumn(name = "idVenta", referencedColumnName = "idVenta")
    @ManyToOne
    private Venta idVenta;

    public RefProductoventas() {
    }

    public RefProductoventas(Integer idRef) {
        this.idRef = idRef;
    }

    public RefProductoventas(Integer idRef, int cantidad, float precio, float importe) {
        this.idRef = idRef;
        this.cantidad = cantidad;
        this.precio = precio;
        this.importe = importe;
    }

    public Integer getIdRef() {
        return idRef;
    }

    public void setIdRef(Integer idRef) {
        this.idRef = idRef;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Venta getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Venta idVenta) {
        this.idVenta = idVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRef != null ? idRef.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RefProductoventas)) {
            return false;
        }
        RefProductoventas other = (RefProductoventas) object;
        if ((this.idRef == null && other.idRef != null) || (this.idRef != null && !this.idRef.equals(other.idRef))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.RefProductoventas[ idRef=" + idRef + " ]";
    }
    
}
