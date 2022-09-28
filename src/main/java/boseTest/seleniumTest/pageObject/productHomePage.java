package boseTest.seleniumTest.pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import abstructcomponent.reuse;

public class productHomePage extends reuse{
	
	
	
	WebDriver driver;
	
	 public productHomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> cartItems;
	
	
	By element=By.cssSelector(".mb-3");
	
	public List<WebElement> allProduct(){
		waitForElementVisible(element);
		return cartItems;
	}
	
	public WebElement getProdByName(String prodName) {
		WebElement prod = allProduct().stream().filter(cartItem->
		cartItem.findElement(By.cssSelector("b")).getText().equals(prodName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProdtoCart(String prodName) {
		WebElement item=getProdByName(prodName);
		item.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		waitForElementInvisible(By.cssSelector(".ng-animating"));
		waitForElementVisible(By.xpath("//*[@id='products']/div[1]/div[2]/div//button[2]"));
	}
	//*[@id="products"]/div[1]/div[2]/div[1]/div/div/button[2] 
//	By.cssSelector(".card-body button:last-of-type")
//	By.xpath("//*[@id='products']/div[1]/div[2]/div//button[2]")
	
}
