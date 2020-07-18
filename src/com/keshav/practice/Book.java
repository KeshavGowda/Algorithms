package com.keshav.practice;

public class Book implements BookReadOnly {
	
	private int id;
	private String title;
	private String author;
	private Price price;
	
	public Book(int id, String title, String author, Double price) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = new Price(price);
	}

	/* (non-Javadoc)
	 * @see com.keshav.practice.BookReadOnly#getId()
	 */
	@Override
	public int getId() {
		return id;
	}
	
	/* (non-Javadoc)
	 * @see com.keshav.practice.BookReadOnly#getTitle()
	 */
	@Override
	public String getTitle() {
		return title;
	}
	
	/* (non-Javadoc)
	 * @see com.keshav.practice.BookReadOnly#getAuthor()
	 */
	@Override
	public String getAuthor() {
		return author;
	}
	
	//TODO: check if Price is immutable
	/* (non-Javadoc)
	 * @see com.keshav.practice.BookReadOnly#getPrice()
	 */
	@Override
	public Price getPrice() {
		return this.price;
	}	
	
	public void setPrice(Double price) {
		this.price = new Price(price);
	}
	
	/* (non-Javadoc)
	 * @see com.keshav.practice.BookReadOnly#toString()
	 */
	@Override
	public String toString() {
		return title + " by " + author;
	}

}
