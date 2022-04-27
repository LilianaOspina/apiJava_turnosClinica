# Sistema de reserva de turnos

Implementa un sistema que permie administrar la reserva de turnos para una clínica odontológica. 

Cumple con los siguientes requerimientos:

## Administración de datos

✅ **Administración de datos de odontólogos:** 

- Listar
- Agregar
- Modificar 
- Eliminar 
- Registrar apellido, nombre y matrícula de los mismos.


✅ **Administración de datos de los pacientes:**

- Listar
- Agregar
- Modificar 
- Eliminar 
- De cada uno se almacenan: nombre, apellido, domicilio, mail, DNI y fecha de alta.

## **Registro de turnos:** 

✅ Permite asignar a un paciente un turno con un odontólogo a una determinada fecha y hora.

## **Login:** 

✅ Valida el ingreso al sistema mediante un login con usuario y password. 

✅ Permite a cualquier usuario logueado (ROLE_USER) registrar un turno, pero solo a quienes tengan un rol de administración (ROLE_ADMIN) poder gestionar odontólogos y pacientes. Un usuario podrá tener un único rol y los mismos se ingresarán directamente en la base de datos.

## Requerimientos técnicos

La aplicación está desarrollada en capas:

- **Capa de entidades de negocio:** Son las clases Java de nuestro negocio modelado a través del paradigma orientado a objetos.

- **Capa de acceso a datos (Repository):** Son las clases que se encargarán de acceder a la base de datos.

- **Capa de datos (base de datos):** Es la base de datos de nuestro sistema modelado a través de un modelo entidad-relación. Utilizaremos la base H2 por su practicidad.

- **Capa de negocio:** Son las clases service que se encargan de desacoplar el acceso a datos de la vista.

- **Capa de presentación:** Son las pantallas web que tendremos que desarrollar utilizando el framework de Spring Boot MVC con los controladores y alguna de estas dos opciones: HTML+JavaScript o React para la vista.

## Manejo de excepciones

Maneja excepciones logueando cualquier excepción que se pueda generar.

## Test

Reaaliza test unitarios para garantizar la calidad de los desarrollos.
