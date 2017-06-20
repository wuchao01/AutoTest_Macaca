package com.uitest.macacaautotest.base;

import macaca.client.common.GetElementWay;

/**
 * Created by wuchao on 2017/4/17.
 */
public class PageCommonUI {
    public GetElementWay androidBy;
    public String androidValue;
    public GetElementWay iosBy;
    public String iosValue;
    public String elementDesc;

    /**
     * 当安卓 ios两个平台对应同一控件的获取方式不一致时使用本构造函数
     * @param androidBy 获取安卓对应控件的方式
     * @param androidValue 获取安卓对应控件的值
     * @param iosBy 获取ios对应控件的方式
     * @param iosValue 获取ios对应控件的值
     */
    public PageCommonUI(GetElementWay androidBy, String androidValue, GetElementWay iosBy, String iosValue, String elementDesc){
        this.androidBy = androidBy;
        this.androidValue = androidValue;
        this.iosBy = iosBy;
        this.iosValue = iosValue;
        this.elementDesc = elementDesc;
    }

    /**
     * 构造函数，用于ios&android两个平台获取UI一致的情况
     * @param commonBy 统一获取控件方式
     * @param commonValue 统一获取控件值
     */
    public PageCommonUI(GetElementWay commonBy, String commonValue, String elementDesc){
        this.androidBy = commonBy;
        this.androidValue = commonValue;
        this.iosBy = commonBy;
        this.iosValue = commonValue;
        this.elementDesc = elementDesc;
    }

    public GetElementWay getAndroidBy() {
        return androidBy;
    }
    public void setAndroidBy(GetElementWay androidBy) {
        this.androidBy = androidBy;
    }
    public String getAndroidValue() {
        return androidValue;
    }
    public void setAndroidValue(String androidValue) {
        this.androidValue = androidValue;
    }
    public GetElementWay getIosBy() {
        return iosBy;
    }
    public void setIosBy(GetElementWay iosBy) {
        this.iosBy = iosBy;
    }
    public String getIosValue() {
        return iosValue;
    }
    public void setIosValue(String iosValue) {
        this.iosValue = iosValue;
    }

    public String getElementDesc() {
        return elementDesc;
    }

    public void setElementDesc(String elementDesc) {
        this.elementDesc = elementDesc;
    }
}
