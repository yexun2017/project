package com.wwx.myo2o.mapper;

import com.wwx.myo2o.BaseTest;
import com.wwx.myo2o.entity.Area;
import com.wwx.myo2o.service.AreaService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author: wangwx5
 * @Email: wangwx5@asiainfo.com
 * CreateDate: 2018/10/26  13:17
 **/

public class AreaTest extends BaseTest {

    @Autowired
    private AreaMapper areaMapper;

    @Autowired
    private AreaService areaService;

    @Test
    public  void  selectAllTest(){
        List<Area> areaList = areaMapper.queryAllAreas();
        assertEquals(4, areaList.size());
    }

    @Test
    public  void  selectAllServiceTest(){
        List<Area> areaList = areaService.queryAllAreas();
        assertEquals(4, areaList.size());
    }
}
