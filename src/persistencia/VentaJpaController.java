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
import modelo.Cliente;
import modelo.RefProductoventas;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;

import modelo.Venta;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Jarol
 */
public class VentaJpaController implements Serializable {

    public VentaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
         public VentaJpaController()
    {
        emf= Persistence.createEntityManagerFactory("SistemaVentasPU");
    }

    public void create(Venta venta) {
        if (venta.getRefProductoventasCollection() == null) {
            venta.setRefProductoventasCollection(new ArrayList<RefProductoventas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente idCliente = venta.getIdCliente();
            if (idCliente != null) {
                idCliente = em.getReference(idCliente.getClass(), idCliente.getIdCliente());
                venta.setIdCliente(idCliente);
            }
            Collection<RefProductoventas> attachedRefProductoventasCollection = new ArrayList<RefProductoventas>();
            for (RefProductoventas refProductoventasCollectionRefProductoventasToAttach : venta.getRefProductoventasCollection()) {
                refProductoventasCollectionRefProductoventasToAttach = em.getReference(refProductoventasCollectionRefProductoventasToAttach.getClass(), refProductoventasCollectionRefProductoventasToAttach.getIdRef());
                attachedRefProductoventasCollection.add(refProductoventasCollectionRefProductoventasToAttach);
            }
            venta.setRefProductoventasCollection(attachedRefProductoventasCollection);
            em.persist(venta);
            if (idCliente != null) {
                idCliente.getVentaCollection().add(venta);
                idCliente = em.merge(idCliente);
            }
            for (RefProductoventas refProductoventasCollectionRefProductoventas : venta.getRefProductoventasCollection()) {
                Venta oldIdVentaOfRefProductoventasCollectionRefProductoventas = refProductoventasCollectionRefProductoventas.getIdVenta();
                refProductoventasCollectionRefProductoventas.setIdVenta(venta);
                refProductoventasCollectionRefProductoventas = em.merge(refProductoventasCollectionRefProductoventas);
                if (oldIdVentaOfRefProductoventasCollectionRefProductoventas != null) {
                    oldIdVentaOfRefProductoventasCollectionRefProductoventas.getRefProductoventasCollection().remove(refProductoventasCollectionRefProductoventas);
                    oldIdVentaOfRefProductoventasCollectionRefProductoventas = em.merge(oldIdVentaOfRefProductoventasCollectionRefProductoventas);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Venta venta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Venta persistentVenta = em.find(Venta.class, venta.getIdVenta());
            Cliente idClienteOld = persistentVenta.getIdCliente();
            Cliente idClienteNew = venta.getIdCliente();
            Collection<RefProductoventas> refProductoventasCollectionOld = persistentVenta.getRefProductoventasCollection();
            Collection<RefProductoventas> refProductoventasCollectionNew = venta.getRefProductoventasCollection();
            if (idClienteNew != null) {
                idClienteNew = em.getReference(idClienteNew.getClass(), idClienteNew.getIdCliente());
                venta.setIdCliente(idClienteNew);
            }
            Collection<RefProductoventas> attachedRefProductoventasCollectionNew = new ArrayList<RefProductoventas>();
            for (RefProductoventas refProductoventasCollectionNewRefProductoventasToAttach : refProductoventasCollectionNew) {
                refProductoventasCollectionNewRefProductoventasToAttach = em.getReference(refProductoventasCollectionNewRefProductoventasToAttach.getClass(), refProductoventasCollectionNewRefProductoventasToAttach.getIdRef());
                attachedRefProductoventasCollectionNew.add(refProductoventasCollectionNewRefProductoventasToAttach);
            }
            refProductoventasCollectionNew = attachedRefProductoventasCollectionNew;
            venta.setRefProductoventasCollection(refProductoventasCollectionNew);
            venta = em.merge(venta);
            if (idClienteOld != null && !idClienteOld.equals(idClienteNew)) {
                idClienteOld.getVentaCollection().remove(venta);
                idClienteOld = em.merge(idClienteOld);
            }
            if (idClienteNew != null && !idClienteNew.equals(idClienteOld)) {
                idClienteNew.getVentaCollection().add(venta);
                idClienteNew = em.merge(idClienteNew);
            }
            for (RefProductoventas refProductoventasCollectionOldRefProductoventas : refProductoventasCollectionOld) {
                if (!refProductoventasCollectionNew.contains(refProductoventasCollectionOldRefProductoventas)) {
                    refProductoventasCollectionOldRefProductoventas.setIdVenta(null);
                    refProductoventasCollectionOldRefProductoventas = em.merge(refProductoventasCollectionOldRefProductoventas);
                }
            }
            for (RefProductoventas refProductoventasCollectionNewRefProductoventas : refProductoventasCollectionNew) {
                if (!refProductoventasCollectionOld.contains(refProductoventasCollectionNewRefProductoventas)) {
                    Venta oldIdVentaOfRefProductoventasCollectionNewRefProductoventas = refProductoventasCollectionNewRefProductoventas.getIdVenta();
                    refProductoventasCollectionNewRefProductoventas.setIdVenta(venta);
                    refProductoventasCollectionNewRefProductoventas = em.merge(refProductoventasCollectionNewRefProductoventas);
                    if (oldIdVentaOfRefProductoventasCollectionNewRefProductoventas != null && !oldIdVentaOfRefProductoventasCollectionNewRefProductoventas.equals(venta)) {
                        oldIdVentaOfRefProductoventasCollectionNewRefProductoventas.getRefProductoventasCollection().remove(refProductoventasCollectionNewRefProductoventas);
                        oldIdVentaOfRefProductoventasCollectionNewRefProductoventas = em.merge(oldIdVentaOfRefProductoventasCollectionNewRefProductoventas);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = venta.getIdVenta();
                if (findVenta(id) == null) {
                    throw new NonexistentEntityException("The venta with id " + id + " no longer exists.");
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
            Venta venta;
            try {
                venta = em.getReference(Venta.class, id);
                venta.getIdVenta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The venta with id " + id + " no longer exists.", enfe);
            }
            Cliente idCliente = venta.getIdCliente();
            if (idCliente != null) {
                idCliente.getVentaCollection().remove(venta);
                idCliente = em.merge(idCliente);
            }
            Collection<RefProductoventas> refProductoventasCollection = venta.getRefProductoventasCollection();
            for (RefProductoventas refProductoventasCollectionRefProductoventas : refProductoventasCollection) {
                refProductoventasCollectionRefProductoventas.setIdVenta(null);
                refProductoventasCollectionRefProductoventas = em.merge(refProductoventasCollectionRefProductoventas);
            }
            em.remove(venta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Venta> findVentaEntities() {
        return findVentaEntities(true, -1, -1);
    }

    public List<Venta> findVentaEntities(int maxResults, int firstResult) {
        return findVentaEntities(false, maxResults, firstResult);
    }

    private List<Venta> findVentaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Venta.class));
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

    public Venta findVenta(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Venta.class, id);
        } finally {
            em.close();
        }
    }

    public int getVentaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Venta> rt = cq.from(Venta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
     public List<Venta> consultarPorFecha(String fechaInicio, String fechaFinal,String idCliente) {
         
         /*
             EntityManagerFactory managerFactory= Persistence.createEntityManagerFactory("SistemaVentasPU");
            EntityManager entityManager = managerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Venta> criteria= builder.createQuery(Venta.class);
            TypedQuery<Venta>query = entityManager.createQuery(criteria);
            
            
           String jpqlQuery="SELECT v FROM Venta   v WHERE   cast(v.fecha as date) BETWEEN '"+fechaInicio+"' AND '"+fechaFinal+"'";
            query= entityManager.createQuery(jpqlQuery,Venta.class);
            List<Venta> ventas= query.getResultList();
              
            
            entityManager.getTransaction().commit();
            return ventas;
*/
         
             EntityManagerFactory managerFactory= Persistence.createEntityManagerFactory("SistemaVentasPU");
            EntityManager entityManager = managerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Venta> criteria= builder.createQuery(Venta.class);
            TypedQuery<Venta>query = entityManager.createQuery(criteria);
          
           // p.idProducto, p.nombre, p.precioActual, p.stock 
            String jpqlQuery="SELECT v FROM Venta   v JOIN v.idCliente c WHERE c.idCliente= :idCliente AND   cast(v.fecha as date) BETWEEN '"+fechaInicio+"' AND '"+fechaFinal+"'";
            query= entityManager.createQuery(jpqlQuery,Venta.class);
           query.setParameter("idCliente", Integer.parseInt(idCliente));
           
            List<Venta> ventas= query.getResultList();
              
            
            entityManager.getTransaction().commit();
            return ventas;
    }
}
