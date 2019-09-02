/**
 * File Name: com.huawei.utils.Constant.java
 * <p>
 * Copyright Notice:
 * Copyright  1998-2008, Huawei Technologies Co., Ltd.  ALL Rights Reserved.
 * <p>
 * Warning: This computer software sourcecode is protected by copyright law
 * and international treaties. Unauthorized reproduction or distribution
 * of this sourcecode, or any portion of it, may result in severe civil and
 * criminal penalties, and will be prosecuted to the maximum extent
 * possible under the law.
 */
package com.utils;

public class Constant {

    //please replace the IP and Port of the IoT platform environment address, when you use the demo.
    //public static  String BASE_URL = "https://develop.api.ct10649.com:8743";
    //https://develop.local.ct10649.com:8843测试环境
    //	https://develop.ct10649.com:8093测试开发环境
    //public static String BASE_URL = "https://180.101.147.89:8743"; //TODO 测试环境
   public  static  String BASE_URL = "https://device.api.ct10649.com:8743";
    //please replace the appId and secret, when you use the demo.

    public static String APPID = "5rRYoyG5oeWPQ0bD9m9N2UqmYYQa";
    public static String APPID() {
        return APPID;
    }
    public static String SECRET = "fZAV8Ax14ycgIlhQfOsPF_GF6o8a";
    public static String SECRET() {
        return SECRET;
    }

//    public  static  String  APPID = "6dToBRdY8P6QtuDSgp_nKvkBlyQa";
//    public  static  String SECRET = "8fm_dLxOER5LINAeP4T95u27lr0a";

    /*
     *IP and port of callback url.
     *please replace the IP and Port of your Application deployment environment address, when you use the demo.
     */
    public static String CALLBACK_BASE_URL = "http://10.10.10.99:9999";

    /*
     * complete callback url.
     * please replace uri, when you use the demo.
     */
    public static String DEVICE_ADDED_CALLBACK_URL = CALLBACK_BASE_URL + "/na/iocm/devNotify/v1.1.0/addDevice";
    public static String DEVICE_ADDED_CALLBACK_URL() {
        return CALLBACK_BASE_URL + "/na/iocm/devNotify/v1.1.0/addDevice";
    }
    public static String DEVICE_INFO_CHANGED_CALLBACK_URL = CALLBACK_BASE_URL + "/na/iocm/devNotify/v1.1.0/updateDeviceInfo";
    public static String DEVICE_DATA_CHANGED_CALLBACK_URL = CALLBACK_BASE_URL + "/na/iocm/devNotify/v1.1.0/updateDeviceData";
    public static String DEVICE_DELETED_CALLBACK_URL = CALLBACK_BASE_URL + "/na/iocm/devNotify/v1.1.0/deletedDevice";
    public static String MESSAGE_CONFIRM_CALLBACK_URL = CALLBACK_BASE_URL + "/na/iocm/devNotify/v1.1.0/commandConfirmData";
    public static String SERVICE_INFO_CHANGED_CALLBACK_URL = CALLBACK_BASE_URL + "/na/iocm/devNotify/v1.1.0/updateServiceInfo";
    public static String COMMAND_RSP_CALLBACK_URL = CALLBACK_BASE_URL + "/na/iocm/devNotify/v1.1.0/commandRspData";
    public static String DEVICE_EVENT_CALLBACK_URL = CALLBACK_BASE_URL + "/na/iocm/devNotify/v1.1.0/DeviceEvent";
    public static String RULE_EVENT_CALLBACK_URL = CALLBACK_BASE_URL + "/na/iocm/devNotify/v1.1.0/RulEevent";
    public static String DEVICE_DATAS_CHANGED_CALLBACK_URL = CALLBACK_BASE_URL + "/na/iocm/devNotify/v1.1.0/updateDeviceDatas";
    public static String DEVICE_SHADOW_MODIFIED_CALLBACK_URL = CALLBACK_BASE_URL + "/na/iocm/devNotify/v1.1.0/modifyDeviceDesired";

