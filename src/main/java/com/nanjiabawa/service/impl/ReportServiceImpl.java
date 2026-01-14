package com.nanjiabawa.service.impl;

import com.nanjiabawa.mapper.EmpMapper;
import com.nanjiabawa.mapper.StudentMapper;
import com.nanjiabawa.pojo.ClassOption;
import com.nanjiabawa.pojo.JobOption;
import com.nanjiabawa.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public JobOption getEmpJobData() {
        List<Map<String, Object>> lists = empMapper.countEmpJobData();
        List<Object> jobList = lists.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = lists.stream().map(dataMap -> dataMap.get("total")).toList();
        return new JobOption(jobList, dataList);
    }

    @Override
    public List<Map> getGenderCount() {
        List<Map> list = empMapper.getGenderInfo();
        return list;
    }

    @Override
    public ClassOption getClassStuData() {
        List<Map<String, Object>> lists = studentMapper.countStuclazzData();
        List<Object> classList = lists.stream().map(item -> item.get("name")).toList();
        List<Object> dataList = lists.stream().map(item -> item.get("total")).toList();
        return new ClassOption(classList, dataList);
    }

    @Override
    public List<Map<String, Integer>> getStuDegree() {
        return studentMapper.selectDegreeCount();
    }
}
