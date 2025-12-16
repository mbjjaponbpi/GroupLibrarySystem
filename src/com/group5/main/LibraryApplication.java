/*
 * 1. Upon application start, ask user to create one User
 * 2. Create one Library object
 * 3. Initialize 5 Book objects and add it to all Library slots
 * 4. Display options:
 * 
 * - [1] Display All Books
 * - [2] Display Available Books
 * - [3] Display All Borrowed Books
 * - [4] Borrow Book
 * - [5] Return Book
 * - [6] Exit
 * 
 * - user selects the number of the option
 * ===============================================
 * 
 *	 [1] Display All Books
 * - Display all Books (ID, Title and Author) regardless if there is a Loan existing for that Book.
 *   
 *   [2] Display Available Books
 * - Display Books that do not have a Loan slot
 * 
 *   [3] Display All Borrowed Books 
 * - Display Books that have a Loan equivalent.
 * - Display the Book title and the User name of borrower
 *   
 *	 [4] Borrow Book
 * - Displays all available books and User selects what book to borrow
 * - Create a Loan object, set Loan id set Book and set User to current user
 * 
 * 	 [5] Return Book
 * - Display all Loans, user selects the Loan and removes that from the slot
 * 
 *   [6] Exit
 * - Stops the program  
 * */

package com.group5.main;

import java.util.Scanner;

import com.group5.model.*;
import com.group5.service.LibraryImpl;
import com.group5.constants.Constants;


public class LibraryApplication {
	
	private User user;
	private Loan loan;
	
	private Library library;
	private LibraryImpl libraryImpl;
	
	public LibraryApplication () {
		// initial user creation
		this.user = new User();
		this.loan = new Loan();

		// initial library creation
		this.library = new Library();
		this.libraryImpl = new LibraryImpl ();
		this.library.setBookArray(libraryImpl.initializeBooks());
		this.library.setLoanArray(libraryImpl.initializeLoans());

	}
	
	
	
