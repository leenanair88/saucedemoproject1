package tests;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.Cartpage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductDetails;
import pages.ProductsPage;

public class EndtoEndTesting extends BaseClass {
	LoginPage log;
	Cartpage cart;
	CheckoutPage chk;
	ProductDetails pd;
	ProductsPage pg;
	
	@BeforeTest
	public void setup() throws InterruptedException
	{
		cart= new Cartpage(driver);
		chk= new CheckoutPage(driver);
		pd=new ProductDetails(driver);
		pg= new ProductsPage(driver);
		log= new LoginPage(driver);
		log.validCredentials();
	}
	
	@Test(priority=0)
	public void productPageTest() throws InterruptedException
	{
		ProductsPage pro= new ProductsPage(driver);
		pro.verifyProductUrl();
		pro.applogoPresent();
		pro.cartLogoPresent();
		pro.menuLogoPresent();
		pro.twitterLogoPresent();
		pro.facebookLogoPresent();
		pro.linkedinLogoPresent();
		pro.sortLogoPresent();
		pro.productsOnPage();
		pro.imagesOnPage();
		pro.addtoCart();
		pro.clickAddtocart();
		pro.removeFromCart();
		pro.addToCartProductPage();
	
	
	}
	@Test(priority=1)
	public void produtsDetailspage() throws InterruptedException
	{
		ProductDetails pdpage= new ProductDetails(driver);
		pdpage.verifyProductDetailsUrl();
		pdpage.backtoProducts();
		pdpage.addProductstoCart();
		pdpage.checkoutopage();
		
	}
	
	@Test(priority=2)
	public void cartpage() throws InterruptedException
	{
		Cartpage cartpg= new Cartpage(driver);
		cartpg.checkoutButton();
		cartpg.continueShoppingTab();
		cartpg.CheckoutpageURL();
		
	}
	
	@Test(priority=3)
	public void checkoutPage() throws InterruptedException
    {
		CheckoutPage coutpg= new CheckoutPage(driver);
		coutpg.yourInfo("sample", "test", "23243546576");
		coutpg.continueButtonClick();
		coutpg.splitPrice();
		coutpg.splittax();
		coutpg.spitSubtotal();
		coutpg.finishButtonPresent();
		coutpg.confirmMessage();
		
	}
}
