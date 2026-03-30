package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
	  /**
     * Takes a screenshot of the current page and saves it in /screenshots folder
     * @param driver - WebDriver instance
     * @param screenshotName - name for the screenshot file
     * @return path of the saved screenshot
     */
	public static String takeScreenshot(String screenshotName, WebDriver driver) {
	    String dateName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	    String destination = System.getProperty("user.dir") + "/screenshots/" + screenshotName + "_" + dateName + ".png";

	    try {
	        Files.createDirectories(Paths.get(System.getProperty("user.dir") + "/screenshots"));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    try {
	        Files.copy(srcFile.toPath(), Paths.get(destination));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return destination;
    }
}
