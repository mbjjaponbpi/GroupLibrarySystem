package com.group5.service;

import com.group5.model.*;


public interface LibraryService {
	
	public Book[] initializeBooks();
	
	public Loan[] initializeLoans();
	
	public void displayAllBooks (Library library);
	
	public void displayAvailableBooks(Library library);
	
	public void displayAllBorrowedBooks(Library library);
	
	public void displayAllLoans(Library library);
	
	public Library borrowBook(Library library, Loan loan, User user, int bookId);
	
	public Library returnBook(Library library, int loanChoice);
	
}
