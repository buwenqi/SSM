package multiAssociation;

import multiAssociation.pojo.Task;
import multiAssociation.pojo.TaskMapper;
import multiAssociation.pojo.WorkCard;
import multiAssociation.pojo.WorkCardMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import wenqi.SqlSessionFactoryUtils;

/**
 * Created by buwenqi on 2017/12/26.
 */
public class WorkCardTest {
    public static void main(String[] args){
        Logger logger=Logger.getLogger(TaskTest.class);
        SqlSession sqlSession= null;
        try{
            sqlSession= SqlSessionFactoryUtils.openSqlSessionAutocommit();
            WorkCardMapper workCardMapper=sqlSession.getMapper(WorkCardMapper.class);
          /*  WorkCard workCard1=new WorkCard();
            workCard1.setEmpId(1L);
            workCard1.setRealName("张三");
            workCard1.setDepartment("214");
            workCard1.setMobile("12345");
            workCard1.setPosition("Shanghai");
            workCard1.setNote("实习");
            int flag=workCardMapper.insertWorkCard(workCard1);
            if (flag>0){
                logger.debug("插入成功："+workCard1.getId());
            }*/

            WorkCard workCard2=workCardMapper.getWorkCardByEmpId(1);
            logger.debug("workCard2:"+workCard2.getId()+",realName:"+workCard2.getRealName()+",position:"+workCard2.getPosition());

        }finally {
            if(sqlSession!=null)
                sqlSession.close();
        }
    }
}
