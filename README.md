# CasoPropusto-JavaMemory

CASO JAVA 
Debe usar POO(Patrones), Programación funcional para todos los casos. 
Una empresa organiza eventos tecnológicos con cierto nivel de frecuencia. Cuando se realiza un evento siempre tiene un título, la duración del mismo, el nombre del expositor, la hora de ingreso, la hora de salida y si esta en temporada alta o no. El costo de las entradas depende de la ubicación según la tabla adjunta. 
Tome en cuenta que de acuerdo a la categoría se definen los costos(PLATINUM=500, GOLD=350, SILVER=100). Use ENUMs para el caso. 
 Los expositores tienen código, nombre, apellidos, sueldo y correo, los asistentes al evento tienen código, nombre, apellidos, correo, teléfono y dirección. 
 
Observación: 
Para este caso se debe tener en cuenta que un evento solo debe tener un expositor y muchos asistentes. Un asistente solo puede ingresar a un evento. 
1.	Desarrollar un programa con las clases necesarias para el mantenimiento de una entidad evento (id, nombre, fecha, dirección, capacidad, categoría, costo), use patrones en memoria y archivos. 

a.	Realice operaciones CRUD con los eventos.  

b.	Mostrar lista de eventos ordenados por fecha ascendente y descendente. 

c.	Lista de eventos filtrados por fechas con rango (fecha inicial y fecha final) 

d.	Mostrar el nombre, mes, día, día de semana del evento con capacidad máxima y mínima. 

e.	Mostrar el promedio, mínimo y máximo de costos de los eventos. La cantidad de eventos superiores al costo promedio. 
 
f.	Halle: 
 
•	el día de la semana y el mes en el que se hacen más eventos. 

•	las cantidades de eventos por día y por mes. 
 
g.	Genere un método que llame a una clase que use un hilo para grabar una copia de seguridad de los datos en memoria en la ruta C:Eventos, el nombre del archivo sería eventofechahora este proceso de debe realizar cada 10 segundos con una duración de 1 minuto. 
 
h.	Defina un periodo 2020-Q3 y muestre: :  
 
•	Lista de eventos del periodo 2020-Q3,  

•	eventos antiguos (anteriores al 2020-Q3) l 

•	eventos nuevos(posteriores al 2020-Q3)  
 
i.	Muestre en todos los casos el trimestre al que pertenece (Q1, Q2, Q3 y Q4). 
 
•	Q1 : Ene, Feb y Mar 

•	Q2 : Abri, may, Jun 

•	Q3: Jul, Ago, Sep 

•	Q4: Oct, Nov y Dic 
 


2. Desarrollar un programa para probar y usar solo los métodos necesarios para el mantenimiento de eventos. 

a.	Prueba de crear eventos y que demuestre que no se pueden traslapar. 

b.	Prueba de creación de eventos para varios periodos y mostrar eventos por periodos. 

c.	Prueba de generación de copia de seguridad. 

d.	Prueba de reportes (de los puntos b,c,d,e, y f) 
 
Tomar en cuenta lo siguiente.

•	Debe usar clases inmutables, enums y buenas prácticas. 

•	Use funciones, expresiones y operaciones lambda. 

•	Use paralelismo en operaciones no determinísticas. 

•	El proyecto debe ser configurable de tal modo que mediante archivos properties se pueda definir si el proyecto usa archivos, memoria o base de datos. 
