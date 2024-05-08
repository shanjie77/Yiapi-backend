package com.yupi.project.service.impl.inner;

import com.api.apicommon.model.entity.InterfaceInfo;
import com.api.apicommon.service.InnerInterfaceInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yupi.project.common.ErrorCode;
import com.yupi.project.exception.BusinessException;
import com.yupi.project.mapper.InterfaceInfoMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
@DubboService
public class InnerInterfaceInfoServiceImpl implements InnerInterfaceInfoService {
    @Resource
    private InterfaceInfoMapper interfaceInfoMapper;

    /**
     * 实现getInterfaceInfo方法 用于根据URL和请求方法来查询内部接口信息
     * @param  url
     * @param method  请求方法
     * @return 内部接口信息 找不到则放回空
     *  异常url错误或者请求方法不正确
     */
    @Override
    public InterfaceInfo getInterfaceInfo(String url, String method) {
        //参数校验
        if(StringUtils.isAnyBlank(url,method))
        {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        //创建查询条件包装器
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("url",url);
        queryWrapper.eq("method",method);
        //利用interfaceInfoMapper中的selectone方法进行查询
        InterfaceInfo interfaceInfo = interfaceInfoMapper.selectOne(queryWrapper);
        return interfaceInfo;


    }
}
