package boseTest.seleniumTest;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import abstructcomponent.reuse;
import baseTest.Base;
import boseTest.seleniumTest.pageObject.LandingPage;
import boseTest.seleniumTest.pageObject.cartPage;
import boseTest.seleniumTest.pageObject.orderSubmitPage;
import boseTest.seleniumTest.pageObject.ordersPage;
import boseTest.seleniumTest.pageObject.productHomePage;
import boseTest.seleniumTest.pageObject.summaryPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class pomTest extends Base{
	
		@Test(dataProvider="getData")
		public void submitOrder(HashMap<Object,Object> input) throws InterruptedException, IOException {
		productHomePage home=lp.loginFuntion(input.get("email").toString(), input.get("password").toString());
		List<WebElement> cartItems=home.allProduct();
		home.addProdtoCart(input.get("product").toString());
		cartPage cp=home.goToCart();
		boolean match=cp.checkcart(input.get("product").toString());
		Assert.assertTrue(match);
		orderSubmitPage op=cp.ClickCheckout();
		op.selectCountry("india");
		summaryPage sp=op.submitOrder();
		Thread.sleep(2000);
		String msg=sp.msgtxt();
		Assert.assertTrue(msg.equals("THANKYOU FOR THE ORDER."));
		
		id=id+sp.getOrderId();
		System.out.println(sp.getOrderId());
	}
		
		
		
		
		@DataProvider
		public Object [][] getData() throws IOException{
			
			List<HashMap<Object, Object>> data=getJsonToHashMap(System.getProperty("user.dir")+"\\src\\test\\java\\boseTest\\data\\purchaseOrder.json");
			return new Object[][] {{data.get(0)},{data.get(1)}};
	
		}
		

}



//@Test(dependsOnMethods= {"submitOrder"})
//public void orderHistoryTest() {
//	productHomePage home=lp.loginFuntion("boserupjit13@gmail.com", "I234567a");
//	ordersPage op=home.goToOrders();
//	Assert.assertTrue(op.orderCheck(id));
//	
//	
//}

//HashMap<Object,Object> map=new HashMap<Object,Object>();
//map.put("email", "boserupjit13@gmail.com");
//map.put("password", "I234567a");
//map.put("product", "ZARA COAT 3");
//HashMap<Object,Object> map1=new HashMap<Object,Object>();
//map1.put("email", "boserupjit13@gmail.com");
//map1.put("password", "I234567a");
//map1.put("product", "ADIDAS ORIGINAL");
//return new Object[][] {{map},{map1}};
