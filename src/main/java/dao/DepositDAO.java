package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Deposit;

public class DepositDAO {
	
	protected static EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("PU");
	
	public DepositDAO() {}
	
	public void persist(Deposit d) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(Deposit d) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(d));
		em.getTransaction().commit();
		em.close();
	}
	
	public Deposit merge(Deposit d) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Deposit updatedDeposit = em.merge(d);
		em.getTransaction().commit();
		em.close();
		
		return updatedDeposit;
	}
}
