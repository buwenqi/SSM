package multiAssociation;

import multiAssociation.pojo.FemaleHealthForm;
import multiAssociation.pojo.FemaleHealthFormMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import wenqi.SqlSessionFactoryUtils;

/**
 * Created by buwenqi on 2017/12/26.
 */
public class FemaleHealthFormTest {
    public static void main(String[] args){
        Logger logger=Logger.getLogger(FemaleHealthFormTest.class);
        SqlSession sqlSession= SqlSessionFactoryUtils.openSqlSessionAutocommit();
        FemaleHealthFormMapper femaleHealthFormMapper=sqlSession.getMapper(FemaleHealthFormMapper.class);
        FemaleHealthForm femaleHealthForm=new FemaleHealthForm();
        femaleHealthForm.setEmpId(2L);
        femaleHealthForm.setUterus("正常");
        femaleHealthForm.setHeart("略快");
        femaleHealthForm.setKidney("正常");
        femaleHealthForm.setSpleen("正常");
        femaleHealthForm.setLiver("正常");
        femaleHealthForm.setLung("正常");
        femaleHealthForm.setNote("有小问题");
        femaleHealthFormMapper.insertFemaleHealthForm(femaleHealthForm);

        //select
        FemaleHealthForm femaleHealthForm1=femaleHealthFormMapper.getFemaleHealthFormWithEmpId(2L);
        logger.debug("femaleHealthForm1:"+femaleHealthForm1.getId()+",conclusion:"+femaleHealthForm1.getNote());

    }
}
