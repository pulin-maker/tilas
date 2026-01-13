package com.nanjiabawa.mapper;

import com.nanjiabawa.pojo.Student;
import com.nanjiabawa.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

    List<Student> selectByCondition(StudentQueryParam param);
}
