package boseTest.seleniumTest.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstructcomponent.reuse;

public class summaryPage extends reuse{
	
	WebDriver driver;
	
	@FindBy(xpath="//label[@class='ng-star-inserted']")
	WebElement orderId;
	
	 public summaryPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public String msgtxt() {
		
		 return driver.findElement(By.cssSelector(".hero-primary")).getText();
	 }
	public String getOrderId() throws InterruptedException {
		
		Thread.sleep(1500);
		System.out.println("check1");
		System.out.println("check2");
		String finalStr=orderId.getText().split(" ")[1].trim();
		return finalStr;
	
}
	
	
}