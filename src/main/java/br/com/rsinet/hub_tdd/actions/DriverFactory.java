package br.com.rsinet.hub_tdd.actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	
	static WebDriver driver;

	
	public static WebDriver inicializarChrome() {
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.advantageonlineshopping.com/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	driver.manage().window().maximize();
	System.out.println("suc");
	{
		return driver;
		
	}
	
	}
	public static WebDriver finalizarChrome() {
		driver.quit();
		return null;
		
	}
	
	
	
	
	}
	
	

