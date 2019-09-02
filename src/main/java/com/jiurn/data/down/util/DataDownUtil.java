package com.jiurn.data.down.util;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.jiurn.data.down.entity.DataDownDO;
import com.jiurn.data.down.entity.DeviceInfo;
import com.utils.Constant;
import com.utils.HttpsUtil;
import com.utils.JsonUtil;
import com.utils.StreamClosedHttpResponse;
import net.sf.json.JSON;
import org.apache.http.HttpResponse;

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
        } catch (Exception e) {
            e.printStackTrace();
        }


        String accessToken = login(httpsUtil);
        Class<?> userClass = Class.forName("com.utils.Constant");
        Constant userEntity = (Constant) userClass.newInstance();
        String urlCreateDeviceCommand = userEntity.CREATE_DEVICE_CMD();
        String appId = Constant.APPID;
        String callbackUrl = Constant.REPORT_CMD_EXEC_RESULT_CALLBACK_URL();

        // String deviceId = "d559e740-009d-4ac6-adb9-10a79d54446f";TODO 测试使用
        //String deviceId = "d559e740-009d-4ac6-adb9-10a79d54446f"; //TODO 测试使用
        //String deviceId = "e1f4afde-be26-4887-91d2-018d83733c9d";
        //String deviceId = "e1f4afde-be26-4887-91d2-018d83733c9d";
        String deviceId = deviceInfo.getOneNetDeviceId();
        Integer expireTime = 0;
        Integer maxRetransmit = 3;
        String serviceId = "Transmission";
        String method = "CONFIG_PARAGRAM";

        String THRESHOLD = "200";
        // System.out.println("进来了"+dataDownDO+deviceInfo);
        if (deviceInfo != null && deviceInfo.getDeviceType() != null) {
            //设备参数值的封装
            if (deviceInfo.getDeviceType() == 7) {
                double da = Double.parseDouble(dataDownDO.getDataDownValue()) * 100 + 50;
                THRESHOLD = da + "";
            } else if (deviceInfo.getDeviceType() == 6) {
                double da = Double.parseDouble(dataDownDO.getDataDownValue()) * 125 + 50;
                THRESHOLD = da + "";
            }
        }

        //IMEI IMSI SENSORLEVEL DETECTINTERVAL WINDOWSOPENTIME
        String IMEI = deviceInfo.getDeviceId() + "";
        String IMSI = deviceInfo.getOneNetIMSI() + "";
        String SENSORLEVEL = 255 + "";
        String DETECTINTERVAL = 2 + "";
        String WINDOWSOPENTIME = 300 + "";
        String TIMEINTERVAL =  60 * 60  + "";
        if (dataDownDO.getTimeInterval() != null) {
            TIMEINTERVAL = Double.parseDouble( dataDownDO.getTimeInterval()) * 60  + "";   //修改时间传入格式,以小时为单位
        }
   /*     //TODO 测试使用
        String dez = "{" + "WINDOWOPENTIME" + ":" + 200 + ","
                + "IMEI" + ":" + "862458045530364" + ","`x
                + "THRESHOLD" + ":" + 5 + ","
                + "DETECTINTERVAL" + ":" + "2" + ","
                + "TIMEINTERVAL" + ":" + "5" + ","
                + "SENSORLEVEL " + ":" + "255" + ","
                + "IMSI" + ":" + "460111172522228" + "}";*/

        String dez = "{" +""+ "WINDOWOPENTIME" + ":" + WINDOWSOPENTIME + ","
                + "IMEI" + ":" + IMEI + ","
                + "THRESHOLD" + ":" + THRESHOLD + ","
                + "DETECTINTERVAL" + ":" + DETECTINTERVAL + ","
                + "SENSORLEVEL" + ":" + SENSORLEVEL + ","
                + "TIMEINTERVAL" + ":" + TIMEINTERVAL + ","
                + "IMSI" + ":" + IMSI + "}";

        com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSON.parseObject(dez);
      /*  ObjectNode paras = JsonUtil.convertObject2ObjectNode("{\"WINDOWOPENTIME\":\"300+\""
                + ",\"IMEI\":\"862458045530364\""
                + ",\"THRESHOLD\":\"150\""
                + ",\"SENSORLEVEL\":\"255\""
                + ",\"TIMEINTERVAL\":\"5\""
                + ",\"IMSI\":\"460111172522228\"}");*/

        Map<String, Object> paramCommand = new HashMap<>();
        paramCommand.put("serviceId", serviceId);
        paramCommand.put("method", method);
        paramCommand.put("paras", jsonObject);
        Map<String, Object> paramCreateDeviceCommand = new HashMap<>();
        paramCreateDeviceCommand.put("deviceId", deviceId);
        paramCreateDeviceCommand.put("command", paramCommand);
        paramCreateDeviceCommand.put("callbackUrl", callbackUrl);
        paramCreateDeviceCommand.put("expireTime", expireTime);
        paramCreateDeviceCommand.put("maxRetransmit", maxRetransmit);

        String jsonRequest = JsonUtil.jsonObj2Sting(paramCreateDeviceCommand);

        Map<String, String> header = new HashMap<>();
        header.put(Constant.HEADER_APP_KEY, appId);
        header.put(Constant.HEADER_APP_AUTH, "Bearer" + " " + accessToken);
        HttpResponse responseCreateDeviceCommand = null;
        for (int i = 0; i < 4; i++) {
            responseCreateDeviceCommand = httpsUtil.doPostJson(urlCreateDeviceCommand, header, jsonRequest);
            Thread.sleep(2000);
       }
        // String responseBody = httpsUtil.getHttpResponseBody(responseCreateDeviceCommand);
        // System.out.println(responseCreateDeviceCommand.getStatusLine().getStatusCode());
        /* System.out.println("CreateDeviceCommand, response content:");
        System.out.println(responseCreateDeviceCommand.getStatusLine());
        System.out.println(responseBody);
        System.out.println();*/
       /* System.out.println(responseCreateDeviceCommand.getStatusLine());
        System.out.println(responseBody);*/
        return responseCreateDeviceCommand.getStatusLine().getStatusCode() + "";
    }

    @SuppressWarnings("unchecked")
    public static String login(HttpsUtil httpsUtil) throws Exception {

        String appId = Constant.APPID();
        String secret = Constant.SECRET();
        String urlLogin = Constant.APP_AUTH();

        Map<String, String> paramLogin = new HashMap<>();
        paramLogin.put("appId", appId);
        paramLogin.put("secret", secret);
        StreamClosedHttpResponse responseLogin = httpsUtil.doPostFormUrlEncodedGetStatusLine(urlLogin, paramLogin);
        Map<String, String> data = new HashMap<>();
        data = JsonUtil.jsonString2SimpleObj(responseLogin.getContent(), data.getClass());
        return data.get("accessToken");
    }
}
