package com.aliyun.controller;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.service.commCall;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 控制器
 */
@RestController
@RequestMapping("/aliyun")
public class handleController {
    @RequestMapping("/{transCode}")
    public JSONObject call(@RequestBody JSONObject req, @PathVariable String transCode, HttpServletRequest request) throws Exception {
        JSONObject body = new JSONObject();
        JSONObject res = new JSONObject();
        System.out.println(transCode);
        commCall commcall = new commCall();
        res = commcall.call(transCode,req);
        return res;
    }
}
