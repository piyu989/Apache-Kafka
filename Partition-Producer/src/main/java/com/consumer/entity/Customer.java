package com.consumer.entity;

public class Customer {
	private String name;
	private int id;
	private String email;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String name, int id, String email) {
		super();
		this.name = name;
		this.id = id;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", id=" + id + ", email=" + email + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
