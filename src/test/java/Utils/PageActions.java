package Utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import solo.charrlie.Base;

import java.time.Duration;

import static solo.charrlie.Base.getDriver;

public class PageActions{
    WebDriver driver;

    protected PageActions()
    {
        driver = getDriver();
    }
    public void click(WebElement element)
    {
        element.click();
    }

    public void waitFor(WebElement element)
    {
        FluentWait wait = (FluentWait) new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(4))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public FluentWait waitForCondition()
    {
        FluentWait wait = (FluentWait) new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(4))
                .ignoring(NoSuchElementException.class);
        return wait;
    }
}
