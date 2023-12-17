package com.scauzj.service.impl;

import com.scauzj.entity.Banner;
import com.scauzj.mapper.GoodsMapper;
import com.scauzj.mapper.BannerMapper;
import com.scauzj.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerMapper bannerMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    public List<Banner> getCarousel() {
        return bannerMapper.getCarousel();
    }
}
