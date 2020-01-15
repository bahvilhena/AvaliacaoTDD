package br.com.rsinet.hub_tdd.test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_tdd.cadastro.Cadastro_Page;
import br.com.rsinet.hub_tdd.cadastro.ExcelUtils;
import br.com.rsinet.hub_tdd.cadastro.InformacoesCadastrais.Constant;
import br.com.rsinet.hub_tdd.home.HomePage;
import br.com.rsinet.hub_tdd.screenshot.Screenshot;

public class teste_cadastro {

	public static WebDriver driver;
	//private WebDriver element = null;

	@Before
	public void teste_cadastro() throws Exception {

		ExcelUtils.setExcelFile(Constant.Path_cadastro + Constant.File_cadastro, "planilha1");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void Teste_Confirma() throws Exception {

		driver.get("https://www.advantageonlineshopping.com/");
		HomePage.login(driver).click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(HomePage.novaconta(driver)));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", HomePage.novaconta(driver));

		Cadastro_Page.usuario(driver).sendKeys(ExcelUtils.getCellData(1, 0));
		Cadastro_Page.email(driver).sendKeys(ExcelUtils.getCellData(1, 1));
		Cadastro_Page.senha(driver).sendKeys(ExcelUtils.getCellData(1, 2));
		Cadastro_Page.confirmasenha(driver).sendKeys(ExcelUtils.getCellData(1, 3));
		Cadastro_Page.primeironome(driver).sendKeys(ExcelUtils.getCellData(1, 4));
		Cadastro_Page.ultimonome(driver).sendKeys(ExcelUtils.getCellData(1, 5));
		Cadastro_Page.telefone(driver).sendKeys(ExcelUtils.getCellData(1, 6));
		Cadastro_Page.cidade(driver).sendKeys(ExcelUtils.getCellData(1, 8));
		Cadastro_Page.pais(driver);
		Cadastro_Page.endereco(driver).sendKeys(ExcelUtils.getCellData(1, 9));
		Cadastro_Page.estado(driver).sendKeys(ExcelUtils.getCellData(1, 10));
		Cadastro_Page.codigopostal(driver).sendKeys(ExcelUtils.getCellData(1, 11));
		Cadastro_Page.aceite(driver).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("div#formCover > sec-view > div > input")).isSelected());
		Cadastro_Page.cadastra(driver).click();
		//assertEquals(ExcelUtils.getCellData(1, 0), Cadastro_Page.capturarTexto(driver));
	}

//	@After
//	public void finaliza() throws Exception {
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//		Screenshot.printTela(driver);
//		 //driver.close();
//		 
//		 
//		 
//	}
	
	@Test
	public void Teste_NaoConfirma() throws Exception {

		driver.get("https://www.advantageonlineshopping.com/");
		HomePage.login(driver).click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(HomePage.novaconta(driver)));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", HomePage.novaconta(driver));

		Cadastro_Page.usuario(driver).sendKeys(ExcelUtils.getCellData(1, 0));
		Cadastro_Page.email(driver).sendKeys(ExcelUtils.getCellData(1, 1));
		Cadastro_Page.senha(driver).sendKeys(ExcelUtils.getCellData(2, 2));
		Cadastro_Page.confirmasenha(driver).sendKeys(ExcelUtils.getCellData(2, 3));
		Screenshot.printTela(driver);
		Cadastro_Page.primeironome(driver).sendKeys(ExcelUtils.getCellData(1, 4));
		Cadastro_Page.ultimonome(driver).sendKeys(ExcelUtils.getCellData(1, 5));
		Cadastro_Page.telefone(driver).sendKeys(ExcelUtils.getCellData(1, 6));
		Cadastro_Page.cidade(driver).sendKeys(ExcelUtils.getCellData(1, 8));
		Cadastro_Page.pais(driver);
		Cadastro_Page.endereco(driver).sendKeys(ExcelUtils.getCellData(1, 9));
		Cadastro_Page.estado(driver).sendKeys(ExcelUtils.getCellData(1, 10));
		Cadastro_Page.codigopostal(driver).sendKeys(ExcelUtils.getCellData(1, 11));
		Cadastro_Page.aceite(driver).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("div#formCover > sec-view > div > input")).isSelected());
		Cadastro_Page.cadastra(driver).click();
		//assertEquals(ExcelUtils.getCellData(1, 0), Cadastro_Page.capturarTexto(driver));
		//Thread.sleep(3000);
	}
	
	@After
	public void finalizaTeste() throws Exception {
		Screenshot.printTela(driver);
       
		
		 driver.close();
	}

}
