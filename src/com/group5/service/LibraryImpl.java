package com.group5.service;

import com.group5.model.*;
import com.group5.constants.Constants;


public class LibraryImpl implements LibraryService {

	
	private static final int bookcnt = 5;
	private static final int loancnt = 5;
	
	private static Book[] bookArray;
	private static Loan[] loanArray;
	
	
	//book table
	private final static Integer maxLenBookId = 7;
	private final static Integer maxLenBookTitle = 30;
	private final static Integer maxLenBookAuthor = 30;
	
	private final static Integer maxLenUserName = 30;
	
	
	//loan table
	private final static Integer maxLenLoanId = 7;
	
	
	@Override
	public final Book[] initializeBooks() {
		bookArray = new Book[bookcnt];
		
		//book 1
		bookArray[0] = new Book();
		bookArray[0].setId(3);
		bookArray[0].setAuthor("Agatha Christie");
		bookArray[0].setTitle("And Then There Were None");
		
		//book 2
		bookArray[1] = new Book();
		bookArray[1].setId(4);
		bookArray[1].setAuthor("Raymond Chandler");
		bookArray[1].setTitle("The Big Sleep");
		
		//book 3
		bookArray[2] = new Book();
		bookArray[2].setId(5);
		bookArray[2].setAuthor("Arthur Conan Doyle");
		bookArray[2].setTitle("The Hound of the Baskervilles");
		
		//book 4
		bookArray[3] = new Book();
		bookArray[3].setId(6);
		bookArray[3].setAuthor("Dan Brown");
		bookArray[3].setTitle("The Da Vinci Code");
		
		//book 5
		bookArray[4] = new Book();
		bookArray[4].setId(7);
		bookArray[4].setAuthor("Stieg Larsson");
		bookArray[4].setTitle("The Girl with the Dragon Tattoo");
		
		//set isBorrowed to false
		for (int i = 0 ; i < bookcnt; i++) {
			bookArray[i].setIsBorrowed(false); 
		}
		
		return bookArray;
	}

	@Override
	public Loan[] initializeLoans() {
		loanArray = new Loan[loancnt];
		
		for (int i = 0 ; i < loancnt; i++) {
			loanArray[i] = new Loan();
			loanArray[i].setLoanId(0);
			loanArray[i].setUser(null);
			loanArray[i].setBook(null);
			
		}
		return loanArray;
	}
	
	
	@Override
	public void displayAllBooks (Library library) {
		// TODO Auto-generated method stub
    	System.out.println(Constants.strDISPLAY_ALL_BOOKS );

		//print table header
		displayTableHeader(1);

		//print book list
		displayTableDetails(library, 1);

		//print table footer
		displayTableLine(1);
		System.out.println();
		System.out.println();
	}
	
	
	@Override
	public void displayAvailableBooks(Library library) {
		// TODO Auto-generated method stub
    	System.out.println(Constants.strDISPLAY_AVAILABLE_BOOKS );

		//print table header
		displayTableHeader(2);
		
		//print book list
		displayTableDetails(library, 2);

		//print table footer
		displayTableLine(2);
		System.out.println();
		System.out.println();
	}


	@Override
	public void displayAllBorrowedBooks(Library library) {
		// TODO Auto-generated method stub
    	System.out.println(Constants.strDISPLAY_BORROWED_BOOKS );

		//print table header
		displayTableHeader(3);
		
		//print book list
		displayTableDetails(library, 3);

		//print table footer
		displayTableLine(3);
		System.out.println();
		System.out.println();
	}

	
	@Override
	public void displayAllLoans(Library library) {
		// TODO Auto-generated method stub
    	System.out.println(Constants.strDISPLAY_BORROWED_BOOKS );

		//print table header
		displayTableHeader(4);

		//print loan list
		displayTableDetails(library, 4);
		
		//print table footer
		displayTableLine(4);
		System.out.println();
		System.out.println();
		
	}
	

