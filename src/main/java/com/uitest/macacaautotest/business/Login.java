package com.uitest.macacaautotest.business;

import com.uitest.macacaautotest.base.BaseClass;
import com.uitest.macacaautotest.page.LoginPage;
import macaca.client.MacacaClient;

/**
 * Created by wuchao on 2017/4/17.
 */
public class Login extends BaseClass{
    private String pageDesc;
    public Login(String pageDesc,MacacaClient driver,String platformName){
        super(driver,platformName);
        this.pageDesc = pageDesc;
    }

    //登录操作
    public void userNameAndPasswordLogin(String userName,String passWord){
        this.input(LoginPage.USER_NAME,userName);
        this.input(LoginPage.PASSWORD,passWord);
        this.onClick(LoginPage.KEY_BOARD);
        this.onClick(LoginPage.LOGIN_BTN);
    }
}
