use bdviajero;

INSERT INTO aeropuerto VALUES (2, 'Andahuaylas', 'Apurimac-Peru', 6000, 1);
INSERT INTO aeropuerto VALUES (3, 'Alejandro Velasco Astete', 'Cusco-Peru', 7000, 2);
INSERT INTO aeropuerto VALUES (4, 'Tingo Maria', 'Huanuco-Peru', 6000, 1);
INSERT INTO aeropuerto VALUES (5, 'Rodriguez Ballon', 'Arequipa-Peru', 8000, 2);
COMMIT;

DROP TABLE vueloprogramado;
CREATE TABLE IF NOT EXISTS `vueloprogramado` (
`idvuelo` int(11) NOT NULL,
  `numero` varchar(50) NOT NULL,
  `idaerolinea` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora` varchar(50) NOT NULL,
  `idruta` int(11) NOT NULL,
  `precio` decimal(6,2) NOT NULL,
  `estado` tinyint(4) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

INSERT INTO `vueloprogramado` (`idvuelo`, `numero`, `idaerolinea`, `fecha`, `hora`, `idruta`, `precio`, `estado`) VALUES
(1, '123', 2, '2014-10-10', '12:12', 1, '700.50', 1),
(2, '1020', 3, '2014-11-11', '10:10', 2, '900.80', 1);

SELECT * FROM aeropuerto;
SELECT * FROM ruta;
SELECT * FROM vueloprogramado;

SELECT v.idvuelo AS ID, 
	a.nombre AS AEROPUERTO, 
	v.numero AS PASAJEROS, 
    v.precio AS PRECIO, 
    r.origen AS ORIGEN,
    r.destino AS DESTINO
FROM vueloprogramado v 
	INNER JOIN aeropuerto a 
		ON v.idaerolinea = a.idaeropuerto
	INNER JOIN ruta r
		ON r.idRuta = v.idruta