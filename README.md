# Proyecto - Pokémon TCG: Gestor de Colección de Cartas
Este programa simula la administración de una colección de cartas de un juego de cartas coleccionables tipo Pokémon TCG mediante una interfaz gráfica, donde el usuario puede agregar, modificar y eliminar cartas desde un panel de Administración,
y visualizar y ordenar su colección desde un panel de Ver Colección.
### Integrantes
* Martin Alvarado - [22.330.833-3] - [Martinooski]
### Estructura
Lógica centralizada en la clase SistemaImp.java (Singleton que implementa la interfaz Sistema), la cual coordina la Coleccion, el Escritor y las estrategias de ordenamiento.
La clase Coleccion, también Singleton, administra en memoria un ArrayList con las cartas del sistema. La clase Lector se encarga de parsear el archivo sobres.txt al inicio del programa,
delegando en la clase Factory la creación de cada carta según su tipo. La clase abstracta Carta define la estructura base, extendida por CartaPokemon, CartaItem, CartaSupporter y CartaEnergy,
cada una con sus propios atributos. El cálculo del poder de cada carta se resuelve mediante el patrón Visitor, a través de la interfaz Visitor y su implementación CalcularPoder,
mientras que el ordenamiento de la colección (por nombre, rareza o poder) se resuelve mediante el patrón Strategy, con las clases PorNombre, PorRareza y PorPoder.
La clase Ventana construye la interfaz gráfica con sus dos pestañas, la clase Escuchador gestiona el detalle de cada carta al hacer clic sobre la tabla,
y Main coordina el inicio del sistema y la apertura de la ventana. Los cambios realizados desde el panel de Administración se persisten automáticamente en el archivo sobres.txt mediante la clase Escritor, usando FileWriter.
