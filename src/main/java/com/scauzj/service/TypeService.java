package com.scauzj.service;

import com.scauzj.entity.PageResult;
import com.scauzj.entity.Type;

import java.util.List;

public interface TypeService {
    List<Type> list();

    PageResult pageQuery(Integer page, Integer pageSize);

    void add(String name);

    void update(Type type);

    void delete(Integer id);
}
