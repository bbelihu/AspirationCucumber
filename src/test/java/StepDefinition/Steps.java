package StepDefinition;

import PageObject.*;
import Resources.Base;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Steps extends Base {
    public WebDriver driver;
    private static Logger logger;


    @Before
    public void setUp(){
        this.driver = init();
        this.driver.get(pro.getProperty("url"));
        logger = Logger.getLogger(Steps.class);
    }


    @Given("the user accepts the cookie")
    public void the_user_accepts_the_cookie() {
        Cookie cook = new Cookie(driver);
        cook.getCookie();
        logger.info("cookie accepted");
    }
    @When("the user clicks on the spend and save link")
    public void the_user_clicks_on_the_spend_and_save_link() {
        Spend s = new Spend(driver);
        s.link().click();
        logger.info("cookie accepted");
    }
    @Then("the user should be able to view two card products Aspiration and Aspiration Plus")
    public void the_user_should_be_able_to_view_two_card_products_aspiration_and_aspiration_plus() {
        Products pro = new Products(driver);
        List<WebElement> elements=pro.getProducts();
        String element1 = "Aspiration";
        String element2 = "Aspiration Plus";
        logger.info("Text when Aspiration Button is clicked is: "+elements.get(0).getText());
        logger.info("Text when Aspiration Plus Button is clicked is: "+elements.get(1).getText());
        Assert.assertEquals(element1,elements.get(0).getText());
        Assert.assertEquals(element2,elements.get(1).getText());
        logger.info("Assertion of Text Buttons complete.....");
    }
    @When("The user should click on get Aspiration")
    public void the_user_should_click_on_get_aspiration() {
        AspirationSignup sign = new AspirationSignup(driver);
        sign.signUpButton();
        logger.info("Get Aspiration Clicked!");
    }
    @Then("the user should be able to view a modal containing an input field for an email.")
    public void the_user_should_be_able_to_view_a_modal_containing_an_input_field_for_an_email() {
        AspirationSignup sign = new AspirationSignup(driver);
        WebElement wElement=sign.input();
        String tag= wElement.getTagName();
        if(tag!= "input"){
            logger.info("Modal doesn't have an input tag");
        }
        else{
            logger.info("Modal contains an input that requests user to input an email...");
        }

    }

    @Then("the user is goes back to the page displayed when clicking spend and save.")
    public void the_user_is_goes_back_to_the_page_displayed_when_clicking_spend_and_save() {
        AspirationSignup sign = new AspirationSignup(driver);
        sign.close();
        logger.info("Modal from the aspiration closed");
    }
    @When("the user clicks on the get Aspiration plus button")
    public void the_user_clicks_on_the_get_aspiration_plus_button() {
        AspirationPlusInfo plus = new AspirationPlusInfo(driver);
        plus.signUpButton();
        logger.info("Aspiration Plus button clicked!");
    }
    @Then("the user should be able to view a modal with monthly and yearly plan.")
    public void the_user_should_be_able_to_view_a_modal_with_monthly_and_yearly_plan() {
        AspirationPlusInfo plus = new AspirationPlusInfo(driver);
        List<WebElement> list=plus.info();
        String monthly = "$71.88 paid once yearly";
        String yearly = "$7.99 paid monthly";
        String outCome1 = list.get(1).getText().toString().trim();
        String outCome2 = list.get(2).getText().toString().trim();
        if(monthly.equals(outCome1)){
            logger.info("yearly shows $71.88 paid once yearly ");
        }
        if(yearly.equals(outCome2)){
            logger.info("Monthly shows:$7.99 paid monthly ");
        }
        Assert.assertEquals(monthly,outCome1);
        Assert.assertEquals(yearly,outCome2);
    }
    @Then("I close the browser.")
    public void i_close_the_browser() {
        this.driver.close();
        this.driver.quit();
        logger.info("driver closed");
    }








}
