package com.yupi.project.service.impl.inner;

import com.api.apicommon.service.InnerUserInterfaceInfoService;
import com.yupi.project.service.UserInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {


    @Resource
   private UserInterfaceInfoService  userInterfaceInfoService;
    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        //调用注入的userInterfaceInfoService中的invokecount方法
        return userInterfaceInfoService.invokeCount(interfaceInfoId,userId);
    }
}
