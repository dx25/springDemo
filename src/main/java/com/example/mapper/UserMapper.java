package com.example.mapper;

import com.example.bean.Person;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by silence on 2017/7/4.
 */
public interface UserMapper {
    @Select("select * from table_user")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age"),
            @Result(property = "password", column = "password")
    })
    List<Person> getAll();

    @Select("select * from table_user where id = #{id}")
    Person selectPersonByPK(@Param("id") Long id);

    @Select("select * from table_user where name = #{userName}")
    Person selectPersonByUserName(@Param("userName") String userName);

    @Update("update table_user set password = #{password} where id = #{id}")
    void updatePassword(Person person);
}
