package com.nanjiabawa.mapper;

import com.nanjiabawa.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    @Select("select e.*, d.name as dept_name from emp e left join dept d on e.dept_id = d.id")
    List<Emp> selectAll();

    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
    Long count();

    List<Emp> selectByCondition(String name, Integer gender, LocalDate begin, LocalDate end);

//    @Select("select e.*, d.name as dept_name from emp e left join dept d on e.dept_id = d.id limit #{page}, #{pageNum}")
//    List<Emp> selectCurrentPage(Integer page, Integer pageNum);
}
