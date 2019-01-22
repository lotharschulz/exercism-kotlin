import java.util.Random

// https://stackoverflow.com/a/45687695
fun IntRange.random() =
        Random().nextInt((endInclusive + 1) - start) +  start

fun CharRange.random():Int 
        = Random().nextInt((endInclusive + 1) - start) + start.toInt()

class Robot{
    var name:String = ('A'..'Z').random().toChar().toString() + ('A'..'Z').random().toChar().toString() + (100..999).random().toString()
    fun reset(){
        name = "123"
    } 
}