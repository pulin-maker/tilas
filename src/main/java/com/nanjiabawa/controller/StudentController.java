package com.nanjiabawa.controller;

import com.nanjiabawa.pojo.PageResult;
import com.nanjiabawa.pojo.Result;
import com.nanjiabawa.pojo.Student;
import com.nanjiabawa.pojo.StudentQueryParam;
import com.nanjiabawa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping
    public Result insertStudent(@RequestBody Student student){
        studentService.insertStudent(student);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result selectByid(@PathVariable Integer id) {
        Student student = studentService.selectById(id);
        return Result.success(student);
    }

    @PutMapping
    public Result updateStudet(@RequestBody Student student){
        studentService.updateStudent(student);
        return Result.success();
    }

    @DeleteMapping("/{ids}")
    public Result deleteByids(@PathVariable List<Integer> ids){
        studentService.deleteByIds(ids);
        return Result.success();
    }

    @PutMapping("/violation/{id}/{score}")
    public Result violation(@PathVariable Integer id, @PathVariable Integer score){
        studentService.dealViolation(id, score);
        return Result.success();
    }



}
