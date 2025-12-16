package com.group5.model;

public class Book {
	
	// adding this "id" to give you an idea on what options you can do
	private Integer id;
	private String title;
	private String author;
	private boolean isBorrowed;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public boolean isBorrowed() {
		return isBorrowed;
	}
	public void setIsBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}
	

// feel free to add fields that may help
	
	
}
