package boseTest.seleniumTest;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import boseTest.seleniumTest.pageObject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class standAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String p1="ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		LandingPage lp=new LandingPage(driver);
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("boserupjit13@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("I234567a");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> cartItems=driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod=cartItems.stream().filter(cartItem->
		cartItem.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		prod.findElement(By.xpath("//div[@class='card-body']/button[2]")).click();
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='toast-container']")));
		
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		
		List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));

	    Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(p1));

	    Assert.assertTrue(match);
		
	    
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("window.scroll(0,1000)");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".totalRow button")));
	    Thread.sleep(3000);
	    driver.findElement(By.cssSelector(".totalRow button")).click();
		
		
		
		Actions a=new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")),"India").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[contains(@class,'list-group ng-star')]")));
		driver.findElement(By.xpath("//button[contains(@class,'list-group-item')][2]")).click();
		driver.findElement(By.xpath("//a[text()='Place Order ']")).click();
		String msg=driver.findElement(By.cssSelector(".hero-primary")).getText();
		
		Assert.assertTrue(msg.equals("THANKYOU FOR THE ORDER."));
		driver.close();
	
	}

}
