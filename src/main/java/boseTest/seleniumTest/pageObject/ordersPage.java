package boseTest.seleniumTest.pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstructcomponent.reuse;

public class ordersPage extends reuse{

	WebDriver driver;
	public ordersPage(WebDriver driver) {
		super(driver);
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//tr[contains(@class,'ng-star-inserted')]/th")
	List<WebElement> orderIds;
	
	public boolean orderCheck(String ID) {
		boolean match = orderIds.stream().anyMatch(orderID-> orderID.getText().equalsIgnoreCase(ID));
		return match;
	}

}
