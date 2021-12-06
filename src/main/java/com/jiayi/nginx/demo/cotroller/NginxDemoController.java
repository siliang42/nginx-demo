package com.jiayi.nginx.demo.cotroller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@RestController
@Slf4j
public class NginxDemoController {

    @GetMapping("/")
    public JSONObject defaultMethod(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        JSONObject jsonObject = new JSONObject();
        for (Enumeration e = headerNames; e.hasMoreElements(); ) {
            String thisName = e.nextElement().toString();
            String thisValue = request.getHeader(thisName);
            jsonObject.put(thisName, thisValue);
            log.info(thisName + "--------------" + thisValue);
        }
        log.info("===default====default====default====default=====");
        return jsonObject.fluentPut("url", request.getRequestURL());
    }


    @GetMapping("test")
    public JSONObject test(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        JSONObject jsonObject = new JSONObject();
        for (Enumeration e = headerNames; e.hasMoreElements(); ) {
            String thisName = e.nextElement().toString();
            String thisValue = request.getHeader(thisName);
            jsonObject.put(thisName, thisValue);
            log.info(thisName + "--------------" + thisValue);
        }
        log.info("===test===test===test===test===test=====");
        return jsonObject.fluentPut("url", request.getRequestURL());
    }


    @GetMapping("lua")
    public JSONObject lua(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        JSONObject jsonObject = new JSONObject();
        for (Enumeration e = headerNames; e.hasMoreElements(); ) {
            String thisName = e.nextElement().toString();
            String thisValue = request.getHeader(thisName);
            jsonObject.put(thisName, thisValue);
            log.info(thisName + "--------------" + thisValue);
        }
        log.info("===lua===lua===lua===lua===lua=====");
        return jsonObject.fluentPut("url", request.getRequestURL());
    }
}
