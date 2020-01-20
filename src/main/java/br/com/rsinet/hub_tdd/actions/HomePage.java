package br.com.rsinet.hub_tdd.actions;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	public static WebElement element = null;
	
	public static WebElement login(WebDriver driver) {

		element = driver.findElement(By.id("menuUser"));

		return element;

	}

	public static WebElement novaconta(WebDriver driver) {

		element = driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]")) ;

		return element;

	}

	public static WebElement menubusca(WebDriver driver) {
		
		element = driver.findElement(By.id("menuSearch"));
		
		return element;
		
	}
	
	public static WebElement busca_produto(WebDriver driver) {

		element = driver.findElement(By.id("autoComplete"));

		return element;

	}
	
	public static WebElement produto(WebDriver driver) {
		element = driver.findElement(By.cssSelector("div#output > div > div:nth-of-type(2) > a:nth-of-type(2) > img"));
		return element;
	}
	
	public static WebElement mouse(WebDriver driver) {
		element = driver.findElement(By.id("miceImg"));
		element.click();
		return element;
	}
	
	public static WebElement mouse_azul(WebDriver driver) {
		element = driver.findElement(By.id("virtualFooter"));
		driver.findElement(By.id("32")).click();
		assertTrue(driver.findElement(By.id("32")).isEnabled());
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("save_to_cart")));
		return element;
	}
	
	public static WebElement outros_produtos(WebDriver driver) throws InterruptedException, AWTException {
		element = driver.findElement(By.xpath("/html/body/header/nav/ul/li[8]/a"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"headphonesImg\"]")));
		Actions action = new Actions(driver).contextClick(element);
		System.out.println("1");
		Thread.sleep(9000);
		System.out.println("2");
		action.sendKeys(Keys.ARROW_DOWN).perform();
		System.out.println("3");
		action.sendKeys(Keys.ARROW_DOWN).perform();
		action.sendKeys(Keys.ARROW_DOWN).perform();
		action.sendKeys(Keys.ARROW_DOWN).perform();
		action.sendKeys(Keys.ARROW_DOWN).perform();
		action.sendKeys(Keys.ENTER).perform();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		
		

		
		return element;
	}
	
}
