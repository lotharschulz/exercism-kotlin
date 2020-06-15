object ResistorColorDuo {

    val colormap: Map<Color, Int> = mapOf(
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

    fun value(vararg colors: Color): Int =
        colors.take(2)
            .map { colormap.getValue(it) }
            .joinToString("")
            .toInt()

    fun value2(vararg colors: Color): Int {
        return colors[0].ordinal *10 + colors[1].ordinal
    }
}
