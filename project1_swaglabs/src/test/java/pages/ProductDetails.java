package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import library.BaseClass;

public class ProductDetails extends BaseClass {
	ProductsPage pg= new ProductsPage(driver);
	
	By product1= By.xpath("//div[text()='Sauce Labs Backpack']");
	By product2= By.xpath("//div[text()='Sauce Labs Bike Light']");
	By backtoproducts= By.xpath("//button[text()='Back to products']");
	By addcart= By.xpath("//button[text()='Add to cart']");
	By cartCount = By.xpath("//div[@id='shopping_cart_container']/a/span");
	By removetext= By.xpath("//button[text()='Remove']");
	By carticon= By.xpath("//div[@id='shopping_cart_container']");
	By addtocart2= By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']");
	
	
	
	public ProductDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyProductDetailsUrl() {
		pg.clickProduct1title();
		String productdetailurl = driver.getCurrentUrl();
		return productdetailurl;
	}
	
	public String backtoProducts() throws InterruptedException
	{
		//pg.clickProduct1title();
		Thread.sleep(2000);
		driver.findElement(backtoproducts).click();
		String currturl = driver.getCurrentUrl();
		return currturl;
	}
	
	public String addProductstoCart() throws InterruptedException
	{
		//pg.clickProduct1title();
		Thread.sleep(2000);
		
		driver.findElement(addtocart2).click();
		String removetitle=driver.findElement(removetext).getText();
		System.out.println(removetitle);
		String count=driver.findElement(cartCount).getText();
		return count;
	}
	
	
	public String checkoutopage() throws InterruptedException
	{
		//pg.clickProduct1title();
//		driver.findElement(addcart).click();
//		Thread.sleep(2000);
		driver.findElement(carticon).click();
		Thread.sleep(2000);
		String currturl = driver.getCurrentUrl();
		return currturl;
	}
	
	
	

}
