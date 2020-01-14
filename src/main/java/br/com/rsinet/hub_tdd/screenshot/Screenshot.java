package br.com.rsinet.hub_tdd.screenshot;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	public static void printTela(WebDriver driver) throws Exception {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

 

        FileUtils.copyFile(screenshot,
                new File("C:\\Users\\rodrigo.vilhena\\Documents\\AvaliacaoTDD\\AvaliacaoTDD\\src\\main\\java\\br\\com\\rsinet\\hub_tdd\\screenshot" + Generator.dataHoraParaArquivo() + ".png"));
    }
	
}