    public static String SW_UPGRADE_CALLBACK_URL = CALLBACK_BASE_URL + "/na/iocm/devNotify/v1.1.0/upgradeSW";
    public static String SW_UPGRADE_CALLBACK_URL() {
        return CALLBACK_BASE_URL + "/na/iocm/devNotify/v1.1.0/upgradeSW";
    }
    public static String FW_UPGRADE_CALLBACK_URL = CALLBACK_BASE_URL + "/na/iocm/devNotify/v1.1.0/upgradeFW";


    /*
     * Specifies the callback URL for the command execution result notification.
     * For details about the execution result notification definition.
     *
     * please replace uri, when you use the demo.
     */
    public static String REPORT_CMD_EXEC_RESULT_CALLBACK_URL = CALLBACK_BASE_URL + "/na/iocm/devNotify/v1.1.0/reportCmdExecResult";

    public static String REPORT_CMD_EXEC_RESULT_CALLBACK_URL() {
        return CALLBACK_BASE_URL + "/na/iocm/devNotify/v1.1.0/reportCmdExecResult";
    }

    public static String getBaseUrl() {

        return null;
    }

    //Paths of certificates.
    public static String SELFCERTPATH = "/src/resources/cert/outgoing.CertwithKey.pkcs12";
    public static String TRUSTCAPATH = "/src/resources/cert/ca.jks";

    //Password of certificates.
    public static String SELFCERTPWD = "IoM@1234";
    public static String TRUSTCAPWD = "Huawei@123";


    //*************************** The following constants do not need to be modified *********************************//

    /*
     * request header
     * 1. HEADER_APP_KEY
     * 2. HEADER_APP_AUTH
     */
    public static String HEADER_APP_KEY = "app_key";
    public static String HEADER_APP_AUTH = "Authorization";

    /*
     * Application Access Security:
     * 1. APP_AUTH
     * 2. REFRESH_TOKEN
     */
    public static String APP_AUTH = BASE_URL + "/iocm/app/sec/v1.1.0/login";
    public static String APP_AUTH() {

        return BASE_URL + "/iocm/app/sec/v1.1.0/login";
    }
    public static String REFRESH_TOKEN = BASE_URL + "/iocm/app/sec/v1.1.0/refreshToken";
    public static String REFRESH_TOKEN() {

        return BASE_URL + "/iocm/app/sec/v1.1.0/refreshToken";
    }


