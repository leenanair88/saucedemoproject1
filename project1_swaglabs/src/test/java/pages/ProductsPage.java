package pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import library.BaseClass;

public class ProductsPage extends BaseClass {

	By applogo = By.xpath("//div[@class='app_logo']");
	By cart = By.xpath("//div[@id='shopping_cart_container']");
	By menu = By.xpath("//div[@class='bm-burger-button']");
	By twitterlogo = By.xpath("//li[@class='social_twitter']");
	By facebooklogo = By.xpath("//li[@class='social_facebook']");
	By linkedinlogo = By.xpath("//li[@class='social_linkedin']");
	By sortlogo= By.xpath("//div[@class='right_component']/child::span/child:: select");
	By products= By.xpath("//div[@class='inventory_list']/child:: div");
	By images= By.xpath("//div[@class='inventory_list']/child:: div/child::div/child::a");
	By addtocart= By.xpath("//div[@class='inventory_item_price']/following-sibling::button");
	By removebutton=By.xpath("//div[@class='inventory_item_price']/following-sibling::button[@id='remove-sauce-labs-backpack']");
	By removetext= By.xpath("//button[text()='Remove']");
	By addtocarttext= By.xpath("//button[text()='Add to cart']");
	By cartCount = By.xpath("//div[@id='shopping_cart_container']/a/span");
	By product1= By.xpath("//div[text()='Sauce Labs Backpack']");
	By product2= By.xpath("//div[text()='Sauce Labs Bike Light']");
	By addtocart1= By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']");
	
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyProductUrl() {
		String producturl = driver.getCurrentUrl();
		return producturl;
	}

	public boolean applogoPresent() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		boolean appl = driver.findElement(applogo).isDisplayed();
		return appl;

	}

	public boolean cartLogoPresent() {

		boolean cartl= driver.findElement(cart).isDisplayed();
		return cartl;
		
	}
	public boolean menuLogoPresent() {

		boolean menul= driver.findElement(menu).isDisplayed();
		return menul;
		
	}
	public boolean twitterLogoPresent() {

		boolean twitterl= driver.findElement(twitterlogo).isDisplayed();
		return twitterl;
		
	}
	public boolean facebookLogoPresent() {

		boolean facebookl= driver.findElement(facebooklogo).isDisplayed();
		return facebookl;
		
	}
	public boolean linkedinLogoPresent() {

		boolean linkedinl= driver.findElement(linkedinlogo).isDisplayed();
		return linkedinl;
		
	}
	
	public boolean sortLogoPresent() {

		boolean sortl= driver.findElement(sortlogo).isDisplayed();
		return sortl;
		
	}
	
	public List<WebElement> productsOnPage()
	{
		List<WebElement> productslist= driver.findElements(products);
		System.out.println(productslist.size());
		
		if (productslist.size() == 6) {
			assertTrue(true);
        }
        else{
        	assertFalse(false);
        }
		return productslist;
	}
	
	public void imagesOnPage()
	{
		List<WebElement> noofimages= driver.findElements(images);
		System.out.println(noofimages.size());

		if (noofimages.size() == 6) {
			assertTrue(true);
        }
        else{
        	assertFalse(false);
        }
	}
	
	public boolean addtoCart()
	{
		boolean addcart=driver.findElement(addtocart).isEnabled();
		return addcart;
	}
	
	public String clickAddtocart()
	{
		driver.findElement(addtocart).click();
		String removetitle=driver.findElement(removetext).getText();
		return removetitle;
	}
	
	public String removeFromCart() throws InterruptedException
	{
//		driver.findElement(addtocart).click();
		Thread.sleep(2000);		
		driver.findElement(removebutton).click();
		String addticarttitle=driver.findElement(addtocarttext).getText();
		return addticarttitle;
	}
	

	
	public String addToCartProductPage() {
		driver.findElement(addtocart).click();
		String count=driver.findElement(cartCount).getText();
		System.out.println(count);
		return count;
	    }
	
	public void clickProduct1title()
	{
		driver.findElement(addtocart1).click();
		driver.findElement(product1).click();
	}
	
	public void clickProduct2title()
	{
		driver.findElement(product2).click();
	}
	
	
	
	

}
