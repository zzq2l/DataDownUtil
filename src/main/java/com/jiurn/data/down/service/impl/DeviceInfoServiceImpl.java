package com.jiurn.data.down.service.impl;

import com.jiurn.data.down.dao.DeviceInfoDao;
import com.jiurn.data.down.entity.DataDownDO;
import com.jiurn.data.down.entity.DeviceInfo;
import com.jiurn.data.down.entity.DownDataInfoDo;
import com.jiurn.data.down.entity.SecretKey;
import com.jiurn.data.down.service.DeviceInfoService;
import com.jiurn.data.down.util.AjaxJson;
import com.jiurn.data.down.util.DataDownUtil;
import com.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Package: com.jiurn.data.down.service.impl
 * @ClassName: DeviceInfoServiceImpl
 * @Author: ${zhouzhiqiang}
 * @Date: 27/7/2019 15:44
 */
@Service
public class DeviceInfoServiceImpl implements DeviceInfoService {
    @Autowired
    private DeviceInfoDao deviceInfoDao;


    @Override
    public AjaxJson setDataDown(DataDownDO dataDownDO) {
        AjaxJson ajaxJson = null;
        if (dataDownDO.getDeviceId() != null && (dataDownDO.getDataDownValue() != null && !"".equals(dataDownDO.getDataDownValue().trim()))) {
            //获取设备信息
            DeviceInfo deviceInfo = deviceInfoDao.fingDeviceInfoByDeviceId(dataDownDO.getDeviceId());
            DownDataInfoDo downDataInfoDo = new DownDataInfoDo();
            downDataInfoDo.setDataDownValue1(dataDownDO.getDataDownValue());
            downDataInfoDo.setDataDownValue2(dataDownDO.getTimeInterval());
            downDataInfoDo.setDeviceId(dataDownDO.getDeviceId());
            AtomicInteger atomicInteger = new AtomicInteger();
            atomicInteger.set(1);
            //  downDataInfoDo.set(dataDownDO.getDeviceId());
            downDataInfoDo.setDataDownValue5("zhongguxing");
            if (dataDownDO.getVendorInfo() != null) {
                downDataInfoDo.setDataDownValue5(dataDownDO.getVendorInfo());
            }
            //判读是否在数据库中添加过
            DownDataInfoDo downDataInfoDo1 = deviceInfoDao.findDownDataInfo(dataDownDO.getDeviceId());
            if (null == downDataInfoDo1) {
                downDataInfoDo.setSendNumber(1);
            } else {
                downDataInfoDo.setSendNumber(downDataInfoDo1.getSendNumber() + 1);
            }
            //设置秘钥和请求URL
            SecretKey secretKey = null;
            if (downDataInfoDo1 != null) {
                secretKey = deviceInfoDao.findSecretKeyInfo(downDataInfoDo1.getDataDownValue5());
            }
            //设置对应设备发送的参数信息
            if (secretKey != null) {
                Constant.APPID = secretKey.getAppId() ;
                Constant.SECRET = secretKey.getSecret();
                Constant.BASE_URL = secretKey.getBaseUrl();
            }

            //下发命令
            try {
                if (deviceInfo != null) {
                    String setDownData = null;
                    try {
                        setDownData = DataDownUtil.setDownData(dataDownDO, deviceInfo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    ajaxJson = new AjaxJson(setDownData);
                    if ("201".equals(setDownData)) {
                        if ("20.555".equals(dataDownDO.getDataDownValue())) {
                            System.out.println("发送成功");
                        }
                        downDataInfoDo.setDownBit(1);
                        downDataInfoDo.setDownSuccessfulTime(new Date());
                    } else {
                        downDataInfoDo.setDownBit(0);
                    }
                    if (downDataInfoDo1 != null) {
                        if (null == downDataInfoDo1.getSendNumber() || downDataInfoDo1.getSendNumber() < 8) {
                            downDataInfoDo.setDownBit(0);
                        }
                        downDataInfoDo.setDownUpdataTime(new Date());
                        Integer down = deviceInfoDao.updaDownDataInfo(downDataInfoDo);
                    } else {
                        downDataInfoDo.setDownBit(0);
                        downDataInfoDo.setDownTime(new Date());
                        Integer down = deviceInfoDao.saveDownDataInfo(downDataInfoDo);
                    }
                }
            } catch (Exception e) {
                return AjaxJson.getFailInfo();
            }
        }
        return ajaxJson;
    }

    @Override
    public AjaxJson getDeviceInfo(DataDownDO downDO) {
        //修改水压/液位下限值
        try {
            if (downDO.getLowerLimit() != null && downDO.getUpperLimit() != null) {

                Integer integer = deviceInfoDao.updateLiquid(downDO);
            }
            return AjaxJson.getSuccessInfo();

        } catch (Exception e) {
            return AjaxJson.getFailInfo();
        }

    }
}
