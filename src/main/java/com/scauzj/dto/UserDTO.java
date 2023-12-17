package com.scauzj.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {
    private Integer id;
    private String username;
    private String name;
    private String phone;
    private String password;
    private String address;
    private String email;
}
