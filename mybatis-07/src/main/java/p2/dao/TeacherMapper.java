package p2.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import p2.pojo.Teacher;

import java.util.List;

public interface TeacherMapper {



    List<Teacher> getTeacher();

    Teacher getTeacherById(@Param("tid") int tid);

    Teacher getTeacher2(@Param("tid") int tid);
}
