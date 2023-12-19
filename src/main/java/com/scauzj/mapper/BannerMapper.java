package com.scauzj.mapper;

import com.scauzj.entity.Banner;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BannerMapper {
    @Select("select * from banner")
    List<Banner> getCarousel();
}
