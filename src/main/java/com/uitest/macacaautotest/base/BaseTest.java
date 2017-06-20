package com.uitest.macacaautotest.base;

import com.alibaba.fastjson.JSONObject;
import com.uitest.macacaautotest.util.Log;
import macaca.client.MacacaClient;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

/**
 * Created by wuchao on 2017/6/14.
 */
public class BaseTest {
    public MacacaClient driver = new MacacaClient();
    protected String platformName;
    @BeforeClass
    @Parameters({"platformVersion","deviceName","activity","platformName","appPath","udid","port"})
    public void setUp(String platformVersion,String deviceName,String activity,String platformName,String appPath,String udid,int port) throws Exception {
        JSONObject porps = new JSONObject();
        // 指定ios or android待测应用的安装包
        porps.put("app",appPath);
        Log.logInfo("开始测试！");
        this.platformName = platformName;
        if(this.platformName.toLowerCase().contains("ios")){
            porps.put("autoAcceptAlerts", true);
            porps.put("platformName",platformName);
            porps.put("platformVersion", platformVersion);
            porps.put("deviceName",deviceName);
            porps.put("udid",udid);
        }else{
            porps.put("platformVersion", platformVersion);
            porps.put("platformName",platformName);
            porps.put("deviceName",deviceName);
            porps.put("activity",activity);
        }
        JSONObject desiredCapabilities = new JSONObject();
        desiredCapabilities.put("desiredCapabilities", porps);
        driver.initDriver(desiredCapabilities);
        Log.logInfo("初始化测试套件完成！");
        //System.setProperty("deviceID",udid);
    }

    @AfterClass
    public void tearDown() throws Exception {
        try {
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
            Log.logError(e.getStackTrace());
        }
    }


}
