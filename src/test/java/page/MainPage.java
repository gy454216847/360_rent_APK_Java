package page;

import core.CommonFunApp;
import core.knifeException;

public class MainPage {
    public static CommonFunApp driver = new CommonFunApp();
    public static String eye_btn = "id=>com.lansent.renting:id/main_home_income_eye_iv";
    public static String totalAccount_loc = "id=>com.lansent.renting:id/main_home_total_income_tv";
    public static String income_help_btn_loc = "id=>com.lansent.renting:id/main_home_income_help_iv";
    public static String income_help_content_loc = "id=>com.lansent.renting:id/dialog_content_tv";
    public static String income_help_content = "统计一个自然年（12个月）内，由租房产生的收益减去支出的总和";
    public static String my_bill_btn_loc = "id=>com.lansent.renting:id/main_home_my_bill_tv";
    public static String my_bonus_btn_loc = "id=>com.lansent.renting:id/main_home_dividends_text_tv";
    public static String my_house_btn_loc = "id=>com.lansent.renting:id/main_home_my_house_iv";
    public static String my_tenant_btn_loc = "id=>com.lansent.renting:id/main_home_my_tenant_iv";
    public static String my_add_btn_loc = "id=>com.lansent.renting:id/main_home_top_add_iv";

    public static void hintAccount() throws knifeException {
        driver.click(eye_btn);
    }

    public static void incomeHelp() throws knifeException {
        driver.click(income_help_btn_loc);
    }

    public static void clickBill() throws knifeException {
        driver.click(my_bill_btn_loc);
    }

    public static void clickBonus() throws knifeException {
        driver.click(my_bonus_btn_loc);
    }

    public static void clickHouse() throws knifeException {
        driver.click(my_house_btn_loc);
    }

    public static void clickTenant() throws knifeException {
        driver.click(my_tenant_btn_loc);
    }

    public static void clickAdd() throws knifeException {
        driver.click(my_add_btn_loc);
    }


}
