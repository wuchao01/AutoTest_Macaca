package com.uitest.macacaautotest.base;

import com.uitest.macacaautotest.util.Log;
import macaca.client.MacacaClient;
import macaca.client.commands.Element;

/**
 * Created by wuchao on 17/3/30.
 */

public class BaseClass{
    protected MacacaClient driver;
    protected String platformName;
    public BaseClass(MacacaClient driver,String platformName){
        this.platformName = platformName;
        this.driver = driver;
    }

    /**
     * 根据索引获取控件，当同样的控件可能存在多个时，查询返回的是一个数组，此时通过传入目标控件的索引获取指定控件
     * @param commonUI 要查找的控件
     * @throws Exception
     */
    public Element findElement(PageCommonUI commonUI) throws Exception {
        if(this.platformName.toLowerCase().contains("ios")){
            return driver.getElement(commonUI.getIosBy(),commonUI.getIosValue());
        }
        else {
            return driver.getElement(commonUI.getAndroidBy(),commonUI.getAndroidValue());
        }
    }

    /**
     * 根据索引获取控件，当同样的控件可能存在多个时，查询返回的是一个数组，此时通过传入目标控件的索引获取指定控件
     * @param commonUI 要查找的控件
     * @param index 目标控件index
     * @throws Exception
     */
    public Element findElement(PageCommonUI commonUI,int index) throws Exception {
        if(this.platformName.toLowerCase().contains("ios")){
            return driver.getElement(commonUI.getIosBy(),commonUI.getIosValue());
        }
        else {
            return driver.getElement(commonUI.getAndroidBy(),commonUI.getAndroidValue());
        }
    }

    /**
     * 点击某一个控件，执行操作为 查找控件-点击控件
     * @param commonUI 目标控件
     */
    public void onClick(PageCommonUI commonUI){
        try {
            if (this.isElementExist(commonUI)) {
                Element element = findElement(commonUI);
                element.click();
                Log.logInfo("点击：" + element);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.logError(e.getStackTrace());
        }
    }

    /**
     * 点击某一个控件，执行操作为 查找控件-点击控件
     * @param commonUI 目标控件
     * @param index 目标控件索引
     */
    public void onClick(PageCommonUI commonUI, int index){
        try {
            if (this.isElementExist(commonUI)) {
                Element element = findElement(commonUI, index);
                element.click();
                Log.logInfo("点击：" + element);
            }
        }
        catch (Exception e){
            e.printStackTrace();
            Log.logError(e.getStackTrace());
        }
    }

    /**
     * 在目标控件输入值
     * @param commonUI 目标控件
     * @param input 目标控件输入值
     */
    public void input(PageCommonUI commonUI,String input){
        try {
            if(isElementExistAfterWaiting(commonUI)) {
                Element element = findElement(commonUI);
                element.sendKeys(input);
                Log.logInfo("输入：" + element + " value:" + input);
            }else{
                Log.logError("未找到控件:" + driver.element.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.logError(e.getStackTrace());
        }
    }

    /**
     * 判断某个控件是否存在
     * @param commonUI
     * @return
     */
    public boolean isElementExist(PageCommonUI commonUI) {
        try {
            //System.out.println("platformName" + this.platformName);
            if(this.platformName.toLowerCase().contains("ios")) {
                return driver.isElementExist(commonUI.getIosBy(), commonUI.getIosValue());
            }
            else
            {
                return driver.isElementExist(commonUI.getAndroidBy(),commonUI.getAndroidValue());
            }

        } catch (Exception e) {
            Log.logError(e.getStackTrace());
            return false;
        }

    }

    /**
     * 判断某个控件是否存在
     * @param commonUI
     * @return
     */
    public boolean isElementExist(PageCommonUI commonUI,int index) {
        try {

            if(this.platformName.toLowerCase().contains("ios")) {
                return driver.isElementExist(commonUI.getIosBy(), commonUI.getIosValue(),index);
            }
            else
            {
                return driver.isElementExist(commonUI.getAndroidBy(),commonUI.getAndroidValue(),index);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Log.logError(e.getStackTrace());
            return false;
        }
    }


    /**
     * 是否存在目标控件，如果当前没有该控件，在给定时间内循环查询，查询间隔以及时长通过setWaitElementTimeInterval,setWaitElementTimeout可设置
     * @param commonUI
     * @return
     */
    public boolean isElementExistAfterWaiting(PageCommonUI commonUI) {
        try {
            if(this.isElementExist(commonUI)) {
                return true;
            } else {
                waitForElement(commonUI);
                return this.isElementExist(commonUI);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.logError(e.getStackTrace());
            return false;
        }
    }

    /**
     * 是否存在目标控件，如果当前没有该控件，在给定时间内循环查询，查询间隔以及时长通过setWaitElementTimeInterval,setWaitElementTimeout可设置
     * @param commonUI
     * @param index
     * @return
     */
    public boolean isElementExistAfterWaiting(PageCommonUI commonUI,int index) {
        try {
            if(this.isElementExist(commonUI,index)) {
                return true;
            } else {
                waitForElement(commonUI,index);
                return this.isElementExist(commonUI,index);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.logError(e.getStackTrace());
            return false;
        }
    }

    /**
     * 循环查找某个element，直到查找完毕
     * @param commonUI
     * @return
     * @throws Exception
     */
    public Element waitForElement(PageCommonUI commonUI) throws Exception {

        if(this.platformName.toLowerCase().contains("ios")) {
            return driver.waitForElement(commonUI.getIosBy(), commonUI.getIosValue());
        }
        else
        {
            return driver.waitForElement(commonUI.getAndroidBy(), commonUI.getAndroidValue());
        }
    }

    /**
     * 循环查找某个element,直到查找完毕，适用于当前控件存在多个时，按照索引查找
     * @param commonUI  要查找的控件
     * @param index 目标控件index
     * @throws Exception
     */
    public Element waitForElement(PageCommonUI commonUI,int index) throws Exception {
        if(this.platformName.toLowerCase().contains("ios")) {
            return driver.waitForElement(commonUI.getIosBy(), commonUI.getIosValue(),index);
        }
        else
        {
            return driver.waitForElement(commonUI.getAndroidBy(), commonUI.getAndroidValue(),index);
        }
    }

}
