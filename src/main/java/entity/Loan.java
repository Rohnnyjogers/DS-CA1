package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="loan")
@Entity
public class Loan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int loanId;
	private double loanAmount;
	private String loanDesc;
	
	private List<Deposit> loanPayments = new ArrayList<Deposit>();
	
	public Loan() {}
	
	public Loan(int lid, double la, String ld, List<Deposit> lp) {
		
		this.loanId = lid;
		this.loanAmount = la;
		this.loanDesc = ld;
		this.loanPayments = lp;
	}

	@XmlElement
	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
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
