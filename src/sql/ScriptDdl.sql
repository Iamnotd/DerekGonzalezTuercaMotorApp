-- ============================================================================
-- DEREK SILVESTRE - 2024486 - IN4CM 
-- ============================================================================

-- drop database if exists tuercamotor_in4cm;
create database if not exists tuercamotor_in4cm;
use tuercamotor_in4cm;

-- =========================================
-- TABLAS
-- =========================================

create table clientes(
    cui bigint primary key,
    nombre varchar(100) not null,
    apellido varchar(100) not null,
    direccion text not null,
    telefono varchar(15)
);

create table vehiculos(
    placa varchar(8) primary key,
    marca varchar(100) not null,
    color varchar(100),
    modelo varchar(100),
    cui_cliente bigint not null
);

create table mecanicos(
    no_empleado bigint primary key,
    nombre varchar(100) not null,
    apellido varchar(100) not null
);

create table ordenes_servicio(
    id_orden int auto_increment primary key,
    fecha_ingreso date not null,
    presupuesto decimal(10,2),
    placa_vehiculo varchar(8) not null,
    no_mecanico bigint not null,
    horas_dedicadas time
);

create table repuestos(
    codigo bigint primary key,
    nombre varchar(100) not null,
    precio_unitario decimal(10,2) not null,
    stock int not null
);

create table detalles_orden_repuestos(
    id_detalle bigint auto_increment primary key,
    id_orden int not null,
    codigo_repuesto bigint not null,
    cantidad_usada int not null,
    precio_momento decimal(10,2) not null
);

-- =========================================
-- LLAVES FORANEAS (CONSTRAINTS)
-- =========================================

alter table vehiculos
add constraint fk_vehiculos_clientes
foreign key (cui_cliente) references clientes(cui)
on delete cascade on update cascade;

alter table ordenes_servicio
add constraint fk_ordenes_vehiculos
foreign key (placa_vehiculo) references vehiculos(placa)
on delete cascade on update cascade,
add constraint fk_ordenes_mecanicos
foreign key (no_mecanico) references mecanicos(no_empleado)
on delete cascade on update cascade;

alter table detalles_orden_repuestos
add constraint fk_detalles_orden
foreign key (id_orden) references ordenes_servicio(id_orden)
on delete cascade on update cascade,
add constraint fk_detalles_repuesto
foreign key (codigo_repuesto) references repuestos(codigo)
on delete cascade on update cascade;

-- ============================================================================
-- PROCEDIMIENTOS ALMACENADOS (CRUD)
-- ============================================================================

delimiter //

-- =========================================
-- CLIENTES
-- =========================================

create procedure sp_insertar_clientes(
    in p_cui bigint,
    in p_nombre varchar(100),
    in p_apellido varchar(100),
    in p_direccion text,
    in p_telefono varchar(15)
)
begin
    insert into clientes values(p_cui, p_nombre, p_apellido, p_direccion, p_telefono);
end //

create procedure sp_actualizar_clientes(
    in p_cui bigint,
    in p_nombre varchar(100),
    in p_apellido varchar(100),
    in p_direccion text,
    in p_telefono varchar(15)
)
begin
    update clientes
    set nombre = p_nombre,
        apellido = p_apellido,
        direccion = p_direccion,
        telefono = p_telefono
    where cui = p_cui;
end //

create procedure sp_eliminar_clientes(
    in p_cui bigint
)
begin
    delete from clientes where cui = p_cui;
end //

create procedure sp_listar_clientes()
begin
    select * from clientes;
end //

-- =========================================
-- VEHICULOS
-- =========================================

create procedure sp_insertar_vehiculos(
    in p_placa varchar(8),
    in p_marca varchar(100),
    in p_color varchar(100),
    in p_modelo varchar(100),
    in p_cui_cliente bigint
)
begin
    insert into vehiculos values(p_placa, p_marca, p_color, p_modelo, p_cui_cliente);
end //

create procedure sp_actualizar_vehiculos(
    in p_placa varchar(8),
    in p_marca varchar(100),
    in p_color varchar(100),
    in p_modelo varchar(100),
    in p_cui_cliente bigint
)
begin
    update vehiculos
    set marca = p_marca,
        color = p_color,
        modelo = p_modelo,
        cui_cliente = p_cui_cliente
    where placa = p_placa;
end //

create procedure sp_eliminar_vehiculos(
    in p_placa varchar(8)
)
begin
    delete from vehiculos where placa = p_placa;
end //

create procedure sp_listar_vehiculos()
begin
    select * from vehiculos;
end //

-- =========================================
-- MECANICOS
-- =========================================

create procedure sp_insertar_mecanicos(
    in p_no_empleado bigint,
    in p_nombre varchar(100),
    in p_apellido varchar(100)
)
begin
    insert into mecanicos values(p_no_empleado, p_nombre, p_apellido);
end //

create procedure sp_actualizar_mecanicos(
    in p_no_empleado bigint,
    in p_nombre varchar(100),
    in p_apellido varchar(100)
)
begin
    update mecanicos
    set nombre = p_nombre,
        apellido = p_apellido
    where no_empleado = p_no_empleado;
end //

