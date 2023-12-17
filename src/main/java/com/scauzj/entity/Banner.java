package com.scauzj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Banner implements Serializable {
    private Integer id;
    private Integer goodsId;
    private String image;
    private Integer type;
}
