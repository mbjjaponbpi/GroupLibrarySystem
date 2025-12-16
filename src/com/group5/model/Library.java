package com.group5.model;

public class Library {
    // can contain up to 5 books	

	private Book[] bookArray;
	private Loan[] loanArray;
	

	public Book[] getBookArray() {
		return bookArray;
	}

	public void setBookArray(Book[] bookArray) {
		this.bookArray = bookArray;
	}

	public Loan[] getLoanArray() {
		return loanArray;
	}

	public void setLoanArray(Loan[] loanArray) {
		this.loanArray = loanArray;
	}

	
}
