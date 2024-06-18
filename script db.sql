
CREATE TABLE IF NOT EXISTS estudiante (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    edad INT NOT NULL,
    ciudad VARCHAR(255) NOT NULL,
    zona_horaria VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS examen (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    total_puntos INT NOT NULL
);

CREATE TABLE IF NOT EXISTS pregunta (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    texto VARCHAR(255) NOT NULL,
    opcion1 VARCHAR(255) NOT NULL,
    opcion2 VARCHAR(255) NOT NULL,
    opcion3 VARCHAR(255) NOT NULL,
    opcion4 VARCHAR(255) NOT NULL,
    respuesta_correcta INT NOT NULL,
    puntos INT NOT NULL,
    examen_id BIGINT,
    FOREIGN KEY (examen_id) REFERENCES examen(id)
);

CREATE TABLE IF NOT EXISTS asignacion (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    estudiante_id BIGINT,
    examen_id BIGINT,
    fecha_examen DATETIME NOT NULL,
    FOREIGN KEY (estudiante_id) REFERENCES estudiante(id),
    FOREIGN KEY (examen_id) REFERENCES examen(id)
);

CREATE TABLE IF NOT EXISTS respuesta (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    asignacion_id BIGINT,
    pregunta_id BIGINT,
    respuesta_estudiante INT NOT NULL,
    FOREIGN KEY (asignacion_id) REFERENCES asignacion(id),
    FOREIGN KEY (pregunta_id) REFERENCES pregunta(id)
);
