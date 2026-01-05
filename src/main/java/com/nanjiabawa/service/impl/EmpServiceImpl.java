package com.nanjiabawa.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nanjiabawa.mapper.EmpExprMapper;
import com.nanjiabawa.mapper.EmpMapper;
import com.nanjiabawa.pojo.Emp;
import com.nanjiabawa.pojo.EmpExpr;
import com.nanjiabawa.pojo.EmpQueryParam;
import com.nanjiabawa.pojo.PageResult;
import com.nanjiabawa.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;

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
    @Transactional(rollbackFor = Exception.class)
    public void addEmpInfo(Emp emp) {
        // 1. 保存员工的信息
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.addEmpInfo(emp);

        //构造一个异常错误 验证时事务
//        int i = 1 / 0;

        // 2. 批量保存员工的工作经历
        Integer id = emp.getId();
        List<EmpExpr> exprLists = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprLists)) {
            for (EmpExpr expr : exprLists) {
                expr.setEmpId(id);
            }
            empExprMapper.insertExprsBatch(exprLists);
        }
    }

    /**
     * 删除员工 （除了需要删除员工还需要删除员工对应的工作经历）
     * @param ids
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByIds(List<Integer> ids) {
        empMapper.deleteByIds(ids);
        empExprMapper.deleteExprByids(ids);
    }

    @Override
    public Emp getEmpInfoById(Integer id) {
        Emp emp = empMapper.getEmpInfoById(id);
        return emp;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateInfo(Emp emp) {
        //1.根据员工id更新信息
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateEmpById(emp);

        //2.删除当前员工所有的工作经历
        empExprMapper.deleteExprByids(Arrays.asList(emp.getId()));

        //3.更新当前员工工作经历
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)) {
            exprList.forEach(expr -> expr.setEmpId(emp.getId()));
            empExprMapper.insertExprsBatch(exprList);
        }
    }
}
