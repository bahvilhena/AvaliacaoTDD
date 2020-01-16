package br.com.rsinet.hub_tdd.test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import br.com.rsinet.hub_tdd.cadastro.ExcelUtils;
import br.com.rsinet.hub_tdd.cadastro.InformacoesCadastrais.Constant;
import br.com.rsinet.hub_tdd.home.HomePage;
import br.com.rsinet.hub_tdd.screenshot.Screenshot;

public class teste_busca {
	
	static WebDriver driver;
	//private WebDriver element = null;
	
	@Before
	public void busca() throws Exception {

		ExcelUtils.setExcelFile(Constant.Path_cadastro + Constant.File_cadastro, "planilha2");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.advantageonlineshopping.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
		@Test
		public void Teste_Busca() throws Exception {

			HomePage.busca_produto(driver).sendKeys(ExcelUtils.getCellData(1, 0) + Keys.ENTER);
			
			driver.findElement(By.id("29")).click();
			
//			JavascriptExecutor executor = (JavascriptExecutor) driver;
//			executor.executeScript("arguments[0].click();", HomePage.produto(driver));

}   
           
		@Test
		public void Teste_Busca_Negativo() throws Exception {
			
//			driver.get("https://www.advantageonlineshopping.com/");
//			HomePage.login(driver).click();


			HomePage.busca_produto(driver).sendKeys(ExcelUtils.getCellData(1, 1) + Keys.ENTER);
			
		}
		@After
		public void finalizaTeste() throws Exception {
			Thread.sleep(3000);
			Screenshot.printTela(driver);
	       
			
			driver.close();
		}
		

            
}