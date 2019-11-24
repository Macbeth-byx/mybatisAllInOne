package p2.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import p2.pojo.Student;
import p2.util.MybatisUtils;

import java.util.List;

import static org.junit.Assert.*;

public class StudentMapperTest {

    @Test
    public void getStudentInfo() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentInfo = mapper.getStudentInfo();
        for (Student student : studentInfo) {
            System.out.println(student);
        }
    }

    @Test
    public void getStudent2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentInfo = mapper.getStudent2();
        for (Student student : studentInfo) {
            System.out.println(student);
        }
    }

}