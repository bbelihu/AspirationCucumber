package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cookie {
    public WebDriver driver;
    By link = By.id("onetrust-accept-btn-handler");
    //Post: This driver intialized to argument driver
    public Cookie(WebDriver driver){
        this.driver = driver;
    }

    public void getCookie(){
        driver.findElement(link).click();
    }
}
