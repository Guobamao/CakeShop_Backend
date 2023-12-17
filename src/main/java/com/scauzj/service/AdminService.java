package com.scauzj.service;

import com.scauzj.dto.LoginDTO;
import com.scauzj.entity.Admin;

public interface AdminService {
    Admin login(LoginDTO loginDTO);
}
