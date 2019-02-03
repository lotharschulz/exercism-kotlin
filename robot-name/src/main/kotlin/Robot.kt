import java.util.Random

// https://stackoverflow.com/a/45687695
fun IntRange.random() = Random().nextInt((endInclusive + 1) - start) +  start
fun String.double() = this + this

class Robot{
    private val names = mutableSetOf<String>()
    var name:String = generateAndAddName()

    private fun generateName():String = generateChar().toString().double() + generateDigits()

    private fun generateAndAddName():String{
        names.add(generateName())
        return names.last()
    }

    private fun generateDigits():String = (100..999).random().toString()
    private fun generateChar():Char = (65..90).random().toChar()

    fun reset(){
        do {
            name = generateName()
        }while(names.contains(name))
    }

}