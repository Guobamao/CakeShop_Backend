package com.scauzj.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(description = "登录DTO")
public class LoginDTO implements Serializable {
    @Schema(defaultValue = "admin", description = "用户名", requiredMode = Schema.RequiredMode.REQUIRED)
    private String username;
    @Schema(defaultValue = "123456", description = "密码", requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;
}
