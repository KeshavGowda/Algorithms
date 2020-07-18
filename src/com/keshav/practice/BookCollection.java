package com.keshav.practice;

import java.util.ArrayList;
import java.util.List;

public class BookCollection {
	
	private List<Book> books;
	
	public BookCollection() {
		books = new ArrayList<>();
		books.add(new Book(1, "Head first java", "Kathy sierra", 3.99));
	}
	
	//TODO: fix escaping reference 
	public BookReadOnly findBookByName(String title) {
		for (BookReadOnly book : books) {
			if (book.getTitle().equals(title)) {
				return book;
			}
		}
		return null;
	}
	
	public void printAllBooks() {
		for (BookReadOnly book : books) {
			System.out.println(book.getTitle() + ": " + book.getPrice());
		}
	}

}
