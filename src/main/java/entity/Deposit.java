package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries({
	@NamedQuery(name="Deposit.findAll", query="select o from Deposit o"),
	@NamedQuery(name="Deposit.findById", query="select o from Deposit where o.depositId=:depositid"),
	@NamedQuery(name="Loan.findByDate", query="select o from Deposit where o.depositDate=:depositdate")
	})

@XmlRootElement(name="deposit")
@Entity
public class Deposit {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String depositId;
	private double depositAmount;
	private String depositDate;
	
	public Deposit() {}
	
	public Deposit(String did, double da, String dd) {
		
		this.depositId = did;
		this.depositAmount = da;
		this.depositDate = dd;
	}

	@XmlElement
	public String getDepositId() {
		return depositId;
	}

	public void setDepositId(String depositId) {
		this.depositId = depositId;
	}

	@XmlElement
	public double getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}

	@XmlElement
	public String getDepositDate() {
		return depositDate;
	}

	public void setDepositDate(String depositDate) {
		this.depositDate = depositDate;
	}
}
