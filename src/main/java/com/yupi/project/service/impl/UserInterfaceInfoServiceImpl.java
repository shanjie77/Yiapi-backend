package com.yupi.project.service.impl;

import com.api.apicommon.model.entity.UserInterfaceInfo;

import com.yupi.project.common.ErrorCode;
import com.yupi.project.exception.BusinessException;
import com.yupi.project.mapper.UserInterfaceInfoMapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.project.service.UserInterfaceInfoService;
import org.springframework.stereotype.Service;

/**
* @author liaozhongshan
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service实现
* @createDate 2024-02-19 10:11:48
*/
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService {
    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        //判断接口信息是否为空，为空则抛出异常
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        // 如果为添加
        if (add) {
            if (userInterfaceInfo.getInterfaceInfoId()<=0||userInterfaceInfo.getUserId()<=0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR,"接口或用户不存在");
            }
        }
        if (userInterfaceInfo.getLeftNum()<0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口剩余次数不能小于0");
        }
    }

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        if(interfaceInfoId<=0 || userId<= 0 )
        {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        //使用updateWrapper 对象构造更新条件
        UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
        // 在 updateWrapper 中设置了两个条件：interfaceInfoId 等于给定的 interfaceInfoId 和 userId 等于给定的 userId。
        updateWrapper.eq("InterfaceInfoId",interfaceInfoId);
        updateWrapper.eq("userId",userId);
        // setSql 方法用于设置要更新的 SQL 语句。这里通过 SQL 表达式实现了两个字段的更新操作：
        // leftNum=leftNum-1和totalNum=totalNum+1。意思是将leftNum字段减一，totalNum字段加一。
        updateWrapper.setSql("leftNum = leftNum -1,totalNum = totalNum + 1");
        return this.update(updateWrapper);
    }
}