	@Override
	public Library borrowBook(Library library, Loan loan, User user, int bookIdChoice) {
		// TODO Auto-generated method stub
		System.out.println(Constants.strPROCESSLOADING);
		
		loanArray = library.getLoanArray();
		bookArray = library.getBookArray();
		
		int bookElement = findBookElement(library, bookIdChoice);
		
		if (bookElement >= 0) {
			if (!bookArray[bookElement].isBorrowed()) {
				//book is available, can be tagged as loaned
				//check where to store the loanId
				for (int i = 0 ; i < loancnt; i++) {

					if (loanArray[i].getLoanId() == 0) {
						//set the loan Id value
						loanArray[i].setBook(bookArray[bookElement]);
						loanArray[i].setLoanId(loan.getLoanId());
						loanArray[i].setUser(user);

						//flag the book as borrowed
						bookArray[bookElement].setIsBorrowed(true);
						System.out.println(" You have successfully loaned the book entitled " + bookArray[bookElement].getTitle());
						
						break;
					}
				}
			} else {
				//should not be encountered here
				System.out.println(Constants.strSELECTEDBOOKUNAVAILABLE );
			}
		} else {
			//should not be encountered here
			System.out.println(Constants.strSELECTEDBOOKUNAVAILABLE );
		}

		
		library.setBookArray(bookArray);
		library.setLoanArray(loanArray);
		
		return library;

	}

	@Override
	public int findBookElement(Library library, Integer input) {
		int bookElement = -1;
		
		bookArray = new Book[bookcnt];
		bookArray = library.getBookArray();

    	//check option
    	for (int i = 0; i < bookcnt ; i++) {
    		
    		if (input == bookArray[i].getId()) {
    			bookElement = i;
    			break;
    		}
    	}
		return bookElement;
	}
	
	
	
	@Override
	public boolean findBook(Library library, Integer input) {
		boolean isFound = false;
		
		bookArray = new Book[bookcnt];
		bookArray = library.getBookArray();

    	//check option
    	for (int i = 0; i < bookcnt ; i++) {
    		
    		if (input == bookArray[i].getId()) {
    			isFound = true;
    			break;
    		}
    	}
		return isFound;
	}
	
	@Override
	public boolean findLoan(Library library, Integer input) {
		boolean isFound = false;
		
		loanArray = new Loan[loancnt];
		loanArray = library.getLoanArray();

    	//check option
    	for (int i = 0; i < loancnt ; i++) {
    		if (input.toString().equalsIgnoreCase(loanArray[i].getLoanId().toString())) {
    			isFound = true;
    		}
    	}
		return isFound;
	}

	
	@Override
	public Library returnBook(Library library, int loanChoice) {
		// TODO Auto-generated method stub
		System.out.println(Constants.strPROCESSLOADING );
		
		loanArray = library.getLoanArray();
		bookArray = library.getBookArray();


		for (int i = 0 ; i < loancnt; i++) {
			if (loanArray[i].getLoanId() == loanChoice) {
				
				int bookIdReturned = loanArray[i].getBook().getId();
				int bookElement = findBookElement(library, bookIdReturned);

				if (bookElement >= 0) {
					//flag the book as available
					bookArray[bookElement].setIsBorrowed(false);
					
					//unset the loan Id value
					loanArray[i].setBook(null);
					loanArray[i].setLoanId(0);
					loanArray[i].setUser(null);

					
					System.out.println(" You have successfully returned the book entitled " + bookArray[bookElement].getTitle());
					break;
					
				}
			}
		}

		library.setBookArray(bookArray);
		library.setLoanArray(loanArray);
		
		return library;

	}
	
	
	
	
	
	
	/*
	 * parameter input 
	 * displayType:
	 * 1 - all books
	 * 2 - available books
	 * 3 - borrowed books
	 * 
	 */

