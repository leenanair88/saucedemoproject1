package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.CheckoutPage;
import pages.LoginPage;

public class CheckoutTest extends BaseClass {
	LoginPage obj;
	CheckoutPage ckp;
	CheckoutPage ckobj= new CheckoutPage(driver);
	
	@BeforeTest
	public void setup() throws InterruptedException
	{
		ckp= new CheckoutPage(driver);
		obj= new LoginPage(driver);
		obj.validCredentials();
	}
	
	@Test(priority=1)
	public void checkout() throws InterruptedException
	{
		ckp.yourInfo("abcd", "errgf","3455643");
		ckp.continueButtonClick();
		ckp.splitPrice();
		ckp.splittax();
		ckp.spitSubtotal();
	}
	
	@Test(priority=2)
	public void comparetotal() throws InterruptedException
	{
		//ckp.yourInfo("abcd", "errgf","3455643");
		//ckp.continueButtonClick();
		float totalprice= ckp.splitPrice();
		float taxvalue= ckp.splittax();
		float subtotal= ckp.spitSubtotal();
		float actual=totalprice+taxvalue;
		float expected= subtotal;
		Assert.assertEquals(actual, expected);
	}
	
	
	@Test(priority=3)
	
	public void verifyFinishbtnEnabled() throws InterruptedException
	{
//		ckp.yourInfo("abcd", "errgf","3455643");
//		ckp.continueButtonClick();
		boolean act=ckp.finishButtonPresent();
		boolean exp= true;
		Assert.assertEquals(act, exp);
	}
	
	@Test(priority=4)
	public void verifysuccessmsg() throws InterruptedException
	{
//		ckp.yourInfo("abcd", "errgf","3455643");
//		ckp.continueButtonClick();
		String actmsg = ckp.confirmMessage();
		System.out.println(actmsg);
		String expmsg= "Thank you for your order!";
		Assert.assertEquals(actmsg, expmsg);
	}
	

}
