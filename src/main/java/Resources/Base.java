package Resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base {
    public WebDriver driver;
    public Properties pro= new Properties();
    public WebDriver init(){
        try{
            FileInputStream fis = new FileInputStream("/Users/betabbelihu/downloads/CucumberAspiration/src/main/java/Resources/URL.properties");
            pro.load(fis);
            pro.getProperty("url");
            System.setProperty("webdriver.chrome.driver","/Users/betabbelihu/downloads/CucumberAspiration/chromedriver");
            this.driver = new ChromeDriver();
        } catch (IOException e){
            System.out.println("Url File not found");
        }
        return this.driver;
    }
}
