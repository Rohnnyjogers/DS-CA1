package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Loan;

public class LoanDAO {

	protected static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("PU");
	
	public LoanDAO() {}
	
	public void persist(Loan l) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(Loan l) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(l));
		em.getTransaction().commit();
		em.close();
	}
	
	public void merge(Loan l) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Loan updatedLoan = em.merge(l);
		em.getTransaction().commit();
		em.close();
	}
}
