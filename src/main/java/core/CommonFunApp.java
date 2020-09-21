package core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * @author YGan
 */
public class CommonFunApp {
    static AndroidDriver driver;
    public static final Log log = LogFactory.getLog(CommonFunApp.class);
    static int timeout = Integer.parseInt(GlobalSettings.timeout);









    public static AndroidDriver<MobileElement> startApp() throws FileNotFoundException, MalformedURLException {


        Yaml yaml = new Yaml();
        File yamlFile = new File("src/main/java/data/360_rent_APK_caps.yaml");
        Map<String, String> data = (Map<String, String>) yaml.load(new FileInputStream(yamlFile));
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", data.get("platformName").toString());
        desiredCapabilities.setCapability("platformVersion", data.get("platformVersion").toString());
        desiredCapabilities.setCapability("deviceName", data.get("deviceName").toString());
        desiredCapabilities.setCapability("appname", data.get("appname").toString());
        desiredCapabilities.setCapability("app", data.get("app").toString());
        desiredCapabilities.setCapability("noReset", data.get("noReset").toString());
        desiredCapabilities.setCapability("unicodeKeyboard", data.get("unicodeKeyboard").toString());
        desiredCapabilities.setCapability("resetKeyboard", data.get("resetKeyboard").toString());
        desiredCapabilities.setCapability("appPackage", data.get("appPackage").toString());
        desiredCapabilities.setCapability("appActivity", data.get("appActivity").toString());
        driver =
                new AndroidDriver(
                        new URL("http://" + data.get("ip").toString() + ":" + data.get("port").toString() + "/wd/hub"),
                        desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       return driver;
    }


    public  WebElement getElement(String xpath) throws knifeException{
        if (xpath.contains("=>") == false) {
            throw new knifeException("Positioning syntax errors, lack of '=>'.");
        }

        String by = xpath.split("=>")[0];
        String value = xpath.split("=>")[1];

        if (by.equals("id")) {
            WebElement element = driver.findElement(By.id(value));
            return element;
        } else if (by.equals("name")) {
            WebElement element = driver.findElement(By.name(value));
            return element;
        } else if (by.equals("class")) {
            WebElement element = driver.findElement(By.className(value));
            return element;
        } else if (by.equals("linkText")) {
            WebElement element = driver.findElement(By.linkText(value));
            return element;
        } else if (by.equals("xpath")) {
            WebElement element = driver.findElement(By.xpath(value));
            return element;
        } else if (by.equals("css")) {
            WebElement element = driver.findElement(By.cssSelector(value));
            return element;
        } else {
            throw new knifeException("Please enter the correct targeting elements,'id','name','class','xpath','css'.");
        }
    }


    public void waitElement(String xpath, int second) throws knifeException {

        if (xpath.contains("=>") == false) {
            throw new knifeException("Positioning syntax errors, lack of '=>'.");
        }

        String by = xpath.split("=>")[0];
        String value = xpath.split("=>")[1];
        By findelement = null;

        if (by.equals("id")) {
            findelement = By.id(value);
        } else if (by.equals("name")) {
            findelement = By.name(value);
        } else if (by.equals("class")) {
            findelement = By.className(value);
        } else if (by.equals("linkText")) {
            findelement = By.linkText(value);
        } else if (by.equals("xpath")) {
            findelement = By.xpath(value);
        } else if (by.equals("css")) {
            findelement = By.cssSelector(value);
        } else {
            throw new knifeException("Please enter the correct targeting elements,'id','name','class','xpath','css'.");
        }
        new WebDriverWait(driver, second).until(ExpectedConditions
                .presenceOfElementLocated(findelement));
    }
    public  void click(String xpath) throws knifeException {

        waitElement(xpath, timeout);
        WebElement element = getElement(xpath);
        try {
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public  void type(String xpath, String text) throws knifeException {

        waitElement(xpath, timeout);
        WebElement element = getElement(xpath);

        try {
            element.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            element.sendKeys(text);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public  void closeApp() {
        driver.closeApp();
    }
    public  String getText(String xpath) throws knifeException {
        WebElement element = getElement(xpath);
        return element.getText();
    }
    public  String getTitle() {
        return driver.getTitle();
    }
    public boolean isElementDisplayed(String xpath) throws knifeException{

        WebElement element = getElement(xpath);
        String name = element.getText();
        if (element.isDisplayed()){
            System.out.println(name + "--"+"元素存在");
            return true;
        }
        else
        {System.out.println(name + "--" + "元素不存在");
            return false;

        }


    }

}



