import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertTrue;

public class FirstTest {

    @Test
    public void myFirstTest() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\Desktop\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.n11.com");

        String keyword = "Samsung";

        WebElement login = driver.findElement(By.cssSelector(".loginStatus>.btnSignIn"));
        login.click();

        WebElement enterMail = driver.findElement(By.id("email"));
        enterMail.sendKeys("entermail@gmail.com");

        WebElement enterPass = driver.findElement(By.id("password"));
        enterPass.sendKeys("enter_password");

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
        assertTrue(resultText.equals(keyword));

    }
}
