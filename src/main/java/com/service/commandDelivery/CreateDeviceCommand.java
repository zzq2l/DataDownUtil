package com.service.commandDelivery;

import java.util.*;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.utils.Constant;
import com.utils.HttpsUtil;
import com.utils.JsonUtil;
import com.utils.StreamClosedHttpResponse;

/**
 * Create Device Command :
 *
 * This interface is used to send command to device.
 * If a device is not online,
 * the IoT platform buffers the command and delivers the message to the device after the device is online.
 * The NA can set the maximum buffering time.
 */
public class CreateDeviceCommand {

    public static void main(String[] args) throws Exception {

        // Two-Way Authentication
        HttpsUtil httpsUtil = new HttpsUtil();
        httpsUtil.initSSLConfigForTwoWay();

        // Authentication.get token
        String accessToken = login(httpsUtil);

        //Please make sure that the following parameter values have been modified in the Constant file.
        String urlCreateDeviceCommand = Constant.CREATE_DEVICE_CMD();
        String appId = Constant.APPID;
        String callbackUrl = Constant.REPORT_CMD_EXEC_RESULT_CALLBACK_URL();

        //please replace the deviceId, when you call this interface.
        String deviceId = "d559e740-009d-4ac6-adb9-10a79d54446f";
        //please replace the following parameter values as required, when you call this interface.
        Integer expireTime = 0;
        Integer maxRetransmit = 3;

        //please replace the following parameter values, when you call this interface.
        //And those parameter values must be consistent with the content of profile that have been preset to IoT platform.
        //The following parameter values of this demo are use the watermeter profile that already initialized to IoT platform.
        String serviceId = "Transmission";
        String method = "SET_TEMPERATURE";

        /**
         * SensorLevel ：255    THRESHOLD ：150 WINDOWOPENTIME： 20  "DETECTINTERVAL": 2, "TIMEINTERVAL": 5, TIMEINTERVAL
         */
        String dez = "{"+"WINDOWOPENTIME"+ ":" + "5"+ "," +"IMEI"+ ":" + "862458045530364"+ "," +"THRESHOLD"+ ":" + "150"+ "," +"DETECTINTERVAL"+ ":" + "2"+ "," +"TIMEINTERVAL"+ ":" + "5"+ "," +"IMSI"+ ":" + "460111172522228" + "}";


        com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSON.parseObject(dez);
        System.out.println("非正宗的: "+jsonObject);
        // JSONObject object = JSONObject.fromObject(hashMap);
        ObjectNode paras = JsonUtil.convertObject2ObjectNode("{\"WINDOWOPENTIME\":\"5\""
                + ",\"IMEI\":\"862458045530364\""
                + ",\"THRESHOLD\":\"150\""
                + ",\"DETECTINTERVAL\":\"2\""
                + ",\"TIMEINTERVAL\":\"5\""
                + ",\"IMSI\":\"460111172522228\"}");
        System.out.println("正宗的:" + paras);
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

        HttpResponse responseCreateDeviceCommand = httpsUtil.doPostJson(urlCreateDeviceCommand, header, jsonRequest);

        String responseBody = httpsUtil.getHttpResponseBody(responseCreateDeviceCommand);

        System.out.println("CreateDeviceCommand, response content:");
        System.out.println(responseCreateDeviceCommand.getStatusLine());
        System.out.println(responseBody);
        System.out.println();
    }

    /**
     * Authentication.get token
     */
    @SuppressWarnings("unchecked")
    public static String login(HttpsUtil httpsUtil) throws Exception {

        String appId = Constant.APPID;
        String secret = Constant.SECRET;
        String urlLogin = Constant.APP_AUTH();

        Map<String, String> paramLogin = new HashMap<>();
        paramLogin.put("appId", appId);
        paramLogin.put("secret", secret);

        StreamClosedHttpResponse responseLogin = httpsUtil.doPostFormUrlEncodedGetStatusLine(urlLogin, paramLogin);

        System.out.println("app auth success,return accessToken:");
        System.out.println(responseLogin.getStatusLine());
        System.out.println(responseLogin.getContent());
        System.out.println();

        Map<String, String> data = new HashMap<>();
        data = JsonUtil.jsonString2SimpleObj(responseLogin.getContent(), data.getClass());
        return data.get("accessToken");
    }



}
