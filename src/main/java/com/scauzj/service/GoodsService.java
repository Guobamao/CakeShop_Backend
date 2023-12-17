package com.scauzj.service;

import com.scauzj.dto.GoodsDTO;
import com.scauzj.dto.GoodsPageQueryDTO;
import com.scauzj.entity.Goods;
import com.scauzj.entity.PageResult;

import java.util.List;

public interface GoodsService {
    PageResult pageQuery(GoodsPageQueryDTO pageQueryDTO);

    void addGoods(GoodsDTO goodsDTO);

    void deleteById(Integer id);

    void updateById(GoodsDTO goodsDTO);

    List<Goods> getByTypeId(Integer id);

    List<Goods> getNew();

    List<Goods> getParty();

    List<Goods> getChild();

    List<Goods> getBirthday();

    List<Goods> getNewList(Integer id);
}
