package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import library.BaseClass;

public class CheckoutPage extends BaseClass {
	Cartpage cartpg= new Cartpage(driver);
	ProductsPage pge= new ProductsPage(driver);
	
	
	
	By Firstname= By.xpath("//input[@id='first-name']");
	By lastname= By.xpath("//input[@id='last-name']");
	By postalcode= By.xpath("//input[@id='postal-code']");
	By continuebutton= By.xpath("//input[@id='continue']");
	By finishbuttton= By.xpath("//button[@id='finish']");
	By totalprice= By.xpath("//div[@class='summary_subtotal_label']");
	By tax= By.xpath("//div[@class='summary_tax_label']");
	By subtotal=By.xpath("//div[@class='summary_info_label summary_total_label']");
	By successmsg= By.xpath("//h2[text()='Thank you for your order!']");
	
	public CheckoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
		
	public void yourInfo(String fn, String LN, String pin) throws InterruptedException
	{
		//pge.addToCartProductPage();
		cartpg.CheckoutpageURL();
		driver.findElement(Firstname).sendKeys(fn);
		driver.findElement(lastname).sendKeys(LN);
		driver.findElement(postalcode).sendKeys(pin);
		Thread.sleep(2000);
		
	}
	
	public void continueButtonClick()
	{
		driver.findElement(continuebutton).click();
		
		
	}
	
	public float splitPrice()
	{
		String total= driver.findElement(totalprice).getText();
		System.out.println(total);
		String[] arrOfStr = total.split(":", 2);
		System.out.println(arrOfStr[1]);
		String tt=arrOfStr[1].replaceAll("[$]", "");
		//System.out.println(tt);
		float f=Float.parseFloat(tt);
		System.out.println(f);
		return f;
				
	}
	
	public float splittax()
	{
		String taxp=driver.findElement(tax).getText();
		System.out.println(taxp);
		String[] arr = taxp.split(":", 2);
		System.out.println(arr[1]);
		String tas=arr[1].replaceAll("[$]", "");
		float fl=Float.parseFloat(tas);
		System.out.println(fl);
		return fl;
	}
	
	public float spitSubtotal()
	{
		String subtotalp=driver.findElement(subtotal).getText();
		System.out.println(subtotalp);
		String[] arr = subtotalp.split(":", 2);
		System.out.println(arr[1]);
		String sub=arr[1].replaceAll("[$]", "");
		float f2=Float.parseFloat(sub);
		System.out.println(f2);
		return f2;
		
	}
	
	public boolean finishButtonPresent() {

		boolean finishbtn= driver.findElement(finishbuttton).isEnabled();
		return finishbtn;
	}
	
	public String confirmMessage()
	{
		driver.findElement(finishbuttton).click();
		String sucssmsg= driver.findElement(successmsg).getText();
		return sucssmsg;
	}
	
	


}

