package br.com.rsinet.hub_tdd.actions;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_tdd.cadastro.ExcelUtils;

public class BuscaProduto {

	public static void busca_positivo(WebDriver driver) throws Exception {

		String produto = ExcelUtils.getCellData(1, 0) + Keys.ENTER;

		HomePage.busca_produto(driver).sendKeys(produto);
		driver.findElement(By.id("29")).click();
		Assert.assertTrue(driver.findElement(By.id("29")).isEnabled());
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bunny")));

	}

	public static void busca_negativo(WebDriver driver) throws Exception {

		String produto_ind = ExcelUtils.getCellData(1, 1) + Keys.ENTER;

		HomePage.busca_produto(driver).sendKeys(produto_ind);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("virtualFooter")));
		assertTrue(driver.getPageSource().contains("No results for"));
	}
}