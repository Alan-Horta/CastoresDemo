# Castores Alan Demo

Proyecto para la prueba de Castores

## Instrucciones

Bajar el repositorio y ejecutar en IDE de preferencia. (Creado en Apache NetBeans IDE 14)
El proyecto se realizo con Glassfish version 6.2.5 con Jakarta EE 9.1 y el Java JDK 11 [enlace](https://projects.eclipse.org/projects/ee4j.glassfish/downloads)

### MySQL

La aplicacion requiere el uso de MySql, el default path esta configurado a `JDBC_URL="jdbc:mysql://192.168.0.126:3306/castores_test_alan?useSSL=false&useTimezone=true&serverTimeZone=UTC&allowPublicKeyRetrieval=true";` en `Conexion.java` por si en dado caso se requiera modificar.

`IP: 192.168.0.126`

`Puerto: 3306`

La aplicacion requiere que exista un Schema con el nombre `castores_test_alan` y el cual esta incluido [aqui](https://github.com/Alan-Horta/CastoresDemo/tree/master/extras) en la carpeta de extras

Para la conexion a la base de datos, se uso la ultima version de [my-sql-connector-java](https://github.com/Alan-Horta/AngularViseDemo) disponible al momento, la [8.0.29](https://github.com/Alan-Horta/CastoresDemo/tree/master/extras) incluido en la carpeta de extras

### Instrucciones de uso

El proyecto contiene un inico de sesion y la posibilidad de crear un usuario, al momento de crearlo perguntara si es usuario interno de Castores, al responderle que si tendra diferentes funciones.

El usuario interno puede realizar todo lo que el externo puede, la diferencia es que el usuario interno puede modificar y crear noticias.

Ambos usuarios pueden comentar.

Solo el creador del comentario puede borrar su comentario.

Usuario existentes:

`Usuario: alan password: 123`

`Usuario: invitado password: 123`

### Comentarios
Este proyecto se realizo unicamente en Java con sus modulos JSP y Servlets, originalmente tenia planeado usar Angular y Java Spring hasta que me comentaron que era en puro Java.

En caso de que se requiera bajar la version de Glassfish por cuestiones de compatibilidad favor de hacermelo saber.
