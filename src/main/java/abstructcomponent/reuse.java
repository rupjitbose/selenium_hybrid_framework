package abstructcomponent;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import boseTest.seleniumTest.pageObject.cartPage;
import boseTest.seleniumTest.pageObject.ordersPage;

public class reuse {
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement gotocart;
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement gotoOders;
	
	
	WebDriver driver;
	public reuse(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitForElementVisible(By element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	
	}
	public void waitForWebElementVisible(WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
	
	}
	public void waitForElementInvisible(By element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(element)));
	
	}
	public cartPage goToCart() {
		gotocart.click();
		cartPage cp=new cartPage(driver);
		return cp;
	}
	public ordersPage goToOrders() {
		gotoOders.click();
		ordersPage op=new ordersPage(driver);
		return op;
	}
}
