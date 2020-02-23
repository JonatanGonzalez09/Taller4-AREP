# Taller de Arquitecturas de Servidores de Aplicaciones #
El objetivo del taller es construir un servidor Web **(tipo Apache)** en _Java_, el cual debe ser capaz de entregar páginas html e imágenes tipo PNG, atendiendolas concurrentemente; también debe proveer un framework **(BetterSpringBoot)** IoC para la construcción de aplicaciones web a partir de _POJOS_.

**Link del despliegue de la aplicación: https://evening-scrubland-29292.herokuapp.com/**

## Prerrequisitos ##
Se debe tener conocimientos claros de la programación Orientada a objetos.
Se debe tener conocimientos sobre manejo de POJOS.
Se debe tener conocimientos sobre como funciona un servidor Web.

## Construido con ##
[Maven](https://maven.apache.org/): Para la gestión de dependencias.

[Java](https://www.java.com/es/): Como lenguaje de programacion.

[Heroku](https://www.heroku.com/): Para realizar el despliegue de la aplicación.

## Descripción en Latex ##
En el siguiente vinculo encontrara el respectivo PDF de la descripción del diseño desarrollado en LaTeX.
[Click](https://github.com/JonatanGonzalez09/Taller4-AREP/blob/master/resources/Laboratorio_4.pdf)

## Documentación Javadoc ##
Para generar la documentacion javadoc, fue necesario ejecutar los siguientes comandos:

```
- mvn javadoc:javadoc
- mvn javadoc:jar
- mvn javadoc:aggregate
- mvn javadoc:aggregate-jar
- mvn javadoc:test-javadoc
- mvn javadoc:test-jar
- mvn javadoc:test-aggregate
- mvn javadoc:test-aggregate-jar
```
La ruta donde encontrara la documentacion es la siguiente: **\target\apidocs\edu\escuelaing\arep\betterSpring** dependiendo del paquete que quiera revisar ya sea _annotations_, _framework_, _ws_, _impl_, o las clases _Server_ o _Usuario_

## Ejecución ##
Para empaquetar el proyecto se ejecuta el comando:

```mvn package```

Para ejecutar las pruebas se ejecuta el comando:

```mvn test```

## Pruebas del Servidor recibiendo multiples solicitudes ##

Se puede observar el recurso de webPage.img que es el retorno de una imagen png. **/webPage.img**

**https://evening-scrubland-29292.herokuapp.com/webPage.img**

![](https://github.com/JonatanGonzalez09/Taller4-AREP/blob/master/resources/imagen.JPG)

Se puede observar el recurso de users.bd que es el retorno de la base de datos. **/users.bd**

**https://evening-scrubland-29292.herokuapp.com/users.bd**

![](https://github.com/JonatanGonzalez09/Taller4-AREP/blob/master/resources/database.JPG)

Se puede observar el recurso de hello.html que es el retorno de un HTML. **/hello.html**

**https://evening-scrubland-29292.herokuapp.com/hello.html**

![](https://github.com/JonatanGonzalez09/Taller4-AREP/blob/master/resources/hello.JPG)

## Licencia ##
Este proyecto cuenta con la licencia [**GNU General Public License v3.0**](https://github.com/JonatanGonzalez09/Clientes-Servicios-AREP/blob/master/LICENSE)

## Autor ##
Jonatan Esteban Gonzalez Rodriguez 

