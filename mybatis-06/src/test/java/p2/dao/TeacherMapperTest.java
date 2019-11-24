package p2.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import p2.pojo.Teacher;
import p2.util.MybatisUtils;

import static org.junit.Assert.*;

public class TeacherMapperTest {

    @Test
    public void getTeacher() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
    }
}