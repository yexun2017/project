package com.wwx.myo2o.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: wangwx5
 * @Email: wangwx5@asiainfo.com
 * CreateDate: 2018/10/28  22:08
 **/
@Controller
public class indexController {
    @RequestMapping(value = "/index")
    public String index(){
       return "index";
    }


    @RequestMapping(value = "/index1")
    public String index1(){
        return "zhongweijingshu/index1";
    }


}
