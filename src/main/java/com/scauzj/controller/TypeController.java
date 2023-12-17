package com.scauzj.controller;

import com.scauzj.entity.PageResult;
import com.scauzj.entity.Result;
import com.scauzj.entity.Type;
import com.scauzj.service.GoodsService;
import com.scauzj.service.TypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
@RequestMapping("/api")
@Slf4j
@Tag(name = "商品分类相关接口")
public class TypeController implements Serializable {

    @Autowired
    private TypeService typeService;
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/user/types")
    @Operation(summary = "查询所有商品分类")
    public Result list() {
        log.info("查询所有商品分类数据");
        return Result.success(typeService.list());
    }

    @GetMapping("/user/types/list/{id}")
    @Operation(summary = "查询该分类下的所有商品")
    public Result listByTypeId(@PathVariable Integer id) {
        log.info("查询该分类下的所有商品: {}", id);

        // 调用service查询商品分类数据
        return Result.success(goodsService.getByTypeId(id));
    }

    // 以下是后台管理系统的接口

    @GetMapping("/admin/types")
    @Operation(summary = "查询所有商品分类")
    public Result pageQuery(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("查询所有商品分类数据");
        PageResult pageResult = typeService.pageQuery(page, pageSize);
        // 调用service查询商品分类数据
        return Result.success(pageResult);
    }

    @PostMapping("/admin/types")
    @Operation(summary = "添加商品分类")
    public Result add(@RequestBody Type type) {
        log.info("添加商品分类数据: {}", type);
        typeService.add(type.getName());
        return Result.success();
    }

    @PutMapping("/admin/types/{id}")
    @Operation(summary = "修改商品分类")
    public Result update(@PathVariable Integer id, @RequestBody Type type) {
        type.setId(id);
        log.info("修改商品分类数据: {}", type);
        typeService.update(type);
        return Result.success();
    }

    @DeleteMapping("/admin/types/{id}")
    @Operation(summary = "删除商品分类")
    public Result delete(@PathVariable Integer id) {
        log.info("删除商品分类数据: {}", id);
        typeService.delete(id);
        return Result.success();
    }
}
