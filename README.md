# _Practica excepciones Java_
### _Hacer una interfaz gráfica para la gestión de una tienda de peliculas:_


- Las peliculas tienen: nombre, una pequeña descripción, genero y duracion.

- El genero puede ser accion, romance o drama

- todas las peliculas cuesta 10000 el alquiler

- Debe haber un menú desplegable donde aparecen los nombres de las peliculas y al seleccionar uno puedo ver toda su información

- Debo poder alquilar tantas peliculas como quiera

- Cuando desee terminar el proceso, debes undir el boton pagar para generar factura, que será un textarea con la información de lo que he pedido, el costo total y cuanto tiempo en total se va a demorar

Se deben generar las siguientes excepciones (mensaje no es válido, tiene que ser excepciones):

- Si el cliente alquila mas de 10 peliculas es como raro( no es normal alquilar tantas)

- Si todas las peliculas son romanticas tampoco (depronto se nos pone triste por idealizar la vida xD)

- Si alguila exactamente 7 peliculas le da un mensaje que dice que le descuentan 5000 pesos de la orden

# _Avances_

1. Para trabajar con JFrame traidos de netBeans y a los que se les agrego un absolute layout es necesario trabajar con una libreria especial
2. Agregué lo que serán las vistas por el momento
3. Se implemento toda la funcionalidad de la interfaz haciendo uso de un patron MVC muy basico
4. se agregaron las excepciones que se piden y tambien se agregaron más peliculas de prueba
5. Se agrega patron DAO para tener un almacenamiento persistente, se agrega la libreria para manejar SQLite
6. Se agrega una base de datos SQLite, el programa solo esta habilitado para consulta de datos