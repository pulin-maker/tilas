package com.nanjiabawa.service;

import com.nanjiabawa.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {

    JobOption getEmpJobData();

    List<Map> getGenderCount();
}
