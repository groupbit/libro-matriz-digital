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
  
  -Pasos necesarios para levantar la app con jetty desde eclipse:
      - elegir RUN del menu de eclipse, luego  elegir la opoción RUN CONFIGURATIONS
      - buscar MAVEN BUILD
      - hacer clic con botón derecho sobre MAVEN BUILD y elegir new
      - en la ventana que se despliega:
              - si queremos podemos en Name escribir un nombre
              - en el botón WORKSPACE elegimos nuestro proyecto
              - en donde dice Goals: escribimos _jetty:run_
              - luego hacemos clic en el boton RUN
   - Para levantar el proyecto desde consola
      - desde donde se encuentra nuestro proyecto abrimos una terminal, luego ejecutamos el comando _mvn jetty:run _
  

  
                                                                     
