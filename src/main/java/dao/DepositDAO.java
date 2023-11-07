package dao;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<Deposit> getDeposits(){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		ArrayList<Deposit> deposits = (ArrayList<Deposit>) em.createNamedQuery("Deposit.findAll")
				.getResultList();
		em.getTransaction().commit();
		em.close();
		
		return deposits;
	}
	
	public Deposit getDepositById(String s) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Deposit deposit = (Deposit) em.createNamedQuery("Deposit.findById")
				.setParameter("depositid", s)
				.getSingleResult();
		em.getTransaction().commit();
		em.close();
		
		return deposit;
	}
	
	public Deposit getDepositByDate(String s) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Deposit deposit = (Deposit) em.createNamedQuery("Deposit.findByDate")
				.setParameter("depositid", s)
				.getSingleResult();
		em.getTransaction().commit();
		em.close();
		
		return deposit;
	}
}
