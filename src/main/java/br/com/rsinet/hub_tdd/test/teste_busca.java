package br.com.rsinet.hub_tdd.test;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_tdd.busca.Busca;
import br.com.rsinet.hub_tdd.cadastro.ExcelUtils;
import br.com.rsinet.hub_tdd.cadastro.InformacoesCadastrais.Constant;
import br.com.rsinet.hub_tdd.home.HomePage;

public class teste_busca {
	
	static WebDriver driver;
	//private WebDriver element = null;
	
	@Before
	public void busca() throws Exception {

		ExcelUtils.setExcelFile(Constant.Path_cadastro + Constant.File_cadastro, "planilha2");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.advantageonlineshopping.com/");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
		@Test
		public void Teste_Busca() throws Exception {

			HomePage.menubusca(driver).click();
			
			Busca.busca_produto(driver).sendKeys(ExcelUtils.getCellData(1, 0) + Keys.ENTER);
			
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(Busca.produto(driver)));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", Busca.produto(driver));
            
		}    

}   
            
            
            
//			driver.findElement(By.linkText("HP ENVY x360 - 15t Laptop")).click();
			
			

//			WebDriverWait wait = new WebDriverWait(driver, 20);
//			wait.until(ExpectedConditions.elementToBeClickable(Busca.produto(driver)));
//			JavascriptExecutor executor = (JavascriptExecutor) driver;
//			executor.executeScript("arguments[0].click();", Busca.produto(driver));
			


		
//		
//		@After
//			 //driver.close();
//		public void finalizaTesteBusca() {
//		}
//	
//	}

//
//import java.util.concurrent.TimeUnit;
//
//import org.junit.After;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import br.com.rsinet.hub_tdd.busca.Busca;
//import br.com.rsinet.hub_tdd.cadastro.ExcelUtils;
//import br.com.rsinet.hub_tdd.cadastro.InformacoesCadastrais.Constant;
//import br.com.rsinet.hub_tdd.screenshot.Screenshot;
//
// 
//
//public class teste_busca {
//
// 
//
//    static WebDriver driver;
//
// 
//
//    @Test
//
// 
//
//    public void BuscarProduto() throws Exception {
//    	ExcelUtils.setExcelFile(Constant.Path_cadastro + Constant.File_cadastro, "planilha2");        
//    	driver = new ChromeDriver();
//        driver.get("http://advantageonlineshopping.com");
//        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        Busca.busca_produto(driver).sendKeys(ExcelUtils.getCellData(1, 0) + Keys.ENTER);
//        driver.findElement(By.linkText("HP ENVY - 17t Touch Laptop")).click();
//
// 
//
//    }
//
// 
//
//    @After
//    public void finaliza_teste() throws Exception {
//        //Thread.sleep(4000);
//        
//        
//        Screenshot.printTela(driver);
//        
//        driver.quit();
//    }
//
// 
//
//    
//}
//
//		
//
