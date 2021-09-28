package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AspirationPlusInfo extends AspirationSignup{
    By radioValues= By.cssSelector("p");
    By aspirationPlusButton = By.cssSelector("button.btn.btn-v3.btn--blue.ng-binding");
    public WebDriverWait wait;
    public AspirationPlusInfo(WebDriver driver){
        super(driver);
        this.wait = new WebDriverWait(super.driver,30);
    }

    public List<WebElement> info(){
        List<WebElement> list=driver.findElements(radioValues);
        return list;
    }
    @Override
    public void signUpButton(){
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(aspirationPlusButton));
        List<WebElement> list = driver.findElements(aspirationPlusButton);
        WebElement but = list.get(1);
        but.click();
    }
}