create procedure sp_eliminar_mecanicos(
    in p_no_empleado bigint
)
begin
    delete from mecanicos where no_empleado = p_no_empleado;
end //

create procedure sp_listar_mecanicos()
begin
    select * from mecanicos;
end //

-- =========================================
-- ORDEN SERVICIO
-- =========================================

create procedure sp_insertar_orden_servicio(
    in p_fecha_ingreso date,
    in p_presupuesto decimal(10,2),
    in p_placa_vehiculo varchar(8),
    in p_no_mecanico bigint,
    in p_horas_dedicadas time
)
begin
    insert into ordenes_servicio(fecha_ingreso, presupuesto, placa_vehiculo, no_mecanico, horas_dedicadas)
    values(p_fecha_ingreso, p_presupuesto, p_placa_vehiculo, p_no_mecanico, p_horas_dedicadas);
end //

create procedure sp_actualizar_orden_servicio(
    in p_id_orden int,
    in p_fecha_ingreso date,
    in p_presupuesto decimal(10,2),
    in p_placa_vehiculo varchar(8),
    in p_no_mecanico bigint,
    in p_horas_dedicadas time
)
begin
    update ordenes_servicio
    set fecha_ingreso = p_fecha_ingreso,
        presupuesto = p_presupuesto,
        placa_vehiculo = p_placa_vehiculo,
        no_mecanico = p_no_mecanico,
        horas_dedicadas = p_horas_dedicadas
    where id_orden = p_id_orden;
end //

create procedure sp_eliminar_orden_servicio(
    in p_id_orden int
)
begin
    delete from ordenes_servicio where id_orden = p_id_orden;
end //

create procedure sp_listar_orden_servicio()
begin
    select * from ordenes_servicio;
end //

-- =========================================
-- REPUESTOS
-- =========================================

create procedure sp_insertar_repuestos(
    in p_codigo bigint,
    in p_nombre varchar(100),
    in p_precio_unitario decimal(10,2),
    in p_stock int
)
begin
    insert into repuestos values(p_codigo, p_nombre, p_precio_unitario, p_stock);
end //

create procedure sp_actualizar_repuestos(
    in p_codigo bigint,
    in p_nombre varchar(100),
    in p_precio_unitario decimal(10,2),
    in p_stock int
)
begin
    update repuestos
    set nombre = p_nombre,
        precio_unitario = p_precio_unitario,
        stock = p_stock
    where codigo = p_codigo;
end //

create procedure sp_eliminar_repuestos(
    in p_codigo bigint
)
begin
    delete from repuestos where codigo = p_codigo;
end //

create procedure sp_listar_repuestos()
begin
    select * from repuestos;
end //

-- =========================================
-- DETALLES ORDEN REPUESTOS
-- =========================================

create procedure sp_insertar_detalles_repuestos(
    in p_id_orden int,
    in p_codigo_repuesto bigint,
    in p_cantidad_usada int,
    in p_precio_momento decimal(10,2)
)
begin
    insert into detalles_orden_repuestos(id_orden, codigo_repuesto, cantidad_usada, precio_momento)
    values(p_id_orden, p_codigo_repuesto, p_cantidad_usada, p_precio_momento);
end //

create procedure sp_actualizar_detalles_repuestos(
    in p_id_detalle bigint,
    in p_id_orden int,
    in p_codigo_repuesto bigint,
    in p_cantidad_usada int,
    in p_precio_momento decimal(10,2)
)
begin
    update detalles_orden_repuestos
    set id_orden = p_id_orden,
        codigo_repuesto = p_codigo_repuesto,
        cantidad_usada = p_cantidad_usada,
        precio_momento = p_precio_momento
    where id_detalle = p_id_detalle;
end //

create procedure sp_eliminar_detalles_repuestos(
    in p_id_detalle bigint
)
begin
    delete from detalles_orden_repuestos where id_detalle = p_id_detalle;
end //

create procedure sp_listar_detalles_repuestos()
begin
    select * from detalles_orden_repuestos;
end //

delimiter ;

-- =========================================
-- VISTAS (VIEWS)
-- =========================================

create view vista_clientes_vehiculos as
select
    c.cui,
    c.nombre,
    c.apellido,
    v.placa,
    v.marca,
    v.modelo
from clientes c
inner join vehiculos v on c.cui = v.cui_cliente;

create view vista_mecanicos_repuestos as
select
    m.no_empleado,
    m.nombre as nombre_mecanico,
    o.id_orden,
    r.nombre as repuesto,
    dor.cantidad_usada,
    dor.precio_momento
from mecanicos m
inner join ordenes_servicio o on m.no_empleado = o.no_mecanico
inner join detalles_orden_repuestos dor on o.id_orden = dor.id_orden
inner join repuestos r on dor.codigo_repuesto = r.codigo;

-- =========================================
-- PROCEDIMIENTOS PARA LISTAR VISTAS
-- =========================================

delimiter //

create procedure sp_listar_vista_clientes_vehiculos()
begin
    select * from vista_clientes_vehiculos;
end //

create procedure sp_listar_vista_mecanicos_repuestos()
begin
    select * from vista_mecanicos_repuestos;
end //

delimiter ;