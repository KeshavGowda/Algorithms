package com.keshav.practice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CustomerRecords {
	
	private Map<String, Customer> records;
	
	public CustomerRecords() {
		records = new HashMap<>();
	}
	
	public void addCustomer(Customer c) {
		this.records.put(c.getName(), c);
	}

	public Map<String, Customer> getCustomers() {
		return Collections.unmodifiableMap(this.records);
	}
	
	public Customer getCustomerByName(String name) {
		return new Customer(this.records.get(name));
	}
	
}