    /*
     * Device Management:
     * 1. REGISTER_DIRECT_CONNECTED_DEVICE
     * 2. MODIFY_DEVICE_INFO
     * 3. QUERY_DEVICE_ACTIVATION_STATUS
     * 4. DELETE_DIRECT_CONNECTED_DEVICE
     * 5. DISCOVER_INDIRECT_CONNECTED_DEVICE
     * 6. REMOVE_INDIRECT_CONNECTED_DEVICE
     * 7. MODIFY_DEVICE_SHADOW
     * 8. QUERY_DEVICE_SHADOW
     * 9. QUERY_DEVICE_REALTIME_LOCATION
     */
    public static String REGISTER_DIRECT_CONNECTED_DEVICE = BASE_URL + "/iocm/app/reg/v1.1.0/deviceCredentials";
    public static String REGISTER_DIRECT_CONNECTED_DEVICE() {

        return BASE_URL + "/iocm/app/reg/v1.1.0/deviceCredentials";
    }
    public static String MODIFY_DEVICE_INFO = BASE_URL + "/iocm/app/dm/v1.4.0/devices";
    public static String MODIFY_DEVICE_INFO() {

        return BASE_URL + "/iocm/app/dm/v1.4.0/devices";
    }
    public static String QUERY_DEVICE_ACTIVATION_STATUS = BASE_URL + "/iocm/app/reg/v1.1.0/deviceCredentials";
    public static String QUERY_DEVICE_ACTIVATION_STATUS() {

        return BASE_URL + "/iocm/app/reg/v1.1.0/deviceCredentials";
    }
    public static String DELETE_DIRECT_CONNECTED_DEVICE = BASE_URL + "/iocm/app/dm/v1.4.0/devices";
    public static String DELETE_DIRECT_CONNECTED_DEVICE() {

        return  BASE_URL + "/iocm/app/dm/v1.4.0/devices";
    }
    public static String DISCOVER_INDIRECT_CONNECTED_DEVICE = BASE_URL + "/iocm/app/signaltrans/v1.1.0/devices/%s/services/%s/sendCommand";
    public static String DISCOVER_INDIRECT_CONNECTED_DEVICE() {

        return BASE_URL + "/iocm/app/signaltrans/v1.1.0/devices/%s/services/%s/sendCommand";
    }
    public static String REMOVE_INDIRECT_CONNECTED_DEVICE = BASE_URL + "/iocm/app/signaltrans/v1.1.0/devices/%s/services/%s/sendCommand";
    public static String REMOVE_INDIRECT_CONNECTED_DEVICE() {

        return  BASE_URL + "/iocm/app/signaltrans/v1.1.0/devices/%s/services/%s/sendCommand";
    }
    public static String MODIFY_DEVICE_SHADOW = BASE_URL + "/iocm/app/shadow/v1.5.0/devices";
    public static String MODIFY_DEVICE_SHADOW() {

        return BASE_URL + "/iocm/app/shadow/v1.5.0/devices";
    }
    public static String QUERY_DEVICE_SHADOW = BASE_URL + "/iocm/app/shadow/v1.5.0/devices";
    public static String QUERY_DEVICE_SHADOW() {

        return  BASE_URL + "/iocm/app/shadow/v1.5.0/devices";
    }
    public static String QUERY_DEVICE_REALTIME_LOCATION = BASE_URL + "/iocm/app/location/v1.1.0/queryDeviceRealtimeLocation";
    public static String QUERY_DEVICE_REALTIME_LOCATION() {

        return BASE_URL + "/iocm/app/location/v1.1.0/queryDeviceRealtimeLocation";
    }

    /*
     * Batch Task:
     * 1. CREATE_BATCH_TASK
     * 2. QUERY_SPECIFY_TASK
     * 3. QUERY_TASK_DETAILS
     */
    public static String CREATE_BATCH_TASK = BASE_URL + "/iocm/app/batchtask/v1.1.0/tasks";
    public static String CREATE_BATCH_TASK() {

        return BASE_URL + "/iocm/app/batchtask/v1.1.0/tasks";
    }
    public static String QUERY_SPECIFY_BATCH_TASK = BASE_URL + "/iocm/app/batchtask/v1.1.0/tasks";
    public static String QUERY_SPECIFY_BATCH_TASK() {

        return BASE_URL + "/iocm/app/batchtask/v1.1.0/tasks";
    }
    public static String QUERY_BATCH_TASK_DETAILS = BASE_URL + "/iocm/app/batchtask/v1.1.0/taskDetails";
    public static String QUERY_BATCH_TASK_DETAILS() {

        return BASE_URL + "/iocm/app/batchtask/v1.1.0/taskDetails";
    }

    /*
     * Data Collection:
     * 1. QUERY_SPECIFY_DEVICE
     * 2. QUERY_DEVICES
     * 3. QUERY_DEVICE_HISTORY_DATA
     * 4. QUERY_DEVICE_CAPABILITIES
     */
    public static String QUERY_SPECIFY_DEVICE = BASE_URL + "/iocm/app/dm/v1.4.0/devices";
    public static String QUERY_SPECIFY_DEVICE() {

        return BASE_URL + "/iocm/app/dm/v1.4.0/devices";
    }
    public static String QUERY_BATCH_DEVICES = BASE_URL + "/iocm/app/dm/v1.4.0/devices";
    public static String QUERY_BATCH_DEVICES() {

        return  BASE_URL + "/iocm/app/dm/v1.4.0/devices";
    }
    public static String QUERY_DEVICE_HISTORY_DATA = BASE_URL + "/iocm/app/data/v1.2.0/deviceDataHistory";
    public static String QUERY_DEVICE_HISTORY_DATA() {

        return  BASE_URL + "/iocm/app/data/v1.2.0/deviceDataHistory";
    }
    public static String QUERY_DEVICE_CAPABILITIES = BASE_URL + "/iocm/app/data/v1.1.0/deviceCapabilities";
    public static String QUERY_DEVICE_CAPABILITIES() {

        return BASE_URL + "/iocm/app/data/v1.1.0/deviceCapabilities";
    }

