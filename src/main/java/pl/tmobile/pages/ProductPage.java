package pl.tmobile.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pl.tmobile.utils.DriverFactory;
import pl.tmobile.utils.PriceConverter;


public class ProductPage {

    PriceConverter priceConverter = new PriceConverter();

    public double getUpFront() {
        String upFrontString = DriverFactory.getDriver().findElement(By.cssSelector("div > div.styles__StyledWrapper-sc-157atax-0.exemHW.stickyAreaWrapper > div > div > div > div.style_priceInfoSection > div.styles__StyledUpfront-sc-1d98su7-0.eyNOLh.upfront-panel > div > div.sc-feUZmu.gSyZgc.dt_typography.variant_h4.value > div > div")).getText();
        return priceConverter.convertPrice(upFrontString);
    }

    public double getMonthly() {
        String monthlyString = DriverFactory.getDriver().findElement(By.cssSelector("div > div.styles__StyledWrapper-sc-157atax-0.exemHW.stickyAreaWrapper > div > div > div > div.style_priceInfoSection > div.priceRightSection.rightAlignment > div > div > div.sc-feUZmu.gSyZgc.dt_typography.variant_h4.value > div > div")).getText();
        return priceConverter.convertPrice(monthlyString);
    }

    public void addProductToBasket() {
        WebElement addToBasketButton = DriverFactory.getDriver().findElement(By.cssSelector("div > div.styles__StyledWrapper-sc-157atax-0.exemHW.stickyAreaWrapper > div > div > div > div.style_ctaSection > section.btnWrapper > button"));
        addToBasketButton.click();
    }

    public boolean isProductNameVisible() {
        return getProductName().isDisplayed();
    }

    private WebElement getProductName() {
        return DriverFactory.getDriver().findElement(By.cssSelector("[data-qa='PRD_ProductName']"));
    }
}
