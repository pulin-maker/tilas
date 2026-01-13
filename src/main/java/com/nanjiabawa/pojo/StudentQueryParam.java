package com.nanjiabawa.pojo;

import lombok.Data;

@Data
public class StudentQueryParam {
    private Integer clazzId;
    private Integer degree;
    private String name;
    private Integer page;
    private Integer pageSize;
}
