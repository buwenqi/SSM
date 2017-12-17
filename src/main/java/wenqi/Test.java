package wenqi;


import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by buwenqi on 2017/12/5.
 */
public class Test {
    public static void main(String[] args){
        //System.out.println(Class.class.getClass().getResource("/").getPath() );
        Logger log=Logger.getLogger(Test.class);
        SqlSession sqlSession=null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            List<Role> roles=roleMapper.findRoles("li");
            roles.forEach(role->System.out.println(String.format("role:%d,%s,%s",role.getId(),role.getRoleName(),role.getNote())));
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }
}
