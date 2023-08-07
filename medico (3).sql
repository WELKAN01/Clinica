-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-08-2023 a las 19:41:37
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `medico`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `area`
--

CREATE TABLE `area` (
  `area_id` bigint(20) NOT NULL,
  `area_nombre` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `area_descripcion` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `area`
--

INSERT INTO `area` (`area_id`, `area_nombre`, `area_descripcion`) VALUES
(1, 'odontologia', 'dientes'),
(4, 'oftalmologia', 'ojos2'),
(6, 'medicina general', 'analisis 2'),
(7, 'Cardiología', 'corazón'),
(8, 'Alergología', 'alergias'),
(9, ' Endocrinología', 'analisis 3'),
(10, 'Urunologo', 'orina'),
(117, 'ludologia', 'estudio de los vicios');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citas`
--

CREATE TABLE `citas` (
  `citas_id` int(20) NOT NULL,
  `citas_cliente` int(255) DEFAULT NULL,
  `citas_areas` bigint(20) DEFAULT NULL,
  `cita_doctor` bigint(20) DEFAULT NULL,
  `citas_descripcion` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `programacion` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `citas`
--

INSERT INTO `citas` (`citas_id`, `citas_cliente`, `citas_areas`, `cita_doctor`, `citas_descripcion`, `programacion`) VALUES
(1, 4, 4, 28, 'wqrrrrrrrr', '2023-03-24 10:09:00'),
(2, 8, 1, 26, 'wqrrrrrrrr', '2023-03-29 15:09:00'),
(3, 8, 1, 26, 'wqrrrrrrrr', '2023-04-01 14:15:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `cli_id` int(20) NOT NULL,
  `cli_nombres` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cli_apellidos` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cli_dni` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cli_telefono` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cli_foto` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cli_nacimiento` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`cli_id`, `cli_nombres`, `cli_apellidos`, `cli_dni`, `cli_telefono`, `cli_foto`, `cli_nacimiento`) VALUES
(2, 'Maria', 'pazzeretti', '24142414', '89992441', 'osito_peru.jpg', '1992-04-05'),
(4, 'Elma', 'Cabrejo', '24142414', '89992441', 'muere-mama-coco-109-anos-mujer-que-guardaba-gran-parecido-abuela-pelicula-pixar_98.jpg', '1919-02-21'),
(5, 'Rosia', 'miller', '24142414', '970479585', 'miau.jpg', '2002-03-12'),
(6, 'Carla', 'Rosamela', '25152441', '987743212', 'Agente_de_Envio_Pablo_infobox.jpg', '2011-03-21'),
(8, 'Emilia', 'Leonilia', '98888822', '2003331', 'miau.jpg', '2021-03-12');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `doctor`
--

CREATE TABLE `doctor` (
  `doc_id` bigint(20) NOT NULL,
  `doc_nombre` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `doc_apellido` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `doc_dni` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `doc_fecha_funcion` date DEFAULT NULL,
  `doc_foto` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fk_area_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `doctor`
--

INSERT INTO `doctor` (`doc_id`, `doc_nombre`, `doc_apellido`, `doc_dni`, `doc_fecha_funcion`, `doc_foto`, `fk_area_id`) VALUES
(26, 'mario', 'guiller', '214444444', '1998-02-22', 'osito_peru.jpg', 1),
(27, 'emil', 'ano', '124444444', '1980-02-29', 'images.jpg', 1),
(28, 'michael', 'olin', '111111', '1977-12-30', 'Nuevo proyecto (1).jpg', 4),
(29, 'asfasf', 'fff', '131414', '0222-02-22', 'myw3schoolsimage (1).jpg', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `doctor_area`
--

CREATE TABLE `doctor_area` (
  `id` int(20) NOT NULL,
  `id_doctor` int(20) NOT NULL,
  `id_area` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proovedor`
--

CREATE TABLE `proovedor` (
  `pro_id` bigint(20) NOT NULL,
  `pro_descripcion` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `pro_nombre` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `id` int(20) NOT NULL,
  `user_id` int(11) NOT NULL,
  `authority` varchar(255) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id`, `user_id`, `authority`) VALUES
(1, 1, 'ADMIN'),
(2, 2, 'User');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sala`
--

CREATE TABLE `sala` (
  `id_sala` bigint(20) NOT NULL,
  `descripcion_sala` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre_sala` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `area_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `sala`
--

INSERT INTO `sala` (`id_sala`, `descripcion_sala`, `nombre_sala`, `area_id`) VALUES
(1, 'Ninguno', '1001', 1),
(2, 'ninguna', '1002', 4),
(3, 'ninguno', '1003', 1),
(4, 'ninguna', '1004', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nombres` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `username` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `correo` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `enabled` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `nombres`, `apellidos`, `username`, `correo`, `password`, `enabled`) VALUES
(1, 'andy', 'leon curo', 'Andleo', 'andy@gmail.com', '123', b'0'),
(2, 'Maria', 'Perez', 'Mape', 'Mape@gmail.com', '123', b'0');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `area`
--
ALTER TABLE `area`
  ADD PRIMARY KEY (`area_id`);

--
-- Indices de la tabla `citas`
--
ALTER TABLE `citas`
  ADD PRIMARY KEY (`citas_id`),
  ADD KEY `id_cliente` (`citas_cliente`),
  ADD KEY `id_doctor` (`cita_doctor`),
  ADD KEY `id_area` (`citas_areas`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`cli_id`);

--
-- Indices de la tabla `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`doc_id`),
  ADD KEY `fk_area_id` (`fk_area_id`);

--
-- Indices de la tabla `doctor_area`
--
ALTER TABLE `doctor_area`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `proovedor`
--
ALTER TABLE `proovedor`
  ADD PRIMARY KEY (`pro_id`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indices de la tabla `sala`
--
ALTER TABLE `sala`
  ADD PRIMARY KEY (`id_sala`),
  ADD KEY `FK9ur87y4ejai0bdlv2va5vbwqv` (`area_id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `area`
--
ALTER TABLE `area`
  MODIFY `area_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=118;

--
-- AUTO_INCREMENT de la tabla `citas`
--
ALTER TABLE `citas`
  MODIFY `citas_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=122;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `cli_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `doctor`
--
ALTER TABLE `doctor`
  MODIFY `doc_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de la tabla `doctor_area`
--
ALTER TABLE `doctor_area`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `proovedor`
--
ALTER TABLE `proovedor`
  MODIFY `pro_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `sala`
--
ALTER TABLE `sala`
  MODIFY `id_sala` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `citas`
--
ALTER TABLE `citas`
  ADD CONSTRAINT `id_area` FOREIGN KEY (`citas_areas`) REFERENCES `area` (`area_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `id_cliente` FOREIGN KEY (`citas_cliente`) REFERENCES `cliente` (`cli_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `id_doctor` FOREIGN KEY (`cita_doctor`) REFERENCES `doctor` (`doc_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `doctor`
--
ALTER TABLE `doctor`
  ADD CONSTRAINT `fk_area_id` FOREIGN KEY (`fk_area_id`) REFERENCES `area` (`area_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `rol`
--
ALTER TABLE `rol`
  ADD CONSTRAINT `rol_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `sala`
--
ALTER TABLE `sala`
  ADD CONSTRAINT `FK9ur87y4ejai0bdlv2va5vbwqv` FOREIGN KEY (`area_id`) REFERENCES `area` (`area_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
