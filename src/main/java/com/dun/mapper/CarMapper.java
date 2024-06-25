package com.dun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dun.entity.Car;
import com.dun.entity.query.GetCarListQuery;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CarMapper extends BaseMapper<Car> {

    Page<Car> getList(GetCarListQuery query);

    List<String> getTypes();

    List<String> getBrands();
}
