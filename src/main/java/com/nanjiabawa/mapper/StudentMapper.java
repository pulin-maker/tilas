package com.nanjiabawa.mapper;

import com.nanjiabawa.pojo.Student;
import com.nanjiabawa.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    List<Student> selectByCondition(StudentQueryParam param);

    @Insert("insert into student(name, no, gender, phone, id_card, is_college, address, degree, graduation_date, clazz_Id, create_time, update_time)"
     + "values(#{name}, #{no}, #{gender}, #{phone}, #{idCard}, #{isCollege}, #{address}, #{degree}, #{graduationDate}, #{clazzId}, #{createTime}, #{updateTime})")
    void insertStudent(Student student);

    @Select("select id, name, gender, id_card, address, graduation_date, no, phone, is_college, degree, clazz_id from student where id = #{id}")
    Student selectById(Integer id);

    @Update("update student set name = #{name}, no = #{no}, gender = #{gender}, " +
            "phone = #{phone}, id_card = #{idCard}, is_college = #{isCollege}, address = #{address}, " +
            "degree = #{degree}, graduation_date = #{graduationDate}, clazz_id = #{clazzId}, " +
            "violation_count = #{violationCount}, violation_score = #{violationScore} " +
            "where id = #{id}")
    void updateStudent(Student student);

    void deleteByIds(List<Integer> ids);

    @Update("update student set violation_count = violation_count + 1, violation_score = violation_score + #{score} where id = #{id}")
    void dealViolation(Integer id, Integer score);

    @MapKey("name")
    List<Map<String, Object>> countStuclazzData();

    @MapKey("degree")
    List<Map<String, Integer>> selectDegreeCount();
}