    /*
     * Subscription Management:
     * 1. SUBSCRIBE_SERVICE_NOTIFYCATION
     * 2. SUBSCRIBE_MANAGEMENT_NOTIFYCATION
     * 3. QUERY_SPECIFY_SUBSCRIPTION
     * 4. QUERY_BATCH_SUBSCRIPTIONS
     * 5. DELETE_SPECIFY_SUBSCRIPTION
     * 6. DELETE_BATCH_SUBSCRIPTIONS
     */
    public static String SUBSCRIBE_SERVICE_NOTIFYCATION = BASE_URL + "/iocm/app/sub/v1.2.0/subscriptions";
    public static String SUBSCRIBE_SERVICE_NOTIFYCATION() {

        return BASE_URL + "/iocm/app/sub/v1.2.0/subscriptions";
    }
    public static String SUBSCRIBE_MANAGEMENT_NOTIFYCATION = BASE_URL + "/iodm/app/sub/v1.1.0/subscribe";
    public static String SUBSCRIBE_MANAGEMENT_NOTIFYCATION() {

        return  BASE_URL + "/iodm/app/sub/v1.1.0/subscribe";
    }
    public static String QUERY_SPECIFY_SUBSCRIPTION = BASE_URL + "/iocm/app/sub/v1.2.0/subscriptions";
    public static String QUERY_SPECIFY_SUBSCRIPTION() {

        return  BASE_URL + "/iocm/app/sub/v1.2.0/subscriptions";
    }
    public static String QUERY_BATCH_SUBSCRIPTIONS = BASE_URL + "/iocm/app/sub/v1.2.0/subscriptions";
    public static String QUERY_BATCH_SUBSCRIPTIONS() {

        return  BASE_URL + "/iocm/app/sub/v1.2.0/subscriptions";
    }
    public static String DELETE_SPECIFY_SUBSCRIPTION = BASE_URL + "/iocm/app/sub/v1.2.0/subscriptions";
    public static String DELETE_SPECIFY_SUBSCRIPTION() {

        return BASE_URL + "/iocm/app/sub/v1.2.0/subscriptions";
    }
    public static String DELETE_BATCH_SUBSCRIPTIONS = BASE_URL + "/iocm/app/sub/v1.2.0/subscriptions";
    public static String DELETE_BATCH_SUBSCRIPTIONS() {

        return BASE_URL + "/iocm/app/sub/v1.2.0/subscriptions";
    }

    /*
     * Command Delivery:
     * 1. CREATE_DEVICE_CMD
     * 2. QUERY_DEVICE_CMD
     * 3. MODIFY_DEVICE_CMD
     * 4. CREATE_DEVICECMD_CANCEL_TASK
     * 5. QUERY_DEVICECMD_CANCEL_TASK
     * 6. INVOKE_DEVICE_SERVICES
     */
    public String CREATE_DEVICE_CMD = BASE_URL + "/iocm/app/cmd/v1.4.0/deviceCommands";
    public static String CREATE_DEVICE_CMD() {

        return BASE_URL + "/iocm/app/cmd/v1.4.0/deviceCommands";
    }

    public static String QUERY_DEVICE_CMD = BASE_URL + "/iocm/app/cmd/v1.4.0/deviceCommands";

    public static String QUERY_DEVICE_CMD() {

        return BASE_URL + "/iocm/app/cmd/v1.4.0/deviceCommands";
    }

