drop view v_movimiento;
go

create view v_movimiento(
sucucodigo, sucunombre, cliecodigo, cliepaterno,
cliematerno, clienombre, cuencodigo, cuensaldo,
cuenestado, movinumero, movifecha, moviimporte,
cuenreferencia, tipocodigo, tiponombre, tipoaccion,
monecodigo, monenombre)
as
select 
  su.chr_sucucodigo  sucucodigo,
  su.vch_sucunombre  sucunombre,
  cl.chr_cliecodigo  cliecodigo,
  cl.vch_cliepaterno cliepaterno,
  cl.vch_cliematerno cliematerno,
  cl.vch_clienombre  clienombre,
  c.chr_cuencodigo  cuencodigo,
  c.dec_cuensaldo   cuensaldo,
  c.vch_cuenestado  cuenestado,
  m.int_movinumero  movinumero,
  m.dtt_movifecha   movifecha,
  m.dec_moviimporte moviimporte,
  m.chr_cuenreferencia cuenreferencia,
  tm.chr_tipocodigo  tipocodigo,
  tm.vch_tipodescripcion tiponombre,
  tm.vch_tipoaccion  tipoaccion,
  mo.chr_monecodigo  monecodigo,
  mo.vch_monedescripcion monenombre
from tipomovimiento tm
join movimiento m on tm.chr_tipocodigo = m.chr_tipocodigo
join cuenta c on m.chr_cuencodigo = c.chr_cuencodigo
join moneda mo on c.chr_monecodigo = mo.chr_monecodigo
join cliente cl on c.chr_cliecodigo = cl.chr_cliecodigo
join sucursal su on c.chr_sucucodigo = su.chr_sucucodigo;
go

select * from v_movimiento
where cuencodigo='00100002';
go

select 
	sucucodigo, sucunombre, 
	tipoaccion, sum(moviimporte) importe
from v_movimiento
group by sucucodigo, sucunombre, tipoaccion;
go

--EJERCICIO
SUCUCODIGO   SUCUNOMBRE  INGRESO    SALIDA    DIFERENCIA
001          SIPAN       14500.00   3100.00   
002          CHAN CHAN   40500.00   20700.00  


select 
  sucucodigo, sucunombre,
  sum(case when tipoaccion='INGRESO' 
       then moviimporte else 0 end) ingreso,
  sum(case when tipoaccion='SALIDA' 
       then moviimporte else 0 end) salida,
  sum(case when tipoaccion='INGRESO' 
       then 1 else -1 end * moviimporte) diferencia
from v_movimiento
group by sucucodigo, sucunombre;
go


SELECT
	sucucodigo, sucunombre,
	[ingreso], [salida], [ingreso]-[salida] diferencia
FROM
	(select 
	sucucodigo, sucunombre, 
	tipoaccion, sum(moviimporte) importe
	from v_movimiento
	group by sucucodigo, sucunombre, tipoaccion) AS DATA
PIVOT(
	SUM(importe) FOR tipoaccion IN ([ingreso],[salida]) ) AS PVT_TABLE
	ORDER BY sucucodigo;
	
	
select 
  cuencodigo, movinumero, tipocodigo, tiponombre, tipoaccion, movifecha, moviimporte
from v_movimiento
where cuencodigo='00100001';


	