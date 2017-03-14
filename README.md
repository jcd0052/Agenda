# Agenda
Es una pequeña aplicación para mantener los datos de contactos y sus llamadas.
Utiliza el diagrama MVC y puede almacenar los datos datos, en un fichero binario manejado por la própia aplicación o a través de una conexión sql.
Para las pruebas se ha utilizado el sistema gestor de base de datos HyperSQL.
También es posible elegir si se ejecutará con interfaz de usuario gráfica o por consola.

# Ejecución
La ejecución se efctua con la siguiente línea:

java -jar Agenda.jar basedatos interface

Parámetros:

basedatos indica que capa de persistencia utilizar "BBDD" para base de datos HSQL, "BIN" para fichero binario.

interface indica que interface de usuario utilizar "TUI" consola de texto, "GUI" para ventana gráfica
