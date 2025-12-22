package com.nanjiabawa.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nanjiabawa.mapper.EmpMapper;
import com.nanjiabawa.pojo.Emp;
import com.nanjiabawa.pojo.EmpQueryParam;
import com.nanjiabawa.pojo.PageResult;
import com.nanjiabawa.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Emp> selectAll() {
        return empMapper.selectAll();
    }

    @Override
    public PageResult page(EmpQueryParam empQueryParam) {

        /*
        // 原始分页查询实现方法
        Long total = empMapper.count();
        Integer start = (page - 1) * pageSize;
        List<Emp> rows = empMapper.selectCurrentPage(start, pageSize);
         */

        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
//        List<Emp> rows = empMapper.selectAll();
        List<Emp> rows = empMapper.selectByCondition(empQueryParam);
        Page<Emp> p =  (Page<Emp>) rows;


        return new PageResult(p.getTotal(), rows);
    }

    @Override
    public void addEmpInfo(Emp emp) {
        empMapper.addEmpInfo(emp);
    }
}
