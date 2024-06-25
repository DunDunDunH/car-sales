package com.dun.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Car {

    private String id; // ID
    private String name; // 名称
    private String brand; // 品牌
    private String type; // 类型
    private Double startPrice; // 配置
    private Double endPrice; // 价格
    private Integer count; // 数量
    @TableLogic(value = "0", delval = "1")
    private boolean isDeleted; // 是否删除。0：否；1：是

    public Car(String name, String brand,String type, Double startPrice, Double endPrice, Integer count) {
        this.id = UUID.randomUUID().toString().replace("-", "");
        this.name = name;
        this.brand = brand;
        this.type = type;
        this.startPrice = startPrice;
        this.endPrice = endPrice;
        this.count = count;
        this.isDeleted = false;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name=" + name +
                ", brand=" + brand +
                ", type=" + type +
                ", startPrice=" + startPrice +
                ", endPrice=" + endPrice +
                ", count=" + count +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
