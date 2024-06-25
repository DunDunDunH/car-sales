package com.dun.service.impl;

import com.dun.entity.Car;
import com.dun.entity.query.GetCarListQuery;
import com.dun.mapper.CarMapper;
import com.dun.service.CarService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public Page<Car> getList(GetCarListQuery query) {
        return carMapper.getList(query);
    }

    @Override
    public List<String> getTypes() {
        return carMapper.getTypes();
    }

    @Override
    public List<String> getBrands() {
        return carMapper.getBrands();
    }
}
