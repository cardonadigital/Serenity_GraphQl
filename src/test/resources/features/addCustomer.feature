#language: es

Característica: Ingresar un nuevo cliente

  Esquema del escenario: agregar cliente
    Dado que el usuario administrador ingreso al aplicativo
    Cuando ingresa los datos de cliente id <id>, nombre "<nombre>" ,apellido "<apellido>" , ordenes de compra <ordenCompra> y <ordenCompra2>
    Entonces podra ver el nuevo cliente creado con el id <id>
    Ejemplos:
      | id | nombre | apellido | ordenCompra | ordenCompra2 |
      | 1  | pepito | perez    | 1           | 2            |