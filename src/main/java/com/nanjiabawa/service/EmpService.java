package com.nanjiabawa.service;

import com.nanjiabawa.pojo.Emp;
import com.nanjiabawa.pojo.EmpQueryParam;
import com.nanjiabawa.pojo.PageResult;

import java.util.List;

public interface EmpService {
    List<Emp> selectAll();

    PageResult page(EmpQueryParam empQueryParam);

    void addEmpInfo(Emp emp);

    void deleteByIds(List<Integer> ids);

    Emp getEmpInfoById(Integer id);

    void updateInfo(Emp emp);
}
