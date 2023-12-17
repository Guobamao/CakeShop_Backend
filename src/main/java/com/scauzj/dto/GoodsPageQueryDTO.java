package com.scauzj.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class GoodsPageQueryDTO implements Serializable {
    private int page;
    private int pageSize;
    private Integer typeId;
}
