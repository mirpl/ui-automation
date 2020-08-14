package ai.makeitright.utilities;

import ai.makeitright.utilities.Main;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Methods extends Main {
    public static String getDateTime(String format) {
        return new SimpleDateFormat(format).format(new GregorianCalendar().getTime());
    }

    public static String getScreenShotAsBase64(WebDriver driver) {
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        String image = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.BASE64);
        return image;
    }

    public static String getWebScreenShot(WebDriver driver) throws IOException {
        return getWebScreenShot(driver, "screenshot" + new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new GregorianCalendar().getTime()));
    }

    public static String getWebScreenShot(WebDriver driver, String strFilename) throws IOException {
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        File srcFile = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
//        String filePath = Main.workspacePath + "result" + System.getProperty("file.separator") + "attachments"
//                + System.getProperty("file.separator");
        String filePath = Main.workspacePath + System.getProperty("file.separator");
        String fileName = strFilename + ".png";
        FileUtils.copyFile(srcFile, new File(filePath + fileName));
        return fileName;
    }
}
