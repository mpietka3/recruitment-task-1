package pl.tmobile.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.tmobile.utils.DriverFactory;
import pl.tmobile.utils.PriceConverter;

import java.time.Duration;

public class BasketPage {

    public static String basketPageUrl = "https://www.t-mobile.pl/sklep/basket";
    PriceConverter priceConverter = new PriceConverter();

    public double getTotalUpFront() {

        try {
            WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-qa='BKT_TotalupFront']")));
            String totalUpFrontString = element.getText();
            return priceConverter.convertPrice(totalUpFrontString);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }

    public double getTotalMonthly() {
        try {
            WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-qa='BKT_TotalMonthly']")));
            String totalMonthlyString = element.getText();
            return priceConverter.convertPrice(totalMonthlyString);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }
}
