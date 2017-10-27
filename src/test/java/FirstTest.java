import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class FirstTest {
    WebDriver driver;
    String keyword = "samsung";

    @Before //the function that will be executed at first thanks to '@Before' and generally the same/similar code blog is written in order not to write the same code in different test block over and over.
    public void startUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.n11.com");
    }
    @After //the function that will be executed at last thanks to '@After'.
    public void tearDown() {
        driver.close();
    }

    @Test
    public void myFirstTest(){

        //provides reaching the search button by using 'id' attribute of the html element, then writes what user wants to by using 'sendKeys' method.
        WebElement searchBar = driver.findElement(By.id("searchData"));
        searchBar.sendKeys(keyword);
        //same thing done with 'className' attribute of the html element
        WebElement searchButton = driver.findElement(By.className("iconSearch"));
        searchButton.click();
    }

    @Test
    public void loginAndSearchProcessWithXpath(){
        login();

        //by the 'className' attribute, gets the text from the stated place and assign it to a variable, then checks whether it is equal to the text which is written to the parameter of the assertThat function.
        String userName = driver.findElement(By.className("username")).getText();
        assertThat("When a buyer logged in", userName, equalTo("Test Bau"));

        driver.findElement(By.id("searchData")).sendKeys(keyword);
        driver.findElement(By.className("searchBtn")).click();

        String breadCrumbText = driver.findElement(By.cssSelector("#breadCrumb li[itemprop=\"itemListElement\"] > a")).getText();
        assertTrue(breadCrumbText.equals(keyword));

        String resultText = driver.findElement(By.cssSelector(".resultText > h1")).getText();
        String text = driver.findElement(By.xpath("//*[@class='resultText']/h1")).getText();
        driver.findElement(By.xpath("//*[@class='group setGroup keywordBannerGroup']//li[1]/a"));
        assertTrue(resultText.equals(keyword));
    }

    @Test
    public void loginAndSearchProcessWithCssSelector(){
        login();

        String userName = driver.findElement(By.className("username")).getText();
        assertThat("When a buyer logged in", userName, equalTo("taha demir"));

        WebElement searchBar = driver.findElement(By.id("searchData"));
        searchBar.sendKeys(keyword);

        WebElement searchButton = driver.findElement(By.className("iconSearch"));
        searchButton.click();

        List<WebElement> productList = driver.findElements(By.cssSelector("#view .productName"));
        //The below code does the same thing as above, only difference is the way of reaching to the elements
        //List<WebElement> productList1 = driver.findElements(By.xpath("//*[@id='view']//*[contains(@class, 'productName')]"));

        for (WebElement product : productList) {
            String productTitle = product.getText().toLowerCase();
            System.out.println("Asserting: " + productTitle);
            assertTrue(productTitle.contains(keyword));
        }
    }

    @Test
    public void intorductionToTesting() {
        /*Xpath Selector

        driver.findElement(By.xpath("//div[@class='panelContent']//*[contains(text(), 'Ürün Özellikleri')]"));
        driver.findElement(By.xpath("//div[@class='panelContent']//*[contains(@id, 'searchButton')]"));
        driver.findElement(By.xpath("//*[contains(@id, 'buyerSearchDataTable')]"));
        driver.findElement(By.id("tabPanelProDetail")).getAttribute("class");
        */


        /* CSS Selector
        String keyword = "Samsung";

        WebElement login = driver.findElement(By.cssSelector(".loginStatus>.btnSignIn"));
        login.click();

        WebElement enterMail = driver.findElement(By.id("email"));
        enterMail.sendKeys("tahadmr.1995@gmail.com");

        WebElement enterPass = driver.findElement(By.id("aa123123"));
        enterPass.sendKeys("aa123123");

        WebElement loginClick = driver.findElement(By.id("loginButton"));
        loginClick.click();

        String userName = driver.findElement(By.className("username")).getText();
        //assertThat("When a buyer logged in", userName, equalTo("Testsdada Bau")); //böle bişi yazmadığı için hata vercek.

        WebElement searchdata = driver.findElement(By.id("searchData"));
        searchdata.sendKeys("samsung");

        WebElement clickSearch = driver.findElement(By.className("iconSearch"));
        clickSearch.click();

        String ass = driver.findElement(By.cssSelector("#breadCrumb>ul>li:nth-child(2)>a>span")).getText();
        assertThat("is it same as in the web", ass, equalTo(keyword));

        String ass2 = driver.findElement((By.cssSelector(".listingGroup>.header>.resultText>h1"))).getText();
        assertThat("is it same as in the web", ass2, equalTo("Samsung"));
        //assertTrue(ass2.equals("Samsung")); -> bi üstteki kodun aynısı


        String resultText = driver.findElement(By.xpath("//*[@class='resultText']/h1")).getText();  //xpath ile yapılışı
        assertTrue(resultText.equals(keyword));*/

    }

    private void login() {
        WebElement loginButton = driver.findElement(By.className("btnSignIn"));
        loginButton.click();

        driver.findElement(By.id("email")).sendKeys("enter_your-mail@gmail.com");
        driver.findElement(By.id("password")).sendKeys("enter_password");
        driver.findElement(By.id("loginButton")).click();
    }
}
