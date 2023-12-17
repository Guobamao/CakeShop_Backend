package com.scauzj.mapper;

import com.github.pagehelper.Page;
import com.scauzj.entity.Type;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TypeMapper {
    @Select("select * from types")
    List<Type> list();

    @Select("select * from types")
    Page<Type> pageQuery();

    @Insert("insert into types(name) values(#{name})")
    void insert(String name);

    @Update("update types set name=#{name} where id=#{id}")
    void update(Type type);

    @Delete("delete from types where id=#{id}")
    void delete(Integer id);
}
