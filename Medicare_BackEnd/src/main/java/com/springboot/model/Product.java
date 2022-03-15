package com.springboot.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "medical_products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "p_seq")
	@SequenceGenerator(name = "p_seq", sequenceName = "p_seq", allocationSize = 1)
	@Column(name = "pid")
	private int pid;

	@Column(name = "pname")
	private String pname;

	@Column(name = "price")
	private int price;

	@Column(name = "pqty")
	private int pqty;

	@Column(name = "ptype")
	private String ptype;

	@Column(name = "status")
	private String status;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPqty() {
		return pqty;
	}

	public void setPqty(int pqty) {
		this.pqty = pqty;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", pqty=" + pqty + ", ptype=" + ptype
				+ ", status=" + status + "]";
	}

	public Product(int pid, String pname, int price, int pqty, String ptype, String status) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.pqty = pqty;
		this.ptype = ptype;
		this.status = status;
	}

	public Product() {
		super();
	}

}
