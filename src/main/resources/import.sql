/*Creacion de usuarios y roles*/
INSERT INTO `usuarios` (username, password, cedula, nombre, apellido, telefono, observacion, estado) VALUES ('andres','$2a$10$hGYG5p11.QRqWeimudyf1.wONsInJxSdMtZnA9.nCJWTySWB7ewse','1234567890', 'Andres', 'Guzman', NULL,NULL,  false);
INSERT INTO `usuarios` (username, password, cedula, nombre, apellido, telefono, observacion, estado) VALUES ('admin','$2a$10$L28mlg6S2ylzC1dKIwJqO.2j6OQw89FIgx.5svkSqOexbtcodpD3e','1234567890', 'John', 'Doe', NULL,NULL,  true);
INSERT INTO `usuarios` (username, password, cedula, nombre, apellido, telefono, observacion, estado) VALUES ('super','$2a$10$VN1xR06L5Ckp5vRhog7C2.9VDK0xbZmCYRxNaLaeXebOP/txoS4Ay','1234567890', 'Diego', 'Arias', NULL, NULL,  true);

INSERT INTO `roles` (nombre) VALUES ('ROLE_USER');
INSERT INTO `roles` (nombre) VALUES ('ROLE_ADMIN');
INSERT INTO `roles` (nombre) VALUES ('ROLE_SUPER');

INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (1, 1);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 2);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 1);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (3, 3);
/*Creacion de usuarios y roles*/

/*Creacion de tipos de personas*/
INSERT INTO tipos_personas (nombre) VALUES ( 'Juridica');
INSERT INTO tipos_personas (nombre) VALUES ( 'Natural');
/*Creacion de tipos de personas*/

