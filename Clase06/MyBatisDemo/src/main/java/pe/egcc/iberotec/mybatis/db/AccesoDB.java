package pe.egcc.iberotec.mybatis.db;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public final class AccesoDB {

  private static SqlSessionFactory sqlSessionFactory;
  
  static{
    try{
      String resource = "pe/egcc/iberotec/mybatis/db/mybatis-config.xml";
      Reader reader = Resources.getResourceAsReader(resource);
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    } catch(Exception e){
    }
  }
  
  private AccesoDB() {
  }
  
  public static SqlSession getSqlSession(){
    return sqlSessionFactory.openSession();
  }
  
}
