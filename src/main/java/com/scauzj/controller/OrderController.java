package com.scauzj.controller;

import com.scauzj.dto.OrderPageQueryDTO;
import com.scauzj.entity.Result;
import com.scauzj.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/orders")
@Tag(name = "订单管理相关接口")
public class OrderController {
    private OrderService orderService;

}