/*Creacion de personas*/
INSERT INTO personas(lote, razon_social, cedula, nombre, apellido, telefono, antecedentes, observacion, estado, fecha_creacion, fecha_actualizacion, email, tipo_persona_id,  usuario_id) VALUES('110', null, '1705658050', 'LUIS ERNESTO',	'ROMAN REYES', '2893360 - 4515669', 'NO', 'MARIA DEL CARMEN ARIAS', false,'2021-05-17', null,null,2, 2);
INSERT INTO personas(lote, razon_social, cedula, nombre, apellido, telefono, antecedentes, observacion, estado, fecha_creacion, fecha_actualizacion, email, tipo_persona_id,  usuario_id) VALUES('111', null, '1305712182', 'MANUEL IVAN','NAVARRETE LOOR', '4520116','NO','JEANETH BOLAÑOS',	true,'2021-05-17',null,	null,	2, 2);
INSERT INTO personas(lote, razon_social, cedula, nombre, apellido, telefono, antecedentes, observacion, estado, fecha_creacion, fecha_actualizacion, email, tipo_persona_id,  usuario_id) VALUES('112', null, '1703690790','MARIA DEL CARMEN','ALBAN SANCHEZ', '2040310','NO','PAREDES LUIS',	true,'2021-05-17',	null,	null,	2, 2);
INSERT INTO personas(lote, razon_social, cedula, nombre, apellido, telefono, antecedentes, observacion, estado, fecha_creacion, fecha_actualizacion, email, tipo_persona_id,  usuario_id) VALUES('113', null, '1701733931','PATRICIO ALFONSO','LOPEZ ARAUJO', '2890154','NO','RITA ASTUDIILO DE LOPEZ',	true ,'2021-05-17',	null,	null,2, 2);
INSERT INTO personas(lote, razon_social, cedula, nombre, apellido, telefono, antecedentes, observacion, estado, fecha_creacion, fecha_actualizacion, email, tipo_persona_id,  usuario_id) VALUES('114', null, '800639544', 'VASCONEZ','FAMILIA','2040172', 'NO','ALMEIDA EGAS BETHSABE PATRICIA, VASCONEZ ESTEBAN',true,'2021-05-17',	null,	null,	2, 2);
INSERT INTO personas(lote, razon_social, cedula, nombre, apellido, telefono, antecedentes, observacion, estado, fecha_creacion, fecha_actualizacion, email, tipo_persona_id,  usuario_id) VALUES('115', null, '1709244048','MONICA PIEDAD','PADILLA PONCE', '2041114','NO','ENDARA',	true,'2021-05-17',	null,	null,	2, 2);
INSERT INTO personas(lote, razon_social, cedula, nombre, apellido, telefono, antecedentes, observacion, estado, fecha_creacion, fecha_actualizacion, email, tipo_persona_id,  usuario_id) VALUES('116', null, '1710166313','GALO EDMUNDO','ARMAS HARO','2894843','NO','PAULINA PADILLA',	true,'2021-05-17',	null,	null,	2, 2);
INSERT INTO personas(lote, razon_social, cedula, nombre, apellido, telefono, antecedentes, observacion, estado, fecha_creacion, fecha_actualizacion, email, tipo_persona_id,  usuario_id) VALUES('117', null, '1703904621','PAOLO STEFANO','DANIELLO DONOSO', '2894937','NO','MONICA RODRIGUEZ',	true,'2021-05-17',	null,	null,	2, 2);
INSERT INTO personas(lote, razon_social, cedula, nombre, apellido, telefono, antecedentes, observacion, estado, fecha_creacion, fecha_actualizacion, email, tipo_persona_id,  usuario_id) VALUES('118', null, '501629307','MILTON FERNANDO','SAONA MALDONADO', null, 'NO','ADRIANA PESANTES',	true,'2021-05-17',	null,	null,	2, 2);
INSERT INTO personas(lote, razon_social, cedula, nombre, apellido, telefono, antecedentes, observacion, estado, fecha_creacion, fecha_actualizacion, email, tipo_persona_id,  usuario_id) VALUES('119', null, '401503313','GILBERTO EFRAIN','NARVAEZ BOLANOS', '2892679','NO','DARIO NARVAEZ',	true,'2021-05-17',	null,	null,	2, 2);
INSERT INTO personas(lote, razon_social, cedula, nombre, apellido, telefono, antecedentes, observacion, estado, fecha_creacion, fecha_actualizacion, email, tipo_persona_id,  usuario_id) VALUES('120', null, '1711978104','MARIA GABRIELA','OQUENDO MARTINOD', null, 'NO','	LOTE VACIÓ O EN CONSTRUCCIÓN',	true,'2021-05-17',	null,	null,	2, 2);
INSERT INTO personas(lote, razon_social, cedula, nombre, apellido, telefono, antecedentes, observacion, estado, fecha_creacion, fecha_actualizacion, email, tipo_persona_id,  usuario_id) VALUES('121', null, '1708595028','IVAN MARCELO','PAZMIÑO ACUA', '2559120','NO',null,		true,'2021-05-17',	null,	null,	2, 2);
INSERT INTO personas(lote, razon_social, cedula, nombre, apellido, telefono, antecedentes, observacion, estado, fecha_creacion, fecha_actualizacion, email, tipo_persona_id,  usuario_id) VALUES('122', null, '1700877747','JOSE AGUSTIN','ARIAS OSEJO', '2892256','NO', null,		true,'2021-05-17',	null,	null,	2, 2);
INSERT INTO personas(lote, razon_social, cedula, nombre, apellido, telefono, antecedentes, observacion, estado, fecha_creacion, fecha_actualizacion, email, tipo_persona_id,  usuario_id) VALUES('123/124', null, '1706934872','SANDRA MARIA','RAMIREZ MOLINA', '2895715','NO','RECALDE MARIO JUAN FRANCISCO',	true,'2021-05-17',	null,	null,	2, 2);
INSERT INTO personas(lote, razon_social, cedula, nombre, apellido, telefono, antecedentes, observacion, estado, fecha_creacion, fecha_actualizacion, email, tipo_persona_id,  usuario_id) VALUES('125', null, '1711385540','MILTON FERNANDO','ALTAMIRANO MUO', '2896742/3617386','NO','CELERI, EVELIN ALTAMIRANO',	true,'2021-05-17',	null,	null,	2, 2);
INSERT INTO personas(lote, razon_social, cedula, nombre, apellido, telefono, antecedentes, observacion, estado, fecha_creacion, fecha_actualizacion, email, tipo_persona_id,  usuario_id) VALUES('126', null, '1707198741','JUAN FERNANDO','ARTEAGA LEON', null, 'NO','	MARIA CRISTINA CARRASCO',	true,'2021-05-17',	null,	null,	2, 2);
INSERT INTO personas(lote, razon_social, cedula, nombre, apellido, telefono, antecedentes, observacion, estado, fecha_creacion, fecha_actualizacion, email, tipo_persona_id,  usuario_id) VALUES('129', null, '1714153234','MIGUEL ANGEL','CHAVEZ AGUILAR', '2040577','NO','TITO SANPEDRO',	true,'2021-05-17',	null,	null,	2, 2);
INSERT INTO personas(lote, razon_social, cedula, nombre, apellido, telefono, antecedentes, observacion, estado, fecha_creacion, fecha_actualizacion, email, tipo_persona_id,  usuario_id) VALUES('130', null, '	800091910','VIVIEN EMM','LEVERONE BUJASE', '2894939','NO',null,		true,'2021-05-17',	null,	null,	2, 2);
INSERT INTO personas(lote, razon_social, cedula, nombre, apellido, telefono, antecedentes, observacion, estado, fecha_creacion, fecha_actualizacion, email, tipo_persona_id,  usuario_id) VALUES('131', null, '1705355665','ANA PAULINA DE LOURDES','CELI DE LA TORRE', '2897308','NO','VALERIA CEVALLOS  # 04',	true,'2021-05-17',	null,	null,	2, 2);
INSERT INTO personas(lote, razon_social, cedula, nombre, apellido, telefono, antecedentes, observacion, estado, fecha_creacion, fecha_actualizacion, email, tipo_persona_id,  usuario_id) VALUES('131-A', null, '1801075928','JORGE VICENTE','GUERRERO MORALES', '2897308','NO','JANETH CHECA - #31',	true,'2021-05-17',	null,	null,	2, 2);
INSERT INTO personas(lote, razon_social, cedula, nombre, apellido, telefono, antecedentes, observacion, estado, fecha_creacion, fecha_actualizacion, email, tipo_persona_id,  usuario_id) VALUES('132',	null, '1708518749','EDGAR PATRICIO','MOSQUERA UTRERAS', '4512151','	NO	',null,	true,'2021-05-17',	null,	null,	2, 2);
INSERT INTO personas(lote, razon_social, cedula, nombre, apellido, telefono, antecedentes, observacion, estado, fecha_creacion, fecha_actualizacion, email, tipo_persona_id,  usuario_id) VALUES('132',	null, '1710123298','LOLA PATRICIA','LOPEZ FREIRE', '4512151','NO',null,		true,'2021-05-17',	null,	null,	2, 2);
INSERT INTO personas(lote, razon_social, cedula, nombre, apellido, telefono, antecedentes, observacion, estado, fecha_creacion, fecha_actualizacion, email, tipo_persona_id,  usuario_id) VALUES('133',	null, '1304662818','ZASKIA NATHALIE','CELY SUAREZ', '2899429/2895488','NO','DANIEL HERNANDEZ',	true,'2021-05-17',	null,	null,	2, 2);
INSERT INTO personas(lote, razon_social, cedula, nombre, apellido, telefono, antecedentes, observacion, estado, fecha_creacion, fecha_actualizacion, email, tipo_persona_id,  usuario_id) VALUES('134',	null, '1707319099','MARCELO OSWALDO','MONTERO YUNDA', '4504063','	NO	',null,	true,'2021-05-17',	null,	null,	2, 2);
INSERT INTO personas(lote, razon_social, cedula, nombre, apellido, telefono, antecedentes, observacion, estado, fecha_creacion, fecha_actualizacion, email, tipo_persona_id,  usuario_id) VALUES('135',	null, '0','	FRANCISCO','AYALA', '4521260','NO','PAZMIÑO LOURDES, TOMAS RAY, ANA LUCIA ,  INQUILINOS: ANA LUCIA GOETSCHEL / WRIGHT TOMAS',	true,'2021-05-17',	null,	null,	2, 2);
INSERT INTO personas(lote, razon_social, cedula, nombre, apellido, telefono, antecedentes, observacion, estado, fecha_creacion, fecha_actualizacion, email, tipo_persona_id,  usuario_id) VALUES('136',	null, '1717238149','CHRISTIAN','MUELLER', '4507128','NO','MEDINA JESS ROLAND, DIANA MUELLER, INQUILINO: CHRISTIAN MUELLER',	true,'2021-05-17',	null,	null,	2, 2);
INSERT INTO personas(lote, razon_social, cedula, nombre, apellido, telefono, antecedentes, observacion, estado, fecha_creacion, fecha_actualizacion, email, tipo_persona_id,  usuario_id) VALUES('137',	null, '1714733738','FAMILIA','PASOS FEIJO', '2891774','NO','PATY RUBIO, RAUL PASOS, PATRICIA FEIJO, NIUTON',	true,'2021-05-17',	null,	null,	2, 2);
INSERT INTO personas(lote, razon_social, cedula, nombre, apellido, telefono, antecedentes, observacion, estado, fecha_creacion, fecha_actualizacion, email, tipo_persona_id,  usuario_id) VALUES('138',	null, '601652340','FAMILIA','ZAMORA', '2621179/2892893','NO','MOREANO TRIVIO GLORITA PATRICIA',	true,'2021-05-17',	null,	null,	2, 2);
INSERT INTO personas(lote, razon_social, cedula, nombre, apellido, telefono, antecedentes, observacion, estado, fecha_creacion, fecha_actualizacion, email, tipo_persona_id,  usuario_id) VALUES('140',	null, '1712212826','GEOVANNA CECILIA','MONTESDEOCA MORALES', '2890178','NO','SEBASTIAN GONZALEZ,  GEOVANA MONTESDEOCA',	true, '2021-05-17',	null,	null,	2, 2);
INSERT INTO personas(lote, razon_social, cedula, nombre, apellido, telefono, antecedentes, observacion, estado, fecha_creacion, fecha_actualizacion, email, tipo_persona_id,  usuario_id) VALUES('141',	null, '1800013565','CARLOS ANTONIO','MAYORGA', '2225505-2892763','NO',null,	true,'2021-05-17',	null,	null,	2, 2);
INSERT INTO personas(lote, razon_social, cedula, nombre, apellido, telefono, antecedentes, observacion, estado, fecha_creacion, fecha_actualizacion, email, tipo_persona_id,  usuario_id) VALUES('142',	null, '1723492987', 'KATZ', 'SERKEY', null ,'NO', null, true, '2021-05-17',	null,	null,	2, 2);
INSERT INTO personas(lote, razon_social, cedula, nombre, apellido, telefono, antecedentes, observacion, estado, fecha_creacion, fecha_actualizacion, email, tipo_persona_id,  usuario_id) VALUES('143',	null, '1704483070','RODOLFO','ARROYO VELASQUEZ', '3617605','NO','REDIN, CLARA ARROYO',	true,'2021-05-17',	null,	null,	2, 2);
INSERT INTO personas(lote, razon_social, cedula, nombre, apellido, telefono, antecedentes, observacion, estado, fecha_creacion, fecha_actualizacion, email, tipo_persona_id,  usuario_id) VALUES('144',	null, '1708229016','FRANCISCO XAVIER','HERRERA SUASNAVAS', '2041311','NO',null,		true,'2021-05-17',	null,	null,	2, 2);
INSERT INTO personas(lote, razon_social, cedula, nombre, apellido, telefono, antecedentes, observacion, estado, fecha_creacion, fecha_actualizacion, email, tipo_persona_id,  usuario_id) VALUES('145',	null, '1722830963','LEZLY CATHERINE','RAMOS CUEVA', '2041482','NO','INQUILINOS: RUBEN LENGUAS RODRIGUEZ, CLAUDIA CENICEROS', 	true,'2021-05-17',	null,	null,	2, 2);
INSERT INTO personas(lote, razon_social, cedula, nombre, apellido, telefono, antecedentes, observacion, estado, fecha_creacion, fecha_actualizacion, email, tipo_persona_id,  usuario_id) VALUES('146',	null, '501618490','MILTON IGNACIO','ORBEA ORBEA', '2893674','NO',null, 		true,'2021-05-17',	null,	null,	2, 2);

