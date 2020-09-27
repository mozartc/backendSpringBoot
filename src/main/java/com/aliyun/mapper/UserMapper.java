package com.aliyun.mapper;

import com.aliyun.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public void insertUser(UserBean user);

    public List<UserBean> selectUser(UserBean user);

    public void updateUser(UserBean user);

    public void deleteUser(UserBean user);
}
