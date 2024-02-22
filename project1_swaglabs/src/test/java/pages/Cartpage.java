package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import library.BaseClass;

public class Cartpage extends BaseClass {
	ProductsPage pg= new ProductsPage(driver);
	ProductDetails pd= new ProductDetails(driver);
	
	By checkoutbutton= By.xpath("//button[@id='checkout']");
	By continueshopping= By.xpath("//button[@id='continue-shopping']");
	By removetext= By.xpath("//button[text()='Remove']");
	By carticon= By.xpath("//div[@id='shopping_cart_container']");
	
	public Cartpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean checkoutButton() throws InterruptedException
	{
		pd.checkoutopage();
		boolean checkbtn=driver.findElement(checkoutbutton).isEnabled();
		return checkbtn;
	}
	
	public String continueShoppingTab() throws InterruptedException
	{
		//pd.checkoutopage();
		driver.findElement(continueshopping).click();
		String url = driver.getCurrentUrl();
		return url;
		
	}
	
	public String CheckoutpageURL() throws InterruptedException
	{
		//pd.checkoutopage();
		driver.findElement(carticon).click();
		Thread.sleep(2000);
		driver.findElement(checkoutbutton).click();
		String title = driver.getCurrentUrl();
		return title;
	}
	
	

	
	

}
