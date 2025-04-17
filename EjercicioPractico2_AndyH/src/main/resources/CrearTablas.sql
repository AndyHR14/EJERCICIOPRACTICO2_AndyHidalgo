DROP DATABASE IF EXISTS cine_teatro_db;
drop user if exists usuario_general;

-- Crear usuario de conexión
CREATE USER 'usuario_general'@'%' IDENTIFIED BY 'Usuar1o_Clave.';

-- Crear base de datos
CREATE DATABASE cine_teatro_db;

-- Otorgar permisos
GRANT ALL PRIVILEGES ON cine_teatro_db.* TO 'usuario_general'@'%';
FLUSH PRIVILEGES;

-- Seleccionar la base de datos
USE cine_teatro_db;

CREATE TABLE role (
    rol VARCHAR(20) PRIMARY KEY
);

INSERT INTO role (rol) VALUES 
('ADMIN'), 
('USUARIO');

CREATE TABLE usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    correo VARCHAR(100) NOT NULL UNIQUE,
    fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP,
    activo BOOLEAN DEFAULT TRUE
);

CREATE TABLE rol (
    id_rol INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(20),
    id_usuario INT,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

-- Tabla de películas u obras
CREATE TABLE pelicula (
    id_pelicula INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150),
    tipo VARCHAR(20), -- 'PELICULA' o 'OBRA'
    activo BOOLEAN
);

-- Tabla de funciones
CREATE TABLE funcion (
    id_funcion INT AUTO_INCREMENT PRIMARY KEY,
    id_pelicula INT,
    fecha DATE,
    hora TIME,
    sala VARCHAR(50),
    activo boolean default true,
    FOREIGN KEY (id_pelicula) REFERENCES pelicula(id_pelicula)
);

-- Tabla de reservas
CREATE TABLE reservas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    id_funcion INT,
    cantidad INT,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario) ON DELETE CASCADE,
    FOREIGN KEY (id_funcion) REFERENCES funcion(id_funcion) ON DELETE CASCADE
);
-- Insertar usuarios de ejemplo (admin tiene contraseña 123 y andy tiene contraseña 789)
INSERT INTO usuario (username, password, nombre, apellidos, correo, activo) VALUES
('admin', '$2a$12$9EfhFXIBSu0wlDnjmlpOAus4J3OIwiLpOQDdtN9ycf6nB2wX0M/nu', 'Admin', 'CineTeatro', 'admin@cineteatro.com', TRUE),
('andy', '$2a$12$LEMHwZYKEcHpX3Ogk6F02.Pr51xIMKxu9jAVLJlV.NR.M2.uQMxD.', 'Andy', 'Hidalgo', 'andyhidalgo@cineteatro.com', TRUE);

INSERT INTO rol (nombre, id_usuario) VALUES
('ADMIN', 1), ('USUARIO', 1),
('USUARIO', 2);

-- Insertar películas/obras
INSERT INTO pelicula (titulo, tipo, activo) VALUES
('El Rey León', 'OBRA', true),
('Avengers: Endgame', 'PELICULA', true),
('La Bella y la Bestia', 'OBRA', true),
('Spider-Man: No Way Home', 'PELICULA', true);

-- Insertar funciones
INSERT INTO funcion (id_pelicula, fecha, hora, sala) VALUES
(1, '2025-04-20', '18:00:00', 'Sala A'),
(2, '2025-04-21', '20:00:00', 'Sala B'),
(3, '2025-04-22', '17:00:00', 'Sala C'),
(4, '2025-04-23', '21:00:00', 'Sala D');

-- Insertar reservas
INSERT INTO reservas (id_usuario, id_funcion, cantidad) VALUES
(1, 1, 2),
(2, 2, 1),
(1, 4, 3);