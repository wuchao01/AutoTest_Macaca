package com.uitest.macacaautotest.testcase;

import com.uitest.macacaautotest.base.BaseTest;
import com.uitest.macacaautotest.business.Login;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by wuchao on 2017/5/3.
 */
public class LoginTest extends BaseTest{
    @Parameters({"userName","passWord"})
    @Test
    public void test_userNameAndPasswordLogin(String userName,String passWord) {
        Login login = new Login("登录页",driver,platformName);
        login.userNameAndPasswordLogin(userName,passWord);
    }

}
