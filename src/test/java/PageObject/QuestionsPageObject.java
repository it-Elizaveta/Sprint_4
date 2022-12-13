package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QuestionsPageObject {
    private WebDriver driver;
    //Кнопка выпадающего списка [0]я
    private By button_0=By.id("accordion__heading-0");
    //Кнопка выпадающего списка [1]я
    private By button_1=By.id("accordion__heading-1");
    //Кнопка выпадающего списка [2]я
    private By button_2=By.id("accordion__heading-2");
    //Кнопка выпадающего списка [3]я
    private By button_3=By.id("accordion__heading-3");
    //Кнопка выпадающего списка [4]я
    private By button_4=By.id("accordion__heading-4");
    //Кнопка выпадающего списка [5]я
    private By button_5=By.id("accordion__heading-5");
    //Кнопка выпадающего списка [6]я
    private By button_6=By.id("accordion__heading-6");
    //Кнопка выпадающего списка [7]я
    private By button_7=By.id("accordion__heading-7");
    //Содержимое выпадающего списка [0]е
    private By content_0=By.xpath(".//div[@id='accordion__panel-0']/p");
    //Содержимое выпадающего списка [1]е
    private By content_1=By.xpath(".//div[@id='accordion__panel-1']/p");
    //Содержимое выпадающего списка [2]е
    private By content_2=By.xpath(".//div[@id='accordion__panel-2']/p");
    //Содержимое выпадающего списка [3]е
    private By content_3=By.xpath(".//div[@id='accordion__panel-3']/p");
    //Содержимое выпадающего списка [4]е
    private By content_4=By.xpath(".//div[@id='accordion__panel-4']/p");
    //Содержимое выпадающего списка [5]е
    private By content_5=By.xpath(".//div[@id='accordion__panel-5']/p");
    //Содержимое выпадающего списка [6]е
    private By content_6=By.xpath(".//div[@id='accordion__panel-6']/p");
    //Содержимое выпадающего списка [7]е
    private By content_7=By.xpath(".//div[@id='accordion__panel-7']/p");

    //Массив локаторов кнопок
    private By[] buttonLocatorsArray= {button_0,button_1,button_2,button_3,button_4,button_5,button_6,button_7};

    //Массив локаторов контента (локаторов содержимого в выпадающих списках)
    private By[] contentLocatorsArray= {content_0,content_1,content_2,content_3,content_4,content_5,content_6,content_7};

    //Массив ожидаемого контента (текста содержимого в выпадающих списках)
    private String[] expectedContentTextArray={"Сутки — 400 рублей. Оплата курьеру — наличными или картой.","Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.","Только начиная с завтрашнего дня. Но скоро станем расторопнее.", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", "Да, обязательно. Всем самокатов! И Москве, и Московской области."};

    public QuestionsPageObject(WebDriver driver) {
        this.driver=driver;
    }

    public void clickButton (int buttonIndex){
        By locator=buttonLocatorsArray[buttonIndex];

        WebElement element=driver.findElement(locator);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();" , element);

        driver.findElement(locator).click();
    }

    public String getContentText (int buttonIndex){
        By locator=contentLocatorsArray[buttonIndex];
        return driver.findElement(locator).getText();
    }

    public boolean contentIsDisplayed (int buttonIndex) {
        By locator = contentLocatorsArray[buttonIndex];
        String expectedContentText = expectedContentTextArray[buttonIndex];
        return driver.findElement(locator).isDisplayed() && getContentText(buttonIndex).equals(expectedContentText);
    }
 }