	// Main Application Logic, call this in your Main.java
	public void start() {
		
		// add code here
		
        Scanner input = new Scanner(System.in);
    	String tempInput;
    	

    	boolean isUserValid = true;
    	do {
            if (!inputUserName(input)) {
            	//user input is invalid
            	System.out.println(Constants.strINVALID_USERNAME);
            	isUserValid = false;
            } else {
            	//user input is valid
            	isUserValid = true;
            }
    	} while (!isUserValid);
    	
    	
    	
    	//initially display the menu
    	displayLibraryMenu();
    	welcomeMenuChoice();

    	char option;
        do {
        	
        	tempInput = input.nextLine().trim();
        	
        	
        	//check the encoded option
        	if ((tempInput == null) || (tempInput.length() != 1) ) {
        		//set to 0 to make it an invalid choice
        		option = "0".charAt(0);
        	} else {
        		option = tempInput.charAt(0);
        	} 
        	
        	System.out.println();
        	//check option
            switch (option) {
	            case '1':
	            	//[1] Display All Books
	            	displayLibraryMenu();
	            	System.out.println(Constants.strDISPLAY_SELECTED_OPTION1);
	            	libraryImpl.displayAllBooks(this.library);
	            	askMenuChoice();
	                break;
	
	            case '2':
	            	//[2] Display Available Books
	            	displayLibraryMenu();
	            	System.out.println(Constants.strDISPLAY_SELECTED_OPTION2);
	            	libraryImpl.displayAvailableBooks(this.library);
	            	askMenuChoice();
	                break;
	
	            case '3':
	            	//[3] Display All Borrowed Books 
	            	displayLibraryMenu();
	            	System.out.println(Constants.strDISPLAY_SELECTED_OPTION3);
	            	libraryImpl.displayAllBorrowedBooks(this.library);
	            	askMenuChoice();
	                break;
	
	            case '4':
	            	//[4] Borrow Book
	            	displayLibraryMenu();
	            	System.out.println(Constants.strDISPLAY_SELECTED_OPTION4);
	            	
	            	//libraryImpl.displayAllBooks(this.library);
	            	libraryImpl.displayAvailableBooks(this.library);
	            	
	            	int bookChoice = askBookChoice(input);
	            	//System.out.println("debug -- book choice:" + retBook);
	            	
	            	if (bookChoice != 0) {
	            		
	            		//book found, ask user to input loan ID
	            		int retLoanId = askLoanId(input);
	            		
	            		if (retLoanId != 0) {
		            		this.loan.setLoanId(retLoanId);
		            		bookChoice -= 1;
			            	this.library = this.libraryImpl.borrowBook(this.library, this.loan, this.user, bookChoice);
			            	//System.out.println("after borrow book, check if tagged as borrowed :" +  this.library.getBookArray()[retBook-1].isBorrowed());
	            		}
	            		displayLibraryMenu();
		            	
	            	} else {
	            		//exit to menu
		            	displayLibraryMenu();
	            	}
	            	askMenuChoice();

	                break;
	
	            case '5':
	            	//[5] Return Book
	            	displayLibraryMenu();
	            	System.out.println(Constants.strDISPLAY_SELECTED_OPTION5);
	            	
	            	libraryImpl.displayAllLoans(this.library);
	            	
	            	int loanChoice = askLoanIdForReturn(input);
	            	
	            	if (loanChoice != 0) {
	            		
	            		//loan found, ask user to input loan ID
		            	this.library = this.libraryImpl.returnBook(this.library, loanChoice);
	            		displayLibraryMenu();
		            	
	            	} else {
	            		//exit to menu
		            	displayLibraryMenu();
	            	}
	            	askMenuChoice();

	                break;
	            	
	            case '6':
	            	//[6] Exit
	                System.out.println(Constants.strDISPLAY_SELECTED_OPTION6);
	                break;

	            default:
	            	displayLibraryMenu();
	                System.out.println(Constants.strINVALID_MENU_CHOICE);
	            	askMenuChoice();
	                
            } // end of switch statement

        } while (option != '6');
        

        //close the Scanner
        input.close();
		
	}
	
	
	private void displayLibraryMenu() {
		System.out.println(Constants.strDISPLAY_MENU);
	}
	
	
	private void welcomeMenuChoice() {
    	System.out.print  (" Hello, " + user.getName() + "! " + Constants.strPROMPT_CHOICE);
	}
	
	private void askMenuChoice() {
//    	System.out.print  (" Please enter your choice: ");
    	System.out.print(Constants.strPROMPT_CHOICE);
	}

