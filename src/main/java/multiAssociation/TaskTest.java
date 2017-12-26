package multiAssociation;

import multiAssociation.pojo.Task;
import multiAssociation.pojo.TaskMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import wenqi.SqlSessionFactoryUtils;

/**
 * Created by buwenqi on 2017/12/22.
 */
public class TaskTest {
    public static void main(String[] args){
        Logger logger=Logger.getLogger(TaskTest.class);
        SqlSession sqlSession= null;
        try{
            sqlSession=SqlSessionFactoryUtils.openSqlSessionAutocommit();
            TaskMapper taskMapper=sqlSession.getMapper(TaskMapper.class);
            Task task=new Task();
            task.setTitle("测试task");
            task.setContext("测试");
            task.setNote("测试！");
            taskMapper.insertTask(task);
            logger.debug("Task id:"+task.getId());

            Task task2=taskMapper.getTaskById(task.getId());
            logger.debug("task2:"+task2.getTitle()+",task_name:"+task2.getNote()+",equals:"+task.equals(task2));
        }finally {
            if(sqlSession!=null)
                sqlSession.close();
        }
    }
}
