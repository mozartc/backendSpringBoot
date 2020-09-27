package com.aliyun.dao;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.bean.UserBean;
import com.aliyun.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserImpl {
    public static void main(String[] args) {
        UserBean user =  new UserBean();
        user.setPassword("122334");
        user.setUsername("大牛");
//        insertUser(user);
    }
    public JSONObject insertUser(JSONObject json){
        UserBean user =  new UserBean();
        user.setUsername(json.getJSONObject("form").getString("username"));
        user.setPassword(json.getJSONObject("form").getString("password"));
        InputStream config=null;
        JSONObject res = new JSONObject();
        try{
            config=Resources.getResourceAsStream("resources/mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
        SqlSession ss = ssf.openSession();
        try {
            UserMapper mapper = ss.getMapper(UserMapper.class);
            mapper.insertUser(user);
            ss.commit();
            res.put("status","success");
        } catch (Exception e) {
            e.printStackTrace();
            res.put("status","error");
        } finally {
            ss.close();
        }
        return res;
    }

    public JSONObject selectUser(JSONObject json){
        UserBean user =  new UserBean();
        user.setUsername(json.getJSONObject("form").getString("username"));
        user.setPassword(json.getJSONObject("form").getString("password"));
        InputStream config=null;
        JSONObject res = new JSONObject();
        try{
            config=Resources.getResourceAsStream("resources/mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
        SqlSession ss = ssf.openSession();
        try {
            UserMapper mapper = ss.getMapper(UserMapper.class);
            List<UserBean> result = mapper.selectUser(user);
            ss.commit();
            res.put("result",result);
            res.put("status","success");
        } catch (Exception e) {
            e.printStackTrace();
            res.put("status","error");
        } finally {
            ss.close();
        }
        return res;
    }

    public JSONObject updateUser(JSONObject json){
        UserBean user =  new UserBean();
        user.setUsername(json.getJSONObject("form").getString("username"));
        user.setPassword(json.getJSONObject("form").getString("password"));
        InputStream config=null;
        JSONObject res = new JSONObject();
        try{
            config=Resources.getResourceAsStream("resources/mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
        SqlSession ss = ssf.openSession();
        try {
            UserMapper mapper = ss.getMapper(UserMapper.class);
            mapper.updateUser(user);
            ss.commit();
            res.put("status","success");
        } catch (Exception e) {
            e.printStackTrace();
            res.put("status","error");
        } finally {
            ss.close();
        }
        return res;
    }

    public JSONObject deleteUser(JSONObject json){
        UserBean user =  new UserBean();
        user.setUsername(json.getJSONObject("form").getString("username"));
        user.setPassword(json.getJSONObject("form").getString("password"));
        InputStream config=null;
        JSONObject res = new JSONObject();
        try{
            config=Resources.getResourceAsStream("resources/mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
        SqlSession ss = ssf.openSession();
        try {
            UserMapper mapper = ss.getMapper(UserMapper.class);
            mapper.deleteUser(user);
            ss.commit();
            res.put("status","success");
        } catch (Exception e) {
            e.printStackTrace();
            res.put("status","error");
        } finally {
            ss.close();
        }
        return res;
    }
}
