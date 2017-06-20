package com.uitest.macacaautotest.util;

import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * Created by wuchao on 2017/5/8.
 */
public class commUtil {
/*  private static String iosCmd = "instruments -s devices";
    private static String androidCmd = "adb devices";*/

    /**
     * 读取liunx命令
     * @param cmd 获取liunx命令的值
     */
    public static String exec(String cmd) {
        try {
            String[] cmdA = { "/bin/sh", "-c", cmd };
            Process process = Runtime.getRuntime().exec(cmdA);
            LineNumberReader br = new LineNumberReader(new InputStreamReader(
                    process.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                sb.append(line).append("\n");
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
