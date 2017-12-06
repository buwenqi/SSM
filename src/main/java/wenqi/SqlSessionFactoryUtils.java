package wenqi;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by buwenqi on 2017/12/5.
 */
public class SqlSessionFactoryUtils {
    private static SqlSessionFactory sqlSessionFactory=null;

    private synchronized static SqlSessionFactory getSqlSessionFactory(){
        if(sqlSessionFactory!=null)
            return sqlSessionFactory;
        try {
            File myfile=new File("mybatis-config.xml");
            if(myfile.exists()){
                System.out.println("文件存在");
            }
            InputStream input=Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }

    public static SqlSession openSqlSession(){
        if(sqlSessionFactory==null)
            getSqlSessionFactory();
        return sqlSessionFactory.openSession();
    }
}
