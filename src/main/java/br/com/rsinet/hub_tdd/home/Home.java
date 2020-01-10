package br.com.rsinet.hub_tdd.home;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
	private static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("http://www.advantageonlineshopping.com/#/");

		driver.findElement(By.id("menuUser")).click();

		//WebDriverWait wait = new WebDriverWait(driver, 10);
		
		//WebDriverWait wait = new WebDriverWait(driver, 5);
		//WebElement tempo = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("CREATE NEW ACCOUNT")));

		driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]")).click();

		driver.findElement(By.name("usernameRegisterPage")).sendKeys("braulioteste");

		driver.findElement(By.name("emailRegisterPage")).sendKeys("braulioteste@teste.com");

		driver.findElement(By.name("passwordRegisterPage")).sendKeys("Teste123");

		driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys("Teste123");

		driver.findElement(By.name("first_nameRegisterPage")).sendKeys("braulio");

		driver.findElement(By.name("last_nameRegisterPage")).sendKeys("teste vilhena");

		driver.findElement(By.name("phone_numberRegisterPage")).sendKeys("11 994445555");

		Thread.sleep(2000);

		Select oSelect = new Select(driver.findElement(By.name("countryListboxRegisterPage")));

		oSelect.selectByVisibleText("Brazil");

		driver.findElement(By.name("cityRegisterPage")).sendKeys("São Teste");

		driver.findElement(By.name("addressRegisterPage")).sendKeys("Rua do Teste, 01");

		driver.findElement(By.xpath("//*[@id=\"formCover\"]/div[3]/div[2]/sec-view[2]/div[1]/input[1]")).sendKeys("Teste");

		driver.findElement(By.name("postal_codeRegisterPage")).sendKeys("55555-333");

		WebElement oCheckBox = driver.findElement(By.cssSelector("div#formCover > sec-view > div > input"));

		oCheckBox.click();

		driver.findElement(By.id("register_btnundefined")).click();

		System.out.println("SHOOOOOW");

	}

}