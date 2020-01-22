package br.com.rsinet.hub_tdd.test;


import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.hub_tdd.actions.BuscaProduto;
import br.com.rsinet.hub_tdd.actions.DriverFactory;
import br.com.rsinet.hub_tdd.actions.Screenshot;

public class teste_pesquisa {

	static WebDriver driver;
	ExtentReports extensao;
    ExtentTest logger;
    private String testName;

	@BeforeMethod
	public void busca() throws Exception {
		driver = DriverFactory.inicializarChromeProdutos();

	}

	@Test
	public void Teste_Pesquisa() throws Exception {
		BuscaProduto.busca_positivo(driver);
		ExtentHtmlReporter report = new ExtentHtmlReporter("./Report/buscaProduto.html");
        extensao = new ExtentReports();
        extensao.attachReporter(report);
        logger = extensao.createTest("Busca Realizada!");
           testName = new Throwable().getStackTrace()[0].getMethodName();

	}

	@Test
	public void Teste_Pesquisa_Negativo() throws Exception {
		BuscaProduto.busca_negativo(driver);
		testName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@AfterMethod
	public void finalizaTeste(ITestResult resultado) throws Exception {
		 if (resultado.getStatus() == ITestResult.FAILURE) {
	            String tempo = Screenshot.getScreenshot(driver, testName );
	            logger.fail(resultado.getThrowable().getMessage(),
	                    MediaEntityBuilder.createScreenCaptureFromPath(tempo).build());
	        } else if (resultado.getStatus() == ITestResult.SUCCESS) {
	            String tempo = Screenshot.getScreenshot(driver, testName);
	            logger.pass(testName, MediaEntityBuilder.createScreenCaptureFromPath(tempo).build());
	        }
	        extensao.flush();

		driver.quit();
	}
}