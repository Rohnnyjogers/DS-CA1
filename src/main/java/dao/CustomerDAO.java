package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Customer;
import entity.Loan;

public class CustomerDAO {
	
	protected static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("PU");
	
	public CustomerDAO() {}
	
	public void persist(Customer c) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
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
	
	public Customer merge(Customer c) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Customer updatedCustomer = em.merge(c);
		em.getTransaction().commit();
		em.close();
		
		return updatedCustomer;
	}
	
	public List<Customer> getCustomers(){
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		ArrayList<Customer> customers = (ArrayList<Customer>) em.createNamedQuery("Customer.findAll")
				.getResultList();
		em.getTransaction().commit();
		em.close();
		
		return customers;
	}
	
	public Customer getCustomerById(String s) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Customer customer = (Customer) em.createNamedQuery("Customer.getById")
				.setParameter("customerid", s)
				.getSingleResult();
		em.getTransaction().begin();
		em.close();
		
		return customer;
	}
	
	public Customer getCustomerByName(String s){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Customer customer = (Customer) em.createNamedQuery("Customer.findByName")
				.setParameter("customername", s)
				.getSingleResult();
		em.getTransaction().commit();
		em.close();
		
		return customer;
	}
	
	public Loan getLoanByCustomerId(String s) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Loan loan = (Loan) em.createNamedQuery("Customer.findLoanById")
				.setParameter("customerid", s)
				.getSingleResult();
		em.getTransaction().commit();
		em.close();
		
		return loan;
	}
	
	public Loan getLoanByCustomerName(String s) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Loan loan = (Loan) em.createNamedQuery("Customer.findLoanByName")
				.setParameter("customername", s)
				.getSingleResult();
		em.getTransaction().commit();
		em.close();
		
		return loan;
	}
	
	public double getLoanAmountByCustomerId(String s) {
		Loan loan = getLoanByCustomerId(s);
		
		return loan.getLoanAmount();
		
	}
}
