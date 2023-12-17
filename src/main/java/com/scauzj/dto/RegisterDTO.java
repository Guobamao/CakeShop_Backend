package com.scauzj.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(description = "用户注册DTO")
public class RegisterDTO implements Serializable {
    @Schema(defaultValue = "zhangsan", description = "用户名", requiredMode = Schema.RequiredMode.REQUIRED)
    private String username;
    @Schema(defaultValue = "123456", description = "密码", requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;
    @Schema(defaultValue = "123456", description = "确认密码", requiredMode = Schema.RequiredMode.REQUIRED)
    private String password2;
    @Schema(description = "姓名", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;
    @Schema(description = "联系方式", requiredMode = Schema.RequiredMode.REQUIRED)
    private String phone;
}
