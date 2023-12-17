package com.scauzj.mapper;

import com.github.pagehelper.Page;
import com.scauzj.dto.GoodsPageQueryDTO;
import com.scauzj.entity.Goods;
import com.scauzj.vo.GoodsVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsMapper {
    Page<GoodsVO> pageQuery(GoodsPageQueryDTO pageQueryDTO);

    @Insert("insert into goods (name, cover, image1, image2, price, description, stock, type_id, new_goods, type) values " +
            "(#{name}, #{cover}, #{image1}, #{image2}, #{price}, #{description}, #{stock}, #{typeId}, #{newGoods}, #{type})")
    void insert(Goods goods);

    @Delete("delete from goods where id = #{id}")
    void deleteById(Integer id);

    void updateById(Goods goods);

    @Select("select * from goods where type_id = #{id}")
    List<Goods> getByTypeId(Integer id);

    @Select("select * from goods where new_goods = 1 and type_id = 1 limit 4")
    List<Goods> getNew();

    @Select("select * from goods where type = 3 limit 4")
    List<Goods> getParty();

    @Select("select * from goods where type = 2 limit 4")
    List<Goods> getChild();

    @Select("select * from goods where type = 1 limit 4")
    List<Goods> getBirthday();

    @Select("select * from goods where new_goods = 1 and type_id = #{id}")
    List<Goods> getNewList(Integer id);
}
