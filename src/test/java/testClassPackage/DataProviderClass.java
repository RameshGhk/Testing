/* 
 * DataProviderClass : This class is used to provide input data for TestClass and TestClass1
 * to execute the different test cases that are defined in TestClass, and TestClass1.
 * 
 * This class mainly contains below methods to provide input data to different test cases.
 * 1) getnewUserData() : To provide data for new user registration to the expense tracker.
 * 2) getLoginData() : To provide data to login to the expense tracker.
 * 3) getCategoryData() : To provide data to create new categories of expenses in the expense tracker.
 * 4) getExpensesData() : To provide data to create expenses in the expense tracker.
 * 5) getEditUserData() : To provide data to edit user account details.
 * 
 * Refer instructions provided above each method in this class to provide different 
 * set of data to validate the expense tracker.
 */

package testClassPackage;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
//*******************************************************************************************************	
	/*
	 * Provide data in the below given format for new user registration
	 * {"User Name", "Password", "Confirm Password"}
	 * 
	 * Here new user registration form is validated with three sets of data to show the following results.
	 * 1) To register to the expense tracker.
	 * 2) To show that two people cannot have same user name.
	 * 3) To show that new user registration with user name and mismatch in password 
	 *    and confirm password will fail to register
	 */
	
	@DataProvider(name = "newUserData")
	public static Object[][] getnewUserData() {
		return new Object[][] {
			{"Ramesh", "pass1", "pass1"},
			{"Ramesh", "1234", "1234"},
			{"Ramesh1", "1234", "abcd"}
			};
	}
	
	
//*******************************************************************************************************
	/*
	 * Provide data in the below given format to login to expense tracker.
	 * {"User Name", "Password"}
	 * 
	 * Here login form is validated with three sets of data to show the following results.
	 * 1) Login to the expense tracker is successful with valid credentials.
	 * 2) Login to expense tracker will fail with invalid user name.
	 * 3) Login to expense tracker will fail with invalid password.
	 */
	
	@DataProvider(name ="loginData")
	public static Object[][] getLoginData() {
		return new Object[][] { 
			{"Ramesh", "pass1"},
			{"wrongusername", "pass1"},
			{"Ramesh", "wrongpassword"}
			};
	}
	
//*******************************************************************************************************	

	
//*******************************************************************************************************
	
	/*
	 * Provide data in the below given format to add category of expenses.
	 * {"category of expenses"}
	 */
	@DataProvider(name ="categories")
	public static Object[][] getCategoryData() {
		return new Object[][] {
			{"bmw"},
			{"honda"},
			{"audi"},
			{"benz"},
			{"Home loan"},
			{"education loan"},
			{"school fee"},
			{"hostel fee"}
			};
	}
	
	
//*******************************************************************************************************
	/*
	 * Provide data in the below given format to add expenses to the tracker.
	 * {"day", "month", "year", "category", "amount", "reason"}
	 */
	
	@DataProvider(name ="getExpensesData")
	public static Object[][] getExpensesData() {
		return new Object[][] {
			{"13", "10", "2000", "honda", "200", "Purchaged"},
			{"13", "10", "2000", "bmw", "200", "Purchaged"},
			{"13", "10", "2000", "audi", "200", "Purchaged"},
			{"13", "11", "2010", "benz", "200", "Purchaged"},
			{"13", "11", "2010", "school fee", "200", "Barrowed"},
			{"13", "11", "2010", "education loan", "200", "Barrowed"},
			{"13", "12", "2011", "school fee", "200", "Paid"},
			{"13", "12", "2011", "hostel fee", "200", "Paid"},
			{"13", "10", "2012", "honda", "200", "Purchaged"},
			{"13", "10", "2012", "bmw", "200", "Purchaged"},
			{"13", "10", "2012", "audi", "200", "Purchaged"},
			{"13", "11", "2013", "benz", "200", "Purchaged"}
			};
	}
	

	
//*******************************************************************************************************	
	
	/*
	 * Provide data in the below given format to edit the user account details
	 * {"Old password", "New Password", "Repeat new Password"}
	 * 
	 * Here edit user account form is validated to show the following results.
	 * 1) To change password with all valid inputs.
	 * 2) To show that password change requires old password field to be filled
	 * 3) To show that password change requires new password field to be filled
	 * 4) To show that password change requires repeat new password field to be filled
	 * 5) To show that password change requires new password and  repeat new password should match
	 */
	
	@DataProvider(name = "editUserData")
	public static Object[][] getEditUserData() {
		return new Object[][] {
			{"pass1 ", " ", "pass2"}, 
			{"pass1", "pass2", " "}, 
			{" ", "pass2", "pass2"},
			{"pass1", "pass2", "pass3"},
			{"pass1", "pass2", "pass2"}
			};
	}
	
}


