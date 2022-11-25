package pages;

import Utils.PageActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

import static solo.charrlie.Base.getDriver;

public class ProductPage extends PageActions{

    public ProductPage()
    {
        PageFactory.initElements(getDriver(),this);
    }
    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    WebElement addToCartButton;

    @FindBy(xpath = "//div[@id='add-to-cart-confirmation-image']")
    WebElement cartItem;

    @FindBy(id = "native_dropdown_selected_size_name")
    WebElement selectSize;

    public void addItemToCar() throws InterruptedException {
        Set<String> windowHandles= getDriver().getWindowHandles();
        String windowHandle = getDriver().getWindowHandle();
        for(String handle : windowHandles) {
            if(handle!=windowHandle)
                getDriver().switchTo().window(handle);
        }
        waitFor(selectSize);
        Select selectSizeDropDown = new Select(selectSize);
        selectSizeDropDown.selectByVisibleText("6 UK (6.5 US)");
        waitForCondition().until(ExpectedConditions.elementToBeClickable(addToCartButton));
        click(addToCartButton);
        addToCartButton.click();
    }

    public boolean verifyItemsInCart() throws InterruptedException {
        return cartItem.isDisplayed();
    }
}