	private int askBookChoice(Scanner input) {
		int ret = 0;
		String tempInput;
    	System.out.print  (Constants.strPROMPT_ENTER_BOOKID_FOR_BORROWING);
    	//user input (Book id to be borrowed)
    	boolean bookFound = false;
    	
    	char option;
        do {
            tempInput = input.nextLine();
            
        	//check the encoded option
        	if ((tempInput == null) || (tempInput.length() != 1) ) {
        		//set to 0 to make it an invalid choice
        		option = "0".charAt(0);
        	} else {
        		option = tempInput.charAt(0);
        	}
        	
        	
        	//System.out.println(String.valueOf(option));
        	if (String.valueOf(option).equalsIgnoreCase("X")) {
        		//System.out.println("Exited");
        		bookFound = true;
        		break;
        	} else if (!isNumeric(String.valueOf(option))) {
        		System.out.print (Constants.strERROR_BOOK_NOT_FOUND);
        	
        	} else {
            	bookFound = libraryImpl.findBook(this.library, Integer.parseInt(String.valueOf(option)));
        		
        		if (bookFound) {
        			//check if currently loaned
        			if (this.library.getBookArray()[(Integer.parseInt(String.valueOf(option)))-1].isBorrowed()) {
        				//currently borrowed
        				System.out.print (Constants.strERROR_BOOK_OUT);
        				bookFound = false;
        				
        			} else {
		        		ret = Integer.parseInt(String.valueOf(option));
		        		bookFound = true;
		        		break;
        			}
        		} else {
        			System.out.print (Constants.strERROR_BOOK_NOT_FOUND);
        		}
        	}

        } while (!bookFound);

    	return ret;
	}
	
	
	private int askLoanIdForReturn(Scanner input) {
		int ret = 0;
		String tempInput;
    	System.out.print  (Constants.strPROMPT_ENTER_LOANID_FOR_RETURN );
    	//user input (loan id for borrowing)
    	boolean loanSearch = false;
    	
    	char option;
        do {
            tempInput = input.nextLine();
            
        	//check the encoded option
        	if ((tempInput == null) || (tempInput.length() != 1) ) {
        		//set to space to make it an invalid choice
        		option = " ".charAt(0);
        	} else {
        		option = tempInput.charAt(0);
        	}
        	
        	
        	//System.out.println(String.valueOf("loanid input " + option));
        	if (String.valueOf(option).equalsIgnoreCase("X")) {
        		//System.out.println("Exited");
        		loanSearch = true;
        		break;
        	} else if (!isNumeric(String.valueOf(option))) {
        		System.out.print (Constants.strINVALID_LOAN_ID);
        	
        	} else if (String.valueOf(option).equalsIgnoreCase("0")) {
        		System.out.print (Constants.strINVALID_LOAN_ID);
        		
        	} else {
        		loanSearch = libraryImpl.findLoan(this.library, Integer.parseInt(String.valueOf(option)));
        		
        		if (!loanSearch) {
        			System.out.print (Constants.strINVALID_LOAN_ID);

        		} else {
        			//valid loan ID
        			ret = Integer.parseInt(String.valueOf(option));
	        		loanSearch = true;
	        		break;
        			
        		}
        		
        	}

        } while (!loanSearch);

    	return ret;

	}
	
	
	private int askLoanId(Scanner input) {
		int ret = 0;
		String tempInput;
    	System.out.print  (Constants.strPROMPT_ENTER_LOANID );
    	//user input (loan id for borrowing)
    	boolean loanSearch = false;
    	
    	char option;
        do {
            tempInput = input.nextLine();
            
        	//check the encoded option
        	if ((tempInput == null) || (tempInput.length() != 1) ) {
        		//set to space to make it an invalid choice
        		option = " ".charAt(0);
        	} else {
        		option = tempInput.charAt(0);
        	}
        	
        	
        	//System.out.println(String.valueOf("loanid input " + option));
        	if (String.valueOf(option).equalsIgnoreCase("X")) {
        		//System.out.println("Exited");
        		loanSearch = true;
        		break;
        	} else if (!isNumeric(String.valueOf(option))) {
        		System.out.print (Constants.strINVALID_LOAN_ID);
        	
        	} else if (String.valueOf(option).equalsIgnoreCase("0")) {
        		System.out.print (Constants.strINVALID_LOAN_ID);
        		
        	} else {
        		loanSearch = libraryImpl.findLoan(this.library, Integer.parseInt(String.valueOf(option)));
        		
        		if (loanSearch) {
        			System.out.print (Constants.strINVALID_LOAN_ID_FOUND);
        			loanSearch = false;
        		} else {
        			//valid loan ID
        			ret = Integer.parseInt(String.valueOf(option));
	        		loanSearch = true;
	        		break;
        			
        		}
        		
        	}

        } while (!loanSearch);

    	return ret;

	}

	
	private boolean inputUserName (Scanner input)  {
		boolean isValid = false;
		System.out.print(Constants.strPROMPT_USERNAME );
    	String tempInput = input.nextLine().trim();
    	
    	//check the username input
    	if (tempInput == null || tempInput == "") {
    		isValid = false;
    	} else {
    		isValid = true;
    		user.setName(tempInput);
    	}
		
		return isValid;
	}

    private final static boolean isNumeric(String string){
    	final String acceptedChars = "0123456789";
		boolean result = true;

		char[] chars = string.toCharArray();
    	for (int i = 0; i < chars.length; i++){
    		char c = chars[i];
        	if(acceptedChars.indexOf((c+"").toUpperCase()) < 0){
        		result = false;
        	}
    		if(!result){
    			return false;
    		}
    	}
    	return true;
    }

    
	// add code here
	
}
