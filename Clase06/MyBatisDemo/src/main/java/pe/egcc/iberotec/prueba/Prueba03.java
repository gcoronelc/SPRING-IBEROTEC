package pe.egcc.iberotec.prueba;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pe.egcc.iberotec.app.model.ClienteBean;
import pe.egcc.iberotec.app.model.EmpleadoBean;
import pe.egcc.iberotec.mybatis.db.AccesoDB;
import pe.egcc.iberotec.mybatis.espec.ClienteMapper;
import pe.egcc.iberotec.mybatis.espec.EmpleadoMapper;

public class Prueba03 {

  public static void main(String[] args) {
    SqlSession sqlSession = null;
    try {
      sqlSession = AccesoDB.getSqlSession();
      EmpleadoMapper empleadoMapper;
      empleadoMapper = sqlSession.getMapper(EmpleadoMapper.class);
      
      EmpleadoBean empleadoBean = empleadoMapper.validar("cromero", "chicho");
      if(empleadoBean == null){
        throw new RuntimeException("Datos incorrectos.!!!");
      }
      System.err.println(empleadoBean.getCodigo()
            + " - " + empleadoBean.getNombre()
            + " - " + empleadoBean.getPaterno()
            + " - " + empleadoBean.getMaterno()
            + " - " + empleadoBean.getCiudad());
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        sqlSession.close();
      } catch (Exception e2) {
      }
    }
  }
}
