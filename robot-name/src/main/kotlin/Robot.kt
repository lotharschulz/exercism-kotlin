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
        var n:String
        do {
            n = generateChar().toString().double() + generateDigits()
        }while(names.contains(n))
        names.add(n)
        return n
    }

    private fun generateDigits():String = (100..999).random().toString()
    private fun generateChar():Char = (65..90).random().toChar()

}