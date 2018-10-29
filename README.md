[![Waffle.io - Columns and their card count](https://badge.waffle.io/ingsw-sarmiento/libro-matriz-digital.svg?columns=backlog)](https://waffle.io/ingsw-sarmiento/libro-matriz-digital)

# Libro matriz digital
> Sistema de gestión para el ISFDyT nro. 138.

## Configuración necesaria para empezar a programar

Instalar el plugin de EditorConfig para Eclipse según se explica en https://marketplace.eclipse.org/content/editorconfig-eclipse.
  
  Instalar Mysql Server en https://www.digitalocean.com/community/tutorials/how-to-install-mysql-on-ubuntu-18-04

  - Instalar IDE Eclipse

  - Clonar el proyecto Maven desde la terminal:
       git clone https://github.com/ingsw-sarmiento/libro-matriz-digital.git

  - Importar el proyecto desde Eclipse en http://www.eclipse.org/downloads/packages/release/neon/3/eclipse-ide-java-ee-developers

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
      - desde donde se encuentra nuestro proyecto abrimos una terminal, luego ejecutamos el comando _mvn jetty:run _
     
	- Por último, independientemente de la opción elegida, abrimos un navegador y escribimos _localhost:8080_
                                                                    
## Pasos para usar Spring
    
    - La clase que vayamos a querer inyectar debe tener una anotations que la identifique, como por ejemplo vemos en la siguiente imagen con @Component
    [@Component](https://drive.google.com/open?id=10LopaKfwTi_XtLDQ99wD-7aPmMfUcUY1)
    
    - La clase en la que vamos a inyectar otra, la haremos con la anotation @Autowire, el atributo tiene que tener el mismo nombre que la clase pero la primera letra con minuscula, como vemos a continuación
    [@Autowire](https://drive.google.com/open?id=1pf-jTqMCB-XNUgoMmjDj3nOXDfXFILk1)
    
    - Cuando queramos que una clase maneje transacciones la anotaremos con @Transactional además de tener la anotation @Component
    [@Transactional](https://drive.google.com/open?id=1yT5f6vGJp785IjaJ1V8s-2rXoOJwkGGS)
    
    
### Spring con Wicket

    - Para inyectar en una clase que use wicket, como por ejemplo las paginas que extienden de WebPage, se tiene que usar @SpringBean(name="nombre") el name tiene que ser el nombre de la clase pero la primera letra con minuscula, como vemos en la siguiente imagen
    [@SpringBean(name="nomre")](https://drive.google.com/open?id=1c1Bj5ddamayiE2ARn2bE_unWxu5BZD9K)
    
    - En la clase HibernateConfig no debe estar la siguiente linea hibernateProperties.setProperty("hibernate.current_session_context_class", "thread"); o en su defecto comentada.
    [Linea comentada](https://drive.google.com/open?id=1ZkxkjWqgZ3OUGHVdLowlvmb8Wj_XP0iz)
    
### Spring para ejecutar el DataGenerator

    - Primero tendremos ir al HibernateConfig y descomentar la linea anteriormente mencionada o agregarla si no estuviese
    [Linea comentada](https://drive.google.com/open?id=1ZkxkjWqgZ3OUGHVdLowlvmb8Wj_XP0iz)
    
    - Para ejecutar el DataGenerator tendremos que hacer clic derecho en la clase GenerateDataMain, luego ir a "Ran As" y precionamos en "Java Aplicattions"
