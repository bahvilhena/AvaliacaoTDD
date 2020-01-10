package br.com.rsinet.hub_tdd.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cadastro {
	
	public static WebElement element = null;
	
	public static WebElement apelido(WebDriver driver) {
		element = driver.findElement(By.name("usernameRegisterPage"));
		
		return element;
			}
	
	public static WebElement email(WebDriver driver) {
		element = driver.findElement(By.name("emailRegisterPage"));
		
		return element;
			}
	
	public static WebElement senha(WebDriver driver) {
		element = driver.findElement(By.name("passwordRegisterPage"));
		
		return element;
			}
	
	public static WebElement confirmasenha(WebDriver driver) {
		element = driver.findElement(By.name("confirm_passwordRegisterPage"));
		
		return element;
			}
	
	public static WebElement nome(WebDriver driver) {
		element = driver.findElement(By.name("first_nameRegisterPage"));
		
		return element;
			}
	
	public static WebElement sobrenome(WebDriver driver) {
		element = driver.findElement(By.name("last_nameRegisterPage"));
		
		return element;
			}
	
	public static WebElement telefone(WebDriver driver) {
		element = driver.findElement(By.name("phone_numberRegisterPage"));
		
		return element;
			}
	
//	Thread.sleep(2000);
//
//	Select oSelect = new Select(driver.findElement(By.name("countryListboxRegisterPage")));
//
//	oSelect.selectByVisibleText("Brazil");
	
	
	
	public static WebElement cidade(WebDriver driver) {
		element = driver.findElement(By.name("cityRegisterPage"));
		
		return element;
			}
	
	public static WebElement endereço(WebDriver driver) {
		element = driver.findElement(By.name("addressRegisterPage"));
		
		return element;
			}
	
	public static WebElement estado(WebDriver driver) {
		element = driver.findElement(By.name("state_/_province_/_regionRegisterPage\r\n" + 
				""));
		
		return element;
			}
	
	public static WebElement codigopostal(WebDriver driver) {
		element = driver.findElement(By.name("postal_codeRegisterPage"));
		
		return element;
			}
	
	

}
