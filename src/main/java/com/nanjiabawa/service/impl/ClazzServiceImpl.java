package com.nanjiabawa.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nanjiabawa.mapper.ClazzMapper;
import com.nanjiabawa.mapper.EmpMapper;
import com.nanjiabawa.pojo.Clazz;
import com.nanjiabawa.pojo.ClazzQueryParam;
import com.nanjiabawa.pojo.PageResult;
import com.nanjiabawa.service.ClazzService;
import com.nanjiabawa.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private EmpService empService;
    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Clazz> selectAllClazz() {
        return clazzMapper.selectAll();
    }

    @Override
    public PageResult<Clazz> page(ClazzQueryParam param) {
        PageHelper.startPage(param.getPage(), param.getPageSize());
        List<Clazz> rows = clazzMapper.selectByCondition(param);
        Page<Clazz> page =  (Page<Clazz>) rows;

        return new PageResult<>(page.getTotal(), rows);
    }

    @Override
    public void insertClass(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.insertClazz(clazz);
    }

    @Override
    public Clazz selectById(String id) {
        Clazz clazz = clazzMapper.selectById(id);
        if (clazz != null && clazz.getMasterId() != null) {
            String masterName = empMapper.selectNameById(clazz.getMasterId());
            clazz.setMasterName(masterName);
        }
        return clazz;
    }

    @Override
    public void updateClazz(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.updateClazz(clazz);
    }

    @Override
    public void deleteById(Integer id) {
        clazzMapper.deleteById(id);
    }
}
