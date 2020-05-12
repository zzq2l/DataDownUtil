package com.jiurun.data.down.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jiurun.data.down.entity.DataDownDO;
import com.jiurun.data.down.entity.DeviceInfo;
import com.jiurun.data.down.entity.DownEntity;
import com.utils.Constant;
import com.utils.HttpsUtil;
import com.utils.JsonUtil;
import com.utils.StreamClosedHttpResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;

import java.text.DecimalFormat;
import java.util.*;

/**
 * @Package: com.jiurn.data.down.util
 * @ClassName: DataDownUtil
 * @Author: ${zhouzhiqiang}
 * @Date: 27/7/2019 14:43
 */
public class DataDownUtil {

    public static String setDownData(DataDownDO dataDownDO, DeviceInfo deviceInfo) throws Exception {
        HttpsUtil httpsUtil = new HttpsUtil();

        try {
            httpsUtil.initSSLConfigForTwoWay();
        } catch (Exception var34) {
            var34.printStackTrace();
        }

        String accessToken = login(httpsUtil);
        Class<?> userClass = Class.forName("com.utils.Constant");
        Constant userEntity = (Constant)userClass.newInstance();
        String urlCreateDeviceCommand = Constant.CREATE_DEVICE_CMD();
        String appId = Constant.APPID();
        String callbackUrl = Constant.REPORT_CMD_EXEC_RESULT_CALLBACK_URL();
        String deviceId = deviceInfo.getOneNetDeviceId();
        Integer expireTime = 0;
        Integer maxRetransmit = 3;
        String serviceId = "Transmission";
        String serviceId1 = "IOTPlatForm";
        String method = "CONFIG_PARAGRAM";
        String method1 = "CLOUD_COMMOND";
        String THRESHOLD = "200";
        String DETECTINTERVAL;
        if (deviceInfo != null && deviceInfo.getDeviceType() != null && !StringUtils.isEmpty(dataDownDO.getDataDownValue().trim())) {
            if (deviceInfo.getDeviceType() == 7) {
                DecimalFormat df = new DecimalFormat("#0");
                double da = Double.parseDouble(dataDownDO.getDataDownValue()) * 66.6D + 50.0D;
                DETECTINTERVAL = df.format(da);
                THRESHOLD = DETECTINTERVAL;
            } else if (deviceInfo.getDeviceType() == 6) {
                double da = Double.parseDouble(dataDownDO.getDataDownValue()) * 125.0D + 50.0D;
                THRESHOLD = da + "";
            }
        }

        String IMEI = deviceInfo.getDeviceId() + "";
        String IMSI = deviceInfo.getOneNetIMSI() + "";
        String SENSORLEVEL = "255";
        DETECTINTERVAL = "2";
        String WINDOWSOPENTIME = "300";
        String TIMEINTERVAL = "480";
        if (dataDownDO.getTimeInterval() != null) {
            TIMEINTERVAL = Double.parseDouble(dataDownDO.getTimeInterval()) * 60.0D + "";
        }

        DownEntity downEntity = new DownEntity();
        String dez = null;
        Double multiple = null;
        DecimalFormat df;
        String date;
        if (!"6-1".equals(deviceInfo.getSmallDeviceType())
                && !"7-1".equals(deviceInfo.getSmallDeviceType())
                && !"6-2".equals(deviceInfo.getSmallDeviceType())
                && !"7-2".equals(deviceInfo.getSmallDeviceType())) {
            dez = "{WINDOWOPENTIME:" + WINDOWSOPENTIME + ",IMEI:" + IMEI + ",THRESHOLD:" + THRESHOLD + ",DETECTINTERVAL:" + DETECTINTERVAL + ",SENSORLEVEL:" + SENSORLEVEL + ",TIMEINTERVAL:" + TIMEINTERVAL + ",IMSI:" + IMSI + "}";
        } else {
            if ("6-1".equals(deviceInfo.getSmallDeviceType())) {
                multiple = 80.0D;
            } else if ("6-2".equals(deviceInfo.getSmallDeviceType())){
                multiple = 125.0D;
            }else {
                multiple = 66.7D;
            }

            df = new DecimalFormat("#0");
            Double da = null;
            String i = null;
            date = null;
            if (!StringUtils.isEmpty(dataDownDO.getLowerLimit().trim())) {
                da = Double.parseDouble(dataDownDO.getLowerLimit()) * multiple + 50.0D;
                i = intToHex(Integer.parseInt(df.format(da)));
                i = StringUtils.leftPad(i + "", 2, '0');
                date = i;
            } else {
                da = 50.0D;
                i = intToHex(Integer.parseInt(df.format(da)));
                i = StringUtils.leftPad(i + "", 2, '0');
                date = i;
            }

            if (!StringUtils.isEmpty(dataDownDO.getUpperLimit().trim())) {
                da = Double.parseDouble(dataDownDO.getUpperLimit()) * multiple + 50.0D;
                i = intToHex(Integer.parseInt(df.format(da)));
                i = StringUtils.leftPad(i + "", 2, '0');
                date = date + i;
            } else {
                da = 250.0D;
                i = intToHex(Integer.parseInt(df.format(da)));
                i = StringUtils.leftPad(i + "", 2, '0');
                date = date + i;
            }

            Integer DetectInterval = 600;
            date = getString(date, DetectInterval);
            Integer TimeInterval = 28800;
            if (dataDownDO.getTimeInterval() != null) {
                TimeInterval = Integer.parseInt(Double.parseDouble(dataDownDO.getTimeInterval()) * 60.0D * 60.0D + "");
            }

            date = getString(date, TimeInterval);
            Integer WINDOWSOPENTIM = 300;
            date = getString(date, WINDOWSOPENTIM);
            Integer CRQ = 0;
            date = getString(date, CRQ);
            downEntity.setRawData(date);
        }

        df = null;
        Map<String, Object> paramCommand = new HashMap();
        JSONObject jsonObject;
        if (!"6-1".equals(deviceInfo.getSmallDeviceType()) && !"7-1".equals(deviceInfo.getSmallDeviceType())) {
            paramCommand.put("serviceId", serviceId);
            paramCommand.put("method", method);
            jsonObject = JSON.parseObject(dez);
        } else {
            jsonObject = (JSONObject)JSON.toJSON(downEntity);
            paramCommand.put("serviceId", serviceId1);
            paramCommand.put("method", method1);
        }

        paramCommand.put("paras", jsonObject);
        Map<String, Object> paramCreateDeviceCommand = new HashMap();
        paramCreateDeviceCommand.put("deviceId", deviceId);
        paramCreateDeviceCommand.put("command", paramCommand);
        paramCreateDeviceCommand.put("callbackUrl", callbackUrl);
        paramCreateDeviceCommand.put("expireTime", expireTime);
        paramCreateDeviceCommand.put("maxRetransmit", maxRetransmit);
        date = JsonUtil.jsonObj2Sting(paramCreateDeviceCommand);
        Map<String, String> header = new HashMap();
        header.put(Constant.HEADER_APP_KEY, appId);
        header.put(Constant.HEADER_APP_AUTH, "Bearer " + accessToken);
        HttpResponse responseCreateDeviceCommand = null;

        for(int i = 0; i < 4; ++i) {
            responseCreateDeviceCommand = httpsUtil.doPostJson(urlCreateDeviceCommand, header, date);
            Thread.sleep(2000L);
        }

        return responseCreateDeviceCommand.getStatusLine().getStatusCode() + "";
    }

