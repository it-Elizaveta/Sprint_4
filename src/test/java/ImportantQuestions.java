import PageObject.QuestionsPageObject;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ImportantQuestions {
    private WebDriver driver;
    private final String driverType;
    private final int buttonIndex;

    public ImportantQuestions(String driverType, int buttonIndex){
        this.driverType=driverType;
        this.buttonIndex=buttonIndex;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][] {
                {"Chrome",0},
                {"Chrome",1},
                {"Chrome",2},
                {"Chrome",3},
                {"Chrome",4},
                {"Chrome",5},
                {"Chrome",6},
                {"Chrome",7},
                {"Firefox",0},
                {"Firefox",1},
                {"Firefox",2},
                {"Firefox",3},
                {"Firefox",4},
                {"Firefox",5},
                {"Firefox",6},
                {"Firefox",7},
        };
    }

    @Test
    public void contentIsVisibleWhenClickedButton(){
        //выбрать браузер: Chrome или Firefox
        if (driverType.equals("Chrome")) {
            driver = new ChromeDriver();
        } else if (driverType.equals("Firefox")) {
            driver = new FirefoxDriver();
        }

        driver.get("https://qa-scooter.praktikum-services.ru/");

        QuestionsPageObject objQuestionsPage = new QuestionsPageObject(driver);

        objQuestionsPage.clickButton(buttonIndex);

        assertEquals(true,objQuestionsPage.contentIsDisplayed(buttonIndex));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
