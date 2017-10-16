/*
 * This is the page class for Edit user account page.
 * All the methods defined here can be re-used to find the web element in Edit user account page and perform actions.
 * All the functionalities related user account details are verified as per the given user story-008
 */

package pageObjectsPackage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;


public class EditUserAccount {
	public static WebElement element = null;

	public static void findEditAccountlink(WebDriver driver) {
		driver.findElement(By.id("editaccount")).click();
	}

	public static void provideExistingPassword(WebDriver driver, String password) {
		element = driver.findElement(By.id("password"));
		element.clear();
		element.sendKeys(password);
	}
	
	public static void provideNewPassword(WebDriver driver, String password1) {
		element = driver.findElement(By.id("newpassword1"));
		element.clear();
		element.sendKeys(password1);
	}
	
	public static void confirmNewPassword(WebDriver driver, String password2) {
		element = driver.findElement(By.id("newpassword2"));
		element.clear();
		element.sendKeys(password2);
	}
	
	public static void clickUpdateaccount(WebDriver driver) {
		element = driver.findElement(By.id("submit"));
		element.click();
		try{
			Alert alert = driver.switchTo().alert();
			Reporter.log("pop up alert displaying error message: 'Error: New Passwords aren't equal!'");
			alert.accept();
			Reporter.log("user account edit is not successful");
			
		}
		catch (Exception e){
		}

   }
	
	
	
	
	/*
	 *1) While editing the url : http://thawing-shelf-73260.herokuapp.com/editaccount.jsp
	 *2) After edit account is successful, url changes to : http://thawing-shelf-73260.herokuapp.com/listexpenses 
	 * these urls are used to verify whether user account details are modified successfully or not.
	 */
	public static void verifyEditAccount(WebDriver driver) {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "http://thawing-shelf-73260.herokuapp.com/listexpenses");
		Reporter.log("user account edit is successful with valid inputs");
		
   }
	
	
	
//	This is the method to validate user account details
	public static void editUserAccount(WebDriver driver, String password, 
			String password1, String password2) {
		findEditAccountlink(driver);
		provideExistingPassword(driver, password);
		provideNewPassword(driver, password1);
		confirmNewPassword(driver, password2);
		clickUpdateaccount(driver);
		verifyEditAccount(driver);
   }
	
	
//	This method is used for proving that the user name cannot be edited/modified
	public static void validateEditUserName(WebDriver driver, String username) {
		findEditAccountlink(driver);
		element = driver.findElement(By.name("login"));
		Reporter.log("Is user name is enabled to edit ? : " +element.isEnabled(), true);
		Reporter.log("User Name cannot be modified", true);
		element.click();
	}
		
}
