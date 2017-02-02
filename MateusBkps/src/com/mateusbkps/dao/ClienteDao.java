package com.mateusbkps.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.mateusbkps.entity.Cliente;

public class ClienteDao {
	
	public void saveOrUpdate(Cliente cliente) {
		EntityManager em = com.mateusbkps.util.HibernateUtil
				.geteEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		try {
			if (cliente.getId() == null){
					em.persist(cliente);
				}else{
					em.merge(cliente);
				}
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
	
	public void delete(Cliente cliente){
		EntityManager em = com.mateusbkps.util.HibernateUtil
				.geteEntityManagerFactory().createEntityManager();
		try{
			em.getTransaction().begin();
			Cliente cl = em.find(Cliente.class, cliente.getId());
			em.remove(cl);
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
		}
	}
	
	
	public List<Cliente> list() {
        List<Cliente> result = null;
        try {
            EntityManager em = com.mateusbkps.util.HibernateUtil
                    .geteEntityManagerFactory().createEntityManager();
            Query query = em.createQuery("FROM Cliente");
            result = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
	

