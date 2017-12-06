package wenqi;


import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

/**
 * Created by buwenqi on 2017/12/5.
 */
public class Test {
    public static void main(String[] args){
        Logger log=Logger.getLogger(Test.class);
        SqlSession sqlSession=null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = new Role();
            role.setRoleName("lisi");
            role.setNote("这是李四");
            long result = roleMapper.insertRole(role);
            System.out.println("插入：" + result);
            sqlSession.commit();
            //sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }
}
