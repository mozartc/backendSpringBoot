package com.aliyun.mapper;

import com.aliyun.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public void insertUser(UserBean user);
}
