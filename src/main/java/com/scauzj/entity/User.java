package com.scauzj.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String address;
    private String email;
    // 购物车
    private List<Goods> cart;
}
