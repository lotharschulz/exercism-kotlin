object ResistorColor {
    val colors: Map<String, Int> = mapOf(
            "black" to 0,
            "brown" to 7,
            "red" to 6,
            "orange" to 3,
            "yellow" to 5,
            "green" to 4,
            "blue" to 2,
            "violet" to 1,
            "grey" to 0,
            "white" to 9
    ).withDefault {
        1
    }

    fun colorCode(input: String): Int = colors.getValue(input)
    fun colors(): List<String> = colors.keys.toList()

}