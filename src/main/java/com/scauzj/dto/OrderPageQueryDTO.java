package com.scauzj.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderPageQueryDTO implements Serializable {
    private int page;
    private int pageSize;
    private Integer status; // 订单状态
}
