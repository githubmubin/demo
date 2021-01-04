package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TimeRackDemo {
	
	static WebDriver driver;
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void setHighlight(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style',arguments[1]);", element,"background:yellow;border:solid red;");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Interruppted exception occured.");
		}
		js.executeScript("arguments[0].setAttribute('style',arguments[1]);", element,"");
    }
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://testing.timerack365.com/TimerackDev_Bug0001186/Login.aspx?user=admin");
		WebElement idv= driver.findElement(By.xpath("//div[@id='login']"));
	    setHighlight(idv);
	    
	    WebElement logo= driver.findElement(By.xpath("//div[@id='divLogo']"));
	    setHighlight(logo);
	    
	    WebElement admin = driver.findElement(By.xpath("//select[@id='ddlLoginType']"));
	    setHighlight(admin);
	    
		WebElement id= driver.findElement(By.xpath("//input[@id='txtUserId']"));
	    setHighlight(id);
	    id.sendKeys("user@name.com");

	    WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
	    setHighlight(password);
	    password.sendKeys("password");
	    
	    WebElement btnLogin = driver.findElement(By.xpath("//input[@id='btnLogin']"));
	    setHighlight(btnLogin);
	    password.click();
	}
}
