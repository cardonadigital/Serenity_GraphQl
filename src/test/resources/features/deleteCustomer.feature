#language: es

Característica: Eliminar cliente

  Esquema del escenario: eliminar cliente de la base de datos
    Dado que el usuario administrador ingreso al aplicativo
    Cuando ingresa el id <id> del cliente que quiere eliminar
    Entonces podra ver que el cliente con el id <id> a sido eliminado correctamente
    Ejemplos:
      | id |
      | 1  |