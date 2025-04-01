package pl.tmobile.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pl.tmobile.utils.DriverFactory;

public class ProductListPage {

    public static final String productListPageUrl = "https://www.t-mobile.pl/sklep/kategoria/telefony/lista/produkty?hardwareOnlySale=true";
    private static final WebElement secondProductOnTheList = DriverFactory.getDriver().findElement(By.cssSelector("[data-qa='LST_ProductCard1']"));

    public void clickOnSecondElementOnTheList() {
        secondProductOnTheList.click();
    }
}
