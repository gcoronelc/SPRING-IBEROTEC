package pe.egcc.iberotec.prueba;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pe.egcc.iberotec.app.model.ClienteBean;
import pe.egcc.iberotec.mybatis.espec.ClienteMapper;

public class Prueba01 {

  public static void main(String[] args) {
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession sqlSession = null;
    ClienteMapper clienteMapper;
    List<ClienteBean> lista;
    try {
      String resource = "pe/egcc/iberotec/mybatis/db/mybatis-config.xml";
      Reader reader = Resources.getResourceAsReader(resource);
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
      sqlSession = sqlSessionFactory.openSession();
      
      clienteMapper = sqlSession.getMapper(ClienteMapper.class);
      lista = clienteMapper.getTodos();
      for (ClienteBean clienteBean : lista) {
        System.out.println(clienteBean.getCodigo() +
            " - " + clienteBean.getNombre());
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        sqlSession.close();
      } catch (Exception e2) {
        // TODO: handle exception
      }
    }
  }
}
