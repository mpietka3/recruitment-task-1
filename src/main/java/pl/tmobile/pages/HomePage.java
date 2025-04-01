package pl.tmobile.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pl.tmobile.utils.DriverFactory;

public class HomePage {

    public String baseUrl = "https://www.t-mobile.pl/";

    public void acceptCookiePopUp() {
        WebElement cookiesAcceptButton = DriverFactory.getDriver().findElement(By.id("didomi-notice-agree-button"));
        cookiesAcceptButton.click();
    }

    public void expandDevicesList() {
        WebElement devicesListButton = DriverFactory.getDriver().findElement(By.cssSelector("#main-menu > div > ul > li:nth-child(1) > button"));
        devicesListButton.click();
    }

    public boolean isDevicesListExpanded() {
        return getDevicesList().isDisplayed();
    }

    public void clickSmartphonesButton() {
        WebElement smartphonesButton = DriverFactory.getDriver().findElement(By.cssSelector("#main-menu > div > ul > li:nth-child(1) > div > div > ul > li:nth-child(3) > ul > li:nth-child(1) > a > div > span"));
        smartphonesButton.click();
    }

    public int getProductsNumberOnBasketIcon() {
        WebElement number = DriverFactory.getDriver().findElement(By.cssSelector("#main-menu > div > div.container.mx-auto.lg\\:px-6.max-lg\\:hidden > div > div > a.group\\/basket.rounded.fill-base-gray-50.p-3.text-base-gray-50.max-sm\\:px-2 > div"));
        return Integer.parseInt(number.getText());
    }

    private WebElement getDevicesList() {
        return DriverFactory.getDriver().findElement(By.cssSelector("li:nth-child(1) > div > div > ul"));
    }
}
