package com.jiurun.data.down.service.impl;

import com.jiurun.data.down.dao.DeviceInfoDao;
import com.jiurun.data.down.entity.*;
import com.jiurun.data.down.service.DeviceInfoService;
import com.jiurun.data.down.util.AjaxJson;
import com.jiurun.data.down.util.DataDownUtil;
import com.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public DeviceInfoServiceImpl() {
    }

    public AjaxJson setDataDown(DataDownDO dataDownDO) {
        AjaxJson ajaxJson = null;
        if (dataDownDO.getDeviceId() != null) {
            DeviceInfo deviceInfo = this.deviceInfoDao.fingDeviceInfoByDeviceId(dataDownDO.getDeviceId());
            DownDataInfoDo downDataInfoDo = new DownDataInfoDo();
            downDataInfoDo.setDataDownValue1(dataDownDO.getDataDownValue());
            downDataInfoDo.setDataDownValue2(dataDownDO.getTimeInterval());
            if (null != dataDownDO.getLowerLimit()) {
                downDataInfoDo.setDataDownValue3(dataDownDO.getLowerLimit());
            }

            if (null != dataDownDO.getUpperLimit()) {
                downDataInfoDo.setDataDownValue4(dataDownDO.getUpperLimit());
            }

            downDataInfoDo.setDeviceId(dataDownDO.getDeviceId());
            AtomicInteger atomicInteger = new AtomicInteger();
            atomicInteger.set(1);
            if (null != deviceInfo.getSmallDeviceType()) {
                DeviceTypeSecretKey deviceTypeSecretKeybySamllType = this.deviceInfoDao.findDeviceTypeSecretKeybySamllType(deviceInfo.getSmallDeviceType());
                if (null != deviceTypeSecretKeybySamllType) {
                    downDataInfoDo.setDataDownValue5(deviceTypeSecretKeybySamllType.getSecretKey());
                }
            } else if (deviceInfo.getDeviceType() == 7) {
                downDataInfoDo.setDataDownValue5("zhongguxing1");
            } else if (deviceInfo.getDeviceType() == 6) {
                downDataInfoDo.setDataDownValue5("zhongguxing");
            }

            DownDataInfoDo downDataInfoDo1 = this.deviceInfoDao.findDownDataInfo(dataDownDO.getDeviceId());
            if (null == downDataInfoDo1) {
                downDataInfoDo.setSendNumber(1);
            } else {
                downDataInfoDo.setSendNumber(downDataInfoDo1.getSendNumber() + 1);
            }

            SecretKey secretKey = this.deviceInfoDao.findSecretKeyInfo(downDataInfoDo.getDataDownValue5());
            if (secretKey != null) {
                Constant.APPID = secretKey.getAppId();
                Constant.SECRET = secretKey.getSecret();
                Constant.BASE_URL = secretKey.getBaseUrl();
            }

            try {
                if (deviceInfo != null) {
                    String setDownData = null;

                    try {
                        setDownData = DataDownUtil.setDownData(dataDownDO, deviceInfo);
                    } catch (Exception var10) {
                        var10.printStackTrace();
                    }

                    ajaxJson = new AjaxJson(setDownData);
                    if ("201".equals(setDownData)) {
                        if ("20.555".equals(dataDownDO.getDataDownValue())) {
                            System.out.println("发送成功");
                        }

                        downDataInfoDo.setDownBit(1);
                        downDataInfoDo.setDownSuccessfulTime(new Date());
                    } else if (downDataInfoDo1.getSendNumber() == 9) {
                        downDataInfoDo.setDownBit(1);
                    } else {
                        downDataInfoDo.setDownBit(0);
                    }

                    if (downDataInfoDo1 != null) {
                        if (null == downDataInfoDo1.getSendNumber() || downDataInfoDo1.getSendNumber() < 8) {
                            downDataInfoDo.setDownBit(0);
                        }

                        downDataInfoDo.setDownUpdataTime(new Date());
                        this.deviceInfoDao.updaDownDataInfo(downDataInfoDo);
                    } else {
                        downDataInfoDo.setDownBit(0);
                        downDataInfoDo.setDownTime(new Date());
                        this.deviceInfoDao.saveDownDataInfo(downDataInfoDo);
                    }
                }
            } catch (Exception var11) {
                return AjaxJson.getFailInfo();
            }
        }

        return ajaxJson;
    }

    public AjaxJson getDeviceInfo(DataDownDO downDO) {
        try {
            if (downDO.getLowerLimit() != null && downDO.getUpperLimit() != null) {
                this.deviceInfoDao.updateLiquid(downDO);
            }

            return AjaxJson.getSuccessInfo();
        } catch (Exception var3) {
            return AjaxJson.getFailInfo();
        }
    }
}
