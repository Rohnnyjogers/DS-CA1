package service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import dao.CustomerDAO;
import dao.DepositDAO;
import dao.LoanDAO;
import entity.Customer;
import entity.Deposit;
import entity.Loan;

@Path("/service")
public class Service {
	
	// Simple end points
	
	@GET
	@Path("/hello")
	@Produces("text/plain")
	public String hello() {
		return "Hello World.";
	}
	
	@GET
	@Path("echo/{message}")
	@Produces("text/plain")
	public String echo(@PathParam("message") String message) {
		return message;
	}
	
	// Customer end points
	
	@GET
	@Path("/customersxml")
	@Produces("application/xml")
	public List<Customer> getCustomersXML() {
		CustomerDAO dao = new CustomerDAO();
		
		return dao.getCustomers();
	}
	
	@GET
	@Path("/customersjson")
	@Produces("application/json")
	public List<Customer> getCustomersJSON(){
		CustomerDAO dao = new CustomerDAO();
		
		return dao.getCustomers();
	}
	
	@GET
	@Path("/customerbyidxml/{customerId}")
	@Produces("application/xml")
	public Customer getCustomerByIdXML(@PathParam("customerId") String customerId) {
		CustomerDAO dao = new CustomerDAO();
		
		return dao.getCustomerById(customerId);
	}
	
	@GET
	@Path("/customerbyidjson/{customerId}")
	@Produces("application/json")
	public Customer getCustomerByIdJSON(@PathParam("customerId") String customerId) {
		CustomerDAO dao = new CustomerDAO();
		
		return dao.getCustomerById(customerId);
	}
	
	@GET
	@Path("/customerbynamexml/{customerName}")
	@Produces("application/xml")
	public Customer getCustomerByNameXML(@PathParam("customerName") String customerName) {
		CustomerDAO dao = new CustomerDAO();
		
		return dao.getCustomerByName(customerName);
	}
	
	@GET
	@Path("/customerbynamejson/{customerName}")
	@Produces("application/json")
	public Customer getCustomerByNameJSON(@PathParam("customerName") String customerName) {
		CustomerDAO dao = new CustomerDAO();
		
		return dao.getCustomerByName(customerName);
	}
	
	@GET
	@Path("/customerloanbyidxml/{customerId}")
	@Produces("application/xml")
	public Loan getLoanByCustomerByIdXML(@PathParam("customerId") String customerId) {
		CustomerDAO dao = new CustomerDAO();
		
		return dao.getLoanByCustomerId(customerId);
	}
	
	@GET
	@Path("/customerloanbyidjson/{customerId}")
	@Produces("application/json")
	public Loan getLoanByCustomerByIdJSON(@PathParam("customerId") String customerId) {
		CustomerDAO dao = new CustomerDAO();
		
		return dao.getLoanByCustomerId(customerId);
	}
	
	@GET
	@Path("/customerloanbynamexml/{customerName}")
	@Produces("application/xml")
	public Loan getLoanByCustomerNameXML(@PathParam("customerName") String customerName) {
		CustomerDAO dao = new CustomerDAO();
		
		return dao.getLoanByCustomerName(customerName);
	}
	
	@GET
	@Path("/customerloanbynamejson/{customerName}")
	@Produces("application/json")
	public Loan getLoanByCustomerNameJSON(@PathParam("customerName") String customerName) {
		CustomerDAO dao = new CustomerDAO();
		
		return dao.getLoanByCustomerName(customerName);
	}
	
	@GET
	@Path("/loanamountbycustomeridjson/{customerId}")
	@Produces("application/json")
	public double getLoanAmountByCustomerIdJSON(@PathParam("customerId") String customerId) {
		CustomerDAO dao = new CustomerDAO();
		
		return dao.getLoanAmountByCustomerId(customerId);
	}
	
	
	@POST
	@Path("/addcustomerxml")
	@Consumes("application/xml")
	@Produces("text/plain")
	public String addCustomerXML(Customer customer) {
		CustomerDAO dao = new CustomerDAO();
		dao.persist(customer);
		
		return customer.getCustomerName()+" added successfully.";
	}
	
	@POST
	@Path("/addcustomerjson")
	@Consumes("application/json")
	public String addCustomerJSON(Customer customer) {
		CustomerDAO dao = new CustomerDAO();
		dao.persist(customer);
		
		return customer.getCustomerName()+" added successfully.";
	}
	
	@PUT
	@Path("/updatecustomer")
	@Consumes("application/xml")
	public Customer updateCustomerXML(Customer customer) {
		CustomerDAO dao = new CustomerDAO();
		
		return dao.merge(customer);
	}
	
	@PUT
	@Path("/updatecustomer")
	@Consumes("application/json")
	public Customer updateCustomerJSON(Customer customer) {
		CustomerDAO dao = new CustomerDAO();
		
		return dao.merge(customer);
	}
	
