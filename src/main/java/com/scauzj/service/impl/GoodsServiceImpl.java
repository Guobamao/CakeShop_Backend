package com.scauzj.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.scauzj.dto.GoodsDTO;
import com.scauzj.dto.GoodsPageQueryDTO;
import com.scauzj.entity.Goods;
import com.scauzj.entity.PageResult;
import com.scauzj.mapper.GoodsMapper;
import com.scauzj.service.GoodsService;
import com.scauzj.vo.GoodsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    public PageResult pageQuery(GoodsPageQueryDTO pageQueryDTO) {
        PageHelper.startPage(pageQueryDTO.getPage(), pageQueryDTO.getPageSize());
        Page<GoodsVO> page =  goodsMapper.pageQuery(pageQueryDTO);
        PageResult pageResult = new PageResult(page.getTotal(), page.getResult());
        return pageResult;
    }

    public void addGoods(GoodsDTO goodsDTO) {
        Goods goods = new Goods();
        BeanUtils.copyProperties(goodsDTO, goods);
        // 设置images1 image2
        String[] images = goodsDTO.getImages();
        goods.setImage1(images[0]);
        goods.setImage2(images[1]);
        if (goods.getTypeId() == 1) {
            goods.setNewGoods(1);
        } else {
            goods.setNewGoods(0);
        }
        goodsMapper.insert(goods);
    }

    public void deleteById(Integer id) {
        goodsMapper.deleteById(id);
    }

    public void updateById(GoodsDTO goodsDTO) {
        Goods goods = new Goods();
        BeanUtils.copyProperties(goodsDTO, goods);
        // 设置images1 image2
        String[] images = goodsDTO.getImages();
        goods.setImage1(images[0]);
        goods.setImage2(images[1]);
        goodsMapper.updateById(goods);
    }

    public List<Goods> getByTypeId(Integer id) {
        return goodsMapper.getByTypeId(id);
    }

    public List<Goods> getNew() {
        return goodsMapper.getNew();
    }

    public List<Goods> getParty() {
        return goodsMapper.getParty();
    }

    public List<Goods> getChild() {
        return goodsMapper.getChild();
    }

    public List<Goods> getBirthday() {
        return goodsMapper.getBirthday();
    }

    @Override
    public List<Goods> getNewList(Integer id) {
        return goodsMapper.getNewList(id);
    }
}
