package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Deposit;
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
	
	public Loan merge(Loan l) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Loan updatedLoan = em.merge(l);
		em.getTransaction().commit();
		em.close();
		
		return updatedLoan;
	}
	
	public List<Loan> getLoans(){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		ArrayList<Loan> loans = (ArrayList<Loan>) em.createNamedQuery("Loan.findAll")
				.getResultList();
		em.getTransaction().commit();
		em.close();
		
		return loans;
	}
	
	public Loan getLoanById(String s) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Loan loan = (Loan) em.createNamedQuery("Loan.findById")
				.setParameter("loanid", s)
				.getSingleResult();
		em.getTransaction().commit();
		em.close();
		
		return loan;
	}
	
	public List<Deposit> getDepositsByLoanId(String s){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		ArrayList<Deposit> loanPayments = (ArrayList<Deposit>) em.createNamedQuery("Loan.getDepositsById")
				.setParameter("loanid", s)
				.getResultList();
		em.getTransaction().commit();
		em.close();
		
		return loanPayments;
	}
}
