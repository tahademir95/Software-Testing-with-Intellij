package com.n11.bau;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    WebDriver driver;

    @Before
    public void startUp() {
//        System.setProperty("webdriver.chrome.driver", "‪C:\Users\pc\Desktop\chromedriver_win32\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.n11.com");
    }

    @After
    public void tearDown() {
        driver.close();
    }
}