package PageObject;

import org.openqa.selenium.*;

public class OrderPageObject1 {
    private WebDriver driver;
    //поле "Имя"
    private By name= By.xpath(".//div[@class='Order_Content__bmtHS']//input[1]");
    //поле "Фамилия"
    private By surname= By.xpath(".//input[@placeholder='* Фамилия']");
    //поле "Адрес"
    private By address= By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //поле "Станция метро"
    private By metro= By.xpath(".//input[@placeholder='* Станция метро']");
    //поле "Телефон"
    private By telNumber= By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //кнопка "Далее"
    private By nextButton= By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    public OrderPageObject1 (WebDriver driver){
        this.driver=driver;
    }

    public void inputName (String newName){
        driver.findElement(name).sendKeys(newName);
    }

    public void inputSurname (String newSurame){
        driver.findElement(surname).sendKeys(newSurame);
    }

    public void inputAddress (String newAddress){
        driver.findElement(address).sendKeys(newAddress);
    }

    public void inputMetro (String newMetro){
        driver.findElement(metro).click();
        driver.findElement(metro).sendKeys(newMetro);
        driver.findElement(metro).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
    }

    public void inputTelNumber (String newTelNumber){
        driver.findElement(telNumber).sendKeys(newTelNumber);
    }

    public void nextButtonClick(){
        driver.findElement(nextButton).click();
           }

    public void fillOrderPage1(String newName,String newSurname, String newAddress, String newMetro,String newTelNumber){
        inputName (newName);
        inputSurname (newSurname);
        inputAddress(newAddress);
        inputMetro(newMetro);
        inputTelNumber(newTelNumber);
        nextButtonClick();
    }
}
