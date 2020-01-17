-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-01-2020 a las 23:05:00
-- Versión del servidor: 10.1.26-MariaDB
-- Versión de PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `triliapp`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `calificacionespublicacionesproductos`
--

CREATE TABLE `calificacionespublicacionesproductos` (
  `idCalificacionPublicacionProducto` int(11) NOT NULL,
  `valorCPP` float DEFAULT NULL,
  `comentarioCPP` char(100) NOT NULL,
  `fechaCPP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `idUsuario` int(11) NOT NULL,
  `idPublicacionDeProducto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE `categorias` (
  `idCategoria` int(11) NOT NULL,
  `nombreCAT` char(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `idProducto` int(11) NOT NULL,
  `nombrePR` char(25) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idCategoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `publicacionesdeproductos`
--

CREATE TABLE `publicacionesdeproductos` (
  `idPublicacionDeProducto` int(11) NOT NULL,
  `nombrePDP` char(25) NOT NULL,
  `fechaPDP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `descripcionProducto` char(100) DEFAULT NULL,
  `imagenProducto` char(50) NOT NULL,
  `marcaProducto` char(25) NOT NULL,
  `precioProducto` float NOT NULL,
  `ubicacionProducto` char(50) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rangos`
--

CREATE TABLE `rangos` (
  `idRango` int(11) NOT NULL,
  `nombreRNG` char(25) NOT NULL,
  `imagenRNG` char(40) NOT NULL,
  `descripcionRNG` char(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `rangos`
--

INSERT INTO `rangos` (`idRango`, `nombreRNG`, `imagenRNG`, `descripcionRNG`) VALUES
(1, 'Bronze', 'imagenRB', 'Primer Rango'),
(2, 'Plata', 'imagenRP', 'Segundo Rango'),
(3, 'Oro', 'imagenRO', 'Tercer Rango'),
(4, 'Diamante', 'imagenRD', 'Cuarto Rango');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reportes`
--

CREATE TABLE `reportes` (
  `idReporte` int(11) NOT NULL,
  `descripcionRPTE` char(100) NOT NULL,
  `fechaRPTE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `idUsuario` int(11) NOT NULL,
  `idPublicacionDeProducto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `idRol` int(11) NOT NULL,
  `nombreRL` char(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`idRol`, `nombreRL`) VALUES
(1, 'Invitado'),
(2, 'Administrador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sugerencias`
--

CREATE TABLE `sugerencias` (
  `idSugerencia` int(11) NOT NULL,
  `tipoSUG` char(25) NOT NULL,
  `fechaSUG` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `descripcionSUG` char(100) NOT NULL,
  `idUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `idUsuario` int(11) NOT NULL,
  `imagenUsu` char(50) DEFAULT NULL,
  `DisplayName` char(25) NOT NULL,
  `contraseniaUsu` char(25) NOT NULL,
  `correoUsu` char(50) NOT NULL,
  `experienciaUsu` int(11) NOT NULL DEFAULT '0',
  `idRango` int(11) NOT NULL,
  `idRol` int(11) NOT NULL,
  `estadoUsuario` char(20) DEFAULT 'Activo'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`idUsuario`, `imagenUsu`, `DisplayName`, `contraseniaUsu`, `correoUsu`, `experienciaUsu`, `idRango`, `idRol`, `estadoUsuario`) VALUES
(1, 'imagen', 'kmargo', 'kmargo', 'kmargo@kmargo', 0, 1, 1, 'Activo'),
(2, 'imagrn2', 'lalos', 'lalos', 'lalos@lalos', 0, 1, 1, 'Activo'),
(3, 'sadas', 'asdas', 'sadasd', 'asdasd', 0, 1, 1, 'Activo'),
(4, 'asdasd', 'a', '1', 'asdasd', 0, 1, 1, 'Activo');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `calificacionespublicacionesproductos`
--
ALTER TABLE `calificacionespublicacionesproductos`
  ADD PRIMARY KEY (`idCalificacionPublicacionProducto`),
  ADD KEY `idUsuario` (`idUsuario`),
  ADD KEY `idPublicacionDeProducto` (`idPublicacionDeProducto`);

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`idCategoria`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`idProducto`),
  ADD KEY `idUsuario` (`idUsuario`),
  ADD KEY `idCategoria` (`idCategoria`);

--
-- Indices de la tabla `publicacionesdeproductos`
--
ALTER TABLE `publicacionesdeproductos`
  ADD PRIMARY KEY (`idPublicacionDeProducto`),
  ADD KEY `idUsuario` (`idUsuario`),
  ADD KEY `idProducto` (`idProducto`);

--
-- Indices de la tabla `rangos`
--
ALTER TABLE `rangos`
  ADD PRIMARY KEY (`idRango`);

--
-- Indices de la tabla `reportes`
--
ALTER TABLE `reportes`
  ADD PRIMARY KEY (`idReporte`),
  ADD KEY `idUsuario` (`idUsuario`),
  ADD KEY `idPublicacionDeProducto` (`idPublicacionDeProducto`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`idRol`);

--
-- Indices de la tabla `sugerencias`
--
ALTER TABLE `sugerencias`
  ADD PRIMARY KEY (`idSugerencia`),
  ADD KEY `idUsuario` (`idUsuario`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idUsuario`),
  ADD UNIQUE KEY `DisplayName` (`DisplayName`),
  ADD KEY `idRango` (`idRango`),
  ADD KEY `idRol` (`idRol`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `calificacionespublicacionesproductos`
--
ALTER TABLE `calificacionespublicacionesproductos`
  MODIFY `idCalificacionPublicacionProducto` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `categorias`
--
ALTER TABLE `categorias`
  MODIFY `idCategoria` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `publicacionesdeproductos`
--
ALTER TABLE `publicacionesdeproductos`
  MODIFY `idPublicacionDeProducto` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `rangos`
--
ALTER TABLE `rangos`
  MODIFY `idRango` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `reportes`
--
ALTER TABLE `reportes`
  MODIFY `idReporte` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `idRol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `sugerencias`
--
ALTER TABLE `sugerencias`
  MODIFY `idSugerencia` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `calificacionespublicacionesproductos`
--
ALTER TABLE `calificacionespublicacionesproductos`
  ADD CONSTRAINT `calificacionespublicacionesproductos_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`),
  ADD CONSTRAINT `calificacionespublicacionesproductos_ibfk_2` FOREIGN KEY (`idPublicacionDeProducto`) REFERENCES `publicacionesdeproductos` (`idPublicacionDeProducto`);

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`),
  ADD CONSTRAINT `productos_ibfk_2` FOREIGN KEY (`idCategoria`) REFERENCES `categorias` (`idCategoria`);

--
-- Filtros para la tabla `publicacionesdeproductos`
--
ALTER TABLE `publicacionesdeproductos`
  ADD CONSTRAINT `publicacionesdeproductos_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`),
  ADD CONSTRAINT `publicacionesdeproductos_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `productos` (`idProducto`);

--
-- Filtros para la tabla `reportes`
--
ALTER TABLE `reportes`
  ADD CONSTRAINT `reportes_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`),
  ADD CONSTRAINT `reportes_ibfk_2` FOREIGN KEY (`idPublicacionDeProducto`) REFERENCES `publicacionesdeproductos` (`idPublicacionDeProducto`);

--
-- Filtros para la tabla `sugerencias`
--
ALTER TABLE `sugerencias`
  ADD CONSTRAINT `sugerencias_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`idRango`) REFERENCES `rangos` (`idRango`),
  ADD CONSTRAINT `usuarios_ibfk_2` FOREIGN KEY (`idRol`) REFERENCES `roles` (`idRol`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
