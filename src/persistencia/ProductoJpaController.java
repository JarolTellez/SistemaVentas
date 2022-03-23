/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.RefProductoventas;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import modelo.Cliente;
import modelo.Producto;
import modelo.Venta;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Jarol
 */
public class ProductoJpaController implements Serializable {

    public ProductoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
         public ProductoJpaController()
    {
        emf= Persistence.createEntityManagerFactory("SistemaVentasPU");
    }

    public void create(Producto producto) {
        if (producto.getRefProductoventasCollection() == null) {
            producto.setRefProductoventasCollection(new ArrayList<RefProductoventas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<RefProductoventas> attachedRefProductoventasCollection = new ArrayList<RefProductoventas>();
            for (RefProductoventas refProductoventasCollectionRefProductoventasToAttach : producto.getRefProductoventasCollection()) {
                refProductoventasCollectionRefProductoventasToAttach = em.getReference(refProductoventasCollectionRefProductoventasToAttach.getClass(), refProductoventasCollectionRefProductoventasToAttach.getIdRef());
                attachedRefProductoventasCollection.add(refProductoventasCollectionRefProductoventasToAttach);
            }
            producto.setRefProductoventasCollection(attachedRefProductoventasCollection);
            em.persist(producto);
            for (RefProductoventas refProductoventasCollectionRefProductoventas : producto.getRefProductoventasCollection()) {
                Producto oldIdProductoOfRefProductoventasCollectionRefProductoventas = refProductoventasCollectionRefProductoventas.getIdProducto();
                refProductoventasCollectionRefProductoventas.setIdProducto(producto);
                refProductoventasCollectionRefProductoventas = em.merge(refProductoventasCollectionRefProductoventas);
                if (oldIdProductoOfRefProductoventasCollectionRefProductoventas != null) {
                    oldIdProductoOfRefProductoventasCollectionRefProductoventas.getRefProductoventasCollection().remove(refProductoventasCollectionRefProductoventas);
                    oldIdProductoOfRefProductoventasCollectionRefProductoventas = em.merge(oldIdProductoOfRefProductoventasCollectionRefProductoventas);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Producto producto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto persistentProducto = em.find(Producto.class, producto.getIdProducto());
            Collection<RefProductoventas> refProductoventasCollectionOld = persistentProducto.getRefProductoventasCollection();
            Collection<RefProductoventas> refProductoventasCollectionNew = producto.getRefProductoventasCollection();
            Collection<RefProductoventas> attachedRefProductoventasCollectionNew = new ArrayList<RefProductoventas>();
            /*
            for (RefProductoventas refProductoventasCollectionNewRefProductoventasToAttach : refProductoventasCollectionNew) {
                refProductoventasCollectionNewRefProductoventasToAttach = em.getReference(refProductoventasCollectionNewRefProductoventasToAttach.getClass(), refProductoventasCollectionNewRefProductoventasToAttach.getIdRef());
                attachedRefProductoventasCollectionNew.add(refProductoventasCollectionNewRefProductoventasToAttach);
            }
*/
            refProductoventasCollectionNew = attachedRefProductoventasCollectionNew;
            producto.setRefProductoventasCollection(refProductoventasCollectionNew);
            producto = em.merge(producto);
            for (RefProductoventas refProductoventasCollectionOldRefProductoventas : refProductoventasCollectionOld) {
                if (!refProductoventasCollectionNew.contains(refProductoventasCollectionOldRefProductoventas)) {
                    refProductoventasCollectionOldRefProductoventas.setIdProducto(null);
                    refProductoventasCollectionOldRefProductoventas = em.merge(refProductoventasCollectionOldRefProductoventas);
                }
            }
            for (RefProductoventas refProductoventasCollectionNewRefProductoventas : refProductoventasCollectionNew) {
                if (!refProductoventasCollectionOld.contains(refProductoventasCollectionNewRefProductoventas)) {
                    Producto oldIdProductoOfRefProductoventasCollectionNewRefProductoventas = refProductoventasCollectionNewRefProductoventas.getIdProducto();
                    refProductoventasCollectionNewRefProductoventas.setIdProducto(producto);
                    refProductoventasCollectionNewRefProductoventas = em.merge(refProductoventasCollectionNewRefProductoventas);
                    if (oldIdProductoOfRefProductoventasCollectionNewRefProductoventas != null && !oldIdProductoOfRefProductoventasCollectionNewRefProductoventas.equals(producto)) {
                        oldIdProductoOfRefProductoventasCollectionNewRefProductoventas.getRefProductoventasCollection().remove(refProductoventasCollectionNewRefProductoventas);
                        oldIdProductoOfRefProductoventasCollectionNewRefProductoventas = em.merge(oldIdProductoOfRefProductoventasCollectionNewRefProductoventas);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = producto.getIdProducto();
                if (findProducto(id) == null) {
                    throw new NonexistentEntityException("The producto with id " + id + " no longer exists.");
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
            Producto producto;
            try {
                producto = em.getReference(Producto.class, id);
                producto.getIdProducto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The producto with id " + id + " no longer exists.", enfe);
            }
            Collection<RefProductoventas> refProductoventasCollection = producto.getRefProductoventasCollection();
            for (RefProductoventas refProductoventasCollectionRefProductoventas : refProductoventasCollection) {
                refProductoventasCollectionRefProductoventas.setIdProducto(null);
                refProductoventasCollectionRefProductoventas = em.merge(refProductoventasCollectionRefProductoventas);
            }
            em.remove(producto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Producto> findProductoEntities() {
        return findProductoEntities(true, -1, -1);
    }

    public List<Producto> findProductoEntities(int maxResults, int firstResult) {
        return findProductoEntities(false, maxResults, firstResult);
    }

    private List<Producto> findProductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Producto.class));
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

    public Producto findProducto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Producto.class, id);
           
        } finally {
            em.close();
        }
    }

    public int getProductoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Producto> rt = cq.from(Producto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
     public List<Producto> consultarProductosVenta(Venta venta) {
        
             EntityManagerFactory managerFactory= Persistence.createEntityManagerFactory("SistemaVentasPU");
            EntityManager entityManager = managerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Producto> criteria= builder.createQuery(Producto.class);
            TypedQuery<Producto>query = entityManager.createQuery(criteria);
          
           // p.idProducto, p.nombre, p.precioActual, p.stock 
           String jpqlQuery="SELECT DISTINCT r.idProducto FROM  RefProductoventas r JOIN r.idProducto p JOIN r.idVenta v where v.idVenta= :idVenta";
            query= entityManager.createQuery(jpqlQuery,Producto.class);
            query.setParameter("idVenta", venta.getIdVenta());
           
            List<Producto> productos= query.getResultList();
              
            
            entityManager.getTransaction().commit();
            return productos;
            
         
         /*
            
       EntityManager em = getEntityManager();
       Query query = em.createQuery("SELECT DISTINCT p FROM Producto p inner join RefProductoventas r on p.idProducto=r.idProducto inner join Venta v on r.idVenta=v.idVenta " +
             " where r.idVenta= :idVenta");
       query.setParameter("idventa", venta.getIdVenta());
       List<Producto> resultList = query.getResultList();
       
       em.close();
       return resultList;
*/
    }
     
       public List<RefProductoventas> consultarRefProductosVenta(Venta venta,Cliente cliente) {
        
             EntityManagerFactory managerFactory= Persistence.createEntityManagerFactory("SistemaVentasPU");
            EntityManager entityManager = managerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<RefProductoventas> criteria= builder.createQuery(RefProductoventas.class);
            TypedQuery<RefProductoventas>query = entityManager.createQuery(criteria);
          
           // p.idProducto, p.nombre, p.precioActual, p.stock 
           String jpqlQuery="SELECT DISTINCT r.idProducto FROM  RefProductoventas r JOIN r.idProducto p JOIN r.idVenta v where v.idVenta= :idVenta AND r.idCliente= :idCliente";
            query= entityManager.createQuery(jpqlQuery,RefProductoventas.class);
            query.setParameter("idVenta", venta.getIdVenta());
           
            List<RefProductoventas> refProductos= query.getResultList();
              
            
            entityManager.getTransaction().commit();
            return refProductos;
            
       
    }
    
}
