package com.nanjiabawa.controller;

import com.nanjiabawa.pojo.Clazz;
import com.nanjiabawa.pojo.ClazzQueryParam;
import com.nanjiabawa.pojo.PageResult;
import com.nanjiabawa.pojo.Result;
import com.nanjiabawa.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    @GetMapping("/list")
    public Result getAllClazz(){
        List<Clazz> lists = clazzService.selectAllClazz();
        return Result.success(lists);
    }

    @GetMapping
    public Result page(ClazzQueryParam param) {
        PageResult<Clazz> pageResult = clazzService.page(param);
        return Result.success(pageResult);
    }

    @PostMapping
    public Result addClazz(@RequestBody Clazz clazz){
        clazzService.insertClass(clazz);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getClazzById(@PathVariable String id){
        Clazz clazz = clazzService.selectById(id);
        return Result.success(clazz);
    }

    @PutMapping
    public Result updateClazz(@RequestBody Clazz clazz) {
        clazzService.updateClazz(clazz);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result deleteClazzById(@PathVariable Integer id) {
        clazzService.deleteById(id);
        return Result.success();
    }
}
