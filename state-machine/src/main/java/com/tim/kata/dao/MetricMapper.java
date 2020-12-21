package com.tim.kata.dao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tim.kata.entity.Metric;

@Mapper
public interface MetricMapper {

    int insertSelective(Metric metric);



    Metric selectById(@Param("id")Long id);

	int updateById(@Param("updated")Metric updated,@Param("id")Long id);


}