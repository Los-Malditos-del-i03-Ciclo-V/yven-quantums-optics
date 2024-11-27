DROP DATABASE IF EXISTS yqo;
CREATE DATABASE yqo;
USE yqo;

CREATE TABLE IF NOT EXISTS operador (
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    correo VARCHAR(255) NOT NULL,
    celular LONG NOT NULL,
    fecha DATETIME NOT NULL,
    estado BIT NOT NULL,
    rol VARCHAR(255) NOT NULL
);

INSERT INTO operador (nombre, correo, celular, fecha, estado, rol) VALUES
('Juan Pérez', 'juan.perez@gmail.com', 1234567890, NOW(), b'1', 'Administrador'),
('María López', 'maria.lopez@outlook.com', 2345678901, NOW(), b'1', 'Operador'),
('Carlos García', 'carlos.garcia@gmail.com', 3456789012, NOW(), b'0', 'Supervisor'),
('Ana Martínez', 'ana.martinez@gmail.com', 4567890123, NOW(), b'1', 'Operador'),
('Luis Rodríguez', 'luis.rodriguez@gmail.com', 5678901234, NOW(), b'1', 'Administrador'),
('Laura Sánchez', 'laura.sanchez@gmail.com', 6789012345, NOW(), b'0', 'Operador'),
('Pedro Hernández', 'pedro.hernandez@gmail.com', 7890123456, NOW(), b'1', 'Supervisor'),
('Sofía Ramírez', 'sofia.ramirez@outlook.com', 8901234567, NOW(), b'1', 'Operador'),
('Diego Torres', 'diego.torres@gmail.com', 9012345678, NOW(), b'0', 'Administrador'),
('Elena Flores', 'elena.flores@gmail.com', 1123456789, NOW(), b'1', 'Operador');
