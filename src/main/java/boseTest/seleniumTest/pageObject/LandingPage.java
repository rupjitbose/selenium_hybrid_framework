package boseTest.seleniumTest.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstructcomponent.reuse;

public class LandingPage extends reuse{
	
	WebDriver driver;
	
	 public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement email;
	@FindBy(id="userPassword")
	WebElement password;
	@FindBy(id="login")
	WebElement loginBtn;
	@FindBy(css="[class*='toast-message']")
	WebElement errorMsg;
	//ng-tns-c4-14 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr toast-error
	
	
	
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	public productHomePage loginFuntion(String uemail,String pass) {
		email.sendKeys(uemail);
		password.sendKeys(pass);
		loginBtn.click();
		System.out.println("check4");
		productHomePage home=new productHomePage(driver);
		return home;
	}
	public String getError() {
		waitForWebElementVisible(errorMsg);
		return errorMsg.getText();
		 
	}
	
}
