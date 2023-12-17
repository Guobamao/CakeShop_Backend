package com.scauzj.service.impl;

import com.scauzj.dto.LoginDTO;
import com.scauzj.entity.Admin;
import com.scauzj.exception.AccountException;
import com.scauzj.mapper.AdminMapper;
import com.scauzj.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public Admin login(LoginDTO loginDTO) {
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();

        // 根据用户名查询管理员，如果不存在则返回null
        Admin admin = adminMapper.getByUsername(username);

        if (admin == null) {
            throw new AccountException("用户名不存在");
        }

        // 判断密码是否正确，如果不正确则返回null
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(admin.getPassword())) {
            throw new AccountException("密码错误");
        }

        return admin;
    }
}