/*Creacion de personas*/

/*VISITANTES*/
INSERT INTO visitantes (cedula, nombre, antecedentes, fecha_creacion) VALUES ('1306299346', 'CUENCA QUIROZ MARIA ROBERTINA', 'NO', '2021-05-03');
INSERT INTO visitantes (cedula, nombre, antecedentes, fecha_creacion) VALUES ('1303656506', 'GARCIA VELEZ BERTHA ISABEL', 'NO', '2021-05-03');
INSERT INTO visitantes (cedula, nombre, antecedentes, fecha_creacion) VALUES ('1307972180', 'ROBERTO JAVIER POSILGUA PIGUAVE',  'NO', '2021-05-03');
INSERT INTO visitantes (cedula, nombre, antecedentes, fecha_creacion) VALUES ('1719072603', 'VILLA YUNGAN EDGAR MANUEL',  'NO', '2021-05-03');
INSERT INTO visitantes (cedula, nombre, antecedentes, fecha_creacion) VALUES ('1302414030', 'VILLAO LAINEZ FELIX HERNAN',  'NO', '2021-05-03');
INSERT INTO visitantes (cedula, nombre, antecedentes, fecha_creacion) VALUES ('1714785639', 'MARTINEZ CAJAS DIANA ALEJANDRA',  'NO', '2021-05-03');
INSERT INTO visitantes (cedula, nombre, antecedentes, fecha_creacion) VALUES ('0913161022', 'MEJIA MORAN ERICA GEOCONDA',  'NO', '2021-05-03');
INSERT INTO visitantes (cedula, nombre, antecedentes, fecha_creacion) VALUES ('1309294195', 'IÑIGUEZ PAZMIÑO ANDREA NATALIE',  'NO', '2021-05-03');
INSERT INTO visitantes (cedula, nombre, antecedentes, fecha_creacion) VALUES ('1311361701', 'VERA MARCILLO LAURA MONSERRATE',  'NO', '2021-05-03');
INSERT INTO visitantes (cedula, nombre, antecedentes, fecha_creacion) VALUES ('0101452936', 'GONZALEZ PEÑA SANDRA CECILIA', 'NO', '2021-05-03');
INSERT INTO visitantes (cedula, nombre, antecedentes, fecha_creacion) VALUES ('0940631989', 'SALVATIERRA CARVAJAL BORYS GREGORY',  'NO', '2021-05-03');
INSERT INTO visitantes (cedula, nombre, antecedentes, fecha_creacion) VALUES ('1308581246', 'GARCIA MERO CORINA VERONICA',  'NO', '2021-05-03');
INSERT INTO visitantes (cedula, nombre, antecedentes, fecha_creacion) VALUES ('0911071728', 'CAMPOVERDE CARRASCO MICHEL ALBINO',  'NO', '2021-05-03');
INSERT INTO visitantes (cedula, nombre, antecedentes, fecha_creacion) VALUES ('1707558506', 'CARTAGENA FERNANDEZ FANNY ESPERANZA',  'NO', '2021-05-03');
INSERT INTO visitantes (cedula, nombre, antecedentes, fecha_creacion) VALUES ('1709900656', 'EGUEZ DEL POZO JUAN PABLO', 'NO', '2021-05-03');
INSERT INTO visitantes (cedula, nombre, antecedentes, fecha_creacion) VALUES ('1720809688', 'VELASQUEZ TOAPANTA JENNYFER MERCEDES', 'NO', '2021-05-03'); 
INSERT INTO visitantes (cedula, nombre, antecedentes, fecha_creacion) VALUES ('1717408197', 'VELEZ MENDIETA ROBERTO CARLOS',  'NO', '2021-05-03');
INSERT INTO visitantes (cedula, nombre, antecedentes, fecha_creacion) VALUES ('1313933028', 'VILLAVICENCIO CEDEÑO ERICK LEANDRO',  'NO', '2021-05-03');
INSERT INTO visitantes (cedula, nombre, antecedentes, fecha_creacion) VALUES ('1313500728', 'BAQUEZEA INTRIAGO JENELY FABIANA', 'NO', '2021-05-03');
INSERT INTO visitantes (cedula, nombre, antecedentes, fecha_creacion) VALUES ('1309901948', 'BENITEZ MERO LUIS FERNANDO', 'NO', '2021-05-03');
INSERT INTO visitantes (cedula, nombre, antecedentes, fecha_creacion) VALUES ('1313310664', 'LUCIA ADRIANA PINARGOTE YELA',  'NO', '2021-05-03');
INSERT INTO visitantes (cedula, nombre, antecedentes, fecha_creacion) VALUES ('1306325281', 'WILLIAM JAVIER DELGADO VERA',  'NO', '2021-05-03');
INSERT INTO visitantes (cedula, nombre, antecedentes, fecha_creacion) VALUES ('0921452462', 'VEJARANO HASING LUIS GERARDO', 'NO', '2021-05-03');
INSERT INTO visitantes (cedula, nombre, antecedentes, fecha_creacion) VALUES ('0918658774', 'SOLIS HOLGUIN CINTHIA MAGALI',  'NO', '2021-05-03');
INSERT INTO visitantes (cedula, nombre, antecedentes, fecha_creacion) VALUES ('0940657877', 'VELEZ AYALA STALIN MARTIN',  'NO', '2021-05-03');
INSERT INTO visitantes (cedula, nombre, antecedentes, fecha_creacion) VALUES ('1309028163', 'MURILLO PARRALES RAUL HOMERO',  'NO', '2021-05-03');
INSERT INTO visitantes (cedula, nombre, antecedentes, fecha_creacion) VALUES ('1304032707', 'CARDENAS CEDEÑO LEONARDO GONZALO', 'NO', '2021-05-03'); 
INSERT INTO visitantes (cedula, nombre, antecedentes, fecha_creacion) VALUES ('1311781296', 'SOLORZANO BARCIA MARIA ALEJANDRA',  'NO', '2021-05-03');
INSERT INTO visitantes (cedula, nombre, antecedentes, fecha_creacion) VALUES ('1312845488', 'CABAL PILOZO DARWIN LIVINTON',  'NO', '2021-05-03');
INSERT INTO visitantes (cedula, nombre, antecedentes, fecha_creacion) VALUES ('0961569787', 'TOMA SAMIR AZIZ KORESSA',  'NO', '2021-05-03');
INSERT INTO visitantes (cedula, nombre, antecedentes, fecha_creacion) VALUES ('1308441540', 'TOROMORENO ZAMBRANO SUSANA JEANINA', 'NO', '2021-05-03'); 

