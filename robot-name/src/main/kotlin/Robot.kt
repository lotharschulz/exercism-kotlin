import java.util.*

// https://stackoverflow.com/a/45687695
fun IntRange.random() = Random().nextInt((endInclusive + 1) - start) +  start
fun String.double() = this + this

class Robot{
    private val names = mutableSetOf<String>()
    var name:String = generateName()

    fun reset(){
        name = generateName()
    }

    fun generateName():String{
        var n = genName()
        while (!names.add(n)) n = genName()
        return n
    }

    private fun genName():String = generateChar().toString().double() + generateDigits()

    private fun generateDigits():String = (100..999).random().toString()
    private fun generateChar():Char = (65..90).random().toChar()

}