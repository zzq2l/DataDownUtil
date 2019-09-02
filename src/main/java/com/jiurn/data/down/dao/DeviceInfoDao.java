package com.jiurn.data.down.dao;

import com.jiurn.data.down.entity.DataDownDO;
import com.jiurn.data.down.entity.DeviceInfo;
import com.jiurn.data.down.entity.DownDataInfoDo;
import com.jiurn.data.down.entity.SecretKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Package: com.jiurn.data.down.dao
 * @ClassName: DeviceInfoDao
 * @Author: ${zhouzhiqiang}
 * @Date: 27/7/2019 14:33
 */
@Mapper
public interface DeviceInfoDao {
    List<DeviceInfo> findDeivceInfo();
    //通过设备ID获取设备信息
    DeviceInfo fingDeviceInfoByDeviceId(String deviceId);

    //修改水压/液位下限值
    Integer updateLiquid(DataDownDO dataDownDO);

    //保存为下发的命令
    Integer saveDownDataInfo(DownDataInfoDo dataDownDO);
    //判读是否在数据库中添加过
    DownDataInfoDo findDownDataInfo(String deviceId);
    //更新操作
    Integer updaDownDataInfo(DownDataInfoDo dataDownDO);
    //获取秘钥信息
    SecretKey findSecretKeyInfo(String dataDownValue5);
}
