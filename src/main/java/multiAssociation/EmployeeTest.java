package multiAssociation;

import multiAssociation.pojo.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import wenqi.SqlSessionFactoryUtils;

import java.util.List;

/**
 * Created by buwenqi on 2017/12/26.
 */
public class EmployeeTest {
    public static void main(String[] args){
        Logger logger=Logger.getLogger(EmployeeTest.class);
        SqlSession sqlSession= SqlSessionFactoryUtils.openSqlSessionAutocommit();
        EmployeeMapper employeeMapper=sqlSession.getMapper(EmployeeMapper.class);
        Employee employee1=employeeMapper.getEmployeeById(1L);
        logger.debug(employee1.getClass().getSimpleName());
        logger.debug("employeeName:"+employee1.getRealName()+",employeeBirthday:"+employee1.getBirthday());
        logger.debug("sex:"+employee1.getSex()+",employeeId:"+employee1.getId());
        WorkCard workCard=employee1.getWorkCard();
        if(workCard!=null)
        logger.debug("workCardId:"+workCard.getId()+",workCardName:"+workCard.getRealName());
        List<EmployeeTask> tasks=employee1.getEmployeeTaskList();
        if(tasks!=null)
        for(EmployeeTask task:tasks){
            logger.debug("task--------------start");
            logger.debug("taskName:"+task.getTaskName()+",taskNote:"+task.getNote());
            logger.debug("task--------------end");
        }

        if(employee1 instanceof MaleEmployee){
            MaleEmployee maleEmployee=(MaleEmployee)employee1;
            logger.debug("男性报告："+maleEmployee.getMaleHealthForm().getNote());
        }else{
            FemaleEmployee femaleEmployee=(FemaleEmployee)employee1;
            logger.debug("女性报告："+ femaleEmployee.getFemaleHealthForm().getNote());
        }
    }
}
