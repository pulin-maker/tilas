package com.nanjiabawa.mapper;

import com.nanjiabawa.pojo.Emp;
import com.nanjiabawa.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {

    @Select("select e.*, d.name as dept_name from emp e left join dept d on e.dept_id = d.id")
    List<Emp> selectAll();

    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
    Long count();

    List<Emp> selectByCondition(EmpQueryParam empQueryParam);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, dept_id, entry_date, create_time, update_time)" +
    "values (#{username}, #{name},#{gender},#{phone},#{job},#{salary},#{image},#{deptId},#{entryDate}, #{createTime}, #{updateTime})")
    void addEmpInfo(Emp emp);

    void deleteByIds(List<Integer> ids);

    Emp getEmpInfoById(Integer id);

    void updateEmpById(Emp emp);

    @MapKey("pos")
    List<Map<String, Object>> countEmpJobData();

    @MapKey("gender")
    List<Map> getGenderInfo();

//    @Select("select e.*, d.name as dept_name from emp e left join dept d on e.dept_id = d.id limit #{page}, #{pageNum}")
//    List<Emp> selectCurrentPage(Integer page, Integer pageNum);
}
