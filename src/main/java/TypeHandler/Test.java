package TypeHandler;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;
import org.apache.ibatis.type.EnumTypeHandler;
import org.apache.log4j.Logger;
import wenqi.SqlSessionFactoryUtils;

/**
 * Created by buwenqi on 2017/12/17.
 */
public class Test {
    public static void main(String[] args){
        Logger logger=Logger.getLogger(Test.class);
        SqlSession sqlSession=null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSessionAutocommit();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            Student student = new Student();
            student.setName("小红");
            student.setAge(18);
            student.setSex(SexEnum.FEMALE);
            String[] interests = {"football","basketball"};
            student.setInterests(interests);
            int insertResult=studentMapper.insertStudent(student);
            System.out.printf("result:%d,name:%s,id:%s\n",insertResult,student.getName(),student.getId());

            Student student1=studentMapper.findStudentById(student.getId());
            System.out.println(student1.toString());
        }finally {
            if (sqlSession!=null)
                sqlSession.close();
        }

    }
}
