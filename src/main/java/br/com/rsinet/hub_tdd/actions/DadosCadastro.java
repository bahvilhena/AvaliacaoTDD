package br.com.rsinet.hub_tdd.actions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_tdd.cadastro.Cadastro_Page;
import br.com.rsinet.hub_tdd.cadastro.ExcelUtils;

public class DadosCadastro {

	public static void dados_positivos(WebDriver driver) throws Exception {

		String usuario = ExcelUtils.getCellData(1, 0);
		String email = ExcelUtils.getCellData(1, 1);
		String senha = ExcelUtils.getCellData(1, 2);
		String confirmasenha = ExcelUtils.getCellData(1, 3);
		String primeironome = ExcelUtils.getCellData(1, 4);
		String ultimonome = ExcelUtils.getCellData(1, 5);
		String telefone = ExcelUtils.getCellData(1, 6);
		String cidade = ExcelUtils.getCellData(1, 8);
		String endereco = ExcelUtils.getCellData(1, 9);
		String estado = ExcelUtils.getCellData(1, 10);
		String codigopostal = ExcelUtils.getCellData(1, 11);

		Cadastro_Page.usuario(driver).sendKeys(usuario);
		Cadastro_Page.email(driver).sendKeys(email);
		Cadastro_Page.senha(driver).sendKeys(senha);
		Cadastro_Page.confirmasenha(driver).sendKeys(confirmasenha);
		Cadastro_Page.primeironome(driver).sendKeys(primeironome);
		Cadastro_Page.ultimonome(driver).sendKeys(ultimonome);
		Cadastro_Page.telefone(driver).sendKeys(telefone);
		Cadastro_Page.cidade(driver).sendKeys(cidade);
		Cadastro_Page.pais(driver);
		Cadastro_Page.endereco(driver).sendKeys(endereco);
		Cadastro_Page.estado(driver).sendKeys(estado);
		Cadastro_Page.codigopostal(driver).sendKeys(codigopostal);
		Cadastro_Page.aceite(driver).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("div#formCover > sec-view > div > input")).isSelected());
		Cadastro_Page.cadastra(driver).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menuUserLink\"]/span[1]")));
	}

	public static void dados_negativos(WebDriver driver) throws Exception {

		String usuario = ExcelUtils.getCellData(1, 0);
		String email = ExcelUtils.getCellData(1, 1);
		String senhaerrada = ExcelUtils.getCellData(2, 2);
		String confirmasenhaerrada = ExcelUtils.getCellData(2, 3);
		String primeironome = ExcelUtils.getCellData(1, 4);
		String ultimonome = ExcelUtils.getCellData(1, 5);
		String telefone = ExcelUtils.getCellData(1, 6);
		String cidade = ExcelUtils.getCellData(1, 8);
		String endereco = ExcelUtils.getCellData(1, 9);
		String estado = ExcelUtils.getCellData(1, 10);
		String codigopostal = ExcelUtils.getCellData(2, 11);

		Cadastro_Page.usuario(driver).sendKeys(usuario);
		Cadastro_Page.email(driver).sendKeys(email);
		Cadastro_Page.senha(driver).sendKeys(senhaerrada);
		Cadastro_Page.confirmasenha(driver).sendKeys(confirmasenhaerrada);
		// Screenshot.printTela(driver);
		Cadastro_Page.primeironome(driver).sendKeys(primeironome);
		Cadastro_Page.ultimonome(driver).sendKeys(ultimonome);
		Cadastro_Page.telefone(driver).sendKeys(telefone);
		Cadastro_Page.cidade(driver).sendKeys(cidade);
		Cadastro_Page.pais(driver);
		Cadastro_Page.endereco(driver).sendKeys(endereco);
		Cadastro_Page.estado(driver).sendKeys(estado);
		Cadastro_Page.codigopostal(driver).sendKeys(codigopostal);
		Cadastro_Page.aceite(driver).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("div#formCover > sec-view > div > input")).isSelected());
		Cadastro_Page.cadastra(driver).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"registerPage\"]/article/sec-form/div[2]/label[2]/a")));
	}
}
