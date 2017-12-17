package TypeHandler;

/**
 * Created by buwenqi on 2017/12/16.
 */
public interface StudentMapper {
    int insertStudent(Student student);
    Student findStudentById(int id);
}
