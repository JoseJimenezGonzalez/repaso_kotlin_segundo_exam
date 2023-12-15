package companion_object.ejercicio_clase_matematicas

//Clase de matemáticas. Crea una clase Matemáticas con métodos para realizar
//operaciones matemáticas como sumar, restar, multiplicar y dividir. Luego, utiliza esta clase en tu
//programa principal.

class Matematicas{
    //Un companion object es un objeto que está vinculado a una clase específica y se utiliza para agrupar funciones y
    //propiedades que están relacionadas con la clase, pero que no dependen de instancias específicas de la misma.
    companion object{
        fun sumar(numero1: Double, numero2: Double): Double = numero1 + numero2

        fun restar(numero1: Double, numero2: Double): Double = numero1 - numero2

        fun multiplicar(numero1: Double, numero2: Double): Double = numero1 * numero2

        fun dividir(numero1: Double, numero2: Double): Double{
            if(numero2 == 0.0){
                throw IllegalArgumentException("No se puede dividir por cero")
            }
            return numero1 / numero2
        }
    }
}

fun main(){
    val resultadoSuma = Matematicas.sumar(5.0, 3.0)
    val resultadoResta = Matematicas.restar(5.0, 3.0)
    val resultadoMultiplicacion = Matematicas.multiplicar(5.0, 3.0)
    val resultadoDivision = Matematicas.dividir(5.0, 3.0)

    println("Suma: $resultadoSuma")
    println("Resta: $resultadoResta")
    println("Multiplicación: $resultadoMultiplicacion")
    println("División: $resultadoDivision")
}