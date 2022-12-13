package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPageObject3 {
    private WebDriver driver;
    //Кнопка "Да"
    private By okButton=By.xpath(".//*[text()='Да']");

    public OrderPageObject3(WebDriver driver){
        this.driver=driver;
    }

    public void clickOkButton(){
        driver.findElement(okButton).click();
    }
}
