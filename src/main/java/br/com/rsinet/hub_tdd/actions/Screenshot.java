package br.com.rsinet.hub_tdd.actions;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	public static void printTela(WebDriver driver) throws Exception {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

 

        FileUtils.copyFile(screenshot,
                new File("C:\\Users\\rodrigo.vilhena\\Desktop\\ScreenShootTDD\\" + Generator.dataHoraParaArquivo() + ".png"));
    }
	
}
