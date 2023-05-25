#language: es

Característica: Actualizar cliente

  Esquema del escenario: actualizar nombre de cliente
    Dado que el usuario administrador ingreso al aplicativo
    Cuando ingresa el nuevo nombre del cliente: "<nombre>"
    Entonces podra ver que el cliente tiene el nombre "<nombre>" actualizado
    Ejemplos:
      | nombre      |
      | nuevoNombre |