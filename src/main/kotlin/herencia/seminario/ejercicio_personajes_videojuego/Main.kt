package herencia.seminario.ejercicio_personajes_videojuego

//Crea la clase PNJ que representa un personaje en un juego de rol.
//La clase tendrá los atributos, nombre, PV –Puntos de Vida-, PM
//–Puntos mágicos- y LVL. Crea las clases hijas de PNJ Guerrero y
//Mago. Dichas clases implementarán el método levelUp() que
//incrementa el atributo LVL del personaje y sus atributos PV y MP.
//Los guerreros por cada nuevo nivel tendrán un 8% más de PV y un
//1% más de PM mientras que los magos tendrán un 4% más de PV y
//un 3% más de PM. Crear un guerrero de nivel 1 con 400PV y 50PM y
//un mago de nivel 1 con 1600PV y 150PM. Partiendo del hecho de
//que ambos personajes subirán de nivel siempre a la vez ¿en qué
//nivel el guerrero tendrá más PV que el mago?

open class PNJ(var nombre: String, var pv: Double, var pm: Double, var lvl: Int){
    open fun levelUp(){
        lvl++
    }
}
class Guerrero(nombre: String, pv: Double, pm: Double, lvl: Int):PNJ(nombre, pv, pm, lvl){
    override fun levelUp() {
        //Queremos que suba de nivel y que haga mas cosas aparte
        super.levelUp()
        pv *= 1.08
        pm *= 1.01
    }

    override fun toString(): String {
        return  "Guerrero\nNombre: $nombre, puntos de vida: $pv, puntos mágicos: $pm y nivel: $lvl"
    }
}

class Mago(nombre: String, pv: Double, pm: Double, lvl: Int):PNJ(nombre, pv, pm, lvl){
    override fun levelUp() {
        //Queremos que suba de nivel y que haga mas cosas aparte
        super.levelUp()
        pv *= 1.04
        pm *= 1.03
    }
    override fun toString(): String {
        return  "Mago\nNombre: $nombre, puntos de vida: $pv, puntos mágicos: $pm y nivel: $lvl"
    }
}
fun main(){
    var guerrero = Guerrero("Guerrero samurai", 400.0, 50.0, 1)
    var mago = Mago("Gandalf el Gris", 1600.0, 150.0, 1)
    //Partiendo del hecho de que ambos personajes subirán de nivel siempre a la vez
    //¿en qué nivel el guerrero tendrá más PV que el mago?
    var respuesta = 0
    while (true){
        if(guerrero.pv > mago.pv){
            respuesta = guerrero.lvl
            break
        }else{
            guerrero.levelUp()
            mago.levelUp()
        }
    }
    println("El guerrero tendrá mas puntos de vida que el mago en el nivel $respuesta")
}
