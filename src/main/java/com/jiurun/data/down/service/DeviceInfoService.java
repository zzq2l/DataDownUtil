package com.jiurun.data.down.service;

import com.jiurun.data.down.entity.DataDownDO;
import com.jiurun.data.down.util.AjaxJson;

/**
 * @Package: com.jiurn.data.down.service
 * @ClassName: DeviceInfoService
 * @Author: ${zhouzhiqiang}
 * @Date: 27/7/2019 15:43
 */

public interface DeviceInfoService {

    AjaxJson setDataDown(DataDownDO dataDownDO);

    AjaxJson getDeviceInfo(DataDownDO downDO);
}
