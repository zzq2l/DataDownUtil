package com.jiurn.data.down.controller;

import com.jiurn.data.down.dao.DeviceInfoDao;
import com.jiurn.data.down.entity.DataDownDO;
import com.jiurn.data.down.entity.DeviceInfo;
import com.jiurn.data.down.service.DeviceInfoService;
import com.jiurn.data.down.util.AjaxJson;
import com.wordnik.swagger.annotations.ApiOperation;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Package: com.jiurn.data
 * @ClassName: DataDownContrller
 * @Author: ${zhouzhiqiang}
 * @Date: 27/7/2019 14:18
 */
@RestController
@RequestMapping("/dataDownController")
public class DataDownController {

    @Autowired
    private DeviceInfoService deviceInfoService;

    @ApiOperation(value = "根据设备ID获取设备信息", httpMethod = "POST", response = AjaxJson.class, notes = "获取设备")
    @RequestMapping(value = "/getDeviceInfo", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson getDeviceInfo(@RequestBody DataDownDO downDO) {
        try {
            return deviceInfoService.getDeviceInfo(downDO);
        } catch (Exception e) {
            return AjaxJson.getFailInfo();
        }
    }

    //数据下发命令
    @ApiOperation(value = "设置数据下发", httpMethod = "POST", response = AjaxJson.class, notes = "设置数据下发")
    @RequestMapping(value = "/setDataDown", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson setDataDown(@RequestBody DataDownDO downDO) {
        try {
            return deviceInfoService.setDataDown(downDO);
        } catch (Exception e) {

            return AjaxJson.getFailInfo();
        }

    }



}
