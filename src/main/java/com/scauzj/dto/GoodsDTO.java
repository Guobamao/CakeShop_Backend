package com.scauzj.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class GoodsDTO implements Serializable {
    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer stock;
    private String description;
    private String cover;
    private String[] images;
    private Integer typeId;
    private Integer type; // 1: 生日 2: 儿童 3: 派对
}
