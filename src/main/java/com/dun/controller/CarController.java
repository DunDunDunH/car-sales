package com.dun.controller;

import com.dun.entity.Car;
import com.dun.entity.query.GetCarListQuery;
import com.dun.service.CarService;
import com.github.pagehelper.Page;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("index")
    public String toIndex() {
        return "index";
    }

    @GetMapping("order")
    public String toOrder() {
        return "order";
    }

    @GetMapping("queryPrice")
    public String toQueryPrice() {
        return "queryPrice";
    }

    @GetMapping("getList")
    public String getList(GetCarListQuery query, HttpServletRequest request) {
        query.setPageSize(10);
        // 品牌
        List<String> brands = carService.getBrands();
        request.setAttribute("brandList", brands);
        // 类型
        List<String> types = carService.getTypes();
        request.setAttribute("typeList", types);
        // 汽车列表
        Page<Car> cars = carService.getList(query);
        request.setAttribute("carList", cars.getResult());
        request.setAttribute("pages", cars.getPages());
        request.setAttribute("pageNum", cars.getPageNum());
        request.setAttribute("pageSize", cars.getPageSize());
        request.setAttribute("total", cars.getTotal());
        request.setAttribute("query", query);
        return "queryPrice";
    }

}
