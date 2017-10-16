/*
 * TestClass1 : To add/edit/delete Expenses, add/edit/delete category and user credentials update validation.
 * Test cases are reading data from DataProviderClass and performing action.
 * Please refer DataProviderClass for different sets of input data.
 */

package testClassPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageObjectsPackage.AddExpensesPage;
import pageObjectsPackage.ListCategoryPage;
import pageObjectsPackage.ListExpensesPage;
import pageObjectsPackage.LoginPage;
import pageObjectsPackage.EditUserAccount;
import java.util.concurrent.TimeUnit;


public class TestClass1 {
	public static WebElement element = null;
	String baseUrl;
	WebDriver driver;
	
	@BeforeClass
	public void SetUp() {
		baseUrl = "http://thawing-shelf-73260.herokuapp.com/";
		System.setProperty("webdriver.gecko.driver", "/C:/Users/HP/Documents/workspace/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);
		LoginPage.loginToExpenseTracker(driver, "Ramesh", "pass1");
	}

//*********************************************************************************************************	
		/*
		 * Test cases based on User story-004: 
		 * As a personal finance lover, user can manage the categories I can use to classify my expenses.
		 */
		
		@Test(enabled=true, dataProvider="categories", dataProviderClass=DataProviderClass.class)
		public void testcase1_create_category(String category) {
			ListCategoryPage.listCategories(driver, category);
		}
		
		@Test(enabled=true)
		public void testcase2_edit_category() {
			ListCategoryPage.editCategories(driver, "Chicken");
		}
		
		@Test(enabled=true)
		public void testcase3_delete_category() {
			ListCategoryPage.deleteCategories(driver);
		}
	
	
	
//***********************************************************************************************************	
	/*
	 * Test cases based on User story-002: 
	 * As a personal finance lover, user can track all his/her expenses in an easy way.
	 * Here test case is reading input data from DataProviderclass to create expenses
	 */
	
	@Test(enabled=true, dataProvider="getExpensesData", dataProviderClass=DataProviderClass.class)
	public void testcase4_add_expenses(String day, String month, String year, 
			String category, String amount, String reason) {
		AddExpensesPage.addExpenses(driver, day, month, year, category, amount, reason);
	}


	
//***********************************************************************************************************	
	/*
	 * Test cases based on User story-003: 
	 * As a personal finance lover, User can manage the expenses that he/she has already registered.
	 */
	
	@Test(enabled=true)
	public void testcase5_edit_expenses() {
		AddExpensesPage.editExpenses(driver, "14", "10", "2018", "bmw", "5000", "edited_expense");		
	}
	
	@Test(enabled=true)
	public void testcase6_delete_expenses() {
		ListExpensesPage.deleteListedExpenses(driver);
	}
	
	
	
//***********************************************************************************************************	
	/*
	 * Test cases based on User story-001: 
	 * As a personal finance lover, user can see all his/her expenses in one single place.
	 * Here user expenses are listed to confirm that user can see all his finance details
	 * in one single page.
	 */
	
	@Test(enabled=true)
	public void testcase7_list_expenses() {
		ListExpensesPage.ListExpenses(driver);	
	}
	
	
	
//************************************************************************************************************		
	/*
	 * Test cases based on user story-008
	 * Here edit user account is validated with different set of inputs that are provided through DataProviderClass
	 * Please refer DataProviderClass for different set of inputs.
	 */
	
	@Test(enabled=true, dataProvider="editUserData", dataProviderClass=DataProviderClass.class)
	public void testcase8_edit_user_account(String Oldpassword, String newpassword, String Repeatpassword) {
		EditUserAccount.editUserAccount(driver, Oldpassword, newpassword, Repeatpassword );
	}
	
	@Test(enabled=true)
	public void testcase9_edit_user_name() {
		EditUserAccount.validateEditUserName(driver, "EditUserName");
	}
	
//************************************************************************************************************	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}

