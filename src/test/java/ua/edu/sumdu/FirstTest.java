package ua.edu.sumdu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;

public class FirstTest extends WebDriverSettings{

    @Test
    public void firstTest()throws InterruptedException {

        /*
         * Открытие страницы https://sumdu.edu.ua/uk
         * */
        driver.get("https://sumdu.edu.ua/uk");
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Сумський державний університет"));

        /*
        * Поиск элемента списка меню
        * */
        Thread.sleep(1000);
        WebElement span = driver.findElement(By.className("header__menu"));

        /*
         * Открытие списка меню
         * */
        span.click();

        Thread.sleep(1000);

        /*
        * Переход по вкладке `Навчання` что находится меню
        * */
            WebElement link = span.findElement(By.xpath("//a[@href='/uk/academic.html']"));
            try {
            link.click();
        }catch (StaleElementReferenceException e){

            }
        Thread.sleep(1000);

        /*
        * Поиск и переход на страницу с расписанием
        * */
        for (int i = 0; i < 4; i++)
            driver.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);

        Thread.sleep(2000);
        try {
            link = driver.findElement(By.xpath("//a[@href='http://schedule.sumdu.edu.ua/']"));
            driver.get(link.getAttribute("href"));
        }catch (StaleElementReferenceException e){

        }
        /*
        * Изменение размеров окна браузера
        * */
        driver.manage().window().setSize(new Dimension(1000, 1000));
        Thread.sleep(2000);

        /*
        * Заполнение и отправка формы для поиска
        * */

        /*
        * Первый кейс
        * */
        driver.findElement(By.id("group")).sendKeys("ІН-81/1");
        Thread.sleep(500);
        driver.findElement(By.className("submit")).submit();

        driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(5000);

        /*
         * Второй кейс
         * */
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_UP);

        driver.findElement(By.id("group")).sendKeys("ІН-82/1");
        Thread.sleep(500);
        driver.findElement(By.id("teacher")).sendKeys("Авраменко Віктор Васильович");
        Thread.sleep(500);
        driver.findElement(By.className("submit")).submit();

        driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);

        Thread.sleep(5000);
    }

}
