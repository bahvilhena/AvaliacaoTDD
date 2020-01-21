package br.com.rsinet.hub_tdd.test;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mongodb.diagnostics.logging.Logger;

import br.com.rsinet.hub_tdd.actions.DadosCadastro;
import br.com.rsinet.hub_tdd.actions.DriverFactory;
import br.com.rsinet.hub_tdd.actions.Screenshot;

public class teste_cadastro {

	public static WebDriver driver;

	@BeforeMethod
	public void inicializarChrome() throws Exception {
		driver = DriverFactory.inicializarChromeCadastro();
		

	}

	@Test
	public void Teste_Confirma() throws Exception {
		DadosCadastro.dados_positivos(driver);
	}

	@Test
	public void Teste_NaoConfirma() throws Exception {
		DadosCadastro.dados_negativos(driver);
	}

	@AfterMethod
	public void finalizaTeste() throws Exception {
		Screenshot.printTela(driver);
		driver.quit();
	}

}
