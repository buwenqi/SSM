package TypeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.*;

/**
 * Created by buwenqi on 2017/12/16.
 */
@MappedTypes(String[].class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class StringArrayTypeHandler extends BaseTypeHandler<String[]> {
    @Override
    /**
     * 将java类型转换为JDBC类型
     */
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String[] strings, JdbcType jdbcType) throws SQLException {
        StringBuilder builder=new StringBuilder();
        for(String item: strings){
            builder.append(item+",");
        }
        builder.deleteCharAt(builder.length()-1);
        System.out.println(builder.toString());
        preparedStatement.setString(i,builder.toString());

    }

    @Override
    /**
     *通过列名获取Java类型的值
     */
    public String[] getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String result=resultSet.getString(s);
        if(result!=null){
            return result.split(",");
        }else{
            return null;
        }
    }

    @Override
    public String[] getNullableResult(ResultSet resultSet, int i) throws SQLException {
       String result=resultSet.getString(i);
       if(result==null)
           return null;
       return result.split(",");
    }

    @Override
    public String[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
       String result=callableStatement.getString(i);
       if(result==null)
           return null;
       return result.split(",");
    }
}
