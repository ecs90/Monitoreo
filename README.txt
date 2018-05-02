GOALS:
-MVN clean: sirve para "limpiar" el proyecto, dejando solo el codigo fuente.
-MVN compile: compila las clases, genera los .class.
-MVN package: mete los .class y recursos en un jar.
-MVN install: guarda el jar en el repositorio local para que cualquier otro proyecto lo pueda usar como dependencia.

SCOPES:
-Compile: default scope (usado si no se especifica cual usar). Se necesitan las clases de la dependencia para poder compilar.
-Provide: como compile, pero espera un JDK o contenedor que provea las dependencias. Solo disponible al compilar/testear.
-Runtime: indica que la dependencia no es necesaria para compilar, pero si para ejecutar.
-Test: dependencia no requerida para el uso normal de la aplicacion. Solo disponible al testear y ejecutar.
-System: similar a "provided", debe proveer el JAR que lo contiene explicitamente. El artifact esta siempre disponible.
-Import: solo soportado en una dependencia de tipo "pom" en la seccion <dependencyManagement>

Todos los scopes, a excepcion de import, afectan las dependencias transitivas de diferentes formas

ARCHETYPE: 1) Modelo o patron del que los demas tipos estan hechos/basados en.
2) Herramienta de creacion de plantillas de proyectos

ARTIFACT: ejecutable generado por el programa al ser compilado.


Estructura basica:
autentiaNegocio
|-- pom.xml
`-- src
    |-- main
    |   `-- java
    |       `-- com
    |           `-- autentia
    |               `-- demoapp
    |                   `-- App.java
    `-- test
        `-- java
            `-- com
                `-- autentia
                    `-- demoapp
                        `-- AppTest.java

@Component: marca una clase como Bean para ser autodetectado y usado en el contexto de la aplicacion.
@Repository: clases marcadas con esta anotacion estan elacionadas con la persistencia.
@Service: capa de servicios o de negocios.
@Controller: controla la app.

Verbos REST:
GET: Para consultar y leer recursos. (Listar)
POST: Para crear recursos. (Crear)
PUT: Para editar recursos. (Modificar objeto)
DELETE: Para eliminar recursos. (Eliminar)
PATCH: Para editar partes concretas de un recurso. (Modificar)