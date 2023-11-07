package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries({
	@NamedQuery(name="Loan.findAll", query="select o from Loan o"),
	@NamedQuery(name="Loan.findById", query="select o from Loan where o.loanId=:loanid"),
	@NamedQuery(name="Loan.findDepositsById", query="select o.loanPayments from Loan where o.loanId=:loanid")
	})

@XmlRootElement(name="loan")
@Entity
public class Loan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String loanId;
	private double loanAmount;
	private String loanDesc;
	
	@OneToMany(fetch=FetchType.EAGER)
	private List<Deposit> loanPayments = new ArrayList<Deposit>();
	
	public Loan() {}
	
	public Loan(String lid, double la, String ld, List<Deposit> lp) {
		
		this.loanId = lid;
		this.loanAmount = la;
		this.loanDesc = ld;
		this.loanPayments = lp;
	}

	@XmlElement
	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}

	@XmlElement
	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	@XmlElement
	public String getLoanDesc() {
		return loanDesc;
	}

	public void setLoanDesc(String loanDesc) {
		this.loanDesc = loanDesc;
	}

	@XmlElement
	public List<Deposit> getLoanPayments() {
		return loanPayments;
	}

	public void setLoanPayments(List<Deposit> loanPayments) {
		this.loanPayments = loanPayments;
	}
}