/*Motivos*/
INSERT INTO motivos ( detalle ) VALUES ('VISITA FAMILIAR');
INSERT INTO motivos ( detalle ) VALUES ('SERVICIO DE TAXI');
INSERT INTO motivos ( detalle ) VALUES ('SERVICIO DE GAS');
INSERT INTO motivos ( detalle ) VALUES ('SERVICIO DE INTERNET - TELCONET');
INSERT INTO motivos ( detalle ) VALUES ('SERVICIO DE INTERNET - CNT');
INSERT INTO motivos ( detalle ) VALUES ('SERVICIO DE INTERNET - MACRONET');
INSERT INTO motivos ( detalle ) VALUES ('SERVICIO DE INTERNET - PUNTO NET');
INSERT INTO motivos ( detalle ) VALUES ('SERVICIO DE INTERNET - NETLIFE');
INSERT INTO motivos ( detalle ) VALUES ('SERVICIO DE INTERNET OTROS');
INSERT INTO motivos ( detalle ) VALUES ('SERVICIOS BANCARIOS');
INSERT INTO motivos ( detalle ) VALUES ('RECOLECCIÓN BASURA');
INSERT INTO motivos ( detalle ) VALUES ('DELIVERY - ENTREGAS A DOMICILIO');
INSERT INTO motivos ( detalle ) VALUES ('SERVICIO TÉCNICO');
INSERT INTO motivos ( detalle ) VALUES ('SERVICIOS BÁSICOS');
INSERT INTO motivos ( detalle ) VALUES ('EMPRESA ELECTRICA');
INSERT INTO motivos ( detalle ) VALUES ('AREAS VERDES');
INSERT INTO motivos ( detalle ) VALUES ('DECORACIÓN');
INSERT INTO motivos ( detalle ) VALUES ('MANTENIMIENTO PISCINA');
INSERT INTO motivos ( detalle ) VALUES ('MANTENIMIENTO OTROS');
INSERT INTO motivos ( detalle ) VALUES ('SERVICIOS VARIOS');



