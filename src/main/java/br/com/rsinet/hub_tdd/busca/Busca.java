package br.com.rsinet.hub_tdd.busca;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Busca {

	public static WebElement element = null;

	public static WebElement busca_produto(WebDriver driver) {

		element = driver.findElement(By.id("autoComplete"));

		return element;

	}
	
	public static WebElement produto(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//*[@id=\"output\"]/div[1]/div[2]/a[2]/img[1]"));
		
		return element;
	}
}
