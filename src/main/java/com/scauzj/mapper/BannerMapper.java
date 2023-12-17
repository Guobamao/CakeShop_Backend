package com.scauzj.mapper;

import com.scauzj.entity.Banner;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BannerMapper {
    @Select("select * from banner left join cake_shop.goods g on g.id = banner.goods_id where banner.type = 1")
    List<Banner> getCarousel();
}
