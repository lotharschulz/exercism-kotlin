import kotlin.math.pow

object ResistorColorTrio {

    val colors: Map<Color, Int> = mapOf(
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

    val decimals: Map<Int, String> = mapOf(
            1 to " ",
            10 to "0 ",
            100 to " kilo",
            1000 to " kilo",
            10000 to " kilo",
            10000000 to " mega"
    ).withDefault {
        "error"
    }

    fun secondPosition(i: Color): String{
        if (colors[i] == 0) return ""
        else if (colors[i] == 7) return "70"
        else return colors[i].toString()
    }

    fun decimalMultiple(input: Color): String? =
            decimals[10.toDouble().pow( colors[input] ?: error(-1)).toInt()]

    fun text(vararg input: Color): String =
            input[0].ordinal.toString() + secondPosition(input[1]) + decimalMultiple(input[2]) + "ohms"

    fun text2(vararg input: Color): String =
            colors[input[0]].toString() + secondPosition(input[1]) + decimalMultiple(input[2]) + "ohms"
}
