package com.wwx.myo2o.mapper;


import com.wwx.myo2o.entity.Area;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AreaMapper {
	/**
	 * 列出地域列表
	 * @return
	 */
    @Select(" select area_id,area_name,area_desc,priority,create_time,last_edit_time FROM tb_area ORDER BY priority DESC ")
	List<Area> queryAllAreas();
	/**
	 * @param area
	 * @return
	 */
	int insertArea(Area area);
	/**
	 * @param area
	 * @return
	 */
	int updateArea(Area area);
	/**
	 * @param areaId
	 * @return
	 */
	int deleteArea(long areaId);
	/**
	 * @param areaIdList
	 * @return
	 */
	int batchDeleteArea(List<Long> areaIdList);
}
