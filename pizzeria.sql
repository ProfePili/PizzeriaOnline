-- CREACIÓN DE BASE DE DATOS
CREATE DATABASE pizzeria1;

-- USO DE BASE DE DATOS
USE pizzeria1;

-- CREACIÓN DE TABLA
CREATE TABLE usuario (
    correo VARCHAR(45) NOT NULL PRIMARY KEY,
    nombre VARCHAR(45) NOT NULL,
    apellido VARCHAR(45) NOT NULL,
    edad VARCHAR(45) NOT NULL
);

-- INSERCIÓN DE DATOS
INSERT INTO usuario VALUES('persona1@egg.com', 'Persona1', 'Numero1', 27);
INSERT INTO usuario VALUES('persona2@egg.com', 'Persona2', 'Numero2', 48);
INSERT INTO usuario VALUES('persona3@egg.com', 'Persona3', 'Numero3', 52);
