package tests;

import org.testng.annotations.BeforeMethod;
import pages.CommonElements;

import static driverFactory.LocalDriverFactory.driver;
import static org.openqa.selenium.support.PageFactory.initElements;
import static org.testng.AssertJUnit.assertTrue;

public class DeletionTests {

    @BeforeMethod
    public void ensurePrecondition() {
        CommonElements commonElements = initElements(driver, CommonElements.class);
   //    if commonElements.getCheckoutButtonInfo().contains("0 item(s)");
    }
}
