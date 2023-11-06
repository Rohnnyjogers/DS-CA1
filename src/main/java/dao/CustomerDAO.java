package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Customer;

public class CustomerDAO {
	
	protected static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("PU");
	
	public CustomerDAO() {}
	
	public void persist(Customer c) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(em);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public void remove(Customer c) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(c));
		em.getTransaction().commit();
		em.close();
	}
}
