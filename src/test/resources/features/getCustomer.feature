#language: es

Característica: Obtener usuario

  Esquema del escenario: obtener usuario por id
    Dado que el usuario administrador ingreso al aplicativo
    Cuando ingresa el id <id> del cliente que quiere obtener
    Entonces podra ver que el nombre de usuario retornado es "<nombre>"
    Ejemplos:
      | id | nombre      |
      | 1  | nuevoNombre |