/*VEHICULOS VISITANTES*/
INSERT INTO VEHICULOS_VISITANTES ( PLACA, MODELO, MARCA, COLOR, TIPO_VEHICULO, DETALLE, FECHA_CREACION, VISITANTE_ID ) VALUES ('PDG9818', 'NEW FORTUNER AC 40 5P 4X4 TA', 'TOYOTA', 'PLOMO', 'JEEP', 'Color1: PLOMO Color 2: PLOMO','2021-05-03', 1);
INSERT INTO VEHICULOS_VISITANTES ( PLACA, MODELO, MARCA, COLOR, TIPO_VEHICULO, DETALLE, FECHA_CREACION, VISITANTE_ID ) VALUES ('GSF2822', 'LUV DMAX CD OPTIMA TM 24 4X2', 'CHEVROLET', 'DORADO', 'CAMIONETA', 'Color1: DORADO Color 2: DORADO','2021-05-03', 2);
INSERT INTO VEHICULOS_VISITANTES ( PLACA, MODELO, MARCA, COLOR, TIPO_VEHICULO, DETALLE, FECHA_CREACION, VISITANTE_ID ) VALUES ('MBB8053', 'SPORTAGE LX AT', 'KIA', 'NEGRO', 'JEEP', 'Color1: NEGRO Color 2: NEGRO', '2021-05-03', 3);
INSERT INTO VEHICULOS_VISITANTES ( PLACA, MODELO, MARCA, COLOR, TIPO_VEHICULO, DETALLE, FECHA_CREACION, VISITANTE_ID ) VALUES ('MBB3930', 'TIIDA 16 MT HATCHBACK', 'NISSAN', 'BLANCO', 'AUTOMOVIL', 'Color1: BLANCO Color 2: BLANCO', '2021-05-03', 4);
INSERT INTO VEHICULOS_VISITANTES ( PLACA, MODELO, MARCA, COLOR, TIPO_VEHICULO, DETALLE, FECHA_CREACION, VISITANTE_ID ) VALUES ('MBB2700', 'ETT HILUX 4X2 CD', 'TOYOTA', 'PLOMO', 'CAMIONETA', 'Color1: PLOMO Color 2: PLOMO', '2021-05-03', 5);
INSERT INTO VEHICULOS_VISITANTES ( PLACA, MODELO, MARCA, COLOR, TIPO_VEHICULO, DETALLE, FECHA_CREACION, VISITANTE_ID ) VALUES ('PDA9873', '407 COUPE 30 AUTO', 'PEUGEOT', 'PLOMO', 'AUTOMOVIL', 'Color1: PLOMO Color 2: PLOMO', '2021-05-03', 6);
INSERT INTO VEHICULOS_VISITANTES ( PLACA, MODELO, MARCA, COLOR, TIPO_VEHICULO, DETALLE, FECHA_CREACION, VISITANTE_ID ) VALUES ('TBF5539', 'PICANTO R LX 10 4P 4X2 TM', 'KIA', 'BLANCO', 'AUTOMOVIL', 'Color1: BLANCO Color 2: BLANCO', '2021-05-03', 7);
INSERT INTO VEHICULOS_VISITANTES ( PLACA, MODELO, MARCA, COLOR, TIPO_VEHICULO, DETALLE, FECHA_CREACION, VISITANTE_ID ) VALUES ('GCB2799', 'GRAND VITARA SZ AC 20 5P 4X2 TM', 'SUZUKI', 'PLOMO', 'JEEP', 'Color1: PLOMO Color 2: BLANCO', '2021-05-03', 8);
INSERT INTO VEHICULOS_VISITANTES ( PLACA, MODELO, MARCA, COLOR, TIPO_VEHICULO, DETALLE, FECHA_CREACION, VISITANTE_ID ) VALUES ('PDG5112', 'TUCSON TL AC 20 5P 4X2 TM', 'HYUNDAI', 'BLANCO', 'JEEP', 'Color1: BLANCO Color 2: BLANCO', '2021-05-03', 9);
INSERT INTO VEHICULOS_VISITANTES ( PLACA, MODELO, MARCA, COLOR, TIPO_VEHICULO, DETALLE, FECHA_CREACION, VISITANTE_ID ) VALUES ('PCU7304', 'DMAX CRDI 30 CD 4X2 TM DIESEL', 'CHEVROLET', 'BLANCO', 'CAMIONETA', 'Color1: BLANCO Color 2: BLANCO', '2021-05-03', 10);
INSERT INTO VEHICULOS_VISITANTES ( PLACA, MODELO, MARCA, COLOR, TIPO_VEHICULO, DETALLE, FECHA_CREACION, VISITANTE_ID ) VALUES ('ABI2149', 'RIO LX AC 14 4P 4X2 TM', 'KIA', 'PLATEADO', 'AUTOMOVIL', 'Color1: PLATEADO Color 2: BLANCO Año: 2019', '2021-05-03', 11);
INSERT INTO VEHICULOS_VISITANTES ( PLACA, MODELO, MARCA, COLOR, TIPO_VEHICULO, DETALLE, FECHA_CREACION, VISITANTE_ID ) VALUES ('PDG6898', 'L200 SPORTERO GLS AC 25 CD 4X4 TM DIESEL', 'MITSUBISHI', 'PLATEADO', 'CAMIONETA', 'Color1: PLATEADO Color 2: PLATEADO Año: 2018', '2021-05-03', 12);
INSERT INTO VEHICULOS_VISITANTES ( PLACA, MODELO, MARCA, COLOR, TIPO_VEHICULO, DETALLE, FECHA_CREACION, VISITANTE_ID ) VALUES ('MBC9709', 'DUSTER AC 20 5P 4X2 TA', 'RENAULT', 'PLOMO', 'JEEP', 'Color1: PLOMO Color 2: BLANCO', '2021-05-03',13);
INSERT INTO VEHICULOS_VISITANTES ( PLACA, MODELO, MARCA, COLOR, TIPO_VEHICULO, DETALLE, FECHA_CREACION, VISITANTE_ID ) VALUES ('GRT0659', 'SANDERO 16 MT DYNAMIQUE', 'RENAULT', 'BLANCO', 'AUTOMOVIL', 'Color1: BLANCO Color 2: BLANCO', '2021-05-03', 14);
INSERT INTO VEHICULOS_VISITANTES ( PLACA, MODELO, MARCA, COLOR, TIPO_VEHICULO, DETALLE, FECHA_CREACION, VISITANTE_ID ) VALUES ('ABG1354', 'F150 XLT SC AC 35 CD 4X2 TA', 'FORD', 'PLOMO', 'CAMIONETA', 'Color1: PLOMO Color 2: BLANCO', '2021-05-03', 15);
INSERT INTO VEHICULOS_VISITANTES ( PLACA, MODELO, MARCA, COLOR, TIPO_VEHICULO, DETALLE, FECHA_CREACION, VISITANTE_ID ) VALUES ('MBB8516', 'GRAND VITARA SZ FL AC 20 5P 4X2 TM', 'SUZUKI', 'BLANCO', 'JEEP', 'Color1: BLANCO Color 2: BLANCO', '2021-05-03',16);
INSERT INTO VEHICULOS_VISITANTES ( PLACA, MODELO, MARCA, COLOR, TIPO_VEHICULO, DETALLE, FECHA_CREACION, VISITANTE_ID ) VALUES ('MBC2654', 'RIO R LX AC 14 4P 4X2 TM', 'KIA', 'BLANCO', 'AUTOMOVIL', 'Color1: BLANCO Color 2: BLANCO', '2021-05-03', 17);
INSERT INTO VEHICULOS_VISITANTES ( PLACA, MODELO, MARCA, COLOR, TIPO_VEHICULO, DETALLE, FECHA_CREACION, VISITANTE_ID ) VALUES ('PBA0950', '323', 'MAZDA', 'PLOMO', 'AUTOMOVIL', 'Color1: PLOMO Color 2: PLOMO', '2021-05-03', 18);
INSERT INTO VEHICULOS_VISITANTES ( PLACA, MODELO, MARCA, COLOR, TIPO_VEHICULO, DETALLE, FECHA_CREACION, VISITANTE_ID ) VALUES ('MBD2253', 'GRAND VITARA SZ AC 24 5P 4X2 TA', 'SUZUKI', 'VINO', 'JEEP', 'Color1: VINO Color 2: BLANCO', '2021-05-03', 19);
INSERT INTO VEHICULOS_VISITANTES ( PLACA, MODELO, MARCA, COLOR, TIPO_VEHICULO, DETALLE, FECHA_CREACION, VISITANTE_ID ) VALUES ('MBD2734', 'T600 T AC 20 5P 4X2 TM', 'ZOTYE', 'NEGRO', 'JEEP', 'Color1: NEGRO Color 2: BLANCO', '2021-05-03', 20);

