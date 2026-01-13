package com.nanjiabawa.service;

import com.nanjiabawa.pojo.Clazz;
import com.nanjiabawa.pojo.ClazzQueryParam;
import com.nanjiabawa.pojo.PageResult;

import java.util.List;

public interface ClazzService {
    List<Clazz> selectAllClazz();

    PageResult<Clazz> page(ClazzQueryParam param);

    void insertClass(Clazz clazz);

    Clazz selectById(String id);

    void updateClazz(Clazz clazz);

    void deleteById(Integer id);
}
