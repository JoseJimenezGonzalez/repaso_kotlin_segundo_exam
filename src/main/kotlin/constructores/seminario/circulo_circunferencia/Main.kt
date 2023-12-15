package constructores.seminario.circulo_circunferencia

import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.sqrt

//Crea la clase circunferencia. El constructor primario recibirá el
//radio de la circunferencia y el secundario recibirá la posición del centro de la
//circunferencia y un punto cualquiera de la misma. Crear el método longitud()
//y sobrecargar el método toString() de forma que muestre toda la info de la
//circunferencia

//Crea la clase Círculo que hereda de circunferencia. Tendrá dos
//constructores, el primero recibirá el radio y el color del círculo y el segundo
//su centro, un punto cualquiera y su color. Crear el método área() y
//sobrecargar el método toString() de forma que muestre toda la info de la
//circunferencia

data class Punto(var coordenadaX: Double, var coordenadaY: Double)

class Circulo(radio: Double, var color: String): Circunferencia(radio){
    constructor(puntoCentro: Punto, puntoCualquiera: Punto, color: String): this(0.0, ""){
        this.puntoCentro = puntoCentro
        this.puntoCualquiera = puntoCualquiera
        this.color = color
        this.radio = super.calcularRadio()
    }

    fun calcularArea(): Double{
        return PI * radio.pow(2.0)
    }

    override fun toString(): String {
        return "${super.toString()} y color: ${color}"
    }
}

open class Circunferencia(var radio: Double){
    //parametros del constructor secundario
    var puntoCentro: Punto = Punto(0.0, 0.0)
    var puntoCualquiera: Punto = Punto(0.0, 0.0)
    constructor(puntoCentro: Punto, puntoCualquiera: Punto): this(0.0){
        this.puntoCentro = puntoCentro
        this.puntoCualquiera = puntoCualquiera
        this.radio = calcularRadio()
    }
    //r = sqrt((Px - Cx)pow2 + (Py - Cy)pow2)
    open fun calcularRadio(): Double {
        return sqrt((puntoCualquiera.coordenadaX - puntoCentro.coordenadaX).pow(2.0) + (puntoCualquiera.coordenadaY - puntoCentro.coordenadaY).pow(2.0))
    }
    fun calcularLongitud(): Double{
        return 2 * PI * radio
    }

    override fun toString(): String {
        return "Radio: ${radio}, punto centro: (${puntoCentro.coordenadaX}, ${puntoCentro.coordenadaY}) y punto cualquiera: (${puntoCualquiera.coordenadaX}, ${puntoCualquiera.coordenadaY}))"
    }
}

fun main(){
    println("Primera circunferencia")
    var circunferencia1 = Circunferencia(5.0)
    println("Longitud del arco: ${circunferencia1.calcularLongitud()}")
    println(circunferencia1.toString())
    println("Segunda circunferencia")
    var puntoCentro = Punto(1.0, 1.0)
    var puntoCualquiera = Punto(1.0, 2.0)
    var circunferencia2 = Circunferencia(puntoCentro, puntoCualquiera)
    println("Longitud del arco: ${circunferencia2.calcularLongitud()}")
    println(circunferencia2.toString())

    println("Primer circulo")
    var circulo1 = Circulo(5.0, "Rojo")
    println("Longitud del arco: ${circulo1.calcularLongitud()}")
    println("Área: ${circulo1.calcularArea()}")
    println(circulo1.toString())
    println("Segundo circulo")
    var puntoCentroCirculo = Punto(1.0, 1.0)
    var puntoCualquieraCirculo = Punto(1.0, 2.0)
    var circulo2 = Circulo(puntoCentroCirculo, puntoCualquieraCirculo, "Morado")
    println("Longitud del arco: ${circulo2.calcularLongitud()}")
    println(circulo2.toString())
}