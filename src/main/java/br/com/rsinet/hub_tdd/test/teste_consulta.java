package br.com.rsinet.hub_tdd.test;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_tdd.actions.Screenshot;
import br.com.rsinet.hub_tdd.home.HomePage;

public class teste_consulta {

	static WebDriver driver;

	@Before
	public void busca() throws Exception {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.advantageonlineshopping.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	//@Test
	public void Teste_Busca() throws Exception {

		HomePage.mouse(driver);

		HomePage.mouse_azul(driver);

		assertTrue(driver.findElement(By.id("32")).isEnabled());

	}
	@Test
	public void Teste_Busca_Negativo() {
		
		Actions myAction = new Actions(driver); 
		
		
		myAction.contextClick(driver.findElement(By.xpath("body/header[1]/nav[1]/ul[1]/li[8]/a[1]"))).build().perform();
		 myAction.sendKeys(Keys.ARROW_DOWN).build().perform();
		 myAction.sendKeys(Keys.ENTER).build().perform();
		
		
	}
	
	
	
	
	//@After
	public void finalizaTeste() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mainImg\"]")));
		Screenshot.printTela(driver);

		driver.quit();
	}

}
