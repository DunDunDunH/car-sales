package com.dun.entity.query;

import lombok.Data;

@Data
public class GetCarListQuery extends PagingQuery{

    private String name; // 名称
    private String brand; // 品牌
    private String type; // 类型
}
