package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Products {
    public WebDriver driver;
    By products= By.cssSelector("h2");

    public Products(WebDriver driver){
        this.driver = driver;
    }

    public List<WebElement> getProducts(){
        List<WebElement> list=driver.findElements(products);
        return list;
    }
}
