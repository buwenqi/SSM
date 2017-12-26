package multiAssociation;

import multiAssociation.pojo.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import wenqi.SqlSessionFactoryUtils;

/**
 * Created by buwenqi on 2017/12/26.
 */
public class EmployeeTaskTest {
    public static void main(String[] args){
        Logger logger=Logger.getLogger(TaskTest.class);
        SqlSession sqlSession= null;
        try{
            sqlSession= SqlSessionFactoryUtils.openSqlSessionAutocommit();
            EmployeeTaskMapper employeeTaskMapper=sqlSession.getMapper(EmployeeTaskMapper.class);
            /*EmployeeTask employeeTask=new EmployeeTask();
            employeeTask.setEmpId(1L);
            employeeTask.setTaskName("test-empTask");
            employeeTask.setNote("test-empTask");
            Task task=new Task();
            task.setId(1L);//仅仅需要id就可以了，不会级联插入
            employeeTask.setTask(task);
            employeeTaskMapper.insertEmployeeTask(employeeTask);*/

            //assocation one-to-one select
            EmployeeTask employeeTask2=employeeTaskMapper.getEmployeeTaskByEmpId(1);
            logger.debug("employeeTask2:"+ employeeTask2.getTaskName()+",empId:"+employeeTask2.getEmpId());
            Task task=employeeTask2.getTask();
            if(task!=null){
                logger.debug("taskTitle:"+task.getTitle()+",taskNote:"+task.getNote());
            }else{
                logger.debug("task is null!");
            }
        }finally {
            if(sqlSession!=null)
                sqlSession.close();
        }
    }
}
