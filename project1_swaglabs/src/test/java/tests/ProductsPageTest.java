package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductsPageTest extends BaseClass{
	ProductsPage products;
	LoginPage obj;
	
	
	@BeforeTest
	public void setup() throws InterruptedException
	{
		products= new ProductsPage(driver);
		obj= new LoginPage(driver);
		obj.validCredentials();
	}
	
	@Test(priority=0)
	public void verifyProductURL()
	{
		String acturl= products.verifyProductUrl();
		String expurl= "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(acturl, expurl);
		System.out.println(acturl);
		
	}
	
	@Test(priority=1)
	public void verifyApplog() throws InterruptedException
	{
		boolean actapplogo=products.applogoPresent();
		boolean expapplogo= true;
		Assert.assertEquals(actapplogo, expapplogo);
	}
	
	@Test(priority=2)
	public void verifyCartlogo() throws InterruptedException
	{
		boolean actcartlogo=products.cartLogoPresent();
		boolean expcartlogo= true;
		Assert.assertEquals(actcartlogo, expcartlogo);
	}
	@Test(priority=3)
	public void verifymMenulogo() throws InterruptedException
	{
		boolean actmenulogo=products.menuLogoPresent();
		boolean expmenulogo= true;
		Assert.assertEquals(actmenulogo, expmenulogo);
	}
	
	@Test(priority=4)
	public void verifyTwitterlogo() throws InterruptedException
	{
		boolean acttwitterlogo=products.twitterLogoPresent();
		boolean exptwitterlogo= true;
		Assert.assertEquals(acttwitterlogo, exptwitterlogo);
	}
	
	@Test(priority=5)
	public void verifyFacebooklogo() throws InterruptedException
	{
		boolean actfacebooklogo=products.facebookLogoPresent();
		boolean expfacebooklogo= true;
		Assert.assertEquals(actfacebooklogo, expfacebooklogo);
	}
	
	@Test(priority=6)
	public void verifyLnkedInlogo() throws InterruptedException
	{
		boolean actlinkedinlogo=products.linkedinLogoPresent();
		boolean explinkedinlogo= true;
		Assert.assertEquals(actlinkedinlogo, explinkedinlogo);
	}
	
	
	@Test(priority=7)
	public void verifySortlogo() throws InterruptedException
	{
		boolean actsortlogo=products.sortLogoPresent();
		boolean expsortlogo= true;
		Assert.assertEquals(actsortlogo, expsortlogo);
	}
	
	@Test(priority=8)
	public void productsNo()
	{
		products.productsOnPage();
		
	}
	
	@Test(priority=9)
	public void imagesNo()
	{
		products.imagesOnPage();
	}
	
	@Test(priority=10)
	public void verifyaddtoCart() throws InterruptedException
	{
		boolean actaddcart=products.addtoCart();
		boolean expaddcart= true;
		Assert.assertEquals(actaddcart, expaddcart);
	}
	
	@Test(priority=11)
	 public void addToCart(){
		 
		 String acttitle= products.clickAddtocart();
		 String exptitle="Remove";
		 Assert.assertEquals(acttitle, exptitle);
	    }
	
	@Test(priority=12)
	 public void removefromCart() throws InterruptedException{
		 
		 String actaddcarttitle= products.removeFromCart();
		 String expaddcarttitle="Add to cart";
		 Assert.assertEquals(actaddcarttitle, expaddcarttitle);
	    }
	
	@Test(priority=13)
	 public void addcartcount() {
		 
		String actcount=products.addToCartProductPage();
		String expcount="1";
		Assert.assertEquals(actcount, expcount);
		
	    }
	
	

}
