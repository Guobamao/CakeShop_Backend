package com.scauzj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item implements Serializable {
    private Integer id;
    private BigDecimal price; // 商品单价
    private Integer quantity; // 商品数量
    private Integer orderId; // 订单id
    private Integer goodId; // 商品id
    private BigDecimal total; // 商品总价
    private Goods goods; // 商品
}
