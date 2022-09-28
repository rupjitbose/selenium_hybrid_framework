package boseTest.seleniumTest.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstructcomponent.reuse;

public class orderSubmitPage extends reuse{

	WebDriver driver;
	public orderSubmitPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement ddown;
	@FindBy(xpath="//button[contains(@class,'list-group-item')][2]")
	WebElement select;
	@FindBy(xpath="//a[text()='Place Order ']")
	WebElement btn;
	
	public void selectCountry(String con) {
		Actions a=new Actions(driver);
		System.out.println("check6");
		a.sendKeys(ddown,con).build().perform();
		waitForElementVisible(By.xpath("//section[contains(@class,'list-group ng-star')]"));
		select.click();
		
	}
	public summaryPage submitOrder() {
		btn.click();
		System.out.println("check7");
		summaryPage sp=new summaryPage(driver);
		return sp;
	}

}
