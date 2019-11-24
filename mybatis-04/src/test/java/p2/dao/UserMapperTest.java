package p2.dao;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import p2.pojo.User;
import p2.util.MybatisUtils;

import java.util.HashMap;
import java.util.List;

public class UserMapperTest {

    Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void getUserByRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RowBounds rowBounds = new RowBounds(1, 2);
        List<User> users = sqlSession.selectList("p2.dao.UserMapper.getUserByRowBounds",null, rowBounds);
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }
    @Test
    public void getUserList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);
    }

    @Test
    public void logtest() {
        logger.info("info:enter log4j");
        logger.debug("debug: enter debug");
        logger.error("error: enter error");
    }

    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<String, Integer>();
        stringIntegerHashMap.put("startIndex", 0);
        stringIntegerHashMap.put("pageSize", 2);

        List<User> userByLimit = mapper.getUserByLimit(stringIntegerHashMap);
        for (User user : userByLimit) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}