package com.scauzj.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.scauzj.dto.LoginDTO;
import com.scauzj.dto.RegisterDTO;
import com.scauzj.dto.UserDTO;
import com.scauzj.dto.UserPageQueryDTO;
import com.scauzj.entity.PageResult;
import com.scauzj.entity.User;
import com.scauzj.exception.AccountException;
import com.scauzj.mapper.UserMapper;
import com.scauzj.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User login(LoginDTO loginDTO) {
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();

        User user = userMapper.getByUsername(username);

        if (user == null) {
            // 用户名不存在
            throw new AccountException("用户名不存在");
        }

        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(user.getPassword())) {
            // 密码错误
            throw new AccountException("密码错误");
        }

        return user;
    }

    public void register(RegisterDTO registerDTO) {
        String username = registerDTO.getUsername();
        String password = registerDTO.getPassword();
        String password2 = registerDTO.getPassword2();
        String name = registerDTO.getName();
        String phone = registerDTO.getPhone();

        User user = userMapper.getByUsername(username);
        if (user != null) {
            // 用户名已存在
            throw new AccountException("用户名已存在");
        }
        if (!password2.equals(password)) {
            // 两次密码不一致
            throw new AccountException("两次密码不一致");
        }
        if (userMapper.getByPhone(phone) != null) {
            // 手机号已存在
            throw new AccountException("手机号已存在");
        }

        password = DigestUtils.md5DigestAsHex(password.getBytes());
        user = User.builder()
                .username(username)
                .password(password)
                .name(name)
                .phone(phone)
                .build();
        userMapper.insert(user);
    }

    public PageResult pageQuery(UserPageQueryDTO userPageQueryDTO) {
        PageHelper.startPage(userPageQueryDTO.getPage(), userPageQueryDTO.getPageSize());
        Page<User> page = userMapper.pageQuery(userPageQueryDTO);
        PageResult pageResult = new PageResult(page.getTotal(), page.getResult());
        return pageResult;
    }

    public void deleteById(Integer id) {
        userMapper.deleteById(id);
    }

    public void updateByAdmin(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        userMapper.updateByAdmin(user);
    }

    public void resetPassword(Integer id) {
        String password = DigestUtils.md5DigestAsHex("123456".getBytes());
        userMapper.resetPassword(id, password);
    }

    public User getUserById(Integer id) {
        return userMapper.getById(id);
    }

    public void updateByUser(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        userMapper.updateByUser(user);
    }
}
