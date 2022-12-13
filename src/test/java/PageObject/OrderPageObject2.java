package PageObject;

import org.openqa.selenium.*;

public class OrderPageObject2 {
    private WebDriver driver;
    //поле "Дата"
    private By date=By.xpath(".//div[@class='react-datepicker__input-container']/input");
    //поле "Срок аренды"
    private By period=By.className("Dropdown-placeholder");
    // поле "Срок аренды" - значение "сутки"
    private By period_1day=By.xpath(".//*[@class='Dropdown-option'][1]");
    // поле "Срок аренды" - значение "двое суток"
    private By period_2days=By.xpath(".//*[@class='Dropdown-option'][2]");
    // поле "Срок аренды" - значение "трое суток"
    private By period_3days=By.xpath(".//*[@class='Dropdown-option'][3]");
    // поле "Срок аренды" - значение "четверо суток"
    private By period_4days=By.xpath(".//*[@class='Dropdown-option'][4]");
    // поле "Срок аренды" - значение "пятеро суток"
    private By period_5days=By.xpath(".//*[@class='Dropdown-option'][5]");
    // поле "Срок аренды" - значение "шестеро суток"
    private By period_6days=By.xpath(".//*[@class='Dropdown-option'][6]");
    // поле "Срок аренды" - значение "семеро суток"
    private By period_7days=By.xpath(".//*[@class='Dropdown-option'][7]");
    //чекбокс "Цвет черный жемчуг"
    private By blackColor=By.xpath(".//input[@id='black']");
    //чекбокс "Цвет серая безысходность"
    private By greyColor=By.xpath(".//input[@id='grey']");
    //поле "Комментарий"
    private By comment=By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //кнопка "Заказать"
    private By orderButton=By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    public OrderPageObject2(WebDriver driver) {
    this.driver=driver;
    }

    public void inputDate(String newDate){
        driver.findElement(date).sendKeys(newDate);
        driver.findElement(date).sendKeys(Keys.ENTER);
    }

    public void inputPeriod(int days){
        driver.findElement(period).click();
        if (days==1) {
            driver.findElement(period_1day).click();
        } else if (days==2) {
            driver.findElement(period_2days).click();
        } else if (days==3) {
            driver.findElement(period_3days).click();
        } else if (days==4) {
            driver.findElement(period_4days).click();
        } else if (days==5) {
            driver.findElement(period_5days).click();
        } else if (days==6) {
            driver.findElement(period_6days).click();
        } else if (days==7) {
            driver.findElement(period_7days).click();
        }
    }

    public void clickBlackColor(){
        driver.findElement(blackColor).click();
    }

    public void clickGreyColor() {
        driver.findElement(greyColor).click();
    }

    public void chooseColor(String newColor) {
        if (newColor.equals("black")) {
            clickBlackColor();
        } else if (newColor.equals("grey")) {
            clickGreyColor();
        }
    }

    public void inputComment(String newComment){
        driver.findElement(comment).sendKeys(newComment);
    }

    public void clickOrderButton(){
        driver.findElement(orderButton).click();
    }

    public void fillOrderPage2(String newDate,int days, String newColor,String newComment){
        inputDate(newDate);
        inputPeriod(days);
        chooseColor(newColor);
        inputComment(newComment);
        clickOrderButton();
    }

}
