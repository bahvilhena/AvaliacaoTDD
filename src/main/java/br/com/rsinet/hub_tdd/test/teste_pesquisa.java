package br.com.rsinet.hub_tdd.test;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.actions.BuscaProduto;
import br.com.rsinet.hub_tdd.actions.DriverFactory;
import br.com.rsinet.hub_tdd.actions.Screenshot;

public class teste_pesquisa {

	static WebDriver driver;

	@BeforeMethod
	public void busca() throws Exception {
		driver = DriverFactory.inicializarChromeProdutos();

	}

	@Test
	public void Teste_Pesquisa() throws Exception {
		BuscaProduto.busca_positivo(driver);

	}

	@Test
	public void Teste_Pesquisa_Negativo() throws Exception {
		BuscaProduto.busca_negativo(driver);

	}

	@AfterMethod
	public void finalizaTeste() throws Exception {
		Screenshot.printTela(driver);

		driver.quit();
	}
}