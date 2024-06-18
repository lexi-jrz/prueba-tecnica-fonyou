# Guía de uso de la aplicación Test Manager

## Requisitos previos

Antes de comenzar, asegúrate de tener instalado lo siguiente:

- Java Development Kit (JDK) 8 o superior
- Maven
- Git

## Instalación

1. Clona este repositorio en tu máquina local:

   git clone https://github.com/lexi-jrz/prueba-tecnica-fonyou.git

2. Configurar la Base de Datos:
   Asegúrate de tener MySQL o PostgreSQL instalado y en ejecución. Crea una base de datos llamada examdb.

	Para MySQL:

		CREATE DATABASE examdb;

	Para PostgreSQL:

		CREATE DATABASE examdb;

3: Configurar el archivo application.properties:
   Configura la conexión a la base de datos en el archivo src/main/resources/application.properties.
   	
	Si usas MySQL, tu configuración podría ser algo así:
	
		spring.datasource.url=jdbc:mysql://localhost:3306/examdb
		spring.datasource.username=root
		spring.datasource.password=yourpassword
		spring.jpa.hibernate.ddl-auto=update
		spring.jpa.show-sql=true

	Si usas PostgreSQL, la configuración sería algo así:

		spring.datasource.url=jdbc:postgresql://localhost:5432/examdb
		spring.datasource.username=postgres
		spring.datasource.password=yourpassword
		spring.jpa.hibernate.ddl-auto=update
		spring.jpa.show-sql=true

4: Ejecutar el Script SQL
   Ejecuta el script schema.sql que se encuentra en el directorio src/main/resources para crear las tablas necesarias.

5: Construir y Ejecutar la Aplicación
   Usa Maven para construir y ejecutar la aplicación:

	mvn clean install
	mvn spring-boot:run

   La aplicación estará disponible en http://localhost:8080.

6: Uso de la API
   A continuación, se detallan los endpoints disponibles en la API y cómo consumirlos usando Postman o cualquier otro cliente HTTP.

	Crear Examen
	URL: /api/exams
	Método: POST
	Body: JSON

	{
    	"title": "test-manager",
    	"questions": [
       	 {
        	    "text": "¿Esto es una pregunta?",
            	"A": "Opcion1",
            	"B": "Opcion2",
            	"C": "Opcion3",
            	"D": "Opcion4",
            	"correctOption": "B",
            	"points": 25
        	},
        	{
            	"text": "¿Esto es una pregunta?",
            	"A": "Opcion1",
            	"B": "Opcion2",
            	"C": "Opcion3",
            	"D": "Opcion4",
            	"correctOption": "B",
            	"points": 25
        	}
        	// Agregar más preguntas hasta que el puntaje total sea 100
    	]
	}


	Crear Estudiante
	URL: /api/students
	Método: POST
	Body: JSON

	{
    	"name": "Juan Pérez",
    	"age": 20,
    	"city": "Bogotá",
    	"timezone": "America/Bogota"
	}

	Asignar Examen
	URL: /api/student-exams/assign
	Método: POST
	Params:
	studentId: ID del estudiante
	examId: ID del examen
	examDate: Fecha del examen en formato yyyy-MM-ddTHH:mm:ss (en zona horaria de Bogotá)

	Ejemplo de URL con parámetros:
		http://localhost:8080/api/student-exams/assign?studentId=1&examId=1&examDate=2023

	Enviar Respuestas
	URL: /api/student-exams/submit
	Método: POST
	Params:
	`studentExamId`: ID del examen asignado al estudiante
	Body: JSON
	[
    	  {
        	"question": {
            	"id": 1
        	},
        	"selectedOption": "B"
    	},
    	{
        	"question": {
            	"id": 2
        	},
        	"selectedOption": "B"
    	}
    // Agregar respuestas para todas las preguntas del examen
]

	Colección de Postman
	Puedes importar la colección de Postman que se encuentra en el archivo postman_collection.json en la raíz del proyecto para facilitar el consumo de los endpoints.