/*Bitacora*/
INSERT INTO bitacora ( fecha_creacion, hora_ingreso, hora_salida, numero_acompaniante, novedad, autorizado_por, tipo_bitacora, motivo_id, persona_id, visitante_id, vehiculo_visitante_id,  usuario_id) VALUES ('2021-05-03', 	'09:53', 		NULL, 		0, NULL, NULL, NULL, 'V', 2, 5, 20, 5, 2);
INSERT INTO bitacora ( fecha_creacion, hora_ingreso, hora_salida, numero_acompaniante, novedad, autorizado_por, tipo_bitacora, motivo_id, persona_id, visitante_id, vehiculo_visitante_id,  usuario_id) VALUES ('2021-05-03', '10:10', NULL, 0, NULL, NULL, NULL, 'V', 5, 12, 13, NULL, 2);



/*Empleos*/
INSERT INTO tipos_empleos (ocupacion) VALUES ('Limpieza');
INSERT INTO tipos_empleos (ocupacion) VALUES ('Cocina');
INSERT INTO tipos_empleos (ocupacion) VALUES ('Seguridad');
INSERT INTO tipos_empleos (ocupacion) VALUES ('Jardinería');
INSERT INTO tipos_empleos (ocupacion) VALUES ('Conductor');
INSERT INTO tipos_empleos (ocupacion) VALUES ('Niñera');
INSERT INTO tipos_empleos (ocupacion) VALUES ('Proferor');
INSERT INTO tipos_empleos (ocupacion) VALUES ('Otros');
/*Empleos*/

