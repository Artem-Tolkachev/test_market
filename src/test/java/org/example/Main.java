package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        String userProfilePath = "C:\\Users\\Artyo\\AppData\\Local\\Google\\Chrome\\User Data";
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"user-data-dir=" + userProfilePath});
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://yandex.ru/search");
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        WebElement element = driver.findElement(By.xpath("//input[@name='text']"));
        element.sendKeys(new CharSequence[]{"Маркет"});
        element.sendKeys(new CharSequence[]{Keys.ENTER});
        WebElement yandexMarket = driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[2]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/a[1]/h2[1]/span[1]"));
        yandexMarket.click();
        Set<String> redirect = driver.getWindowHandles();
        Iterator var7 = redirect.iterator();

        while(var7.hasNext()) {
            String windowRedirect = (String)var7.next();
            driver.switchTo().window(windowRedirect);
        }

        WebElement catalog = driver.findElement(By.xpath("//span[contains(text(),'Каталог')]"));
        catalog.click();
        WebElement electronica = driver.findElement(By.xpath("//span[@class='_3krX4'][contains(text(),'Электроника')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(electronica).perform();
        WebElement mobile = driver.findElement(By.xpath("//a[@class='egKyN _1mqvV _1wg9X'][contains(text(),'Смартфоны')]"));
        mobile.click();
        WebElement mobile_smart = driver.findElement(By.xpath("//span[@class='_66nxG _3WROT Qg8Jj _14ZJi']"));
        mobile_smart.click();
        WebElement filterOne = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/section[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"));
        filterOne.sendKeys(new CharSequence[]{"0"});
        WebElement filterTwo = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/section[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]"));
        filterTwo.sendKeys(new CharSequence[]{"20000"});
        WebElement diagonal = driver.findElement(By.xpath("//h4[contains(text(),'Диагональ экрана (точно), \"')]"));
        diagonal.click();
        WebElement filterDiagonalOne = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/section[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"));
        filterDiagonalOne.sendKeys(new CharSequence[]{"3"});

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException var32) {
            var32.printStackTrace();
        }

        List<WebElement> buttons = driver.findElements(By.className("_1WMsA"));
        int count = Math.min(5, buttons.size());

        for(int i = 0; i < count; ++i) {
            WebElement button = (WebElement)buttons.get(i);
            button.click();
        }

        WebElement search = driver.findElement(By.xpath("//a[@class='_2qvOO _3qN-v _1Rc6L']"));
        search.click();
        List<WebElement> elements = driver.findElements(By.className("nXZ_7"));
        int minElementCount = 10;
        if (elements.size() >= minElementCount) {
            System.out.println("На странице найдено " + elements.size() + " элементов.");
        } else {
            System.out.println("На странице найдено всего " + elements.size() + " элементов");
        }

        WebElement firstElement = driver.findElement(By.cssSelector("._1KpjX._3uhJ0.T6363"));
        if (firstElement.isEnabled()) {
            firstElement.click();
        }

        WebElement dataElement = driver.findElement(By.cssSelector("._1E10J._2o124._1zh3_"));
        String dataToEnter = dataElement.getText();
        WebElement filter = driver.findElement(By.xpath("//button[contains(text(),'по рейтингу')]"));
        filter.click();
        WebElement inputField = driver.findElement(By.xpath("//input[@id='header-search']"));
        inputField.sendKeys(new CharSequence[]{dataToEnter});
        WebElement searchButton = driver.findElement(By.xpath("//span[contains(text(),'Найти')]"));
        searchButton.click();
        WebElement firstSearch = driver.findElement(By.cssSelector("._1E10J._2o124._1zh3_"));
        firstSearch.click();
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator var29 = windowHandles.iterator();

        while(var29.hasNext()) {
            String windowHandle = (String)var29.next();
            driver.switchTo().window(windowHandle);
        }

        WebElement pointClick = driver.findElement(By.xpath("(//div[@class='V6yhF'])[1]"));
        pointClick.click();
        WebElement point = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/main[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/a[1]/div[1]/span[1]"));
        String elementText = point.getText();
        System.out.println("Рейтинг товара " + elementText);
        driver.close();
        driver.quit();
    }
}