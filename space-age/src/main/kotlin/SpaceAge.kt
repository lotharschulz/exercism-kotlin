import java.math.BigDecimal

class SpaceAge(sec: Long) {

    private val earthYearInSeconds:Double = 31557600.0

    private val earthYear:Double = sec.div(earthYearInSeconds)

    private fun convertedYears(earthYears: Double):Double =
            roundTo2DecimalPlaces(earthYear.div(earthYears), 2)

    private fun roundTo2DecimalPlaces(input: Double, scale: Int): Double =
            BigDecimal(input).setScale(scale, BigDecimal.ROUND_HALF_UP).toDouble()

    fun onEarth(): Double = roundTo2DecimalPlaces(earthYear, 2)
    fun onMercury(): Double = convertedYears(0.2408467)
    fun onVenus(): Double = convertedYears(0.6152)
    fun onMars(): Double = convertedYears(1.8809)
    fun onJupiter(): Double = convertedYears(11.8618)
    fun onSaturn(): Double = convertedYears(29.447498)
    fun onUranus(): Double = convertedYears(84.0)
    fun onNeptune(): Double = convertedYears(164.8)


}