    public static String MODIFY_DEVICE_COMMAND = BASE_URL + "/iocm/app/cmd/v1.4.0/deviceCommands";
    public static String MODIFY_DEVICE_COMMAND() {

        return BASE_URL + "/iocm/app/cmd/v1.4.0/deviceCommands";
    }
    public static String CREATE_DEVICECMD_CANCEL_TASK = BASE_URL + "/iocm/app/cmd/v1.4.0/deviceCommandCancelTasks";
    public static String CREATE_DEVICECMD_CANCEL_TASK() {

        return BASE_URL + "/iocm/app/cmd/v1.4.0/deviceCommandCancelTasks";
    }
    public static String QUERY_DEVICECMD_CANCEL_TASK = BASE_URL + "/iocm/app/cmd/v1.4.0/deviceCommandCancelTasks";
    public static String QUERY_DEVICECMD_CANCEL_TASK() {

        return BASE_URL + "/iocm/app/cmd/v1.4.0/deviceCommandCancelTasks";
    }
    public static String INVOKE_DEVICE_SERVICES = BASE_URL + "/iocm/app/signaltrans/v1.1.0/devices/%s/services/%s/sendCommand";
    public static String INVOKE_DEVICE_SERVICES() {

        return BASE_URL + "/iocm/app/signaltrans/v1.1.0/devices/%s/services/%s/sendCommand";
    }


    /*
     * Device Group Management:
     * 1. CREATE_DEVICE_GROUP
     * 2. MODIFY_DEVICE_GROUP
     * 3. DELETE_DEVICE_GROUP
     * 4. QUERY_SPECIFY_DEVICE_GROUP
     * 5. QUERY_DEVICE_GROUPS
     * 6. QUERY_DEVICE_GROUP_MEMBERS
     * 7. ADD_DEVICE_GROUP_MEMBER
     * 8. DELETE_DEVICE_GROUP_MEMBER
     */
    public static String CREATE_DEVICE_GROUP = BASE_URL + "/iocm/app/devgroup/v1.3.0/devGroups";
    public static String CREATE_DEVICE_GROUP() {

        return BASE_URL + "/iocm/app/devgroup/v1.3.0/devGroups";
    }
    public static String MODIFY_DEVICE_GROUP = BASE_URL + "/iocm/app/devgroup/v1.3.0/devGroups";
    public static String MODIFY_DEVICE_GROUP() {

        return BASE_URL + "/iocm/app/devgroup/v1.3.0/devGroups";
    }
    public static String DELETE_DEVICE_GROUP = BASE_URL + "/iocm/app/devgroup/v1.3.0/devGroups";
    public static String DELETE_DEVICE_GROUP() {

        return BASE_URL + "/iocm/app/devgroup/v1.3.0/devGroups";
    }
    public static String QUERY_SPECIFY_DEVICE_GROUP = BASE_URL + "/iocm/app/devgroup/v1.3.0/devGroups";
    public static String QUERY_SPECIFY_DEVICE_GROUP() {

        return BASE_URL + "/iocm/app/devgroup/v1.3.0/devGroups";
    }
    public static String QUERY_DEVICE_GROUPS = BASE_URL + "/iocm/app/devgroup/v1.3.0/devGroups";
    public static String QUERY_DEVICE_GROUPS() {

        return BASE_URL + "/iocm/app/devgroup/v1.3.0/devGroups";
    }
    public static String QUERY_DEVICE_GROUP_MEMBERS = BASE_URL + "/iocm/app/dm/v1.2.0/devices/ids";
    public static String QUERY_DEVICE_GROUP_MEMBERS() {

        return BASE_URL + "/iocm/app/dm/v1.2.0/devices/ids";
    }
    public static String ADD_DEVICE_GROUP_MEMBER = BASE_URL + "/iocm/app/dm/v1.1.0/devices/addDevGroupTagToDevices";
    public static String ADD_DEVICE_GROUP_MEMBER() {

        return BASE_URL + "/iocm/app/dm/v1.1.0/devices/addDevGroupTagToDevices";
    }
    public static String DELETE_DEVICE_GROUP_MEMBER = BASE_URL + "/iocm/app/dm/v1.1.0/devices/deleteDevGroupTagFromDevices";
    public static String DELETE_DEVICE_GROUP_MEMBER() {

        return BASE_URL + "/iocm/app/dm/v1.1.0/devices/deleteDevGroupTagFromDevices";
    }


