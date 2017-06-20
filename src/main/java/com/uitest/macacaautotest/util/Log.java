package com.uitest.macacaautotest.util;

import org.apache.log4j.*;
import java.lang.*;
import java.io.File;

/**
 * Created by wuchao on 17/4/5.
 */
public class Log {
    private static Logger logger;
    private static Logger logger1;
    private static String filePath = "src/main/resources/log4j.properties";

    //静态代码块，jvm只执行一次
    static {
        //logger = Logger.getLogger(Log.class.getName());
        logger = Logger.getLogger("dev_log");
        logger1 = Logger.getLogger("macaca_log");
        PropertyConfigurator.configure(new File(filePath).getAbsolutePath());
    }

    /**
     * 记录Info级别日志。
     *
     * @param message the message object.
     */
    public static void logInfo(Object message) {
        logger.info("[INFO] " + message);
        //Reporter.log(new Tools().getSimpleDateFormat() + " : " + "[INFO] " + message);
    }

    /**
     * 记录Error级别日志。
     *
     * @param message the message object.
     */
    public static void logError(Object message) {
        logger.error("[ERROR] " + message);
        //Reporter.log(new Tools().getSimpleDateFormat() + " : " + "[ERROR]   " + message);
    }

    /**
     * 记录Warn级别日志。
     *
     * @param message the message object.
     */
    public static void logWarn(Object message) {
        logger.warn("[WARN] " + message);
        //Reporter.log(new Tools().getSimpleDateFormat() + " : " + "[WARN] " + message);
    }

    /*public static void main(String[] args) {
        Log.test("test","test1","test2");
        Log.logInfo("info");
        Log.logError("error");
        Log.logWarn("warn");
        logger1.info("macaca_info");
    }*/
}
