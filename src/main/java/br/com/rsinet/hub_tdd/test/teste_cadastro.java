package br.com.rsinet.hub_tdd.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_tdd.actions.DadosCadastro;
import br.com.rsinet.hub_tdd.actions.DriverFactory;
import br.com.rsinet.hub_tdd.actions.Screenshot;

public class teste_cadastro {

	public static WebDriver driver;

	@Before

	public void inicializarChrome() throws Exception {
		driver = DriverFactory.inicializarChrome();
	}

	@Test
	public void Teste_Confirma() throws Exception {
		DadosCadastro.dados_positivos(driver);
	}

	@Test
	public void Teste_NaoConfirma() throws Exception {
		DadosCadastro.dados_negativos(driver);
	}

	@After
	public void finalizaTeste() throws Exception {
		Screenshot.printTela(driver);
		driver.quit();
	}

}
