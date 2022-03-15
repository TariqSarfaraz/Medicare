package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "logins")
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq1")
	@SequenceGenerator(name = "id_seq1", sequenceName = "id_seq1", allocationSize = 1)
	@Column(name = "id")
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "password")
	private String password;

	@Column(name = "CONTACT")
	private long contact;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", name=" + name + ", password=" + password + ", contact=" + contact + "]";
	}

	public Login(int id, String name, String password, long contact) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;

		this.contact = contact;
	}

	public Login() {
		super();
	}

}
