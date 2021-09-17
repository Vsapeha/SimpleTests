package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;

public class PageBase{
    protected WebDriver driver;

    public PageBase(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }
}
