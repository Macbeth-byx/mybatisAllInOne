package com.p2.springbootmybatis.dao;

import com.p2.springbootmybatis.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    User findById(@Param("id") int id);

    int insert(User user);

    @Select("select * from user")
    List<User> showUser();

}
