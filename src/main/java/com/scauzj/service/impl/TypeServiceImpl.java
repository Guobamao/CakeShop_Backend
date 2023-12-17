package com.scauzj.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.scauzj.entity.PageResult;
import com.scauzj.entity.Type;
import com.scauzj.mapper.TypeMapper;
import com.scauzj.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;

    public List<Type> list() {
        return typeMapper.list();
    }

    public PageResult pageQuery(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        Page<Type> pages = typeMapper.pageQuery();
        return new PageResult(pages.getTotal(), pages.getResult());
    }

    public void add(String name) {
        typeMapper.insert(name);
    }

    public void update(Type type) {
        typeMapper.update(type);
    }

    public void delete(Integer id) {
        typeMapper.delete(id);
    }
}
