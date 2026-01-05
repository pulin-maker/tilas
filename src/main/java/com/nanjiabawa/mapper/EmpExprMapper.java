package com.nanjiabawa.mapper;

import com.nanjiabawa.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    void insertExprsBatch(List<EmpExpr> exprList);

    void deleteExprByids(List<Integer> ids);
}
