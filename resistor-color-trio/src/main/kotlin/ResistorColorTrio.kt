import kotlin.math.log
import kotlin.math.log10
import kotlin.math.pow

object ResistorColorTrio {

    private val colors: Map<Color, Int> = mapOf(
            Color.BLACK to 0,
            Color.BROWN to 1,
            Color.RED to 2,
            Color.ORANGE to 3,
            Color.YELLOW to 4,
            Color.GREEN to 5,
            Color.BLUE to 6,
            Color.VIOLET to 7,
            Color.GREY to 8,
            Color.WHITE to 9
    ).withDefault {
        10
    }

    private val decimals: Map<Int, String> = mapOf(
            1 to " ",
            10 to "0 ",
            100 to " kilo",
            1000 to " kilo",
            10000 to " kilo",
            10000000 to " mega"
    ).withDefault {
        "error"
    }

    private fun secondPosition(i: Color): String{
        if (colors[i] == 0) return ""
        else if (colors[i] == 7) return "70"
        else return colors[i].toString()
    }

    private fun magnitude(input: Color): String? =
            decimals[10.toDouble().pow( colors[input] ?: error(-1)).toInt()]

    fun text(vararg input: Color): String =
            input[0].ordinal.toString() + secondPosition(input[1]) + magnitude(input[2]) + "ohms"

    fun text2(vararg input: Color): String =
            colors[input[0]].toString() + secondPosition(input[1]) + magnitude(input[2]) + "ohms"

    private fun resistorValue(vararg input: Color): Int {
        val (c1, c2, c3) = input
        var value = 10 * c1.ordinal + c2.ordinal
        repeat(times = c3.ordinal) { value *= 10 }
        return value
    }

    fun text3(vararg input: Color): String {
        val value = resistorValue(*input)
        //var magnitude = 0
        val mag3 = log(value.toDouble(), 1000.toDouble()).toInt()
        val newvalue = (value / 1000.toDouble().pow(mag3.toDouble())).toInt()
/*
        println("value: $value - newvalue: $newvalue - magnitude: $magnitude -- mag3: $mag3")
        while (value % 1000 == 0) {
            println("value: $value")
            value /= 1000
            magnitude++
        }
        println("value: $value - newvalue: $newvalue - magnitude: $magnitude -- mag3: $mag3")
*/

        val unit = Unit.values()[mag3].name.toLowerCase()
        return "$newvalue $unit"
    }
}
