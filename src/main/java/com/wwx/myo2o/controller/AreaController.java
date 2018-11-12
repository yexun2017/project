package com.wwx.myo2o.controller;

import com.wwx.myo2o.entity.Area;
import com.wwx.myo2o.service.AreaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: wangwx5
 * @Email: wangwx5@asiainfo.com
 * CreateDate: 2018/10/26  14:21
 **/
@RestController
@Slf4j
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/lists",method = RequestMethod.GET)
    public List<Area> getAreaLists(){
        return areaService.queryAllAreas();
    }

}
