DROP TABLE IF EXISTS domicilios;
CREATE TABLE domicilios (ID INT AUTO_INCREMENT PRIMARY KEY,
CALLE varchar(200) NOT NULL,
NUMERO INT NOT NULL,
LOCALIDAD varchar(100) NOT NULL,
PROVINCIA varchar(100) NOT NULL);

DROP TABLE IF EXISTS pacientes;
CREATE TABLE pacientes (ID INT AUTO_INCREMENT PRIMARY KEY,
APELLIDO varchar(100) NOT NULL,
NOMBRE varchar(100) NOT NULL,
EMAIL varchar(100) NOT NULL,
DNI INT NOT NULL,
FECHA_INGRESO DATE NOT NULL,
DOMICILIO_ID INT NOT NULL);

DROP TABLE IF EXISTS odontologos;
CREATE TABLE odontologos (ID INT AUTO_INCREMENT PRIMARY KEY,
MATRICULA varchar(100) NOT NULL,
NOMBRE varchar(200) NOT NULL,
APELLIDO varchar(100) NOT NULL);


INSERT INTO domicilios (calle, numero, localidad, provincia) VALUES ('Calle A',474,'Cafayate','Salta');
INSERT INTO domicilios (calle, numero, localidad, provincia) VALUES ('Calle B',7841,'Óran','Salta');

INSERT INTO pacientes (apellido, nombre, email, dni, fecha_ingreso, domicilio_id)
VALUES ('Baspineiro','Rodolfo','qwe@gmail.com',147852,'2022-03-01',1);

INSERT INTO pacientes (apellido, nombre, email, dni, fecha_ingreso, domicilio_id)
VALUES ('Baspineiro','Ezequiel','zxc@gmail.com',748574,'2022-03-10',2);

INSERT INTO odontologos (nombre, apellido, matricula)
VALUES ('Liliana','Ospina','A47854');

INSERT INTO odontologos (nombre, apellido, matricula)
VALUES ('Leslie','Lowenstern','A47184');