	@DELETE
	@Path("/deletecustomer/{customerName}")
	@Produces("text/plain")
	public String deleteCustomerByName(@PathParam("customerName") String customerName) {
		CustomerDAO dao = new CustomerDAO();
		Customer customer = dao.getCustomerByName(customerName);
		dao.remove(customer);
		
		return customer.getCustomerName()+" removed successfully.";
	}
	
	@DELETE
	@Path("/deletecustomerloan/{customerName}")
	@Produces("text/plain")
	public String deleteLoanByCustomerName(@PathParam("customerName") String customerName) {
		CustomerDAO cDAO = new CustomerDAO();
		LoanDAO lDAO = new LoanDAO();
		
		Loan loan = cDAO.getLoanByCustomerName(customerName);
		lDAO.remove(loan);
		
		return "Loan under "+customerName+" removed successfully.";
	}
	
	// Loan end points
	
	@GET
	@Path("/loansxml")
	@Produces("application/xml")
	public List<Loan> getLoansXML() {
		LoanDAO dao = new LoanDAO();
		
		return dao.getLoans();
	}
	
	@GET
	@Path("/loansjson")
	@Produces("application/json")
	public List<Loan> getLoansJSON(){
		LoanDAO dao = new LoanDAO();
		
		return dao.getLoans();
	}
	
	@GET
	@Path("/loanbyidjson/{loanId}")
	@Produces("application/json")
	public Loan getLoanByIdJSON(@PathParam("loanId") String loanId){
		LoanDAO dao = new LoanDAO();
		
		return dao.getLoanById(loanId);
	}
	
	@GET
	@Path("/loandepositsbyidjson/{loanId}")
	@Produces("application/json")
	public List<Deposit> getDepositsLoanByIdJSON(@PathParam("loanId") String loanId){
		LoanDAO dao = new LoanDAO();
		
		return dao.getDepositsByLoanId(loanId);
	}
	
	@POST
	@Path("/addloanjson")
	@Consumes("application/json")
	@Produces("text/plain")
	public String addLoanJSON(Loan loan) {
		LoanDAO dao = new LoanDAO();
		dao.persist(loan);
		
		return "Loan with ID "+loan.getLoanId()+" added successfully.";
	}
	
	@PUT
	@Path("/updateloanjson")
	@Consumes("application/json")
	@Produces("text/plain")
	public String updateLoanJSON(Loan loan) {
		LoanDAO dao = new LoanDAO();
		dao.merge(loan);
		
		return "Loan with ID "+loan.getLoanId()+" updated successfully.";
	}
	
	@DELETE
	@Path("/deleteloan/{loanId}")
	@Produces("text/plain")
	public String deleteLoanById(@PathParam("loanId") String loanId) {
		LoanDAO dao = new LoanDAO();
		Loan loan = dao.getLoanById(loanId);
		dao.remove(loan);
		
		return "Loan with ID"+loanId+" removed successfully.";
	}
	
	// Deposit end points
	
	@GET
	@Path("/depositsxml")
	@Produces("application/xml")
	public List<Deposit> getDepositsXML(){
		DepositDAO dao = new DepositDAO();
		
		return dao.getDeposits();
	}
	
	@GET
	@Path("/depositsjson")
	@Produces("application/json")
	public List<Deposit> getDepositsJSON(){
		DepositDAO dao = new DepositDAO();
		
		return dao.getDeposits();
	}
	
	@GET
	@Path("/depositbyidjson/{depositId}")
	@Produces("application/json")
	public Deposit getDepositByJSON(@PathParam("depositId") String depositId){
		DepositDAO dao = new DepositDAO();
		
		return dao.getDepositById(depositId);
	}
	
	@GET
	@Path("/depositbydatejson/{depositId}")
	@Produces("application/json")
	public Deposit getDepositByDateJSON(@PathParam("depositDate") String depositDate) {
		DepositDAO dao = new DepositDAO();
		
		return dao.getDepositByDate(depositDate);
	}
	
	@POST
	@Path("/adddepositjson")
	@Consumes("application/json")
	@Produces("text/plain")
	public String addDepositJSON(Deposit deposit) {
		DepositDAO dao = new DepositDAO();
		dao.persist(deposit);
		
		return "Deposit with ID "+deposit.getDepositId()+" added successfully.";
	}
	
	@PUT
	@Path("/updatedepositjson")
	@Consumes("apllication/json")
	@Produces("text/plain")
	public String updateDepositJSON(Deposit deposit) {
		DepositDAO dao =new DepositDAO();
		dao.merge(deposit);
		
		return "Deposit with ID "+deposit.getDepositId()+" updated successfully.";
	}
	
	@DELETE
	@Path("/deletedeposit/{depositId}")
	@Produces("text/plain")
	public String deleteDepositById(@PathParam("depositId") String depositId) {
		DepositDAO dao = new DepositDAO();
		Deposit deposit = dao.getDepositById(depositId);
		dao.remove(deposit);
		
		return "Deposit with ID "+depositId+" have been removed successfully.";
		
	}
}
