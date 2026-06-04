use tuercamotor_in4cm;

-- =========================================
-- CLIENTES 
-- =========================================
call sp_insertar_clientes(16121210101, 'mario', 'lopez', 'zona 10, ciudad', '4343-4546');
call sp_insertar_clientes(13131310102, 'carlos', 'ramirez', 'zona 5, mixco', '4545-5656');
call sp_insertar_clientes(14141410103, 'maria', 'gomez', 'villa nueva', '4747-5858');
call sp_insertar_clientes(15151510104, 'jose', 'martinez', 'amatitlan', '4848-5959');
call sp_insertar_clientes(16161610105, 'lucia', 'fernandez', 'zona 7, ciudad', '4949-6060');
call sp_insertar_clientes(17171710106, 'miguel', 'castillo', 'zona 3, villa canales', '5050-6161');
call sp_insertar_clientes(18181810107, 'sofia', 'hernandez', 'escuintla', '5151-6262');
call sp_insertar_clientes(19191910108, 'luis', 'morales', 'zona 12, ciudad', '5252-6363');
call sp_insertar_clientes(20202010109, 'valeria', 'ruiz', 'quetzaltenango', '5353-6464');
call sp_insertar_clientes(21212110110, 'andres', 'vasquez', 'retalhuleu', '5454-6565');
call sp_insertar_clientes(22222210111, 'paola', 'mendoza', 'zona 11, ciudad', '5555-6666');
call sp_insertar_clientes(23232310112, 'fernando', 'ortega', 'san miguel petapa', '5656-6767');
call sp_insertar_clientes(24242410113, 'daniela', 'flores', 'zona 15, ciudad', '5757-6868');
call sp_insertar_clientes(25252510114, 'ricardo', 'aguilar', 'chimaltenango', '5858-6969');
call sp_insertar_clientes(26262610115, 'elena', 'navarro', 'sacatepequez', '5959-7070');
call sp_insertar_clientes(27272710116, 'pedro', 'reyes', 'zona 18, ciudad', '6060-7171');
call sp_insertar_clientes(28282810117, 'gabriela', 'cruz', 'jalapa', '6161-7272');
call sp_insertar_clientes(29292910118, 'diego', 'santos', 'zona 6, ciudad', '6262-7373');
call sp_insertar_clientes(30303010119, 'natalia', 'pineda', 'coban', '6363-7474');
call sp_insertar_clientes(31313110120, 'hugo', 'salazar', 'huehuetenango', '6464-7575');

-- =========================================
-- VEHICULOS (20 REGISTROS)
-- =========================================
call sp_insertar_vehiculos('p125abc', 'toyota', 'rojo', '2020', 16121210101);
call sp_insertar_vehiculos('p234bcd', 'honda', 'azul', '2019', 13131310102);
call sp_insertar_vehiculos('p345cde', 'nissan', 'blanco', '2021', 14141410103);
call sp_insertar_vehiculos('p456def', 'mazda', 'negro', '2018', 15151510104);
call sp_insertar_vehiculos('p567efg', 'hyundai', 'gris', '2022', 16161610105);
call sp_insertar_vehiculos('p678fgh', 'kia', 'plata', '2020', 17171710106);
call sp_insertar_vehiculos('p789ghi', 'chevrolet', 'rojo', '2017', 18181810107);
call sp_insertar_vehiculos('p890hij', 'ford', 'azul', '2023', 19191910108);
call sp_insertar_vehiculos('p901ijk', 'volkswagen', 'blanco', '2019', 20202010109);
call sp_insertar_vehiculos('p012jkl', 'mitsubishi', 'negro', '2021', 21212110110);
call sp_insertar_vehiculos('p135klm', 'suzuki', 'verde', '2018', 22222210111);
call sp_insertar_vehiculos('p246lmn', 'bmw', 'gris', '2022', 23232310112);
call sp_insertar_vehiculos('p357mno', 'mercedes', 'plata', '2020', 24242410113);
call sp_insertar_vehiculos('p468nop', 'audi', 'rojo', '2021', 25252510114);
call sp_insertar_vehiculos('p579opq', 'jeep', 'azul', '2019', 26262610115);
call sp_insertar_vehiculos('p680pqr', 'subaru', 'blanco', '2017', 27272710116);
call sp_insertar_vehiculos('p791qrs', 'peugeot', 'negro', '2023', 28282810117);
call sp_insertar_vehiculos('p802rst', 'renault', 'gris', '2020', 29292910118);
call sp_insertar_vehiculos('p913stu', 'tesla', 'blanco', '2022', 30303010119);
call sp_insertar_vehiculos('p024tuv', 'volvo', 'azul', '2021', 31313110120);

