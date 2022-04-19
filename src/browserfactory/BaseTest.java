package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    public static WebDriver driver; // public static webdriver variable created so it can be accessed globaly

    String herokuappUrl ="http://the-internet.herokuapp.com/login";

    public void openBrowser_HeroKuapp() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe"); // setting up driver properties
        driver = new ChromeDriver(); // creating chrome driver object
        driver.get(herokuappUrl);// opening Url received as method parameter
        driver.manage().window().maximize();// maximize window once opened    }

    }

    public void endProcedure(){

        driver.quit();

    }

}
