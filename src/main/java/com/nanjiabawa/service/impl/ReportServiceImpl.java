package com.nanjiabawa.service.impl;

import com.nanjiabawa.mapper.EmpMapper;
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
}
