package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.LoginPage;
import pages.ProductDetails;

public class ProductsDetailsPageTest extends BaseClass {
	LoginPage obj;
	ProductDetails productdel;
	
	@BeforeTest
	public void setup() throws InterruptedException
	{
		productdel= new ProductDetails(driver);
		obj= new LoginPage(driver);
		obj.validCredentials();
	}
	
	@Test(priority=1)
	public void verifyProductURL()
	{
		String acturl= productdel.verifyProductDetailsUrl();
		String expurl= "https://www.saucedemo.com/inventory-item.html?id=4";
		Assert.assertEquals(acturl, expurl);
		System.out.println(acturl);
		
	}
	
	@Test(priority=2)
	public void verifybacktoProducts() throws InterruptedException
	{
		String acturl= productdel.backtoProducts();
		String expurl= "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(acturl, expurl);
		System.out.println(acturl);
		
	}
	
	@Test(priority=3)
	public void verifyaddToCart() throws InterruptedException
	{
		String actcartcount= productdel.addProductstoCart();
		String expcartcount= "2";
		Assert.assertEquals(actcartcount, expcartcount);
		System.out.println(actcartcount);
		
	}
	
	@Test(priority=4)
	public void checkoutURL() throws InterruptedException
	{
		String actURL= productdel.checkoutopage();
		String expURL= "https://www.saucedemo.com/cart.html";
		Assert.assertEquals(actURL, expURL);
		System.out.println(actURL);
	}
	

}
