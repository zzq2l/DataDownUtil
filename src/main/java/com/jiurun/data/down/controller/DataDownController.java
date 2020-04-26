package com.jiurun.data.down.controller;

import com.jiurun.data.down.entity.DataDownDO;
import com.jiurun.data.down.service.DeviceInfoService;
import com.jiurun.data.down.util.AjaxJson;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Package: com.jiurn.data
 * @ClassName: DataDownContrller
 * @Author: ${zhouzhiqiang}
 * @Date: 27/7/2019 14:18
 */
@RestController
@RequestMapping({"/dataDownController"})
public class DataDownController {
    @Autowired
    private DeviceInfoService deviceInfoService;

    public DataDownController() {
    }

    @ApiOperation(
            value = "根据设备ID获取设备信息",
            httpMethod = "POST",
            response = AjaxJson.class,
            notes = "获取设备"
    )
    @RequestMapping(
            value = {"/getDeviceInfo"},
            method = {RequestMethod.POST}
    )
    @ResponseBody
    public AjaxJson getDeviceInfo(@RequestParam DataDownDO downDO) {
        try {
            return this.deviceInfoService.getDeviceInfo(downDO);
        } catch (Exception var3) {
            return AjaxJson.getFailInfo();
        }
    }

    @ApiOperation(
            value = "设置数据下发",
            httpMethod = "POST",
            response = AjaxJson.class,
            notes = "设置数据下发"
    )
    @RequestMapping(
            value = {"/setDataDown"},
            method = {RequestMethod.POST}
    )
    @ResponseBody
    public AjaxJson setDataDown(@RequestBody DataDownDO downDO) {
        try {
            return this.deviceInfoService.setDataDown(downDO);
        } catch (Exception var3) {
            return AjaxJson.getFailInfo();
        }
    }
}

