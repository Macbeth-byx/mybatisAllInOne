package p2.dao;

import org.apache.ibatis.annotations.*;
import p2.pojo.User;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    List<User> getUsers();

    @Select("select * from user where id=#{id}")
    User getUserById(@Param("id") int id);

    @Insert("insert into user(id,name,pwd) values(#{id}, #{name},#{password})")
    int addUser(User user);

    @Update("update user set name=#{name}, pwd=#{password} where id=#{id}")
    int updateUser(User user);

    @Delete("delete from user where id=#{id}")
    int deleteUser(@Param("id") int id);
}
