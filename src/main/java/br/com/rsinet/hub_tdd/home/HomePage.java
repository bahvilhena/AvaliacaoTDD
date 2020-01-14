package br.com.rsinet.hub_tdd.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public static WebElement element = null;
	
	public static WebElement login(WebDriver driver) {

		element = driver.findElement(By.id("menuUser"));

		return element;

	}

	public static WebElement novaconta(WebDriver driver) {

		element = driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]"));

		return element;

	}

	public static WebElement menubusca(WebDriver driver) {
		
		element = driver.findElement(By.id("menuSearch"));
		
		return element;
		
	}
	
}
