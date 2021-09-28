package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AspirationSignup {
    public WebDriver driver;
    By aspirationButton = By.cssSelector("button.btn.btn-v3.btn--blue.ng-binding");
    By emailAssert = By.id("join-waitlist-input");
    By buttonClose = By.cssSelector("button.close");


    public AspirationSignup(WebDriver driver){
        this.driver = driver;
    }

    public void signUpButton(){
        WebElement element = driver.findElement(aspirationButton);
        element.click();
    }

    public WebElement input(){
        WebElement element = driver.findElement(emailAssert);
        return element;
    }
    public void close(){
        driver.findElement(buttonClose).click();
    }
}