/*Eventos*/
INSERT INTO tipos_eventos (nombre_evento) VALUES ('Sociales');
INSERT INTO tipos_eventos (nombre_evento) VALUES ('Empresariales');
INSERT INTO tipos_eventos (nombre_evento) VALUES ('Comunitarios');
INSERT INTO tipos_eventos (nombre_evento) VALUES ('Académicos');
INSERT INTO tipos_eventos (nombre_evento) VALUES ('Culturales');
INSERT INTO tipos_eventos (nombre_evento) VALUES ('Deportivos');
INSERT INTO tipos_eventos (nombre_evento) VALUES ('Políticos');
INSERT INTO tipos_eventos (nombre_evento) VALUES ('Otros');
/*Eventos*/
INSERT INTO empleados (cedula, nombre, apellido, observacion, fecha_creacion, fecha_actualizacion, estado, persona_id, tipo_empleo_id) VALUES ('1234567890', 'JUAN', 'PAREDES', NULL,'2021-05-17',	null, true, 2, 2 );
INSERT INTO empleados (cedula, nombre, apellido, observacion, fecha_creacion, fecha_actualizacion, estado, persona_id, tipo_empleo_id) VALUES ('1234567890','Deigo', 'Arias', NULL,'2021-05-17',	null, true, 2, 3 );
/*Empleados*/

/*Empleados*/

