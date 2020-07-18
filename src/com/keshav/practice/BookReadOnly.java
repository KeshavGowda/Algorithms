package com.keshav.practice;

public interface BookReadOnly {

	int getId();

	String getTitle();

	String getAuthor();

	//TODO: check if Price is immutable
	Price getPrice();

	String toString();

}