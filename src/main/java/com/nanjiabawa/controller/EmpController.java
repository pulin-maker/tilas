package com.nanjiabawa.controller;

import com.nanjiabawa.mapper.EmpMapper;
import com.nanjiabawa.pojo.Emp;
import com.nanjiabawa.pojo.PageResult;
import com.nanjiabawa.pojo.Result;
import com.nanjiabawa.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public Result page(@RequestParam(defaultValue = "0") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name,
                       Integer gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end
    ) {
        log.info("分页查询，查询页号为: {}, 每页展示: {}", page, pageSize);
        PageResult pageResult = empService.page(page, pageSize, name, gender, begin, end);
        return Result.success(pageResult);
    }
}
