package com.scauzj.controller;

import com.scauzj.dto.LoginDTO;
import com.scauzj.dto.RegisterDTO;
import com.scauzj.dto.UserDTO;
import com.scauzj.dto.UserPageQueryDTO;
import com.scauzj.entity.PageResult;
import com.scauzj.entity.Result;
import com.scauzj.entity.User;
import com.scauzj.service.UserService;
import com.scauzj.util.JwtUtils;
import com.scauzj.vo.LoginVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Slf4j
@Tag(name = "用户相关接口")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/login")
    public Result login(@RequestBody LoginDTO loginDTO) {
        log.info("用户登录：{}", loginDTO);
        User user = userService.login(loginDTO);
        // 登录成功，生成jwt令牌并下发
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        String token = JwtUtils.generateJwt(claims);

        LoginVO userLoginVO = LoginVO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .token(token)
                .build();
        return Result.success(userLoginVO);
    }

    @PostMapping("/user/logout")
    public Result logout() { return Result.success();}

    @PostMapping("/user/register")
    public Result register(@RequestBody RegisterDTO registerDTO) {
        log.info("用户注册：{}", registerDTO);
        userService.register(registerDTO);
        return Result.success();
    }

    @GetMapping("/user/info/{id}")
    public Result info(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        return Result.success(user);
    }

    @PutMapping("/user/info/{id}")
    public Result editByUser(@PathVariable Integer id, @RequestBody UserDTO userDTO) {
        userDTO.setId(id);
        log.info("修改用户：{}", userDTO);
        userService.updateByUser(userDTO);
        return Result.success();
    }

    // 以下是管理员接口
    @GetMapping("/admin/users")
    @Operation(summary = "读者用户查询")
    public Result list(UserPageQueryDTO userPageQueryDTO) {
        log.info("用户分页查询：{}", userPageQueryDTO);
        PageResult pageResult = userService.pageQuery(userPageQueryDTO);
        return Result.success(pageResult);
    }

    @DeleteMapping("/admin/users/{id}")
    @Operation(summary = "删除用户")
    public Result delete(@PathVariable Integer id) {
        log.info("删除用户：{}", id);
        userService.deleteById(id);
        return Result.success();
    }

    @PutMapping("/admin/users/{id}")
    @Operation(summary = "修改用户信息")
    public Result editByAdmin(@PathVariable Integer id, @RequestBody UserDTO userDTO) {
        userDTO.setId(id);
        log.info("修改用户：{}", userDTO);
        userService.updateByAdmin(userDTO);
        return Result.success();
    }

    @PutMapping("/admin/users/{id}/password")
    @Operation(summary = "重置用户密码")
    public Result editPassword(@PathVariable Integer id) {
        log.info("重置用户密码：{}", id);
        userService.resetPassword(id);
        return Result.success();
    }
}
