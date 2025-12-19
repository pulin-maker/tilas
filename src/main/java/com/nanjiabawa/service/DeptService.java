package com.nanjiabawa.service;

import com.nanjiabawa.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> findAll();

    void deleteById(Integer id);

    void save(Dept dept);

    Dept selectOne(Integer id);

    void updateDept(Dept dept);
}
