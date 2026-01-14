package com.nanjiabawa.service;

import com.nanjiabawa.pojo.PageResult;
import com.nanjiabawa.pojo.Student;
import com.nanjiabawa.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {
    PageResult<Student> selectAllStu(StudentQueryParam studentQueryParam);

    void insertStudent(Student student);

    Student selectById(Integer id);

    void updateStudent(Student student);

    void deleteByIds(List<Integer> ids);

    void dealViolation(Integer id, Integer score);
}
