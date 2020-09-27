package com.aliyun.service;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.dao.UserImpl;

public class commCall {
    public JSONObject call(String transCode, JSONObject req){
        JSONObject res = new JSONObject();
        String type = req.getJSONObject("form").getString("type");
        if("001".equals(transCode) && "1".equals(type)){
            UserImpl user = new UserImpl();
            res = user.insertUser(req);
        }
        if("001".equals(transCode) && "2".equals(type)){
            UserImpl user = new UserImpl();
            res = user.selectUser(req);
        }
        if("001".equals(transCode) && "3".equals(type)){
            UserImpl user = new UserImpl();
            res = user.updateUser(req);
        }
        if("001".equals(transCode) && "4".equals(type)){
            UserImpl user = new UserImpl();
            res = user.deleteUser(req);
        }
        return res;
    }
}
