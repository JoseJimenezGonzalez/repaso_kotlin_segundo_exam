package ultimos_ejercicios_seminario

//Crea la clase de datos Videojuego, que tendrá nombre, año y plataforma del
//juego. Crea una lista con 8 videojuegos de tres plataformas distintas. Crea una función
//que dada una lista de juegos, un año y una plataforma devuelve los juegos de la lista de
//dicho año y plataforma. La función también debe poder usarse especificando solo el año
//o solo la plataforma.

//Crea una función que reciba una lista de juegos y devuelva un mapa
//donde las claves sean las plataformas y el valor el número de juegos para dicha
//plataforma.
data class Videojuego (var nombre: String, var anio: Int, var plataformaVideojuego: String){
    override fun toString(): String {
        return "Nombre: $nombre, año de lanzamiento: $anio y plataforma en la que está disponible el videojuego: $plataformaVideojuego\n"
    }
}
//Crea una funciónque dada una lista de juegos, un año y una plataforma devuelve los juegos de la lista de
//dicho año y plataforma. La función también debe poder usarse especificando solo el año o solo la plataforma.
//Se si no se mete anio este va a null y lo mismo para la plataforma
fun filtrarPorAnioPlataforma(listaMutable: MutableList<Videojuego>, anio: Int? = null, plataforma: String? = null): List<Videojuego>{
    return listaMutable.filter { videojuego ->
        //Condicion para que lo meta en la lista
        (anio == null || videojuego.anio == anio) && (plataforma == null || videojuego.plataformaVideojuego == plataforma)
    }
}
/*
groupBy { juego -> juego.plataforma }:
groupBy es una función de la colección que agrupa los elementos según el resultado de aplicar la función especificada (juego -> juego.plataforma en este caso).
En este contexto, se están agrupando los videojuegos por la propiedad plataforma.
map { (plataforma, listaJuegosPorPlataforma) -> plataforma to listaJuegosPorPlataforma.size }:
map es otra función de la colección que transforma cada grupo resultante de groupBy en un nuevo objeto.
En este caso, la transformación se realiza mediante una función lambda que toma cada par (plataforma, listaJuegosPorPlataforma) y lo transforma en un nuevo par
(plataforma, cantidad de juegos) utilizando el operador to.
La cantidad de juegos se obtiene mediante listaJuegosPorPlataforma.size.
toMap(): Convierte la lista resultante de map en un Map. En este punto, tienes un Map donde la clave es la plataforma y el valor es la cantidad de juegos asociada a esa plataforma.
*/
//Crea una función que reciba una lista de juegos y devuelva un mapa
//donde las claves sean las plataformas y el valor el número de juegos para dicha plataforma.
fun contarJuegosPorPlataforma(listaJuegos: List<Videojuego>): Map<String, Int> {
    return listaJuegos
        .groupBy { juego -> juego.plataformaVideojuego }  // Agrupa los juegos por plataforma
        .map { (plataforma, listaJuegosPorPlataforma) -> plataforma to listaJuegosPorPlataforma.size }  // Convierte la agrupación en pares plataforma -> cantidad de juegos
        .toMap()  // Convierte la lista de pares en un Map
}

//Crear una función que dada una lista de videojuegos, lista de años y lista de
//plataformas devuelva los juegos de la lista que fueron creados en esos años y para esas
//plataformas. La función debe poder usarse si solo se especifica la lista de años o la lista
//de plataformas.
/**
Declaración de la función:

fun filtrarJuegosPorListas(: Define una función llamada filtrarJuegosPorListas que toma tres parámetros: listaJuegos (una lista de objetos Videojuego), listaAnios (una lista opcional de años) y listaPlataformas (una lista opcional de plataformas).
Parámetros con valores por defecto:

listaAnios: List<Int>? = null, listaPlataformas: List<String>? = null: Los parámetros listaAnios y listaPlataformas son opcionales y tienen valores predeterminados de null. Esto significa que puedes llamar a la función sin proporcionar estas listas, en cuyo caso se usarán los valores predeterminados.
Cuerpo de la función:
listaJuegos.filter { juego -> ... }: Utiliza la función filter de la lista listaJuegos. Para cada juego en la lista, se evalúa la condición en el bloque de código entre llaves {...}.

// Condición para agregar el juego a la lista: Comentario que explica el propósito de la condición siguiente.

(listaAnios == null || juego.anio in listaAnios): Verifica si listaAnios es null o si el año del juego está contenido en la lista de años. Si es cierto, el juego cumple con la condición.

&&: Operador lógico "y" que asegura que ambas condiciones deben ser verdaderas para que el juego sea incluido en la lista filtrada.

(listaPlataformas == null || juego.plataformaVideojuego in listaPlataformas): Verifica si listaPlataformas es null o si la plataforma del juego está contenida en la lista de plataformas. Si es cierto, el juego cumple con la condición.

Valor de retorno:

return: Devuelve la lista filtrada de juegos que cumplen con las condiciones especificadas.
 */
fun filtrarJuegosPorListas(listaJuegos: List<Videojuego>, listaAnios: List<Int>? = null, listaPlataformas: List<String>? = null): List<Videojuego> {
    return listaJuegos.filter { juego ->
        //Condicion para agregarlo a la lista
        (listaAnios == null || juego.anio in listaAnios) && (listaPlataformas == null || juego.plataformaVideojuego in listaPlataformas)
    }
}
fun main(){
    val listaJuegos = mutableListOf(
        Videojuego("Resident Evil", 2000, "PS2"),
        Videojuego("Silent Hill 3", 2006, "PS2"),
        Videojuego("Rule Of Rose", 2006, "PS2"),
        Videojuego("Pokemon Rubí", 2002, "Game Boy"),
        Videojuego("Pokemon Rojo Fuego", 2002, "Game Boy"),
        Videojuego("Evil Within 2", 2017, "PC"),
        Videojuego("Imperium", 2006, "PC"),
        Videojuego("Quake", 1996, "PC"),
    )
    val juegosFiltrados1 = filtrarPorAnioPlataforma(listaJuegos, anio = 2006, plataforma = "PS2")
    println(juegosFiltrados1.toString())
    val juegosFiltrados2 = filtrarPorAnioPlataforma(listaJuegos, anio = 2006)
    println(juegosFiltrados2.toString())
    val juegosFiltrados3 = filtrarPorAnioPlataforma(listaJuegos, plataforma = "PS2")
    println(juegosFiltrados3.toString())


    println("Contar juegos por plataforma")
    val mapaJuegos = contarJuegosPorPlataforma(listaJuegos)
    mapaJuegos.forEach{(plataforma, numeroJuegos) ->
        println("Plataforma: $plataforma, número de juegos: $numeroJuegos")
    }


    val juegosFiltrados = filtrarJuegosPorListas(listaJuegos, listOf(2006, 2002), listaPlataformas = listOf("PS4", "Xbox"))
    println("Juegos filtrados: $juegosFiltrados")

    // Ejemplo de uso solo con lista de años
    val juegosFiltradosAnioos = filtrarJuegosPorListas(listaJuegos, listOf(2021))
    println("Juegos filtrados por año: $juegosFiltradosAnioos")

    // Ejemplo de uso solo con lista de plataformas
    val juegosFiltradosPlataformas = filtrarJuegosPorListas(listaJuegos, listaPlataformas = listOf("PS2", "Game Boy"))
    println("Juegos filtrados por plataforma: $juegosFiltradosPlataformas")
}