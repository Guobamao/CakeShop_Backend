package com.scauzj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {
    private Integer id;
    private Integer userId; // 用户id
    private String name; // 收货人姓名
    private String phone; // 收货人电话
    private String address; // 收货人地址
    private LocalDateTime createTime; // 创建时间
    private Integer quantity; // 商品数量
    private BigDecimal total; // 总价
    private Integer Status; // 订单状态
    private Integer payType; // 支付方式
    private User user; // 用户
    private List<Item> itemList; // 订单项
}