-- =========================================
-- MECANICOS (20 REGISTROS)
-- =========================================
call sp_insertar_mecanicos(1001, 'carlos', 'mendez');
call sp_insertar_mecanicos(1002, 'luis', 'ramirez');
call sp_insertar_mecanicos(1003, 'jose', 'hernandez');
call sp_insertar_mecanicos(1004, 'miguel', 'castillo');
call sp_insertar_mecanicos(1005, 'andres', 'morales');
call sp_insertar_mecanicos(1006, 'fernando', 'gomez');
call sp_insertar_mecanicos(1007, 'ricardo', 'vasquez');
call sp_insertar_mecanicos(1008, 'pedro', 'ruiz');
call sp_insertar_mecanicos(1009, 'hugo', 'martinez');
call sp_insertar_mecanicos(1010, 'diego', 'flores');
call sp_insertar_mecanicos(1011, 'mario', 'navarro');
call sp_insertar_mecanicos(1012, 'jorge', 'aguilar');
call sp_insertar_mecanicos(1013, 'raul', 'ortega');
call sp_insertar_mecanicos(1014, 'sergio', 'pineda');
call sp_insertar_mecanicos(1015, 'manuel', 'cruz');
call sp_insertar_mecanicos(1016, 'eduardo', 'santos');
call sp_insertar_mecanicos(1017, 'pablo', 'reyes');
call sp_insertar_mecanicos(1018, 'esteban', 'salazar');
call sp_insertar_mecanicos(1019, 'tomas', 'fernandez');
call sp_insertar_mecanicos(1020, 'javier', 'mendoza');

-- =========================================
-- ORDENES DE SERVICIO (20 REGISTROS)
-- =========================================
call sp_insertar_orden_servicio('2026-01-05', 1500.00, 'p125abc', 1001, '08:00:00');
call sp_insertar_orden_servicio('2026-01-08', 2300.50, 'p234bcd', 1002, '06:00:00');
call sp_insertar_orden_servicio('2026-01-10', 1750.75, 'p345cde', 1003, '07:00:00');
call sp_insertar_orden_servicio('2026-01-12', 3200.00, 'p456def', 1004, '05:00:00');
call sp_insertar_orden_servicio('2026-01-15', 980.25,  'p567efg', 1005, '09:00:00');
call sp_insertar_orden_servicio('2026-01-18', 4100.90, 'p678fgh', 1006, '04:00:00');
call sp_insertar_orden_servicio('2026-01-20', 2650.40, 'p789ghi', 1007, '08:00:00');
call sp_insertar_orden_servicio('2026-01-22', 1450.00, 'p890hij', 1008, '06:00:00');
call sp_insertar_orden_servicio('2026-01-25', 3890.60, 'p901ijk', 1009, '07:00:00');
call sp_insertar_orden_servicio('2026-01-27', 2100.30, 'p012jkl', 1010, '05:00:00');
call sp_insertar_orden_servicio('2026-02-01', 1755.80, 'p135klm', 1011, '08:00:00');
call sp_insertar_orden_servicio('2026-02-03', 2999.99, 'p246lmn', 1012, '06:00:00');
call sp_insertar_orden_servicio('2026-02-05', 1250.45, 'p357mno', 1013, '07:00:00');
call sp_insertar_orden_servicio('2026-02-08', 3400.00, 'p468nop', 1014, '04:00:00');
call sp_insertar_orden_servicio('2026-02-10', 1875.20, 'p579opq', 1015, '09:00:00');
call sp_insertar_orden_servicio('2026-02-12', 4500.75, 'p680pqr', 1016, '05:00:00');
call sp_insertar_orden_servicio('2026-02-15', 2200.10, 'p791qrs', 1017, '08:00:00');
call sp_insertar_orden_servicio('2026-02-18', 1999.95, 'p802rst', 1018, '06:00:00');
call sp_insertar_orden_servicio('2026-02-20', 2780.60, 'p913stu', 1019, '07:00:00');
call sp_insertar_orden_servicio('2026-02-22', 1600.00, 'p024tuv', 1020, '05:00:00');

