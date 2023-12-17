package com.scauzj.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserPageQueryDTO implements Serializable {
    private int page;
    private int pageSize;
    private String name; // 姓名
    private String phone; // 手机号
}
