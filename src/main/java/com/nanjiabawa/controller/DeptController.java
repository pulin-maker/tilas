package com.nanjiabawa.controller;

import com.nanjiabawa.pojo.Dept;
import com.nanjiabawa.pojo.Result;
import com.nanjiabawa.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result findAll() {
        List<Dept> list = deptService.findAll();
        log.info("查询所有部门信息为: {}", list);
        return Result.success(list);
    }

    @DeleteMapping
    public Result deleteDept(@RequestParam Integer id) {
        log.info("根据id删除部门，删除部门id: {}", id);
        deptService.deleteById(id);
        return Result.success();
    }

    @PostMapping
    public Result saveDept(@RequestBody Dept dept) {
        deptService.save(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result selectOne(@PathVariable Integer id) {
        Dept dept = deptService.selectOne(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result updateDept(@RequestBody Dept dept) {
        deptService.updateDept(dept);
        return Result.success();
    }
}
