package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import library.BaseClass;

public class LoginPage extends BaseClass {
	By usrname = By.id("user-name");
	By passwd = By.id("password");
	By LoginButton = By.id("login-button");
	By errmsg = By.xpath("//div[@class='error-message-container error']");
	By logoutmenu = By.xpath("//div[@class='bm-burger-button']");
	By logout = By.xpath("//div[@class='bm-menu-wrap']/child::div/child::nav/child::a[3]");
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String verifyUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public String verifytitle() {
		String title = driver.getTitle();
		return title;

	}

	public void verifyloginCredentials() throws IOException, InterruptedException {
		File f = new File(System.getProperty("user.dir") + "\\\\src\\\\test\\\\resources\\\\testdata\\\\LoginCredentials.xlsx");
		//String filepath = "E:\\Eclipse New Codes\\my workspace\\project1_swaglabs\\src\\test\\resources\\testdata\\LoginCredentials.xlsx";
		FileInputStream fis = new FileInputStream(f);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("login");
		int rows = sheet.getLastRowNum();
		System.out.println("Number of rows " + rows);

		for (int r = 1; r <= rows; r++) {
			XSSFRow row = sheet.getRow(r);
			XSSFCell username = row.getCell(0);
			XSSFCell password = row.getCell(1);
			XSSFCell result = row.createCell(2);
			System.out.println("Username ---->" + username + "     Password---->" + password);

			driver.findElement(usrname).clear();
			driver.findElement(usrname).sendKeys(username.toString());

			Thread.sleep(2000);
			driver.findElement(passwd).clear();
			driver.findElement(passwd).sendKeys(password.toString());

			Thread.sleep(2000);
			driver.findElement(LoginButton).click();

			try {
				driver.findElement(logoutmenu).click();
				Thread.sleep(2000);
				driver.findElement(logout).click();
				System.out.println("valid data");
				result.setCellValue("Pass");
			} catch (Exception e) {
				System.out.println("Invalid data");
				result.setCellValue("Fail");
			}

		}

		fis.close();
		FileOutputStream fos = new FileOutputStream(f);
		workbook.write(fos);

	}

	public void invalidUserErrorMessage() throws InterruptedException {
		
		driver.findElement(usrname).clear();
		driver.findElement(usrname).sendKeys("asdfe");
		driver.findElement(passwd).clear();
		driver.findElement(passwd).sendKeys("123445");
		Thread.sleep(2000);
		driver.findElement(LoginButton).click();

		String actmsg = driver.findElement(errmsg).getText();
		System.out.println(actmsg);
		String expmsg= "Epic sadface: Username and password do not match any user in this service";
		Assert.assertEquals(actmsg, expmsg);
		 driver. navigate(). refresh();

	}
	
	public String blankFields() throws InterruptedException
	{
		driver.findElement(usrname).clear();
		driver.findElement(usrname).sendKeys("");
		driver.findElement(passwd).clear();
		driver.findElement(passwd).sendKeys("");
		Thread.sleep(2000);
		driver.findElement(LoginButton).click();
		String msg= driver.findElement(errmsg).getText();
		return msg;
		
	}
	
	public String validCredentials() throws InterruptedException
	{
		driver.findElement(usrname).clear();
		driver.findElement(usrname).sendKeys("standard_user");
		driver.findElement(passwd).clear();
		driver.findElement(passwd).sendKeys("secret_sauce");
		Thread.sleep(2000);
		driver.findElement(LoginButton).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String ptitle = driver.getCurrentUrl();
		return ptitle;
	}

}
