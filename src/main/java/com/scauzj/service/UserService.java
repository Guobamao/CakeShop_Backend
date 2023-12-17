package com.scauzj.service;

import com.scauzj.dto.LoginDTO;
import com.scauzj.dto.RegisterDTO;
import com.scauzj.dto.UserDTO;
import com.scauzj.dto.UserPageQueryDTO;
import com.scauzj.entity.PageResult;
import com.scauzj.entity.User;

public interface UserService {
    User login(LoginDTO loginDTO);

    void register(RegisterDTO registerDTO);

    PageResult pageQuery(UserPageQueryDTO userPageQueryDTO);

    void deleteById(Integer id);

    void updateByAdmin(UserDTO userDTO);

    void resetPassword(Integer id);

    User getUserById(Integer id);

    void updateByUser(UserDTO userDTO);
}
