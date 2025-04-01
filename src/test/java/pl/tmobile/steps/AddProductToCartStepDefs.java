package pl.tmobile.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pl.tmobile.pages.BasketPage;
import pl.tmobile.pages.HomePage;
import pl.tmobile.pages.ProductListPage;
import pl.tmobile.pages.ProductPage;
import pl.tmobile.utils.DriverFactory;

import java.time.Duration;

public class AddProductToCartStepDefs {

    double upFront;
    double monthly;
    double totalUpFront;
    double totalMonthly;

    @Given("Open browser")
    public void userOpensChromeBrowser() {
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @When("User goes to home page")
    public void userGoesToHomePage() {
        HomePage homePage = new HomePage();
        DriverFactory.getDriver().get(homePage.baseUrl);
        homePage.acceptCookiePopUp();
    }

    @Then("Home page is visible")
    public void homePageIsVisible() {
        HomePage homePage = new HomePage();
        Assert.assertEquals(DriverFactory.getDriver().getCurrentUrl(), homePage.baseUrl);
    }

    @When("User expands devices list")
    public void userShowsDevices() {
        HomePage homePage = new HomePage();
        homePage.expandDevicesList();
    }

    @Then("Devices list is visible")
    public void devicesListIsVisible() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isDevicesListExpanded());
    }

    @When("User picks Smartfony from Bez abonamentu section")
    public void userChoosesSmartfonyFromBezAbonamentuSection() {
        HomePage homePage = new HomePage();
        homePage.clickSmartphonesButton();
    }

    @Then("Product List is visible")
    public void productListIsVisible() {
        Assert.assertEquals(DriverFactory.getDriver().getCurrentUrl(), ProductListPage.productListPageUrl);
    }

    @When("User clicks on second element from site")
    public void userClicksOnSecondElementFromProductList() {
        ProductListPage productListPage = new ProductListPage();
        productListPage.clickOnSecondElementOnTheList();
    }

    @Then("Product page is visible")
    public void productPageIsVisible() {
        ProductPage productPage = new ProductPage();
        Assert.assertTrue(productPage.isProductNameVisible());
    }

    @When("User adds product to cart")
    public void userAddsProductToCart() {
        ProductPage productPage = new ProductPage();
        upFront = productPage.getUpFront();
        monthly = productPage.getMonthly();
        productPage.addProductToBasket();
    }

    @Then("Then user gets to basket")
    public void thenUserGetsToBasket() {
        BasketPage basketPage = new BasketPage();

        totalUpFront = basketPage.getTotalUpFront();
        totalMonthly = basketPage.getTotalMonthly();

        Assert.assertEquals(upFront, basketPage.getTotalUpFront(), "Up front values are not equal");
        Assert.assertEquals(monthly, basketPage.getTotalMonthly(), "Monthly values are not equal");
        Assert.assertEquals(DriverFactory.getDriver().getCurrentUrl(), BasketPage.basketPageUrl);
    }

    @When("User goes back to home page")
    public void userGoesBackToHomePage() {
        HomePage homePage = new HomePage();
        DriverFactory.getDriver().get(homePage.baseUrl);
    }

    @And("Products number is shown on basket icon")
    public void productsNumberIsShownOnBasketIcon() {
        HomePage homePage = new HomePage();
        Assert.assertEquals(homePage.getProductsNumberOnBasketIcon(), 1);
        DriverFactory.getDriver().quit();
    }
}
