package base;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public WebDriver driver;
    public Properties prop;

    public WebDriver init_driver(String browserName){

        if(browserName.equals("chrome")){
            ChromeDriverManager.chromedriver().setup();
            if(prop.getProperty("headless").equals("yes")){
                //headless more
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                driver = new ChromeDriver(options);
            }else{
                driver = new ChromeDriver();
            }
        }


        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }

    public Properties init_properties(){

        prop = new Properties();
        try {
            FileInputStream file = new FileInputStream("src/main/java/config/config.properties");

            prop.load(file);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;

    }
}
