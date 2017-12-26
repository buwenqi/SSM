package multiAssociation;


import multiAssociation.pojo.MaleHealthForm;
import multiAssociation.pojo.MaleHealthFormMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import wenqi.SqlSessionFactoryUtils;

/**
 * Created by buwenqi on 2017/12/26.
 */
public class MaleHealthFormTest {
    public static void main(String[] args){
        Logger logger=Logger.getLogger(MaleHealthFormTest.class);
        SqlSession sqlSession= SqlSessionFactoryUtils.openSqlSessionAutocommit();
        MaleHealthFormMapper maleHeathFormMapper=sqlSession.getMapper(MaleHealthFormMapper.class);
        MaleHealthForm maleHealthForm=new MaleHealthForm();
        maleHealthForm.setEmpId(1L);
        maleHealthForm.setProstate("正常");
        maleHealthForm.setHeart("正常");
        maleHealthForm.setKidney("正常");
        maleHealthForm.setLiver("正常");
        maleHealthForm.setLung("正常");
        maleHealthForm.setSpleen("正常");
        maleHealthForm.setNote("一切正常");
        maleHeathFormMapper.insertMaleHealthForm(maleHealthForm);

        //select
        MaleHealthForm maleHeathForm1=maleHeathFormMapper.getMaleHealthFormWithEmpId(1L);
        logger.debug("maleHealthForm1:"+maleHeathForm1.getEmpId()+",result:"+maleHeathForm1.getNote());
        sqlSession.close();

    }
}
