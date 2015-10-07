
update cliente set   
vch_cliepaterno   = #{paterno},   
vch_cliematerno   = #{materno},   
vch_clienombre    = #{nombre},    
chr_cliedni       = #{dni},       
vch_clieciudad    = #{ciudad},    
vch_cliedireccion = #{direccion}, 
vch_clietelefono  = #{telefono},  
vch_clieemail     = #{email}
where chr_cliecodigo = 

insert into cliente(chr_cliecodigo,
vch_cliepaterno,vch_cliematerno,  
vch_clienombre,chr_cliedni,      
vch_clieciudad,vch_cliedireccion,
vch_clietelefono,vch_clieemail)
values(#{codigo},#{paterno},#{materno},  
#{nombre},#{dni},#{ciudad},#{direccion},
#{telefono},#{email})


		select int_contitem, int_contlongitud 
		from contador
		where vch_conttabla='cliente'
		
		
		
		
		