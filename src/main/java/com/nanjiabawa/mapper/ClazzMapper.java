package com.nanjiabawa.mapper;

import com.nanjiabawa.pojo.Clazz;
import com.nanjiabawa.pojo.ClazzQueryParam;
import com.nanjiabawa.pojo.Result;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClazzMapper {

    List<Clazz> selectAll();

    List<Clazz> selectByCondition(ClazzQueryParam param);

    @Insert("insert into clazz(name, room, begin_date, end_date, master_id, subject, create_time, update_time) values (#{name}, #{room}, #{beginDate}, #{endDate}, #{masterId}, #{subject}, #{createTime}, #{updateTime});")
    void insertClazz(Clazz clazz);

    @Select("select c.name, room, begin_date, end_date, master_id, e.name, subject from clazz c left join emp e on c.master_id = e.id where c.id = #{id}")
    Clazz selectById(String id);

    @Update("update clazz set name = #{name}, room = #{room}, begin_date = #{beginDate}, end_date = #{endDate}, master_id = #{masterId}, subject = #{subject}, update_time = #{updateTime} where id = #{id};")
    void updateClazz(Clazz clazz);

    @Delete("delete from clazz where id = #{id}")
    void deleteById(Integer id);
}