    /*
     * Device Upgrade:
     * 1. CREATE_SW_UPGRADE_TASK
     * 2. CREATE_FW_UPGRADE_TASK
     * 3. QUERY_SPECIFY_PACKAGE
     * 4. QUERY_BATCH_PACKAGES
     * 5. DELETE_SPECIFY_PACKAGE
     * 6. QUERY_SPECIFY_UPGRADE_TASK_RESULT
     * 7. QUERY_UPGRADE_TASKS
     */
    public static String CREATE_SW_UPGRADE_TASK = BASE_URL + "/iodm/northbound/v1.5.0/operations/softwareUpgrade";
    public static String CREATE_SW_UPGRADE_TASK() {

        return BASE_URL + "/iodm/northbound/v1.5.0/operations/softwareUpgrade";
    }
    public static String CREATE_FW_UPGRADE_TASK = BASE_URL + "/iodm/northbound/v1.5.0/operations/firmwareUpgrade";
    public static String CREATE_FW_UPGRADE_TASK() {

        return BASE_URL + "/iodm/northbound/v1.5.0/operations/firmwareUpgrade";
    }
    public static String QUERY_SPECIFY_PACKAGE = BASE_URL + "/iodm/northbound/v1.5.0/category";
    public static String QUERY_SPECIFY_PACKAGE() {

        return BASE_URL + "/iodm/northbound/v1.5.0/category";
    }
    public static String QUERY_BATCH_PACKAGES = BASE_URL + "/iodm/northbound/v1.5.0/category";
    public static String QUERY_BATCH_PACKAGES() {

        return BASE_URL + "/iodm/northbound/v1.5.0/category";
    }
    public static String DELETE_SPECIFY_PACKAGE = BASE_URL + "/iodm/northbound/v1.5.0/category";
    public static String DELETE_SPECIFY_PACKAGE() {

        return BASE_URL + "/iodm/northbound/v1.5.0/category";
    }
    public static String QUERY_SPECIFY_UPGRADE_TASK_RESULT = BASE_URL + "/iodm/northbound/v1.5.0/operations";
    public static String QUERY_SPECIFY_UPGRADE_TASK_RESULT() {

        return BASE_URL + "/iodm/northbound/v1.5.0/operations";
    }
    public static String QUERY_UPGRADE_TASKS = BASE_URL + "/iodm/northbound/v1.5.0/operations";
    public static String QUERY_UPGRADE_TASKS() {

        return BASE_URL + "/iodm/northbound/v1.5.0/operations";
    }


    /*
     * service Notify Type
     * serviceInfoChanged|deviceInfoChanged|LocationChanged|deviceDataChanged|deviceDatasChanged
     * deviceAdded|deviceDeleted|messageConfirm|commandRsp|deviceEvent|ruleEvent
     */
    public static String DEVICE_ADDED = "deviceAdded";
    public static String DEVICE_INFO_CHANGED = "deviceInfoChanged";
    public static String DEVICE_DATA_CHANGED = "deviceDataChanged";
    public static String DEVICE_DELETED = "deviceDeleted";
    public static String MESSAGE_CONFIRM = "messageConfirm";
    public static String SERVICE_INFO_CHANGED = "serviceInfoChanged";
    public static String COMMAND_RSP = "commandRsp";
    public static String DEVICE_EVENT = "deviceEvent";
    public static String RULE_EVENT = "ruleEvent";
    public static String DEVICE_DATAS_CHANGED = "deviceDatasChanged";
    public static String DEVICE_SHADOW_MODIFIED = "deviceDesiredPropertiesModifyStatusChanged";

    /*
     * management Notify Type
     * swUpgradeStateChangeNotify|swUpgradeResultNotify|fwUpgradeStateChangeNotify|fwUpgradeResultNotify
     */
    public static String SW_UPGRADE_STATE_CHANGED = "swUpgradeStateChangeNotify";
    public static String SW_UPGRADE_RESULT = "swUpgradeResultNotify";
    public static String FW_UPGRADE_STATE_CHANGED = "fwUpgradeStateChangeNotify";
    public static String FW_UPGRADE_RESULT = "fwUpgradeResultNotify";

}
