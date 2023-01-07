# - Identifica las características principales de los patrones de diseño más conocidos, indica para qué valen y un caso de uso para cada uno de ellos.
 
  ## Creational 

  - Singleton: Este patrón hace que solo pueda haber una instancia de una clase. De esta manera se comparte una instancia, evitando que hayan distintas instancias de la misma clase que a su vez puedan invocar a métodos que tengan comportamientos diferentes. Se puede utilizar para las conexiones a las bases de datos.

  - Factory: Nos ayuda a crear una jerarquía de clases y utilizar una u otra de manera transparente. Permite encapsular la creación de objetos. Un ejemplo de uso podría ser a la hora de realizar una factura, dependiendo del tipo de IVA de los productos (exento, reducido, etc.).

  - Builder: Se usa para la creación de objetos complejos paso a paso, sin necesidad de utilizar constructores con muchos parámetros o teniendo que llamar a infinidad de métodos. Un ejemplo de uso podría ser a la hora de crear un objeto de la clase Vehiculo, habiendo distintos tipos de vehículo con diferentes parámetros para cada tipo. De esta manera se crean nuevos vehículos, añadiendo los atributos que consideremos necesarios en cada caso. 

  - Prototype: Nos permite crear un clon de un objeto. Un ejemplo podría ser una clase llamada Animal, con sus parámetros y un método "clonar". Este método nos permitiría crear clones de la clase Animal.
  

  ## Structural 

  - Decorator: Permite agregar funcionalidades y responsabilidades a objetos de forma dinámica y transparente para el usuario. Un ejemplo podría ser un restaurante de comida rápida que ofrece tres tipos de combos con características distintas (básico, especial y familiar), y a su vez, a estos combos se les pueden añadir extras.

  - Adapter: Funcionará como adaptador entre dos objetos, recibe información de uno para "adaptar" esa información para que pueda ser consumida por el otro objeto. Un ejemplo de uso podría ser el caso de tener que adaptar un programa obsoleto a uno actualizado.

  - Facade: Este patrón define una solución modelo para fusionar diferentes interfaces de sistemas complejos, delegando importantes funcionalidades del programa a las "subclases". Un ejemplo podría ser un convesor de tipos de archivo, escondiendo su complejidad en las subclases.


# - Crea una pequeña aplicación implementando el patrón Singlenton y demuestra que, efectivamente, no crea instancias nuevas. Puedes tomar la sesión 7 como referencia.