package com.uitest.macacaautotest.page;

import com.uitest.macacaautotest.base.PageCommonUI;
import macaca.client.common.GetElementWay;

/**
 * Created by wuchao on 2017/4/15.
 */
public class LoginPage{
    //登录页-用户名输入框
    public static final PageCommonUI USER_NAME = new PageCommonUI(GetElementWay.ID, "com.github.android_app_bootstrap:id/mobileNoEditText",GetElementWay.NAME,"please input username","用户名输入框");
    //登录页-密码输入框
    public static final PageCommonUI PASSWORD = new PageCommonUI(GetElementWay.ID,"com.github.android_app_bootstrap:id/codeEditText",GetElementWay.NAME,"please input password","密码输入框");
    //登录页-登录按钮
    public static final PageCommonUI LOGIN_BTN = new PageCommonUI(GetElementWay.ID,"com.github.android_app_bootstrap:id/login_button",GetElementWay.NAME,"Login","登录按钮");
    public static final PageCommonUI KEY_BOARD = new PageCommonUI(GetElementWay.NAME, "Done", "键盘完成按钮");

}
