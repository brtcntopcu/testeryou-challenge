package pages;

import io.restassured.RestAssured;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BasePage {

    WebDriver driver;

    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public void clickForXpath(String identifier) {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(identifier))).click();
    }

    public void clickForId(String identifier) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(identifier))).click();
    }

    public void scrollUntilFindElement(String identifier) {
        WebElement element = driver.findElement(By.xpath(identifier));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public String getTextXpath(String identifier) {
        WebElement element = driver.findElement(By.xpath(identifier));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(identifier)));
        return element.getText();
    }

    public void sendKeysForId(String identifier, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(identifier))).sendKeys(text);
    }

    public void scrollUntilFindMovieAndClick(String identifier) {
        scrollUntilFindElement(identifier);
        clickForXpath(identifier);
    }

    public void clickForCSSPath(String identifier) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(identifier))).click();
    }

    public int findBrokenImages() {
        List<WebElement> image_list = driver.findElements(By.tagName("img"));
        List<String> broken_image_list = new ArrayList<>();
        for (WebElement s : image_list) {
            if (RestAssured.get(s.getAttribute("src")).statusCode() != 200) {
                broken_image_list.add(s.getAttribute("src"));
            }

        }
        return broken_image_list.size();
    }

}
