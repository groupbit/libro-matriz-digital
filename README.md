[![Waffle.io - Columns and their card count](https://badge.waffle.io/ingsw-sarmiento/libro-matriz-digital.svg?columns=backlog)](https://waffle.io/ingsw-sarmiento/libro-matriz-digital)
[![Build Status](https://travis-ci.org/ingsw-sarmiento/libro-matriz-digital.svg?branch=master)](https://travis-ci.org/ingsw-sarmiento/libro-matriz-digital)

# Libro matriz digital
> Sistema de gestión para el ISFDyT nro. 138.

## Configuración necesaria para empezar a programar

  - Instalar el plugin de EditorConfig para Eclipse según se explica en https://marketplace.eclipse.org/content/editorconfig-eclipse.

  - Instalar Mysql Server en https://www.digitalocean.com/community/tutorials/how-to-install-mysql-on-ubuntu-18-04

  - Instalar IDE Eclipse en http://www.eclipse.org/downloads/packages/release/neon/3/eclipse-ide-java-ee-developers

  - Clonar el proyecto Maven desde la terminal:
       git clone https://github.com/ingsw-sarmiento/libro-matriz-digital.git

  - Integrar el proyecto Maven clonado a Eclipse con $mvn eclipse:eclipse; luego se podrá importar en Eclipse,desde el menú -> import -> Existing Maven Projects  

  - Probar el mvn desde consola con $mvn test ;otra opción con Eclipse, sobre la clase Test.java clicklear sobre Run As -> JUnit

  - Para inicializar la base de datos desde la consola de Mysql Server escribir los siguientes comandos:
      mysql -u root -proot

  - Crear una base de datos desde la consola y usarla(mas comandos en https://desarrolloweb.com/articulos/2408.php):

  ```
create database libro;
use libro;
```

Luego desde la clase GenerateDataMain correr Run-> JavaApplication para crear la base de datos.

Si es necesario borrar la base de datos, usar:
```
drop database libro;
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
