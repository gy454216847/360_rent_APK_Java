package page;

import core.CommonFunApp;
import core.knifeException;

import static page.MainPage.my_bonus_btn_loc;

public class BonusPage {
    public static CommonFunApp driver = new CommonFunApp();
    public static String bonus_title_loc = "xpath=>/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView";
    public static String bonus_title = "我的收益";
    public static String bonus_help_btn = "id=>com.lansent.renting:id/main_home_my_earnings_help_iv";
    public static String bonus_help_content_loc = "id=>com.lansent.renting:id/dialog_content_tv";
    public static String bonus_help_content = "1.您的收益来源于您的房屋出租后，租客注册成为我们合作伙伴产品的用户，并由此产生的获客收益，请放心收取 \n" +
            "2.您的收益提现功能正在开发中，敬请期待，您也可以联系我们的客服人员操作提现，详询: 4000545666";

    public static void click_bonus_help() throws knifeException {
        driver.click(my_bonus_btn_loc);
        driver.click(bonus_help_btn);
    }


}
