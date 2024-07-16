CREATE TABLE topicos (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         titulo VARCHAR(255) NOT NULL,
                         mensaje TEXT NOT NULL,
                         email varchar(100) NOT NULL unique,
                         fecha_creacion DATE NOT NULL,
                         status enum('ACTIVO','INACTIVO'),
                         autor VARCHAR(255) NOT NULL,
                         curso VARCHAR(255) NOT NULL
);