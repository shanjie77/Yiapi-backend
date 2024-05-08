package com.yupi.project.mapper;

import com.api.apicommon.model.entity.UserInterfaceInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author liaozhongshan
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Mapper
* @createDate 2024-02-19 10:11:48
* @Entity com.yupi.project.model.entity.UserInterfaceInfo
*/
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {
//select interfaceInfoId,sum(totalNum)as totalNum
//from user_interface_info
//group by interfaceInfoId
//order by totalNum desc
//limit 3;
    //查询用户接口信息表中，按照指定的limit参数进行筛选
    //返回前limit条记录的接口信息列表
    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int limit);
}




