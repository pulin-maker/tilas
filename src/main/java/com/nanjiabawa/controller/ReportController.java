package com.nanjiabawa.controller;

import com.nanjiabawa.pojo.ClassOption;
import com.nanjiabawa.pojo.JobOption;
import com.nanjiabawa.pojo.Result;
import com.nanjiabawa.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/empJobData")
    public Result getEmpJobData() {
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }

    @GetMapping("/empGenderData")
    public Result getGenderCount() {
        List<Map> genderInfo = reportService.getGenderCount();
        return Result.success(genderInfo);
    }

    @GetMapping("/studentCountData")
    public Result getClassNumber() {
        ClassOption classOption = reportService.getClassStuData();
        return Result.success(classOption);
    }

    @GetMapping("/studentDegreeData")
    public Result getStuDegree() {
        List<Map<String, Integer>> list = reportService.getStuDegree();
        return Result.success(list);
    }

}
