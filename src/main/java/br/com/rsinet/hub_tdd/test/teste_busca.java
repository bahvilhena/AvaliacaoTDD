package br.com.rsinet.hub_tdd.test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_tdd.busca.Busca;
import br.com.rsinet.hub_tdd.cadastro.ExcelUtils;
import br.com.rsinet.hub_tdd.cadastro.InformacoesCadastrais.Constant;
import br.com.rsinet.hub_tdd.home.HomePage;

public class teste_busca {
	
	public static WebDriver driver;
	private WebDriver element = null;
	
	@Before
	public void busca() throws Exception {

		ExcelUtils.setExcelFile(Constant.Path_cadastro + Constant.File_cadastro, "planilha2");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
		@Test
		public void Teste_Busca() throws Exception {

			driver.get("https://www.advantageonlineshopping.com/");
			HomePage.menubusca(driver).click();
			
			Busca.busca_produto(driver).sendKeys(ExcelUtils.getCellData(6, 0));

			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(Busca.produto(driver)));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", Busca.produto(driver));
			
		}
		
		
		
		@After
		public void finalizaTesteBusca() {
			 //driver.close();
		}
	
	}

		

