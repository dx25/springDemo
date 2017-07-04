package com.example.mapper;

import com.example.bean.Person;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by silence on 2017/7/4.
 */
public interface UserMapper {
    @Select("select * from table_user")
    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    List<Person> getAll();

    @Select("select * from table_user where id = #{id}")
    Person selectPersonByPK(@Param("id") Long id);
}
