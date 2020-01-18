package br.com.rsinet.hub_tdd.actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_tdd.cadastro.ExcelUtils;
import br.com.rsinet.hub_tdd.cadastro.InformacoesCadastrais.Constant;
import br.com.rsinet.hub_tdd.home.HomePage;

public class DriverFactory {

	static WebDriver driver;

	public static WebDriver inicializarChrome() throws Exception {
		WebDriver driver = new ChromeDriver();
		ExcelUtils.setExcelFile(Constant.Path_cadastro + Constant.File_cadastro, "planilha1");
		driver.get("https://www.advantageonlineshopping.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", HomePage.novaconta(driver));

		{
			return driver;

		}
	}

}
