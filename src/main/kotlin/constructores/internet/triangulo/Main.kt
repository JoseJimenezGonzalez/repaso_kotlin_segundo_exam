package constructores.internet.triangulo

//Implementar una clase que cargue los lados de un triángulo e implemente los siguientes métodos: inicializar las
//propiedades, imprimir el valor del lado mayor y otro método que muestre el tipo(equilatero, isosceles y escaleno).
//Plantear el constructor principal que reciba los valores de los lados y un segundo constructor que permita
//por teclado los tres lados.

class Triangulo(var lado1: Double, var lado2: Double, var lado3: Double){

    constructor(): this(0.0, 0.0, 0.0){
        println("Ingrese el lado 1:")
        this.lado1 = readln().toDouble()
        println("Ingrese el lado 2:")
        this.lado2 = readln().toDouble()
        println("Ingrese el lado 3:")
        this.lado3 = readln().toDouble()
    }

    override fun toString(): String {
        return "Lado 1: ${lado1}, lado 2: ${lado2} y lado 3: ${lado3}"
    }

    fun obtenerLadoMayor(): Double{
        var listaLados: List<Double> = mutableListOf(lado1, lado2, lado3)
        var listaLadosOrdenada: List<Double> = listaLados.sortedDescending()
        return listaLadosOrdenada[0]
    }

    fun tipoTriangulo(): String{
        if(lado1 == lado2 && lado1 == lado3){
            return "Equilatero"
        }else if (lado1 == lado2 || lado1 == lado3){
            return "Isósceles"
        }else{
            return "Escaleno"
        }
    }
}

fun main(){
    var triangulo1 = Triangulo(8.0, 8.0, 6.0)
    println("Triangulo 1")
    println(triangulo1.toString())
    println("Es de tipo: ${triangulo1.tipoTriangulo()}")
    println("Lado mayor: ${triangulo1.obtenerLadoMayor()}")
    var triangulo2 = Triangulo()
    println("Triangulo 2")
    println(triangulo2.toString())
    println("Es de tipo: ${triangulo2.tipoTriangulo()}")
    println("Lado mayor: ${triangulo2.obtenerLadoMayor()}")
}