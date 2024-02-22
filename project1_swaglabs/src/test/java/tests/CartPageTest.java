package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.Cartpage;
import pages.LoginPage;

public class CartPageTest extends BaseClass {
	
	LoginPage obj;
	Cartpage cp;
	
	@BeforeTest
	public void setup() throws InterruptedException
	{
		cp= new Cartpage(driver);
		obj= new LoginPage(driver);
		obj.validCredentials();
	}
	
	@Test(priority=1)
	public void verifyProductURL() throws InterruptedException
	{
		boolean actstatuso=cp.checkoutButton();
		boolean expstatus= true;
		Assert.assertEquals(actstatuso, expstatus);
	}
	
	@Test(priority=2)
	public void ContinueShoppiongurl() throws InterruptedException
	{
		String acturl=cp.continueShoppingTab();
		String expurl="https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(acturl, expurl);
				
	}
	
	@Test(priority=3)
	public void checkoutPageURL() throws InterruptedException
	{
		String acturl=cp.CheckoutpageURL();
		String expurl="https://www.saucedemo.com/checkout-step-one.html";
		Assert.assertEquals(acturl, expurl);
				
	}


}
