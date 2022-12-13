package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPageObject {
    private WebDriver driver;
    //Сообщение "Заказ оформлен"
    private By resultMessage=By.className("Order_ModalHeader__3FDaJ");

    public ResultPageObject(WebDriver driver){
        this.driver=driver;
    }

    public String getResultMessage(){
        return driver.findElement(resultMessage).getText();
    }

}
