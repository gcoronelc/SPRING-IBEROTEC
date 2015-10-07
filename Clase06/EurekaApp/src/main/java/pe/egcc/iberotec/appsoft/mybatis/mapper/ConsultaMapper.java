package pe.egcc.iberotec.appsoft.mybatis.mapper;

import java.util.List;
import java.util.Map;

public interface ConsultaMapper {

	
	
	<select id="obtenerResumen" resultType="map">
	select
		*
	from empleado
	
	</select>
	
}
