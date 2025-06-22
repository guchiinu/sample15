package com.example.demo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DatabaseInfoMapper {
    @Select("SELECT datname FROM pg_database")
    List<String> selectDatabases();

    @Select("SELECT schema_name FROM information_schema.schemata")
    List<String> selectSchemas();

    @Select("SELECT usename FROM pg_user")
    List<String> selectUsers();
}
