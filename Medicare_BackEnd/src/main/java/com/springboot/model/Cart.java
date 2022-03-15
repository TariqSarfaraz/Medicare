package com.springboot.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_seq")
	@SequenceGenerator(name = "card_seq", sequenceName = "card_seq", allocationSize = 1)
	@Column(name = "ID")
	private int id;

	@Column(name = "LOGINS_ID", nullable = true)
	private int lid;

	@Column(name = "PRODUCTS_ID")
	private int pid;

	@Column(name = "BOOKED")
	private String booked;

	@Column(name = "PRINT")
	private String print;

	@Column(name = "PNAME")
	private String pname;

	@Column(name = "PRICE")
	private int price;

	@Column(name = "PTYPE")
	private String ptype;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getBooked() {
		return booked;
	}

	public void setBooked(String booked) {
		this.booked = booked;
	}

	public String getPrint() {
		return print;
	}

	public void setPrint(String print) {
		this.print = print;
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

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public Cart(int id, int lid, int pid, String booked, String print, String pname, int price, String ptype) {
		super();
		this.id = id;
		this.lid = lid;
		this.pid = pid;
		this.booked = booked;
		this.print = print;
		this.pname = pname;
		this.price = price;
		this.ptype = ptype;
	}

	public Cart() {
		super();
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", lid=" + lid + ", pid=" + pid + ", booked=" + booked + ", print=" + print
				+ ", pname=" + pname + ", price=" + price + ", ptype=" + ptype + "]";
	}

//	
//	@OneToMany(mappedBy = "Cart")
//	List<Product> product;

//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "PRODUCTS_ID",insertable=false, updatable=false)
//	private Product prodcut;

}
