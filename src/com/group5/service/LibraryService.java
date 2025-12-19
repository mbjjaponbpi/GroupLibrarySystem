package com.group5.service;

import com.group5.model.*;


public interface LibraryService {
	
	public Book[] initializeBooks();
	
	public Loan[] initializeLoans();
	
	public void displayAllBooks (Library library);
	
	public int displayAvailableBooks(Library library);
	
	public int displayAllBorrowedBooks(Library library);
	
	public int displayAllLoans(Library library);
	
	public Library borrowBook(Library library, Loan loan, User user, int bookId);
	
	public Library returnBook(Library library, int loanChoice);
	
	public boolean findBook(Library library, Integer bookId);

	public int findBookElement(Library library, Integer bookId);

	public boolean findLoan(Library library, Integer loanId);

		
}
