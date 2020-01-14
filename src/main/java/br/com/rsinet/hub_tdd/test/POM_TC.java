package br.com.rsinet.hub_tdd.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_tdd.cadastro.Cadastro;
import br.com.rsinet.hub_tdd.cadastro.ExcelUtils;
import br.com.rsinet.hub_tdd.cadastro.InformacoesCadastrais.Constant;
import br.com.rsinet.hub_tdd.home.HomePage;

public class POM_TC {

	private static WebDriver driver = null;

	public static void main(String[] args) throws Exception {

		ExcelUtils.setExcelFile(Constant.Path_cadastro + Constant.File_cadastro, "planilha1");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.advantageonlineshopping.com/");

		HomePage.login(driver).click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(HomePage.novaconta(driver)));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", HomePage.novaconta(driver));

		Cadastro.usuario(driver).sendKeys(ExcelUtils.getCellData(1, 0));

		Cadastro.email(driver).sendKeys(ExcelUtils.getCellData(1, 1));

		Cadastro.senha(driver).sendKeys(ExcelUtils.getCellData(1, 2));

		Cadastro.confirmasenha(driver).sendKeys(ExcelUtils.getCellData(1, 3));

		Cadastro.primeironome(driver).sendKeys(ExcelUtils.getCellData(1, 4));

		Cadastro.ultimonome(driver).sendKeys(ExcelUtils.getCellData(1, 5));

		Cadastro.telefone(driver).sendKeys(ExcelUtils.getCellData(1, 6));

		Cadastro.cidade(driver).sendKeys(ExcelUtils.getCellData(1, 8));

		Cadastro.pais(driver);

		Cadastro.endereco(driver).sendKeys(ExcelUtils.getCellData(1, 9));

		Cadastro.estado(driver).sendKeys(ExcelUtils.getCellData(1, 10));

		Cadastro.codigopostal(driver).sendKeys(ExcelUtils.getCellData(1, 11));

		Cadastro.aceite(driver).click();

		Cadastro.cadastra(driver).click();

	}

}
