package boseTest.seleniumTest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import baseTest.Base;
import boseTest.seleniumTest.pageObject.cartPage;
import boseTest.seleniumTest.pageObject.productHomePage;
import globalData.retry;

public class errorValidation extends Base{
	@Test(groups={"errorHandling"},retryAnalyzer=retry.class)
	public void loginError() throws InterruptedException, IOException {
	lp.loginFuntion("boserut13@gmail.com", "I234567a");
	 Assert.assertEquals(lp.getError(),"Incorrect email  password.");
	  
	}
	
	@Test
	public void cartError() throws InterruptedException, IOException {
	// TODO Auto-generated method stub
	String p1="ZARA COAT 3";
	productHomePage home=lp.loginFuntion("boserupjit13@gmail.com", "I234567a");
	List<WebElement> cartItems=home.allProduct();
	home.addProdtoCart(p1);
	cartPage cp=home.goToCart();
	boolean match=cp.checkcart(p1);
	Assert.assertTrue(match);
	}

}
