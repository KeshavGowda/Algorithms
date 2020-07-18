package com.keshav.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Practice {
	
	public static void main2(String[] args) throws IOException {
		String name1 = "johnsmith";
		String name2 = "smithjohn";
		boolean isAnagram = false;
		char[] name_1 = name1.toCharArray();
		char[] name_2 = name2.toCharArray();
		Arrays.sort(name_1);
		Arrays.sort(name_2);
		if(Arrays.equals(name_1, name_2)) isAnagram = true;
		System.out.println(isAnagram);
	}
	
	public static void main(String[] args) {
		CustomerRecords rec = new CustomerRecords();
		rec.addCustomer(new Customer("barry"));
		rec.addCustomer(new Customer("john"));
		//rec.getCustomers().clear();
		for(Customer c : rec.getCustomers().values()) {
			System.out.println(c.getName());
		}
		
		Customer customer = rec.getCustomerByName("barry");
		customer.setName("kallu");
		
		for(Customer c : rec.getCustomers().values()) {
			System.out.println(c.getName());
		}
		stringTest();
	}
	
	public static void stringTest() {
		String one = "hello";
		String two = "hello";
		if(one == two)
			System.out.println("same");
		else
			System.out.println("different");
		String three = new Integer(75).toString();
		String four = "75";
		if(three == four)
			System.out.println("same");
		else
			System.out.println("different");
	}
}
