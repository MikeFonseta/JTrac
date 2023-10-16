package org.mikefonseta;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.AssertJUnit.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Suite {

    private static final String MAIN = "http://127.0.0.1:8888/app";

    private static WebDriver driver;

    @BeforeAll
    public static void init(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--no-sandbox");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @Test
    @Order(1)
    public void LoginAdmin()  {

        driver.get(MAIN);

        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.name("loginName"))).sendKeys("admin");
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.name("password"))).sendKeys("admin");
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.name("password"))).sendKeys(Keys.ENTER);

        WebElement loginField = null;

        try{
            loginField = driver.findElement(By.name("loginName"));
        }catch (Exception ignored)
        {

        }

        assertNull(loginField);
    }

    @Test
    @Order(2)
    public void CreateUser1()  {

        driver.get(MAIN);

        List<WebElement> elements = driver.findElements(By.tagName("a"));

        for (WebElement element : elements) {
            if(element.getText().toLowerCase().contains("opzioni"))
            {
                element.click();
                break;
            }
        }

        elements = driver.findElements(By.tagName("a"));
        for (WebElement element : elements) {
            if(element.getText().toLowerCase().contains("utenti"))
            {
                element.click();
                break;
            }
        }

        elements = driver.findElements(By.tagName("a"));
        for (WebElement element : elements) {
            if(element.getText().toLowerCase().contains("nuovo"))
            {
                element.click();
                break;
            }
        }

        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.name("user.loginName"))).sendKeys("Mike");
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.name("user.name"))).sendKeys("Mike Fonseta");
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.name("user.email"))).sendKeys("m.fonseta@studenti.unina.it");
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.name("password"))).sendKeys("123456789");
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.name("passwordConfirm"))).sendKeys("123456789");
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.name("passwordConfirm"))).sendKeys(Keys.ENTER);

        elements = driver.findElements(By.tagName("input"));
        for (WebElement element : elements) {
            if(element.getAttribute("value").toLowerCase().contains("cerca"))
            {
                element.click();
                break;
            }
        }

        boolean exists = false;

        elements = driver.findElements(By.tagName("td"));
        for (WebElement element : elements) {
            if(element.getText().toLowerCase().contains("mike"))
            {
                exists = true;
                break;
            }
        }

        assertTrue(exists);
    }

    @Test
    @Order(3)
    public void CreateUser2()  {

        driver.get(MAIN);

        List<WebElement> elements = driver.findElements(By.tagName("a"));

        for (WebElement element : elements) {
            if(element.getText().toLowerCase().contains("opzioni"))
            {
                element.click();
                break;
            }
        }

        elements = driver.findElements(By.tagName("a"));
        for (WebElement element : elements) {
            if(element.getText().toLowerCase().contains("utenti"))
            {
                element.click();
                break;
            }
        }

        elements = driver.findElements(By.tagName("a"));
        for (WebElement element : elements) {
            if(element.getText().toLowerCase().contains("nuovo"))
            {
                element.click();
                break;
            }
        }

        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.name("user.loginName"))).sendKeys("Test");
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.name("user.name"))).sendKeys("Account Test");
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.name("user.email"))).sendKeys("test@test.test");
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.name("password"))).sendKeys("123456789");
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.name("passwordConfirm"))).sendKeys("123456789");
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.name("passwordConfirm"))).sendKeys(Keys.ENTER);

        elements = driver.findElements(By.tagName("input"));
        for (WebElement element : elements) {
            if(element.getAttribute("value").toLowerCase().contains("cerca"))
            {
                element.click();
                break;
            }
        }

        boolean exists = false;

        elements = driver.findElements(By.tagName("td"));
        for (WebElement element : elements) {
            if(element.getText().toLowerCase().contains("mike"))
            {
                exists = true;
                break;
            }
        }

        assertTrue(exists);
    }

    @Test
    @Order(4)
    public void ModifyUser1()  {

        driver.get(MAIN);
        List<WebElement> elements = driver.findElements(By.tagName("a"));

        for (WebElement element : elements) {
            if(element.getText().toLowerCase().contains("opzioni"))
            {
                element.click();
                break;
            }
        }
        elements = driver.findElements(By.tagName("a"));
        for (WebElement element : elements) {
            if(element.getText().toLowerCase().contains("utenti"))
            {
                element.click();
                break;
            }
        }

        driver.findElement(By.xpath("//input[@value='Cerca']")).click();
        elements = driver.findElements(By.className("jtrac"));

        boolean found = false;

        for (WebElement table :
                elements) {
            if(!found)
            {
                List<WebElement> trs = table.findElements(By.tagName("tr"));
                for (WebElement tr :trs) {
                    if(tr.getText().toLowerCase().contains("mike"))
                    {
                        tr.findElements(By.tagName("td")).get(tr.findElements(By.tagName("td")).size() - 2).click();
                        found = true;
                        break;
                    }
                }
            }
            else
            {
                break;
            }
        }

        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.name("user.loginName"))).sendKeys("13");
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.name("password"))).sendKeys("987654321");
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.name("passwordConfirm"))).sendKeys("987654321");

        driver.findElement(By.xpath("//input[@value='Invia']")).click();
        driver.findElement(By.xpath("//input[@value='Cerca']")).click();

        elements = driver.findElements(By.className("jtrac"));

        found = false;

        for (WebElement table :
                elements) {
            if(!found)
            {
                List<WebElement> trs = table.findElements(By.tagName("tr"));
                for (WebElement tr :trs) {
                    if(tr.getText().toLowerCase().contains("mike"))
                    {
                        tr.findElements(By.tagName("td")).get(tr.findElements(By.tagName("td")).size() - 2).click();
                        found = true;
                        break;
                    }
                }
            }
            else
            {
                break;
            }
        }

        assertEquals("13Mike",new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.name("user.loginName"))).getAttribute("value"));
    }

    @Test
    @Order(5)
    public void DeleteUser2()  {

        driver.get(MAIN);

        List<WebElement> elements = driver.findElements(By.tagName("a"));

        for (WebElement element : elements) {
            if(element.getText().toLowerCase().contains("opzioni"))
            {
                element.click();
                break;
            }
        }
        elements = driver.findElements(By.tagName("a"));

        for (WebElement element : elements) {
            if(element.getText().toLowerCase().contains("utenti"))
            {
                element.click();
                break;
            }
        }

        driver.findElement(By.xpath("//input[@value='Cerca']")).click();
        elements = driver.findElements(By.className("jtrac"));

        boolean found = false;

        for (WebElement table :
                elements) {
            if(!found)
            {
                List<WebElement> trs = table.findElements(By.tagName("tr"));
                for (WebElement tr :trs) {
                    if(tr.getText().toLowerCase().contains("test"))
                    {
                        tr.findElements(By.tagName("td")).get(tr.findElements(By.tagName("td")).size() - 2).click();
                        found = true;
                        break;
                    }
                }
            }
            else
            {
                break;
            }
        }

        driver.findElement(By.xpath("//input[@value='Cancella']")).click();
        driver.findElement(By.xpath("//input[@value='Invia']")).click();
        driver.findElement(By.xpath("//input[@value='Cerca']")).click();

        elements = driver.findElements(By.className("jtrac"));

        found = false;

        for (WebElement table :elements) {
            if(!found)
            {
                List<WebElement> trs = table.findElements(By.tagName("tr"));
                for (WebElement tr :trs) {
                    if(tr.getText().toLowerCase().contains("test"))
                    {
                        found = true;
                        break;
                    }
                }
            }
            else
            {
                break;
            }
        }
        assertFalse(found);
    }

    @Test
    @Order(6)
    public void CreateSpace() throws InterruptedException {

        driver.get(MAIN);

        List<WebElement> elements = driver.findElements(By.tagName("a"));

        for (WebElement element : elements) {
            if(element.getText().toLowerCase().contains("opzioni"))
            {
                element.click();
                break;
            }
        }

        elements = driver.findElements(By.tagName("a"));
        for (WebElement element : elements) {
            if(element.getText().toLowerCase().contains("spazi"))
            {
                element.click();
                break;
            }
        }

        elements = driver.findElements(By.tagName("a"));
        for (WebElement element : elements) {
            if(element.getText().toLowerCase().contains("nuovo"))
            {
                element.click();
                break;
            }
        }

        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.name("space.name"))).sendKeys("My space");
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.name("space.prefixCode"))).sendKeys("MFS");
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.name("space.description"))).sendKeys("Description of my space");
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.name("space.guestAllowed"))).click();


        driver.findElement(By.xpath("//input[@value='Avanti']")).click();
        driver.findElement(By.xpath("//input[@value='Avanti']")).click();
        driver.findElement(By.xpath("//input[@value='Salva']")).click();


        Thread.sleep(10000);
        elements = driver.findElements(By.tagName("a"));

        for (WebElement element : elements) {
            if(element.getText().toLowerCase().contains("opzioni"))
            {
                element.click();
                break;
            }
        }

        elements = driver.findElements(By.tagName("a"));
        for (WebElement element : elements) {
            if(element.getText().toLowerCase().contains("spazi"))
            {
                element.click();
                break;
            }
        }

        elements = driver.findElements(By.className("jtrac"));
        boolean found = false;
        for (WebElement table : elements) {
            if(!found)
            {
                List<WebElement> trs = table.findElements(By.tagName("tr"));
                for (WebElement tr :trs) {
                    if(tr.getText().toLowerCase().contains("space"))
                    {
                        found = true;
                        break;
                    }
                }
            }
            else
            {
                break;
            }
        }

        assertEquals(true,found);
    }

    @Test
    @Order(7)
    public void Settings() {

        driver.get(MAIN);

        List<WebElement> elements = driver.findElements(By.tagName("a"));

        for (WebElement element : elements) {
            if(element.getText().toLowerCase().contains("opzioni"))
            {
                element.click();
                break;
            }
        }

        elements = driver.findElements(By.tagName("a"));
        for (WebElement element : elements) {
            if(element.getText().toLowerCase().contains("impostazioni"))
            {
                element.click();
                break;
            }
        }

        assertTrue(driver.findElement(By.className("heading")).getText().toLowerCase().contains("impostazioni"));
    }

    @Test
    @Order(8)
    public void LogoutAdmin() {

        driver.get(MAIN);

        List<WebElement> elements = driver.findElements(By.tagName("a"));

        for (WebElement element : elements) {
            if(element.getText().toLowerCase().contains("logout"))
            {
                element.click();
                break;
            }
        }

        elements = driver.findElements(By.tagName("a"));
        for (WebElement element : elements) {
            if(element.getText().toLowerCase().contains("login"))
            {
                element.click();
                break;
            }
        }

        WebElement logoutField = null;

        try{
            logoutField = driver.findElement(By.name("loginName"));
        }catch (Exception ignored)
        {

        }

        assertNotNull(logoutField);
    }

    @Test
    @Order(9)
    public void LoginUser1() {

        driver.get(MAIN);

        List<WebElement> elements = driver.findElements(By.tagName("a"));

        for (WebElement element : elements) {
            if(element.getText().toLowerCase().contains("login"))
            {
                element.click();
                break;
            }
        }

        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.name("loginName"))).sendKeys("13Mike");
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.name("password"))).sendKeys("987654321");
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.name("password"))).sendKeys(Keys.ENTER);

        WebElement loginField = null;

        try{
            loginField = driver.findElement(By.name("loginName"));
        }catch (Exception ignored)
        {

        }

        assertNull(loginField);
    }

    @Test
    @Order(10)
    public void Blackboard() {

        driver.get(MAIN);

        List<WebElement> elements = driver.findElements(By.tagName("a"));

        for (WebElement element : elements) {
            if(element.getText().toLowerCase().contains("lavagna"))
            {
                element.click();
                break;
            }
        }

        boolean exists = false;

        elements = driver.findElements(By.tagName("span"));
        for (WebElement element : elements) {
            if(element.getText().toLowerCase().contains("my space"))
            {
                exists = true;
                break;
            }
        }

        assertEquals(true,exists);
    }

    @AfterAll
    public static void finish() {
        driver.close();
    }
}