package p2.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import p2.pojo.User;
import p2.util.MybatisUtils;

import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest {

    @Test
    public void queryUsebyId() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUsebyId(1);
        System.out.println(user);
        mapper.updateUser(new User(2, "aaa",  "bbb"));
        User user1 = mapper.queryUsebyId(1);

        System.out.println(user==user1);
        sqlSession.close();
    }
}