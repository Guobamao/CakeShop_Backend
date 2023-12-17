package com.scauzj.controller;

import com.scauzj.entity.Result;
import com.scauzj.entity.Banner;
import com.scauzj.service.BannerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@Slf4j
@Tag(name = "轮播图相关接口")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @GetMapping("/user/banner/carousel")
    @Operation(summary = "获取轮播图片")
    public Result getCarousel() {
        List<Banner> carousels = bannerService.getCarousel();
        return Result.success(carousels);
    }
}
