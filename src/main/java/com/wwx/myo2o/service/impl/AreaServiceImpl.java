package com.wwx.myo2o.service.impl;

import com.wwx.myo2o.entity.Area;
import com.wwx.myo2o.mapper.AreaMapper;
import com.wwx.myo2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: wangwx5
 * @Email: wangwx5@asiainfo.com
 * CreateDate: 2018/10/26  13:43
 **/
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaMapper areaMapper;

    @Override
    public List<Area> queryAllAreas() {
        return areaMapper.queryAllAreas();
    }
}
