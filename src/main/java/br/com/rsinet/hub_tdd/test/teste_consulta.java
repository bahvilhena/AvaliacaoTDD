package br.com.rsinet.hub_tdd.test;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.actions.DriverFactory;
import br.com.rsinet.hub_tdd.actions.HomePage;
import br.com.rsinet.hub_tdd.actions.Screenshot;

public class teste_consulta {

	static WebDriver driver;

	@BeforeMethod
	public void consulta() throws Exception {
		driver = DriverFactory.inicializarChromeProdutos();
	}

	 @Test
	public void Teste_Busca() throws Exception {

		HomePage.mouse(driver);

		HomePage.mouse_azul(driver);

	}
//	@Test
//	public void Teste_Busca_Negativo() throws InterruptedException {
//		
//		HomePage.outros_produtos(driver);
//		
//
//	}

	@AfterMethod
	public void finalizaTeste() throws Exception {
		Screenshot.printTela(driver);

		driver.quit();
	}

}
