package com.nanjiabawa.service;

import com.nanjiabawa.pojo.Emp;
import com.nanjiabawa.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    List<Emp> selectAll();

    PageResult page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);
}
