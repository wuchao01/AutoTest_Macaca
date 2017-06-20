package com.uitest.macacaautotest.base;

/**
 * Created by wuchao on 2017/4/17.
 */
public class BasePage {
    public String pageDesc;
    public BaseClass driver;

    public BasePage(String pageDesc) {
        this.pageDesc = pageDesc;
    }

    public BasePage(String pageDesc,BaseClass driver){
        this.pageDesc = pageDesc;
        this.driver = driver;
    }

    public void setDriver(BaseClass driver){
        this.driver = driver;
    }

    public BaseClass getDriver(){
        return driver;
    }

}