    private static String getString(String date, Integer WINDOWSOPENTIM) {
        String WINDOWSOPENTI = intToHex(WINDOWSOPENTIM);
        WINDOWSOPENTI = StringUtils.leftPad(WINDOWSOPENTI + "", 4, '0');
        date = date + WINDOWSOPENTI;
        return date;
    }

    public static String login(HttpsUtil httpsUtil) throws Exception {
        String appId = Constant.APPID();
        String secret = Constant.SECRET();
        String urlLogin = Constant.APP_AUTH();
        Map<String, String> paramLogin = new HashMap();
        paramLogin.put("appId", appId);
        paramLogin.put("secret", secret);
        StreamClosedHttpResponse responseLogin = httpsUtil.doPostFormUrlEncodedGetStatusLine(urlLogin, paramLogin);
        Map<String, String> data = new HashMap();
        data = (Map)JsonUtil.jsonString2SimpleObj(responseLogin.getContent(), data.getClass());
        return (String)data.get("accessToken");
    }

    public static String intToHex(int n) {
        StringBuffer s = new StringBuffer();

        for(char[] b = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'}; n != 0; n /= 16) {
            s = s.append(b[n % 16]);
        }

        String a = s.reverse().toString();
        return a;
    }

    public static void main(String[] args) {
        int integer = Integer.parseInt("24", 16);
        char s = (char)integer;
        System.out.println(s);
    }
}
