[![Waffle.io - Columns and their card count](https://badge.waffle.io/ingsw-sarmiento/libro-matriz-digital.svg?columns=backlog)](https://waffle.io/ingsw-sarmiento/libro-matriz-digital)
[![Build Status](https://travis-ci.org/ingsw-sarmiento/libro-matriz-digital.svg?branch=master)](https://travis-ci.org/ingsw-sarmiento/libro-matriz-digital)

# Libro matriz digital
> Sistema de gestión para el ISFDyT nro. 138. [:link:](http://libro-matriz-digital.us-east-1.elasticbeanstalk.com)

## Configuración necesaria para empezar a programar

  - Instalar el plugin de EditorConfig para Eclipse según se explica en https://marketplace.eclipse.org/content/editorconfig-eclipse.

  - Instalar Mysql Server en https://www.digitalocean.com/community/tutorials/how-to-install-mysql-on-ubuntu-18-04

  - Instalar IDE Eclipse en http://www.eclipse.org/downloads/packages/release/neon/3/eclipse-ide-java-ee-developers

  - Clonar el proyecto Maven desde la terminal:
       git clone https://github.com/ingsw-sarmiento/libro-matriz-digital.git

  - Integrar el proyecto Maven clonado a Eclipse con $mvn eclipse:eclipse; luego se podrá importar en Eclipse,desde el menú -> import -> Existing Maven Projects  

  - Probar el mvn desde consola con $mvn test ;otra opción con Eclipse, sobre la clase Test.java clicklear sobre Run As -> JUnit

  - Para inicializar la base de datos desde la consola de Mysql Server escribir los siguientes comandos:
```      
mysql -u root -proot
```
  - Crear una base de datos desde la consola y usarla(mas comandos en https://desarrolloweb.com/articulos/2408.php):

```
create database libroMatrizDigital;
use libroMatrizDigital;
```

Luego, ejecutar:

1. `RunFlywayDBMigrations` para crear las tablas.
1. `GenerateDataMain` para cargar el juego de datos iniciales.

Ambas clases se ejecutan mediante la opción `Run As -> Java Application`.

Si es necesario borrar la base de datos, usar:
```
drop database libroMatrizDigital;
```

## Pasos para levantar el proyecto con Jetty desde eclipse o desde consola:

### Para levantar el proyecto con jetty desde eclipse:
- elegir RUN del menu de eclipse, luego  elegir la opción RUN CONFIGURATIONS
- buscar MAVEN BUILD
- hacer clic con botón derecho sobre MAVEN BUILD y elegir new
- en la ventana que se despliega:
	- si queremos podemos en Name escribir un nombre
	- en el botón WORKSPACE elegimos nuestro proyecto
	- en donde dice Goals: escribimos _jetty:run_
	- luego hacemos clic en el boton RUN

### Para levantar el proyecto desde consola:
- desde donde se encuentra nuestro proyecto abrimos una terminal, luego ejecutamos el comando `mvn jetty:run`.

- Por último, independientemente de la opción elegida, abrimos un navegador y escribimos `localhost:8080`.

### Para debuguear:

- Levantar el proyecto por consola como se indica en el paso anterior, pero utilizando el comando `mvnDebug` en vez de `mvn`. Quedaría `mvnDebug jetty:run`.
- En el Eclipse, ir a `Run -> Debug configurations...` y agregar una nueva del tipo `Remote Java Application`. Configurarlo como se ve en la imagen, usando `localhost` para el _Host_ y `8000` para el _Port_:
![screenshot from 2018-11-13 20-46-34](https://user-images.githubusercontent.com/1585835/48450543-61aa0880-e785-11e8-8306-48d964ea8542.png)

## Migraciones de SQL

Para manejar las migraciones de la base de datos utilizamos [Flyway](https://flywaydb.org/), una herramienta que automatiza parte de la tarea.

Las migraciones no son más que archivos SQL dentro de la carpeta `src/main/resources/db/migration`, que Flyway va a ejecutar en orden, según su nombre. Para este proyecto elegimos nombrar a los archivos según su fecha y hora de creación, por ejemplo: `V20190205174623__Crear_tabla_Representante` es una migración creada el 05/02/2019 a las 17:46:23 que crea una tabla llamada `Representante`.

En el proyecto hay una serie de clases ejecutables que ayudan en esta tarea:

* `DumpSQLSchema.java`: exporta el esquema generado por Hibernate al archivo `src/main/resources/db/schema.sql`. Resulta útil para ver qué cambió.
* `CreateMigrationFile.java`: crea un archivo vacío para escribir una migración, usando la convención de nombre por fecha y hora. Es importante recordar agregarle una descripción adecuada.
* `RunFlywayDBMigrations.java`: corre las migraciones necesarias y actualiza el archivo con el schema.
#Manejo de errores:

##Instalación:

 * Agregar las dependencias en el pom:
    wicket_bean_validation:
     
       <dependency>
       <groupId>org.apache.wicket</groupId>
       <artifactId>wicket-bean-validation</artifactId>
       <version>${wicket.version}</version>
       </dependency> 

    hibernate_validator:
        <dependency>
        <groupId>org.hibernate</groupId>
        <artifactId>hibernate-validator</artifactId>
        <version>5.3.5.Final</version>
        </dependency>

 * Agregar las clases:

    Creamos la clase ModelErrorRequestCycleListernerHandler que se utiliza para poder insertar código en el momento que se hace resquest, en nuestro caso la usamos para chequear si es un 
    error de ModelException o un defaultException(error fuera de nuestro modelo) y lanzar el error según sea el caso.

    Creamos la clase ModelException que se utiliza para filtrar los errores que se generan en nuestro modelo. 

    Creamos la clase BootstrapFeedbackPanel y su respectivo html en donde en la clase se definirá su construcción y sus diferentes ventanas del panel. En el html su construcción para 
    visualizar en el navegador. Se agrega al archivo main.css el estilo del feedbackPanel.
    
 * Configuración en Wicket:
    
    En WicketAplication se utilizan para:
       validación imperativa: - PageRequestHandlerTracker.
                              - ModelErrorRequestCycleListernerHandler

       annotations: - BeanValidationConfiguration.

 * Configuración de la clase LayoutPage a la cual agregamos el componente BootstrapFeedbackPanel y en su correspondiente html definimos la construcción para visualizar en el navegador.
 

