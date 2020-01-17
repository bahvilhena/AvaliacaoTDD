package br.com.rsinet.hub_tdd.test;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_tdd.actions.Screenshot;
import br.com.rsinet.hub_tdd.cadastro.ExcelUtils;
import br.com.rsinet.hub_tdd.cadastro.InformacoesCadastrais.Constant;
import br.com.rsinet.hub_tdd.home.HomePage;

public class teste_pesquisa {

	static WebDriver driver;
	
	@Before
	public void busca() throws Exception {

		ExcelUtils.setExcelFile(Constant.Path_cadastro + Constant.File_cadastro, "planilha2");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.advantageonlineshopping.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void Teste_Pesquisa() throws Exception {

		HomePage.busca_produto(driver).sendKeys(ExcelUtils.getCellData(1, 0) + Keys.ENTER);

		driver.findElement(By.id("29")).click();
		assertTrue(driver.findElement(By.id("29")).isEnabled());


	}

	@Test
	public void Teste_Pesquisa_Negativo() throws Exception {

		HomePage.busca_produto(driver).sendKeys(ExcelUtils.getCellData(1, 1) + Keys.ENTER);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"searchPage\"]/div[3]/div/label/span")));
		assertTrue(driver.getPageSource().contains("No results for"));

	}

	@After
	public void finalizaTeste() throws Exception {
		Thread.sleep(3000);
		Screenshot.printTela(driver);

		driver.quit();
	}

}