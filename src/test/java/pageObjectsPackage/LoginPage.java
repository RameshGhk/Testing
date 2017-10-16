/*
 * This is the page class for login page.
 * All the methods defined here can be re-used to find the web element in login page and perform actions.
 */

package pageObjectsPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;



public class LoginPage {
	public static WebElement element = null;

	public static void fillUserName(WebDriver driver, String username) {
		element = driver.findElement(By.id("login"));
		element.sendKeys(username);
	}

	public static void fillPassword(WebDriver driver, String Password) {
		element = driver.findElement(By.id("password"));
		element.sendKeys(Password);
	}
	
	public static void clickLoginButton(WebDriver driver) {
		driver.findElement(By.id("submit")).click();
   }
	
//	Log out button is searched to verify whether the user login is success or not.
	public static void verifyLogin(WebDriver driver) {
		element = driver.findElement(By.id("logout"));
		Reporter.log("Login with valid credentials is successful", true);
	}
	
	
	/*
	 This is the method that can be re-used to login to expense tracker with valid
	 credentials and verify.
	 */
	public static void loginToExpenseTracker(WebDriver driver, String username, String password) {
		fillUserName(driver, username);
		fillPassword(driver, password);
		clickLoginButton(driver);
		verifyLogin(driver);
   }
}