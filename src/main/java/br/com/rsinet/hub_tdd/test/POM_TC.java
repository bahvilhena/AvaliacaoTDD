package br.com.rsinet.hub_tdd.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_tdd.home.HomePage;

public class POM_TC {

	
	private static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.advantageonlineshopping.com/");

		HomePage.login(driver).click();

		 Thread.sleep(5000);

		

		 HomePage.novaconta(driver).click();

	}

}
