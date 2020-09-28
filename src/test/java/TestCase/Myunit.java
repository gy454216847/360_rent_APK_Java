package TestCase;

import core.CommonFunApp;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import page.MainPage;


import java.io.FileNotFoundException;
import java.net.MalformedURLException;



/** @author YGan */
public class Myunit extends MainPage {

  public CommonFunApp getDriver(){
    return driver;
  }

  @BeforeTest
  public void setUp() throws FileNotFoundException,MalformedURLException{


    driver.startApp();
  }

  @AfterTest
  public void tearDown() {
    driver.closeApp();
  }
}
