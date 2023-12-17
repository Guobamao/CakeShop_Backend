package com.scauzj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods implements Serializable {
    private Integer id;
    private String name; // 商品名称
    private String cover; // 商品封面
    private String image1; // 商品图片1
    private String image2; // 商品图片2
    private BigDecimal price; // 商品价格
    private String description; // 商品描述
    private Integer stock; // 商品库存
    private Integer typeId; // 商品类型id
    private Integer newGoods; // 是否是新品
    private Integer type; // 1:生日 2:儿童 3:派对
}
