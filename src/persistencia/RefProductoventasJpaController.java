/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Producto;
import modelo.RefProductoventas;
import modelo.Venta;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Jarol
 */
public class RefProductoventasJpaController implements Serializable {

    public RefProductoventasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    private EntityManagerFactory emf = null;
    
       public RefProductoventasJpaController()
    {
        emf= Persistence.createEntityManagerFactory("SistemaVentasPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(RefProductoventas refProductoventas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto idProducto = refProductoventas.getIdProducto();
            if (idProducto != null) {
                //idProducto = em.getReference(idProducto.getClass(), idProducto.getIdProducto());
                refProductoventas.setIdProducto(idProducto);
            }
            Venta idVenta = refProductoventas.getIdVenta();
            if (idVenta != null) {
                idVenta = em.getReference(idVenta.getClass(), idVenta.getIdVenta());
                refProductoventas.setIdVenta(idVenta);
            }
            em.persist(refProductoventas);
            if (idProducto != null) {
              //  idProducto.getRefProductoventasCollection().add(refProductoventas);
                idProducto = em.merge(idProducto);
            }
            if (idVenta != null) {
                idVenta.getRefProductoventasCollection().add(refProductoventas);
                idVenta = em.merge(idVenta);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(RefProductoventas refProductoventas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            RefProductoventas persistentRefProductoventas = em.find(RefProductoventas.class, refProductoventas.getIdRef());
            Producto idProductoOld = persistentRefProductoventas.getIdProducto();
            Producto idProductoNew = refProductoventas.getIdProducto();
            Venta idVentaOld = persistentRefProductoventas.getIdVenta();
            Venta idVentaNew = refProductoventas.getIdVenta();
            if (idProductoNew != null) {
                idProductoNew = em.getReference(idProductoNew.getClass(), idProductoNew.getIdProducto());
                refProductoventas.setIdProducto(idProductoNew);
            }
            if (idVentaNew != null) {
                idVentaNew = em.getReference(idVentaNew.getClass(), idVentaNew.getIdVenta());
                refProductoventas.setIdVenta(idVentaNew);
            }
            refProductoventas = em.merge(refProductoventas);
            if (idProductoOld != null && !idProductoOld.equals(idProductoNew)) {
                idProductoOld.getRefProductoventasCollection().remove(refProductoventas);
                idProductoOld = em.merge(idProductoOld);
            }
            if (idProductoNew != null && !idProductoNew.equals(idProductoOld)) {
                idProductoNew.getRefProductoventasCollection().add(refProductoventas);
                idProductoNew = em.merge(idProductoNew);
            }
            if (idVentaOld != null && !idVentaOld.equals(idVentaNew)) {
                idVentaOld.getRefProductoventasCollection().remove(refProductoventas);
                idVentaOld = em.merge(idVentaOld);
            }
            if (idVentaNew != null && !idVentaNew.equals(idVentaOld)) {
                idVentaNew.getRefProductoventasCollection().add(refProductoventas);
                idVentaNew = em.merge(idVentaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = refProductoventas.getIdRef();
                if (findRefProductoventas(id) == null) {
                    throw new NonexistentEntityException("The refProductoventas with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            RefProductoventas refProductoventas;
            try {
                refProductoventas = em.getReference(RefProductoventas.class, id);
                refProductoventas.getIdRef();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The refProductoventas with id " + id + " no longer exists.", enfe);
            }
            Producto idProducto = refProductoventas.getIdProducto();
            if (idProducto != null) {
                idProducto.getRefProductoventasCollection().remove(refProductoventas);
                idProducto = em.merge(idProducto);
            }
            Venta idVenta = refProductoventas.getIdVenta();
            if (idVenta != null) {
                idVenta.getRefProductoventasCollection().remove(refProductoventas);
                idVenta = em.merge(idVenta);
            }
            em.remove(refProductoventas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<RefProductoventas> findRefProductoventasEntities() {
        return findRefProductoventasEntities(true, -1, -1);
    }

    public List<RefProductoventas> findRefProductoventasEntities(int maxResults, int firstResult) {
        return findRefProductoventasEntities(false, maxResults, firstResult);
    }

    private List<RefProductoventas> findRefProductoventasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(RefProductoventas.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public RefProductoventas findRefProductoventas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(RefProductoventas.class, id);
        } finally {
            em.close();
        }
    }

    public int getRefProductoventasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<RefProductoventas> rt = cq.from(RefProductoventas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
     public List<RefProductoventas> consultarRefProductosVenta(Venta venta) {
        
             EntityManagerFactory managerFactory= Persistence.createEntityManagerFactory("SistemaVentasPU");
            EntityManager entityManager = managerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<RefProductoventas> criteria= builder.createQuery(RefProductoventas.class);
            TypedQuery<RefProductoventas>query = entityManager.createQuery(criteria);
          
           // p.idProducto, p.nombre, p.precioActual, p.stock 
           String jpqlQuery="SELECT DISTINCT r.idProducto FROM  RefProductoventas r JOIN r.idProducto p JOIN r.idVenta  v where v.idVenta= :idVenta";
            query= entityManager.createQuery(jpqlQuery,RefProductoventas.class);
            query.setParameter("idVenta", venta.getIdVenta());
           
            List<RefProductoventas> refProductos= query.getResultList();
              
            
            entityManager.getTransaction().commit();
            return refProductos;
            
       
    }
    
    
}
