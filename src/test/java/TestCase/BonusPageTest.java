package TestCase;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
import static page.BonusPage.*;

public class BonusPageTest extends Myunit{
    @Test
    public void bonus_help() throws InterruptedException{
        click_bonus_help();
        assertEquals(driver.getText(bonus_help_content_loc),bonus_help_content);
    }
}
