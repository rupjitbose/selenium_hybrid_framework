package boseTest.seleniumTest.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import abstructcomponent.reuse;

public class cartPage extends reuse{
	
	WebDriver driver;
	public cartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	@FindBy(css=".totalRow button")
	WebElement checkout;

	public boolean checkcart(String p1) {
		boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(p1));
		return match;
	}
	public orderSubmitPage ClickCheckout() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("window.scroll(0,1000)");
	    waitForElementVisible(By.cssSelector(".totalRow button"));
	    Thread.sleep(3000);
	    checkout.click();
	    orderSubmitPage op=new orderSubmitPage(driver);
	    return op;
	}
	
	
}
