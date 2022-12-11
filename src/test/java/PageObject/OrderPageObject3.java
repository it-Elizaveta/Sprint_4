package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPageObject3 {
    private WebDriver driver;
    //Кнопка "Да"
    private By okButton=By.xpath(".//*[text()='Да']");

    //private By okButton=By.xpath("html/body/div/div/div/div/div/button[text()='Да']");
    //private By okButton=By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[@class='Order_Buttons__1xGrp']/button[2]");
    //private By okButton=By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[@class='Order_Buttons__1xGrp']/button[text()='Да']");
    //private By okButton=By.xpath("html/body/div/div/div[2]/div[5]/div[2]/button[2]");

    public OrderPageObject3(WebDriver driver){
        this.driver=driver;
    }

    public void clickOkButton(){
        //new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(okButton));
        //WebElement element=driver.findElement(okButton);
        //((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();" , element);
        driver.findElement(okButton).click();
        System.out.println("Текст кнопки ОК="+driver.findElement(okButton).getText());
    }
}
