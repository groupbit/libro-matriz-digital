[![Waffle.io - Columns and their card count](https://badge.waffle.io/ingsw-sarmiento/libro-matriz-digital.svg?columns=backlog)](https://waffle.io/ingsw-sarmiento/libro-matriz-digital)

# Libro matriz digital
> Sistema de gestión para el ISFDyT nro. 138.

## Configuración necesaria para empezar a programar

Instalar el plugin de EditorConfig para Eclipse según se explica en https://marketplace.eclipse.org/content/editorconfig-eclipse.
  
  -Tener instalado el Server de Mysl

  -Clonar el proyecto Maven desde la terminal:
       git clone https://github.com/ingsw-sarmiento/libro-matriz-digital.git

  -Compilar el proyecto Maven desde la terminal, de ser necesario: 
        mvn compile

  -Adaptar el proyecto Maven a Eclipse, de ser necesario, agregando las fuentes. Parados en el directorio que tiene el proyecto:
        mvn eclipse:eclipse

  -Desde el IDE Eclipse importar el proyecto libro-matriz-digital en el workspace.

  -Agregar las dependencias para integrar al proyecto Maven:
 
   Las dependecias que no estén implementadas  en el pom.xml pueden buscarse en https://search.maven.org/
 
           *Wicket(framework de desarrollo de aplicaciones web)
           *API Jdbc que permite la ejecución de operaciones sobre la base de datos de Mysql Server desde el lenguaje Java
           *Hibernate (ORM) que implementa además  el estándar JPA Java Persistence API ,para las annotations
    
   -Agregar las librerías de Apache Tomcat y JUnit.

   -Actualizar proyecto Maven : updateProjectMaven en el menú de eclipse
                                                                     
