package com.scauzj.controller;

import com.scauzj.entity.Result;
import com.scauzj.service.GoodsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/goods")
@Slf4j
@Tag(name = "用户商品相关接口")
public class UserGoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/new")
    @Operation(summary = "获取新品")
    public Result getNew() {
        log.info("获取新品");
        return Result.success(goodsService.getNew());
    }

    @GetMapping("/party")
    @Operation(summary = "获取聚会商品")
    public Result getParty() {
        log.info("获取聚会商品");
        return Result.success(goodsService.getParty());
    }

    @GetMapping("/child")
    @Operation(summary = "获取儿童商品")
    public Result getChild() {
        log.info("获取儿童商品");
        return Result.success(goodsService.getChild());
    }

    @GetMapping("/birthday")
    @Operation(summary = "获取生日商品")
    public Result getBirthday() {
        log.info("获取生日商品");
        return Result.success(goodsService.getBirthday());
    }

    @GetMapping("/new/{id}")
    @Operation(summary = "获取新品商品列表")
    public Result getNewList(@PathVariable Integer id) {
        log.info("获取新品商品列表：{}", id);
        return Result.success(goodsService.getNewList(id));
    }
}
