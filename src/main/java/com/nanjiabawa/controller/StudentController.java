package com.nanjiabawa.controller;

import com.nanjiabawa.pojo.PageResult;
import com.nanjiabawa.pojo.Result;
import com.nanjiabawa.pojo.Student;
import com.nanjiabawa.pojo.StudentQueryParam;
import com.nanjiabawa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public Result getAllStudents(StudentQueryParam studentQueryParam){
        PageResult<Student> list = studentService.selectAllStu(studentQueryParam);
        return Result.success(list);
    }


}
