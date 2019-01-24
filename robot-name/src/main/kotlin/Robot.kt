import java.util.*

// https://stackoverflow.com/a/45687695
fun IntRange.random() = Random().nextInt((endInclusive + 1) - start) +  start
fun String.double() = this + this

class Robot{
    var name:String = generateName()

    fun reset(){
        do {
            val newname = generateName()
            name = newname
        }while(!names.add(newname))
    }

    private val names:MutableSet<String> = mutableSetOf()

    private fun generateName():String = generateChar().toString().double() + (100..999).random().toString()

    private fun generateChar():Char = (65..90).random().toChar()
}