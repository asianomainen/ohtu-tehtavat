package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";
    
    @Given("login is selected")
    public void loginIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();   
    }    
    
    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }    
 
    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }    
    
    @When("username {string} and password {string} are given")
    public void usernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }   
    
    @Then("system will respond {string}")
    public void systemWillRespond(String pageContent) {
        assertTrue(driver.getPageSource().contains(pageContent));
    }
    
    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    }

    @When("non-existent username {string} and non-existent password {string} are given")
    public void nonExistentUsernameAndNonExistentPasswordAreGiven(String usr, String pwd) {
        logInWith(usr, pwd);
    }

    @Given("command new user is selected")
    public void commandNewUserIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
    }

    @When("a valid username {string} and password {string} and matching password confirmation are entered")
    public void aValidUsernameAndPasswordAndMatchingPasswordConfirmationAreEntered(String usr, String pwd) {
        addUser(usr, pwd, pwd);
    }

    @Then("a new user is created")
    public void aNewUserIsCreated() {
        pageHasContent("Welcome to Ohtu Application");
    }

    private void addUser(String usr, String pwd, String conf) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));

        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(usr);

        element = driver.findElement(By.name("password"));
        element.sendKeys(pwd);

        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(conf);

        element = driver.findElement(By.name("signup"));
        element.submit();
    }

    @When("a short username {string} and valid password {string} are entered")
    public void aShortUsernameAndValidPasswordAreEntered(String usr, String pwd) {
        addUser(usr, pwd, pwd);
    }

    @When("a valid username {string} and short password {string} are entered")
    public void aValidUsernameAndShortPasswordAreEntered(String usr, String pwd) {
        addUser(usr, pwd, pwd);
    }

    @Then("user is not created and error {string} is reported")
    public void userIsNotCreatedAndErrorIsReported(String error) {
        pageHasContent(error);
    }

    @When("a valid username {string} and non-matching passwords {string} and {string} are entered")
    public void aValidUsernameAndNonMatchingPasswordsAndAreEntered(String usr, String pwd, String conf) {
        addUser(usr, pwd, conf);
    }

    @Given("user with username {string} with password {string} is successfully created")
    public void userWithUsernameWithPasswordIsSuccessfullyCreated(String usr, String pwd) {
        commandNewUserIsSelected();
        addUser(usr, pwd, pwd);
    }

    @Given("user with username {string} and password {string} is tried to be created")
    public void userWithUsernameAndPasswordIsTriedToBeCreated(String usr, String pwd) {
        commandNewUserIsSelected();
        addUser(usr, pwd, pwd);
    }
}
