package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    @FindBy(xpath = "//input[@aria-label='Search']")
    WebElement searchBox;

    @FindBy(id="nav-search-submit-button")
    WebElement searchButton;

    @FindBy(xpath="//span[@data-component-type='s-product-image']")
    WebElement firstItem;

    public HomePage(WebDriver driver)
    {

    }

    public void enterText(String text)
    {
        searchBox.sendKeys(text);
    }

    public void clickSearchButton()
    {
        searchButton.click();
    }

    public void selectFirstItem()
    {
        firstItem.click();
    }

}
