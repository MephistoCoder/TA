package ua.edu.sumdu;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSettings {
    public ChromeDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:/Java/chromedriver_win32_77/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void close(){
        driver.close();
    }
}