-- =========================================
-- REPUESTOS (20 REGISTROS)
-- =========================================
call sp_insertar_repuestos(2001, 'filtro de aceite', 85.50, 50);
call sp_insertar_repuestos(2002, 'pastillas de freno', 320.00, 30);
call sp_insertar_repuestos(2003, 'bujia', 45.75, 100);
call sp_insertar_repuestos(2004, 'aceite sintetico', 250.00, 40);
call sp_insertar_repuestos(2005, 'bateria', 950.00, 15);
call sp_insertar_repuestos(2006, 'correa de distribucion', 475.25, 10);
call sp_insertar_repuestos(2007, 'radiador', 1250.00, 8);
call sp_insertar_repuestos(2008, 'filtro de aire', 90.00, 35);
call sp_insertar_repuestos(2009, 'amortiguador', 780.50, 20);
call sp_insertar_repuestos(2010, 'liquido de frenos', 60.00, 60);
call sp_insertar_repuestos(2011, 'alternador', 1450.75, 5);
call sp_insertar_repuestos(2012, 'llanta', 650.00, 80);
call sp_insertar_repuestos(2013, 'sensor de oxigeno', 520.30, 12);
call sp_insertar_repuestos(2014, 'bombilla halogena', 35.00, 120);
call sp_insertar_repuestos(2015, 'motor de arranque', 1750.90, 6);
call sp_insertar_repuestos(2016, 'filtro de combustible', 110.25, 45);
call sp_insertar_repuestos(2017, 'compresor de aire', 2300.00, 4);
call sp_insertar_repuestos(2018, 'empaque de culata', 410.40, 15);
call sp_insertar_repuestos(2019, 'manguera de radiador', 95.60, 25);
call sp_insertar_repuestos(2020, 'disco de freno', 380.00, 24);

-- =========================================
-- DETALLES ORDEN REPUESTOS (20 REGISTROS)
-- =========================================
call sp_insertar_detalles_repuestos(1, 2001, 2, 85.50);
call sp_insertar_detalles_repuestos(2, 2002, 1, 320.00);
call sp_insertar_detalles_repuestos(3, 2003, 4, 45.75);
call sp_insertar_detalles_repuestos(4, 2004, 3, 250.00);
call sp_insertar_detalles_repuestos(5, 2005, 1, 950.00);
call sp_insertar_detalles_repuestos(6, 2006, 1, 475.25);
call sp_insertar_detalles_repuestos(7, 2007, 1, 1250.00);
call sp_insertar_detalles_repuestos(8, 2008, 2, 90.00);
call sp_insertar_detalles_repuestos(9, 2009, 2, 780.50);
call sp_insertar_detalles_repuestos(10, 2010, 3, 60.00);
call sp_insertar_detalles_repuestos(11, 2011, 1, 1450.75);
call sp_insertar_detalles_repuestos(12, 2012, 4, 650.00);
call sp_insertar_detalles_repuestos(13, 2013, 1, 520.30);
call sp_insertar_detalles_repuestos(14, 2014, 6, 35.00);
call sp_insertar_detalles_repuestos(15, 2015, 1, 1750.90);
call sp_insertar_detalles_repuestos(16, 2016, 2, 110.25);
call sp_insertar_detalles_repuestos(17, 2017, 1, 2300.00);
call sp_insertar_detalles_repuestos(18, 2018, 1, 410.40);
call sp_insertar_detalles_repuestos(19, 2019, 3, 95.60);
call sp_insertar_detalles_repuestos(20, 2020, 2, 380.00);

-- =========================================
-- LISTAR DATOS Y VISTAS
-- =========================================
call sp_listar_clientes();
call sp_listar_vehiculos();
call sp_listar_mecanicos();
call sp_listar_orden_servicio();
call sp_listar_repuestos();
call sp_listar_detalles_repuestos();

call sp_listar_vista_clientes_vehiculos();
call sp_listar_vista_mecanicos_repuestos();