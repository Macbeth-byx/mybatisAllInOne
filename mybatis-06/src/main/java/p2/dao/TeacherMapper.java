package p2.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import p2.pojo.Teacher;

public interface TeacherMapper {
    @Select("select * from teacher where id = #{tid}")
    Teacher getTeacher(@Param("tid") int id);
}