	private static void displayTableHeader(int displayType) {
		//header
		
		displayTableLine(displayType);
		
		if (displayType == 1 || displayType == 2) {
			System.out.println("" + 
					" | " + padRight(Constants.strBOOK_COLUMN_ID,       maxLenBookId,     " ") + 
					" | " + padRight(Constants.strBOOK_COLUMN_TITLE,    maxLenBookTitle,  " ") + 
					" | " + padRight(Constants.strBOOK_COLUMN_AUTHOR,   maxLenBookAuthor, " ") +
					" |");
		
		} else if (displayType == 3) {
			System.out.println("" + 
					" | " + padRight(Constants.strBOOK_COLUMN_ID,        maxLenBookId,     " ") + 
					" | " + padRight(Constants.strBOOK_COLUMN_TITLE,     maxLenBookTitle,  " ") + 
					" | " + padRight(Constants.strBOOK_COLUMN_AUTHOR,    maxLenBookAuthor, " ") +
					" | " + padRight(Constants.strBOOK_COLUMN_BORROWER,  maxLenUserName,   " ") +
					" |");
			
		} else if (displayType == 4) {
			System.out.println("" + 
					" | " + padRight(Constants.strLOAN_COLUMN_ID,        maxLenBookId,     " ") + 
					" | " + padRight(Constants.strBOOK_COLUMN_TITLE,     maxLenBookTitle,  " ") + 
					" | " + padRight(Constants.strBOOK_COLUMN_BORROWER,  maxLenUserName,   " ") +
					" |");
			
		}
		displayTableLine(displayType);
		
	}
	
	
	/*
	 * parameter input 
	 * displayType:
	 * 1 - all books
	 * 2 - available books
	 * 3 - borrowed books
	 * 
	 */
	private static void displayTableDetails(Library library, int displayType) {
		String userBorrower = "";
		bookArray = new Book[bookcnt];
		bookArray = library.getBookArray();
		
		loanArray = new Loan[loancnt];
		loanArray = library.getLoanArray();

		
		if (displayType == 1 || displayType == 2 || displayType == 3) {
			
			for (int i = 0; i < bookcnt; i++ ) {
				if (displayType == 1) {  //all books
					System.out.println("" + 
							" | " + padRight(bookArray[i].getId().toString(), maxLenBookId, " ") + 
							" | " + padRight(bookArray[i].getTitle(), maxLenBookTitle, " ") + 
							" | " + padRight(bookArray[i].getAuthor(), maxLenBookAuthor, " ") +
							" |");
					
				} else if (displayType == 2) { //available books
					
					if (!bookArray[i].isBorrowed()) {
						System.out.println("" + 
										" | " + padRight(bookArray[i].getId().toString(), maxLenBookId, " ") + 
										" | " + padRight(bookArray[i].getTitle(), maxLenBookTitle, " ") + 
										" | " + padRight(bookArray[i].getAuthor(), maxLenBookAuthor, " ") +
										" |");
					}
				} else if (displayType == 3) {  //borrowed books
					if (bookArray[i].isBorrowed()) {
						for (int j = 0; j < loancnt; j++ ) { 
							if (loanArray[j].getLoanId() > 0) {
								if (loanArray[j].getBook().getId() == bookArray[i].getId()) {
									userBorrower = loanArray[j].getUser().getName();
									break;
								}
							}
							
						}
						System.out.println("" + 
										" | " + padRight(bookArray[i].getId().toString(), maxLenBookId, " ") + 
										" | " + padRight(bookArray[i].getTitle(), maxLenBookTitle, " ") + 
										" | " + padRight(bookArray[i].getAuthor(), maxLenBookAuthor, " ") +
										" | " + padRight(userBorrower, maxLenUserName, " ") +
										" |");
					}
				}
			}

		} else if (displayType == 4) { // all loan records
			
			for (int k = 0 ; k < loancnt; k++) {
				if (displayType == 4) {
					if (loanArray[k].getLoanId() != 0 ) {
						System.out.println("" + 
								" | " + padRight(loanArray[k].getLoanId().toString(), maxLenLoanId, " ") + 
								" | " + padRight(loanArray[k].getBook().getTitle(), maxLenBookTitle, " ") + 
								" | " + padRight(loanArray[k].getUser().getName(), maxLenUserName, " ") +
								" |");
					}
				}
			}
		}
	}
	

	private static void displayTableLine (int displayType) {
		//header
		
		if (displayType == 1 || displayType == 2) {
			System.out.println(" " + 
					padRight("", maxLenBookId + 3,  "=") + 
					padRight("", maxLenBookTitle + 3, "=") + 
					padRight("", maxLenBookAuthor + 4, "=") 
					);
			
		} else if (displayType == 3) {
			System.out.println(" " + 
					padRight("", maxLenBookId + 3,  "=") + 
					padRight("", maxLenBookTitle + 3, "=") + 
					padRight("", maxLenBookAuthor + 4, "=") +
					padRight("", maxLenUserName + 3, "=") 
					);
			
		} else if (displayType == 4) {
			System.out.println(" " + 
					padRight("", maxLenLoanId + 3,  "=") + 
					padRight("", maxLenBookTitle + 3, "=") + 
					padRight("", maxLenUserName + 4, "=") 
					);
			
		}
		
	}
	
	private static String padRight(String param, int length, String padValue) {
		String returnValue = "";
		String temp  = "";
		
		if (param.equals("")) {
			temp = param;
			
			for (int i = 0; i < length; i++) {
				temp = padValue + "" + temp;
			}
			returnValue = temp;
			
		}
		
		int difference = length - param.length();
		
		if (param.length() < length) {
			temp = param;
			for (int i = 0; i < difference; i++) {
				temp += padValue;
			}
			returnValue = temp;
			
		} else if (param.length() > length) {
			returnValue = param.substring(0, length);
			
		} else if (param.length() == length) {
			returnValue = param;
		}	
		
		return returnValue;
	}

	

}
