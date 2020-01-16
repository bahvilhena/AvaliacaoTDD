package br.com.rsinet.hub_tdd.test;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_tdd.cadastro.ExcelUtils;
import br.com.rsinet.hub_tdd.cadastro.InformacoesCadastrais.Constant;
import br.com.rsinet.hub_tdd.home.HomePage;

public class teste_consulta {
	
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

			HomePage.mouse(driver).click();
			
//			WebDriverWait wait = new WebDriverWait(driver, 10); 		
//			ExcelUtils.setExcelFile(Constant.File_cadastro, "Planilha2"); 		
//			wait.until(ExpectedConditions.visibilityOf(HomePage.mouse_vermelho(driver))); 		
//			HomePage.mouse_vermelho(driver).click();
			
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", HomePage.produto(driver));

}   

}
