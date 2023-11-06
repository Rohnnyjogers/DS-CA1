package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="customer")
@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int customerId;
	private String customerName;
	private String customerAddr;
	private int customerPhone;
	private double cusotmerSalary;
	
	public Customer() {}
	
	public Customer(int cid, String cn, String ca, int cp, double cs) {
		
		this.customerId = cid;
		this.customerName = cn;
		this.customerAddr = ca;
		this.customerPhone = cp;
		this.cusotmerSalary = cs;
	}
	
	@XmlElement
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	@XmlElement
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@XmlElement
	public String getCustomerAddr() {
		return customerAddr;
	}

	public void setCustomerAddr(String customerAddr) {
		this.customerAddr = customerAddr;
	}

	@XmlElement
	public int getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(int customerPhone) {
		this.customerPhone = customerPhone;
	}

	@XmlElement
	public double getCusotmerSalary() {
		return cusotmerSalary;
	}

	public void setCusotmerSalary(double cusotmerSalary) {
		this.cusotmerSalary = cusotmerSalary;
	}
}
