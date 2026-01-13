package com.nanjiabawa.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nanjiabawa.mapper.StudentMapper;
import com.nanjiabawa.pojo.PageResult;
import com.nanjiabawa.pojo.Student;
import com.nanjiabawa.pojo.StudentQueryParam;
import com.nanjiabawa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult<Student> selectAllStu(StudentQueryParam param) {
        PageHelper.startPage(param.getPage(), param.getPageSize());
        List<Student> rows = studentMapper.selectByCondition(param);
        Page<Student> page = (Page<Student>) rows;

        return new PageResult<>(page.getTotal(), rows);
    }
}
