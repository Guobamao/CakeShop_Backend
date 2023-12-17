package com.scauzj.controller;

import com.scauzj.dto.GoodsDTO;
import com.scauzj.dto.GoodsPageQueryDTO;
import com.scauzj.entity.PageResult;
import com.scauzj.entity.Result;
import com.scauzj.service.GoodsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/goods")
@Slf4j
@Tag(name = "商品管理相关接口")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping
    @Operation(summary = "分页查询商品列表")
    public Result pageQuery(GoodsPageQueryDTO pageQueryDTO) {
        log.info("分页查询商品列表: {}", pageQueryDTO);
        PageResult pageResult = goodsService.pageQuery(pageQueryDTO);
        return Result.success(pageResult);
    }

    @PostMapping
    @Operation(summary = "添加商品")
    public Result addGoods(@RequestBody GoodsDTO goodsDTO) {
        log.info("添加商品: {}", goodsDTO);
        goodsService.addGoods(goodsDTO);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除商品")
    public Result deleteById(@PathVariable Integer id) {
        log.info("删除商品: id={}", id);
        goodsService.deleteById(id);
        return Result.success();
    }

    @PutMapping("/{id}")
    @Operation(summary = "修改商品")
    public Result updateById(@PathVariable Integer id, @RequestBody GoodsDTO goodsDTO) {
        goodsDTO.setId(id);
        log.info("修改商品: id={}, goodsDTO={}", id, goodsDTO);
        goodsService.updateById(goodsDTO);
        return Result.success();
    }
}
