package com.yupi.project.service.impl.inner;

import com.api.apicommon.model.entity.User;
import com.api.apicommon.service.InnerUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yupi.project.common.ErrorCode;
import com.yupi.project.exception.BusinessException;
import com.yupi.project.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
@DubboService
public class InnerUserServiceImpl implements InnerUserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 实现接口中getInvokeUser方法，用于根据密钥获取内部用户信息
     * @param accessKey 密钥
     * @return 内部用户信息，找不到则返回null
     * 参数错误则抛出异常
     */

    @Override
    public User getInvokeUser(String accessKey) {
        //参数校验
        if(StringUtils.isAnyBlank(accessKey))
        {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        //创建查询条件包装器
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("accesskey",accessKey);
        //使用usermapper 的selectone方法查询用户信息
        return  userMapper.selectOne(queryWrapper);

    }
}
