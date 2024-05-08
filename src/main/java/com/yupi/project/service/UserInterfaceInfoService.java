package com.yupi.project.service;


import com.api.apicommon.model.entity.UserInterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author liaozhongshan
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2024-02-19 10:11:48
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {
    /**
     * 校验
     *
     * @param userInterfaceInfo
     * @param add 是否为创建校验
     */
    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);
    /**
     * 调用接口统计
     * @param  interfaceInfoId
     * @param  userId
     *
     */
    boolean invokeCount(long interfaceInfoId,long userId);

}
