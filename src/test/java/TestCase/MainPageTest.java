package TestCase;

import core.CommonFunApp;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static page.BillPage.*;
import static page.BonusPage.bonus_title;
import static page.BonusPage.bonus_title_loc;
import static page.HousePage.my_house_title;
import static page.HousePage.my_house_title_loc;
import static page.TenantPage.my_tenant_titile_loc;
import static page.TenantPage.my_tenant_title_content;
import static page.AddPage.buy_lock_btn_loc;

/**
 * @author YGan
 */
public class MainPageTest extends Myunit{

  @Test
  public void hint_Account() throws InterruptedException {
    hintAccount();
    assertEquals(driver.getText(totalAccount_loc),"****");

  }

  @Test
  public void help_income() throws InterruptedException{
    incomeHelp();
    assertEquals(driver.getText(income_help_content_loc),income_help_content);

  }

  @Test
  public void enter_my_bill() throws InterruptedException{
    clickBill();
    assertEquals(driver.getText(bill_title_loc),bill_title_content);
  }

  @Test
  public void enter_my_bonus() throws InterruptedException{
    clickBonus();
    assertEquals(driver.getText(bonus_title_loc),bonus_title);
  }

  @Test
  public void enter_my_house() throws InterruptedException{
    clickHouse();
    assertEquals(driver.getText(my_house_title_loc),my_house_title);
  }

  @Test
  public void enter_my_tenant() throws InterruptedException{
    clickTenant();
    assertEquals(driver.getText(my_tenant_titile_loc),my_tenant_title_content);
  }

  @Test
  public void enter_my_add() throws InterruptedException{
    clickAdd();
    assertTrue(driver.isElementDisplayed(buy_lock_btn_loc));

  }
}
