/*
 * This is the page class for add expenses page.
 * All the methods defined here can be re-used to find the web element and perform actions.
 */

package pageObjectsPackage;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;


public class AddExpensesPage {
	public static WebElement element = null;

	public static void goToAddExpensePage(WebDriver driver) {
		driver.findElement(By.id("go_add_expense")).click();
	}
	
	public static void fillDay(WebDriver driver, String str1) {
		element = driver.findElement(By.id("day"));
		element.clear();
		element.sendKeys(str1);
	}
	
	public static void fillMonth(WebDriver driver, String str1) {
		element = driver.findElement(By.id("month"));
		element.clear();
		element.sendKeys(str1);
	}
	
	public static void fillYear(WebDriver driver, String str1) {
		element = driver.findElement(By.id("year"));
		element.clear();
		element.sendKeys(str1);
	}
	
	public static void selectCategory(WebDriver driver, String str1) {
		element = driver.findElement(By.id("category"));
		Select sel = new Select(element);
		sel.selectByVisibleText(str1);
	}
	
	public static void fillAmount(WebDriver driver, String str1) {
		element = driver.findElement(By.id("amount"));
		element.clear();
		element.sendKeys(str1);
	}

	public static void fillReason(WebDriver driver, String str1) {
		element = driver.findElement(By.id("reason"));
		element.clear();
		element.sendKeys(str1);
	}
	
	public static void clickCreateExpense(WebDriver driver) {
		driver.findElement(By.id("submit")).click();
	}
	
	public static void editListedExpenses(WebDriver driver) {
		try{
			List<WebElement> listedExpense = driver.findElements(
					By.xpath("//*[@title='edit expense']"));
			int size = listedExpense.size();
			Reporter.log("Size of the list: " + size, true);
			for (int i=0; i<size;) {
				listedExpense.get(i).click();
				Reporter.log("clicked to edit the listed expenses");
			}
		}
		catch (Exception e) {
			}	
		}

	
//	Method to add expenses
	public static void addExpenses(WebDriver driver, String day, String month, 
			String year, String category, String amount, String reason ) {
		goToAddExpensePage(driver);
		fillDay(driver, day);
		fillMonth(driver, month);
		fillYear(driver, year);
		selectCategory(driver, category);
		fillAmount(driver, amount);
		fillReason(driver, reason);
		clickCreateExpense(driver);
	}

	
//	Method to edit the expenses
	public static void editExpenses(WebDriver driver, String day, String month, 
			String year, String category, String amount, String reason) {
		editListedExpenses(driver);
		fillDay(driver, day);
		fillMonth(driver, month);
		fillYear(driver, year);
		selectCategory(driver, category);
		fillAmount(driver, amount);
		fillReason(driver, reason);
		clickCreateExpense(driver);
		Reporter.log("Expense modification is successful", true);
	}
	
}






