package com.scauzj.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "登录返回的数据格式")
public class LoginVO implements Serializable {
    @Schema(description = "id")
    private Integer id;
    @Schema(description = "用户名")
    private String username;
    @Schema(description = "token")
    private String token;
}
