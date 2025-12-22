package com.nanjiabawa.controller;

import com.nanjiabawa.mapper.EmpMapper;
import com.nanjiabawa.pojo.Emp;
import com.nanjiabawa.pojo.EmpQueryParam;
import com.nanjiabawa.pojo.PageResult;
import com.nanjiabawa.pojo.Result;
import com.nanjiabawa.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/list")
    public Result getAll() {
        log.info("查询所有的员工及其部门信息~");
        List<Emp> list = empService.selectAll();
        return Result.success(list);
    }

    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
        log.info("分页查询，查询页号为: {}, 每页展示: {}", empQueryParam.getPage(), empQueryParam.getPageSize());
        PageResult pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }

    @PostMapping
    public Result addEmpInfo(@RequestBody Emp emp) {
        log.info("添加员工及员工工作经历: {}", emp);
        empService.addEmpInfo(emp);
        return Result.success();
    }
}
