package stepDefinition;

import java.io.IOException;

import org.testng.Assert;

import baseTest.Base;
import boseTest.seleniumTest.pageObject.LandingPage;
import boseTest.seleniumTest.pageObject.cartPage;
import boseTest.seleniumTest.pageObject.orderSubmitPage;
import boseTest.seleniumTest.pageObject.productHomePage;
import boseTest.seleniumTest.pageObject.summaryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImplementation extends Base{

	public LandingPage lp;
	public productHomePage home;
	public cartPage cp;
	public orderSubmitPage op;
	public summaryPage sp;
	
	@Given("I landed on the login page")
	public void I_landed_on_the_login_page() throws IOException {
		lp=launchApplication();
	}
	@Given("^I login with the username(.+) and password(.+)$")
	public void I_login_with_the_username_and_password(String uname,String pword) {
		 home=lp.loginFuntion(uname, decode(pword));
	}
	@When("^I add the product(.+) to the cart$")
	public void I_add_the_product_to_the_cart(String prod) {
		home.addProdtoCart(prod);
		cp=home.goToCart();
	}
	@And("^checkout (.+) and submit the order$")
	public void checkout_and_submit_the_order(String prod) throws InterruptedException {
		boolean match=cp.checkcart(prod);
		Assert.assertTrue(match);
		op=cp.ClickCheckout();
		op.selectCountry("india");
		sp=op.submitOrder();
		Thread.sleep(2000);
	}
	@Then("I verify {string} message is displayed on the page")
	public void I_verify_message_is_displayed_on_the_page(String msg) {
		String gotmsg=sp.msgtxt();
		Assert.assertTrue(gotmsg.equals(msg));
		driver.quit();
	}
	
	@Then("I verify {string} message is displayed")
	public void I_verify_message_is_displayed(String msg) {
		 Assert.assertEquals(msg, lp.getError());
		 driver.quit();
	}
	
}
