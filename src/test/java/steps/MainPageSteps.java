package steps;

import core.CommonFunApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.*;

import static org.testng.Assert.*;


public class MainPageSteps {
    static CommonFunApp driver = new CommonFunApp();
    @Given("I open the app")
    public void iOpenTheApp() throws Exception{
        driver.startApp();
    }

    @When("I click eye button")
    public void iClickEyeButton() throws Exception {
        driver.click(MainPage.eye_btn);
    }

    @Then("Account balance Will be hidden")
    public void accountBalanceWillBeHidden() throws Exception{
        assertEquals(driver.getText(MainPage.totalAccount_loc),"****");
}



    @Then("I can see help information")
    public void iCanSeeHelpInformation() throws Exception {
        assertEquals(driver.getText(MainPage.income_help_content_loc),MainPage.income_help_content);
    }

    @When("I click income help button")
    public void iClickIncomeHelpButton() throws Exception{
        driver.click(MainPage.income_help_btn_loc);
    }

    @When("I click my bill button")
    public void iClickMyBillButton() throws Exception {
        driver.click(MainPage.my_bill_btn_loc);

    }

    @Then("I can enter my bill page")
    public void iCanEnterMyBillPage() throws Exception{
        assertTrue(driver.isElementDisplayed(BillPage.bill_title_loc));
        assertEquals(driver.getText(BillPage.bill_title_loc),BillPage.bill_title_content);
    }

    @When("I click bonus button")
    public void iClickBonusButton() throws Exception{
        driver.click(MainPage.my_bonus_btn_loc);

    }

    @Then("I can enter bonus page")
    public void iCanEnterBonusPage() throws Exception{
        assertEquals(driver.getText(BonusPage.bonus_title_loc),BonusPage.bonus_title);

    }

    @When("I click bonus help button")
    public void iClickBonusHelpButton() throws Exception{
        driver.click(BonusPage.bonus_help_btn);
    }

    @Then("I can see bonus help information")
    public void iCanSeeBonusHelpInformation() throws Exception {
        assertEquals(driver.getText(BonusPage.bonus_help_content_loc),BonusPage.bonus_help_content);
    }

    @When("I click my house button")
    public void iClickMyHouseButton() throws Exception{
        driver.click(MainPage.my_house_btn_loc);
    }

    @Then("I can enter my house page")
    public void iCanEnterMyHousePage() throws Exception{
        assertEquals(driver.getText(HousePage.my_house_title_loc),HousePage.my_house_title);

    }

    @When("I click my tenant button")
    public void iClickMyTenantButton() throws Exception{
        driver.click(MainPage.my_tenant_btn_loc);
    }

    @Then("I can enter my tenant page")
    public void iCanEnterMyTenantPage() throws Exception{
        assertEquals(driver.getText(TenantPage.my_tenant_titile_loc),TenantPage.my_tenant_title_content);
    }

    @When("I click my add button")
    public void iClickMyAddButton() throws Exception{
        driver.click(MainPage.my_add_btn_loc);
    }

    @Then("I can enter my add page")
    public void iCanEnterMyAddPage() throws Exception{
        assertEquals(driver.getText(AddPage.buy_lock_btn_loc),AddPage.buy_lock_btn_content);
        assertEquals(driver.getText(AddPage.add_lock_btn_loc),AddPage.add_lock_btn_content);
    }
}
