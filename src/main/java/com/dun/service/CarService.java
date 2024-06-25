package com.dun.service;

import com.dun.entity.Car;
import com.dun.entity.query.GetCarListQuery;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CarService {

    Page<Car> getList(GetCarListQuery query);

    List<String> getTypes();

    List<String> getBrands();

}
