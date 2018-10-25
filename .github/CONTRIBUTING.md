# Proceso de revisión

Cada _pull request_ deberá ser revisado por dos personas, un/a estudiante y el docente. Qué estudiante revisará a quién lo definiremos semalmente según un esquema rotativo que plasmaremos aquí.

El objetivo de esto es que el proceso de revisión constituya una instancia de aprendizaje tanto para quien escribió el código como para quien lo va a revisar. Todo el intercambio debe ocurrir en los comentarios, para que el docente pueda enterarse de cómo fue el proceso.

## Criterios mínimos para aprobar una revisión

Del _pull request_:
* la descripción debe comenzar con `Closes #n`, siendo `n` el número de issue;
* si la issue tiene un componente visual, debe incluirse una captura de pantalla que muestre el trabajo realizado;

Del código:
* todo código de dominio debe estar acompañado por sus tests;
* no tener faltas de ortografía;
* intentar no mezclar español con inglés, excepto para las cosas "estándar" (_getters_, _setters_, métodos que tengan que ver con la base de datos, objetos de bibliotecas, etc);
* el código debe estar formateado según los parámetros de [EditorConfig](https://editorconfig.org/) que definamos.
