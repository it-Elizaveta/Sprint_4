package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObject {
    private WebDriver driver;
    // кнопка Куки
    private By cookieButton = By.id("rcc-confirm-button");
    // кнопка "Заказать" сверху
    private By upperOrderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    // кнопка "Заказать" снизу
    private By lowerOrderButton = By.className("Button_Middle__1CSJM");
    public HomePageObject(WebDriver driver) {
        this.driver=driver;
    }

    public void cookieButtonClick(){
        driver.findElement(cookieButton).click();
    }

    public void upperOrderButtonClick() {
        driver.findElement(upperOrderButton).click();
    }

    public void lowerOrderButtonClick() {
        WebElement element=driver.findElement(lowerOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();" , element);
        driver.findElement(lowerOrderButton).click();
    }

    public void chooseOrderButtonAndClick(String buttonLocation){
        if (buttonLocation.equals("upper")) {
            upperOrderButtonClick();
        } else if (buttonLocation.equals("lower")) {
            lowerOrderButtonClick();
        }
    }

}
