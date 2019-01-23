import java.util.*

// https://stackoverflow.com/a/45687695
fun IntRange.random() = Random().nextInt((endInclusive + 1) - start) +  start

fun String.double() = this + this

class Robot{
    var name:String = generateName()
    private var names:Set<String> = mutableSetOf()
    fun reset(){
        val newname:String = generateName()
        if (!names.contains(newname)){
            name = newname
            names.plus(name)
        }else{
            reset()
        }
    }
    private fun generateName():String = generateChar().toString().double() + (100..999).random().toString()
    private fun generateChar():Char = (65..90).random().toChar()
}