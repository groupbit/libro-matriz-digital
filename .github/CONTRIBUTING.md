# Proceso de revisión

El objetivo es que el proceso de revisión constituya una instancia de aprendizaje tanto para quien escribió el código como para quien lo va a revisar. Todas las observaciones deben ser constructivas y aportar a la mejora de la calidad del proyecto, sin dejar de ser rigurosas.

Cada _pull request_ deberá ser revisado por dos personas, un/a estudiante y el docente, siguiendo los criterios especificados en el apartado **Criterios mínimos para aprobar una revisión**. Qué estudiante revisará a quién lo definiremos semalmente según un esquema rotativo que plasmaremos aquí.

La responsabilidad de revisar es, en primera instancia, de el/la estudiante; el docente actuará solamente como revisor de segunda instancia, validando que se estén respetando los criterios establecidos. Todo el intercambio debe ocurrir en los comentarios, para que el docente pueda visualizar cómo fue el proceso.

## Criterios mínimos para aprobar una revisión

Del _pull request_:
  1. tiene que asignar como _Reviewer_ a quien le corresponda según el esquema semanal;
  1. la rama debe estar nombrada según se indica en el [Flujo de trabajo](https://github.com/ingsw-sarmiento/libro-matriz-digital/wiki#flujo-de-trabajo) que está en la wiki;
  1. la descripción debe comenzar con `Closes #n`, siendo `n` el número de issue;
  1. si la issue tiene un componente visual, debe incluirse una captura de pantalla que muestre el trabajo realizado. Para incluir una imagen se puede arrastrar desde una carpeta o simplemente pegarla con <kbd>Ctrl</kbd> + <kbd>V</kbd> si está en el portapapeles.

Del código:
  1. todo código de dominio debe estar acompañado por sus tests;
  1. si es una entidad de Hibernate debe tener test de persistencia;
  1. no tener faltas de ortografía;
  1. las entidades de dominio, los tests y todo lo que creemos nosotros deberá estar en español. Se puede usar inglés para las cosas "estándar" (_getters_, _setters_, métodos que tengan que ver con la base de datos, objetos de bibliotecas, etc);
  1. no puede haber código comentado;
  1. no puede haber definiciones de CSS en los HTML, todo debe estar en `webapp/css`.

## Esquema de revisión (período 17/04 - 24/04)

* @nataliaMarzec revisa a @NahuelM426.
* @JuanCS95 revisa a @vgrana.
* @NahuelM426 revisa a @fede9612.
* @fede9612 revisa a @JuanCS95.
* @vgrana revisa a @nataliaMarzec.

