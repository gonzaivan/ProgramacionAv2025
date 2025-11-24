House Hunter - Sistema de Gestión Hotelera

Resumen:
Proyecto final para la materia Programación Avanzada 2025. Este sistema es una aplicación de escritorio en Java diseñada para administrar la asignación de habitaciones y limpieza de un hotel durante los Juegos Olímpicos.

  Características Principales

Gestión de Reservas: Asignación inteligente de delegaciones a habitaciones, con control de cupos y descuentos automáticos de huéspedes.

Roles de Usuario: Menús diferenciados para Recepcionistas y Personal de Limpieza.

Persistencia de Datos: Conexión a base de datos MySQL para guardar habitaciones, usuarios y delegaciones.

Seguridad: Login con encriptación de contraseñas (Algoritmo de Cifrado César).

Reportes: Visualización de estado del hotel y delegaciones pendientes.

  Tecnologías y Conceptos Aplicados
Este proyecto implementa los siguientes requisitos académicos:

Java (JDK 8+)

MySQL (Base de datos relacional)

JDBC (Conexión Java-SQL)

Patrón Singleton: Para la gestión eficiente de la conexión a la BD.

Interfaces: Implementación de IMenu para polimorfismo en los roles.

Genéricos: Uso de clases genéricas para la generación de reportes (ReporteGenerico<T>).

Manejo de Excepciones: Bloques try-catch para control de errores SQL y lógicos.

  Instalación y Configuración
1. Base de Datos
Para correr el proyecto, necesitas ejecutar este script en tu gestor de MySQL (Workbench o phpMyAdmin) para crear la estructura y el usuario administrador:

SQL

CREATE DATABASE IF NOT EXISTS srshotel;
USE srshotel;

-- Tabla de Usuarios
CREATE TABLE IF NOT EXISTS usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    rol VARCHAR(50),
    email VARCHAR(100),
    contrasena VARCHAR(100)
);

-- Tabla Delegación
CREATE TABLE IF NOT EXISTS delegacion (
    id_delegacion INT AUTO_INCREMENT PRIMARY KEY,
    pais VARCHAR(50),
    deporte VARCHAR(50),
    cantidad_personas INT
);

-- Tabla Habitación
CREATE TABLE IF NOT EXISTS habitacion (
    id_habitacion INT AUTO_INCREMENT PRIMARY KEY,
    numero INT,
    capacidad INT,
    estado TINYINT(1), -- 0 libre, 1 ocupada
    id_delegacion INT,
    FOREIGN KEY (id_delegacion) REFERENCES delegacion(id_delegacion)
);

-- USUARIOS DE PRUEBA (Contraseña real: "admin" -> Encriptada: "dgplq")
INSERT INTO usuario (rol, email, contrasena) VALUES 
('Recepcionista', 'recepcion@hotel.com', 'dgplq'),
('Limpieza', 'limpieza@hotel.com', 'dgplq');
2. Librerías
Asegúrate de agregar el driver mysql-connector-java al Build Path de tu proyecto en Eclipse/IDE.

   Cómo Usar (Credenciales)
Ejecuta el archivo Main.java. El sistema pedirá login.

Usuario Recepción:

Email: recepcion@hotel.com

Pass: admin

Usuario Limpieza:

Email: limpieza@hotel.com

Pass: admin

  Autor
Gonzalo Iván Fernandez- Desarrollo Inicial y Lógica de Negocio
