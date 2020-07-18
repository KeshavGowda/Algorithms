package com.keshav.practice;

import java.util.HashMap;
import java.util.Map;

public class Price {
	
	private Map<String, Double> rates;
	private Double value;
	
	public Price(Double value) {
		this.value = value;
		rates = new HashMap<>();
		rates.put("USD", 1d);
		rates.put("GBP", 0.6);
		rates.put("EUR", 0.8);
	}
	
	//TODO: this method seems to be mutating a value in get method
	public Double convert(String toCurrency) {
		if (toCurrency.equals("USD")) {
			return value;
		} else {
			Double conversion = rates.get("USD") / rates.get(toCurrency);
			return conversion * value;
		}
	}
	
	@Override
	public String toString() {
		return this.value.toString();
	}
	
	//TODO: escaping reference for rates
	public Double getRates(String currency) {
		return rates.get(currency);
	}

}
