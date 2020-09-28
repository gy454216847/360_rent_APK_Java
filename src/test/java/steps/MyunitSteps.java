package steps;

import io.cucumber.java.After;
import page.MainPage;

public class MyunitSteps {
    @After
    public void tearDown() {
        MainPage.driver.closeApp();
    }
}
