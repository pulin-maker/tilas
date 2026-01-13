package com.nanjiabawa.service;

import com.nanjiabawa.pojo.PageResult;
import com.nanjiabawa.pojo.Student;
import com.nanjiabawa.pojo.StudentQueryParam;

public interface StudentService {
    PageResult<Student> selectAllStu(StudentQueryParam studentQueryParam);
}
