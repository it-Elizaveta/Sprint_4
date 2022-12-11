import PageObject.*;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MakeOrder {
    private WebDriver driver;
    private final String driverType;
    private final String buttonLocation;
    private final String newName;
    private final String newSurname;
    private final String newAddress;
    private final String newMetro;
    private final String newTelNumber;
    private final String newDate;
    private final int days;
    private final String newColor;
    private final String newComment;

    public MakeOrder(String driverType,String buttonLocation,String newName,String newSurname,String newAddress,String newMetro,String newTelNumber, String newDate,int days,String newColor, String newComment){
        this.driverType=driverType;
        this.buttonLocation=buttonLocation;
        this.newName=newName;
        this.newSurname=newSurname;
        this.newAddress=newAddress;
        this.newMetro=newMetro;
        this.newTelNumber=newTelNumber;
        this.newDate=newDate;
        this.days=days;
        this.newColor=newColor;
        this.newComment=newComment;
    }

    @Parameterized.Parameters
    public static Object[][] newOrderData(){
        return new Object[][] {
                {"Chrome","lower","Елизавета","Агзамова","Москва","Деловой центр", "+79872539683","12.12.2022",6,"grey","Мур-Мур"},
                {"Chrome","upper","Иван","Иванов","Дрожжино","Дмитрия Донского", "+79872539688","13.12.2022",2,"black","Гав-Гав"},
                {"Firefox","lower","Елизавета","Агзамова","Москва","Деловой центр", "+79872539683","12.12.2022",6,"grey","Мур-Мур"},
                {"Firefox","upper","Иван","Иванов","Дрожжино","Дмитрия Донского", "+79872539688","13.12.2022",2,"black","Гав-Гав"},
        };
    }

    @Test
    public void successfullyOrderInChrome (){


        //выбрать браузер: Chrome или Firefox
        if (driverType=="Chrome") {
            driver = new ChromeDriver();
        } else if (driverType=="Firefox") {
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePageObject objHomePage = new HomePageObject(driver);
        //Согласиться с куки
        objHomePage.cookieButtonClick();

        //нажать кнопку Заказа сверху или снизу
        objHomePage.chooseOrderButtonAndClick(buttonLocation);

        //Заполнить стр.1
        OrderPageObject1 objOrderPage1 = new OrderPageObject1(driver);
        objOrderPage1.fillOrderPage1(newName, newSurname, newAddress, newMetro, newTelNumber);

        //Заполнить стр.2
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        OrderPageObject2 objOrderPage2 = new OrderPageObject2(driver);
        objOrderPage2.fillOrderPage2(newDate,days, newColor,newComment);

        //Заполнить стр.3
        OrderPageObject3 objOrderPage3 = new OrderPageObject3(driver);
        objOrderPage3.clickOkButton();

        //Проверить, что появилось сообщение об успешном создании заказа
        ResultPageObject objResultPage = new ResultPageObject(driver);
        assertEquals("Заказ оформлен",objResultPage.getResultMessage());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
