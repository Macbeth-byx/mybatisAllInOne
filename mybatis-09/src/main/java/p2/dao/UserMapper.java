package p2.dao;

import org.apache.ibatis.annotations.Param;
import p2.pojo.User;

public interface UserMapper {

    User queryUsebyId(@Param("id") int id);

    int updateUser(User user);
}
