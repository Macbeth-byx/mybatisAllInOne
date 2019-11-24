package p2.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import p2.pojo.Teacher;
import p2.util.MybatisUtils;

import java.util.List;

public class TeacherMapperTest {

    @Test
    public void getTeacher() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teacher1 = mapper.getTeacher();
        for (Teacher teacher : teacher1) {
            System.out.println(teacher);
        }
        sqlSession.close();
    }

    @Test
    public void getTeacherById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacherById = mapper.getTeacherById(1);
        System.out.println(teacherById);
        sqlSession.close();
    }

    @Test
    public void getTeachr2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher2 = mapper.getTeacher2(1);
        System.out.println(teacher2);
        sqlSession.close();
    }
}