package com.scauzj.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class GoodsVO implements Serializable {
    private Integer id;
    private String name; // 商品名称
    private String description; // 商品描述
    private String cover; // 商品封面
    private String image1; // 商品图片1
    private String image2; // 商品图片2
    private BigDecimal price; // 商品价格
    private Integer stock; // 商品库存
    private Integer typeId; // 商品类型id
    private String typeName; // 商品类型名称
    private Integer newGoods; // 是否新品
    private Integer type; // 商品归类 1:生日 2:儿童 3:聚会
}
