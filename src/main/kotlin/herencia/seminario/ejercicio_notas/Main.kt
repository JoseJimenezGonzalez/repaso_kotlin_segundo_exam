package herencia.seminario.ejercicio_notas

//clase Nota. Una nota contiene un identificador numérico y una línea de texto. Define constructor,
//accedentes y toString.
//clase NotaAlarma. Una nota que además contiene la hora en la que sonará la alarma. Define
//constructor, accedentes y toString.
//clase BlocNotas que modela un bloc de notas en el que se pueden introducir notas, listar todas las
//notas, eliminar una nota mediante su posición en el bloc de notas o saber cuantas notas contiene el
//bloc de notas. Debes utilizar una colección.
//clase Prueba que cree un bloc de Notas de ejemplo y pruebe las operaciones que soporta.

open class Nota(var id: Int, var lineaTexto: String){
    override fun toString(): String {
        return "-------\nObjeto tipo nota, con id: $id y linea de texto: $lineaTexto\n"
    }
}

class NotaAlarma(id: Int, lineaTexto: String, var horaAlarma: String): Nota(id, lineaTexto){
    override fun toString(): String {
        return "----------\nObjeto tipo nota alarma, con id: $id, linea de texto: $lineaTexto y la hora es: $horaAlarma\n"
    }
}

class BlocNotas(val listaNotas: MutableList<Nota>){
    fun agregarNota(nota: Nota){
        listaNotas.add(nota)
    }
    fun listarNotas(): String{
        if(listaNotas.isEmpty()){
            return "No hay notas que mostrar"
        }else{
            var respuesta = ""
            listaNotas.forEach{ nota ->
                respuesta += nota.toString()
            }
            return respuesta
        }
    }
    fun eliminarNotaSegunPosicion(posicion: Int){
        if(posicion < listaNotas.size){
            //Remueve por posicicion
            listaNotas.removeAt(posicion)
        }
    }
    fun numeroNotas(): Int = listaNotas.size
}

class BlocNotasAlarma(val listaNotas: MutableList<NotaAlarma>){
    fun agregarNota(nota: NotaAlarma){
        listaNotas.add(nota)
    }
    fun listarNotas(): String{
        if(listaNotas.isEmpty()){
            return "No hay notas de alarma que mostrar"
        }else{
            var respuesta = ""
            listaNotas.forEach{ nota ->
                respuesta += nota.toString()
            }
            return respuesta
        }
    }
    fun eliminarNotaSegunPosicion(posicion: Int){
        if(posicion < listaNotas.size){
            //Remueve por posicicion
            listaNotas.removeAt(posicion)
        }
    }
    fun numeroNotas(): Int = listaNotas.size
}



fun main(){
    var nota1 = Nota(1, "Esta es la primera nota")
    var nota2 = Nota(2, "Esta es la segunda nota")
    var nota3 = Nota(3, "Esta es la tercera nota")
    var listaMutableDeNotas = mutableListOf(nota1, nota2, nota3)
    var blocNotas = BlocNotas(listaMutableDeNotas)
    println(blocNotas.listaNotas)
    blocNotas.eliminarNotaSegunPosicion(0)
    println(blocNotas.listaNotas)
    var nota4 = Nota(4, "Esta es la cuarta nota")
    blocNotas.agregarNota(nota4)
    println(blocNotas.numeroNotas())
    println(blocNotas.listaNotas)

    var notaAlarma1 = NotaAlarma(5, "Esta es la primera nota de alarma", "20:00")
    println(notaAlarma1.toString())
    blocNotas.agregarNota(notaAlarma1) //Me deja y está ok
    //Me deja porque esa mutable list admite objetos de tipo nota y subtipos de esta
    println(blocNotas.listarNotas())


    var notaAlarma2 = NotaAlarma(5, "Esta es la segunda nota de alarma", "22:00")
    var notaAlarma3 = NotaAlarma(5, "Esta es la tercera nota de alarma", "24:00")
    var listaNotasAlarma = mutableListOf(notaAlarma1, notaAlarma2, notaAlarma3)
    var blocNotasAlarma = BlocNotasAlarma(listaNotasAlarma)
    println(blocNotasAlarma.listarNotas())
    //blocNotasAlarma.agregarNota(nota1) -> No me deja
    //No deja ya que bloc nota alarma tiene una mutable list de nota alarma y nota no es subtipo de nota alarma,
    //es clase padre y no se permite
}