package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import static org.junit.Assert.assertTrue;

public class LoginSteps {
    WebDriver driver = Hooks.driver;
    LoginPage loginPage = new LoginPage(driver);

    public LoginSteps() {
    }

    @Given("I am on the SauceDemo login page")
    public void i_am_on_the_login_page() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("I enter username {string}")
    public void i_enter_username(String username) {
        loginPage.enterUsername(username);
    }

    @When("I enter password {string}")
    public void i_enter_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("I click the login button")
    public void i_click_login() {
        loginPage.clickLogin();
    }

    @Then("I should be redirected to the inventory page")
    public void verify_inventory_page() {
        assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Then("I should see an error message {string}")
    public void verify_error(String expectedMessage) {
        assertTrue(loginPage.getErrorMessage().contains(expectedMessage));
    }
}
