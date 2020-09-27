package com.aliyun.service;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.dao.UserImpl;

public class commCall {
    public JSONObject call(String transCode, JSONObject req){
        JSONObject res = new JSONObject();
        if("001".equals(transCode)){
            UserImpl user = new UserImpl();
            res = user.insertUser(req);
        }
        return res;
    }
}
