package com.example.demo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface VersionMapper {
    @Select("SELECT version()")
    String selectVersion();
}
