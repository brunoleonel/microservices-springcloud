package com.example.demo.models;

import java.util.List;

public class Transaction {

	private String id;
	private String currency;
	private Object user;
	private List<Item> items;
	private float taxUSD;
	private float taxBRL;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Object getUser() {
		return user;
	}
	public void setUser(Object user) {
		this.user = user;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public float getTaxUSD() {
		return taxUSD;
	}
	public void setTaxUSD(float taxUSD) {
		this.taxUSD = taxUSD;
	}
	public float getTaxBRL() {
		return taxBRL;
	}
	public void setTaxBRL(float taxBRL) {
		this.taxBRL = taxBRL;
	}
}
