package base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.Properties;

//import io.cucumber.java.After;
//import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.core.util.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
    public static Properties prop;
    public static WebDriver driver;
    public static String Browser;
    final public static Logger log = Logger.getLogger(BaseClass.class);;

    @Before
    public void BaseClassMethod() throws IOException {


//        log = Logger.getLogger(BaseClass.class);
//log.addAppender();
        PropertyConfigurator.configure("C:\\Users\\ajink\\IdeaProjects\\CITIAssignment\\CITIAssignment\\src\\main\\java\\configFile\\log4j2.properties");
        prop = new Properties();

        prop.load(new FileReader("C:\\Users\\ajink\\IdeaProjects\\CITIAssignment\\CITIAssignment\\src\\main\\java\\configFile\\config.properties"));

        log.info("Property file loaded");
        Browser = prop.getProperty("Browser");
        if (Browser.equalsIgnoreCase("chrome"))
            driver = new ChromeDriver();
        else if (Browser.equalsIgnoreCase("mozilla"))
            driver = new FirefoxDriver();
        else if (Browser.equalsIgnoreCase("edge"))
            driver = new EdgeDriver();
        log.info("Browser Initiated successfully");
        driver.manage().deleteAllCookies();

        driver.get(prop.getProperty("url"));
        log.info("OrangeHRM application opened");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public static void closing(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                File ScreenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File destinationFIle = new File("C:\\Users\\ajink\\IdeaProjects\\CITIAssignment\\CITIAssignment\\Screen");
                Files.copy(ScreenshotFile.toPath(), destinationFIle.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            driver.quit();
        }

    }
}
