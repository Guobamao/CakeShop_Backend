package com.scauzj.controller;

import com.scauzj.dto.LoginDTO;
import com.scauzj.entity.Admin;
import com.scauzj.entity.Result;
import com.scauzj.service.AdminService;
import com.scauzj.util.JwtUtils;
import com.scauzj.vo.LoginVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@Slf4j
@Tag(name = "管理员相关接口")
public class AdminController {
    @Autowired
    private AdminService adminService;


    @PostMapping("/login")
    @Operation(summary = "管理员登录")
    public Result login(@RequestBody LoginDTO loginDTO) {
        log.info("管理员登录：{}", loginDTO);

        Admin admin = adminService.login(loginDTO);

        // 登录成功，生成jwt令牌并下发
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", admin.getId());
        String token = JwtUtils.generateJwt(claims);

        // 封装返回数据
        LoginVO loginVO = LoginVO.builder()
                .id(admin.getId())
                .username(admin.getUsername())
                .token(token)
                .build();

        return Result.success(loginVO);
    }

    @PostMapping("/logout")
    @Operation(summary = "管理员登出")
    public Result logout() { return Result.success();}


}
