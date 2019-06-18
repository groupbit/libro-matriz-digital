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

## Manejo de errores

Esta aplicación cuenta con un mecanismo transparente de manejo y visualización de errores, cuyos detalles pueden consultarse en [la wiki](https://github.com/ingsw-sarmiento/libro-matriz-digital/wiki/Mecanismo-de-manejo-de-errores).

Hay dos tipos posibles de validaciones: las que tienen que ver estrictamente con el input del usuario (campos obligatorios, números dentro de un rango, textos con una longitud mínima, etc.) y las que tienen que ver con una validación del dominio (bucle de correlativas, materia repetida, etc.). Cada tipo de validación se programa de forma diferente, según se explica a continuación.

### Validaciones del input

Para este tipo de validaciones sencillas nos valdremos de las annotations que provee Hibernate Validator, cuyo listado podemos consultar [acá](http://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#section-builtin-constraints). Estas validaciones deberían ser la opción por defecto, ya que requieren poco código y funcionan automáticamente.

Los pasos a seguir son:
1. Agregar las annotations necesarias a los atributos del modelo o del controller, dependiendo de cómo esté armada la `Page`.
1. Agregar al campo un `PropertyValidator` para que tenga en cuenta las annotations.

Un pequeño ejemplo:

```java
class Alumno {
  @NotNull
  @Size(min = 2, max = 30)
  private String nombre;
  // Se validará que no esté vacío y que tenga una longitud entre 2 y 30.
}

class AlumnoPage {
  // Configuración de la page
  public void configurarPagina() {
    Form<Alumno> formularioAlumno = // más configuraciones

    formularioAlumno
      .add(new TextField<>("nombre", new PropertyModel<>(alumno, "nombre"))
      .add(new PropertyValidator<>()));
  }
}
```

### Validaciones del dominio

Cuando no podamos utilizar las anteriores porque la validación sea más compleja, utilizaremos un mecanismo más precario pero poderoso también: arrojar una excepción. Es importante en este caso que el mensaje esté bien armado, porque será eso lo que verá nuestro usuario.

Para armar una de estas validaciones basta con arrojar una excepción de tipo `ModelException` en alguna parte del código que vaya a ejecutarse luego de hacer submit.

Un pequeño ejemplo:

```java
class Carrera {
  public void agregarMateria(Materia materia){
    validarMateriaEsNueva(materia);
    this.listadoMaterias.add(materia);
  }

  private void validarMateriaEsNueva(Materia materia) {
    if (this.listadoMaterias.stream().anyMatch(m -> m.getNombre().equals(materia.getNombre()))) {
      throw new ModelException("Ya existe una materia llamada " + materia.getNombre() + ".");
    }
  }
}
```

## Deploy de la aplicación

Para desplegar la aplicación utilizamos `docker`, según se explica en [este tutorial](https://github.com/ingsw-sarmiento/docker-java-mysql). Para subir una nueva versión hay que hacer _build_ de la imagen Docker y luego publicarla, ejecutando lo siguiente desde la raíz del repositorio:

```
./scripts/deploy-dockerhub
```

Si el `push` no funciona es porque no tenés la sesión iniciada o no tenés permisos para _pushear_ a dockerhub. Lo primero se soluciona ejecutando `docker login`, lo segundo pidiéndole a alguien que te de permisos.

Luego, hay que conectarse a la máquina remota, bajar la imagen nueva y reiniciar el servicio, lo cual se logra ejecutando lo siguiente desde la raíz del repositorio:

```
./scripts/reiniciar-produccion
```

Para que funcione, son necesarias dos cosas:
* debe existir un archivo `docker-compose.prod.yml`, con la configuración para el entorno de producción;
* tiene que estar configurada en tu computadora una `docker-machine` llamada `produccion`.
