package com.group5.constants;

public abstract class Constants {

	//login/menu
	public static final String strPROMPT_USERNAME = "Enter username: ";
	
	public static final String strPROMPT_CHOICE = " Please enter your choice: ";
	
	public static final String strDISPLAY_SELECTED_OPTION1 = "\n You have selected Option 1 - Display All Books";

	public static final String strDISPLAY_SELECTED_OPTION2 = "\n You have selected Option 2 - Display Available Books";

	public static final String strDISPLAY_SELECTED_OPTION3 = "\n You have selected Option 3 - Display All Borrowed Books";

	public static final String strDISPLAY_SELECTED_OPTION4 = "\n You have selected Option 4 - Borrow Book";

	public static final String strDISPLAY_SELECTED_OPTION5 = "\n You have selected Option 5 - Return Book";
	
	public static final String strDISPLAY_SELECTED_OPTION6 = "\n Thank you for using the system!";
	
	public static final String strDISPLAY_MENU = 
							("\n " +
							"\n ****************************************** WELCOME TO GROUP 5 LIBRARY SYSTEM *****************************************" + 
							"\n *                                                                                                                    *" + 
							"\n *             [1] Display All Books                      [4] Borrow Book                                             *" + 
							"\n *             [2] Display Available Books                [5] Return Book                                             *" + 
							"\n *             [3] Display All Borrowed Books             [6] Exit                                                    *" + 
							//System.out.println(" | ");
							//System.out.println(" | ");
							//System.out.println(" | ");
							"\n *                                                                                                                    *" + 
							"\n **********************************************************************************************************************");

	
	public static final String strBOOK_COLUMN_ID       = "Book ID";
	public static final String strBOOK_COLUMN_TITLE    = "Book Title";
	public static final String strBOOK_COLUMN_AUTHOR   = "Author";
	public static final String strBOOK_COLUMN_BORROWER = "Borrower";
	
	public static final String strLOAN_COLUMN_ID       = "Loan ID";
	
	
	//option 1
	public static final String strDISPLAY_ALL_BOOKS       = " Displaying all the books... \n";
	
	//option 2
	public static final String strDISPLAY_AVAILABLE_BOOKS = " Displaying available books... \n";
	
	//option 3
	public static final String strDISPLAY_BORROWED_BOOKS  = " Displaying all borrowed books... \n";
	
	//option 4
	public static final String strPROMPT_ENTER_BOOKID_FOR_BORROWING = " Please enter the book ID to be borrowed (enter X to go back to main menu): ";
	public static final String strPROMPT_ENTER_LOANID      = " Please enter the loan ID (enter X to go back to main menu): ";
	
	//option 5
	public static final String strPROMPT_ENTER_LOANID_FOR_RETURN = " Please enter the loan ID to be returned (enter X to go back to main menu): ";

	
	
	//error prompts
	public static final String strINVALID_USERNAME      = " ERROR! Invalid user name.";
	
	public static final String strINVALID_MENU_CHOICE   = "\n Invalid choice. Please try again.";

	public static final String strERROR_BOOK_NOT_FOUND  = " Book not found. Please enter another one: ";
	
	public static final String strERROR_BOOK_OUT        = " Selected book is currently out. Please enter another one: ";
	
	public static final String strINVALID_LOAN_ID       = " Invalid loan ID. Please enter another one: ";

	public static final String strINVALID_LOAN_ID_FOUND = "\" Loan ID found. Please enter another one: \"";
	

}
