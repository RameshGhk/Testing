/*
 * TestClass for new user and login page validation with valid and invalid credentials.
 * Test cases are reading data from DataProviderClass and performing action.
 * please refer DataProviderClass for different sets of input data
 * Test cases will pass when valid credentials are provided
 * Test cases will fail when invalid credentials are given
 */

package testClassPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjectsPackage.LoginPage;
import pageObjectsPackage.NewUserRegistrationPage;
import java.util.concurrent.TimeUnit;


public class TestClass {
	public static WebElement element = null;
	String baseUrl;
	WebDriver driver;
	
	
	@BeforeMethod
	public void SetUp() {
		baseUrl = "http://thawing-shelf-73260.herokuapp.com/";
		System.setProperty("webdriver.gecko.driver", "/C:/Users/HP/Documents/workspace/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}

	
//*****************************************************************************************************	
	/*
	 * Test cases based on User story-007:- 
	 * As a user concerned about security and interested in personal finance, 
	 * user can registered in order to have access to the expense tracker functionalities.
	 */
	
	@Test(dataProvider="newUserData", dataProviderClass=DataProviderClass.class)
	public void testcase1_create_new_user(String username, String password, String confirmpassword) {
			NewUserRegistrationPage.newUserRegistration(driver, username, password, confirmpassword);		
	}
	
	
	
//*****************************************************************************************************	
	/*
	 * Test cases based on User story-006:- 
	 * As a user concerned about security, user can access to all functionalities 
	 * related to expense tracking if he/she is a registered user and logged in.
	 */
	
	@Test(dataProvider="loginData", dataProviderClass=DataProviderClass.class)
	public void testcase2_login_to_tracker(String username, String password) {
		LoginPage.loginToExpenseTracker(driver, username, password);
	}

//*****************************************************************************************************	

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

