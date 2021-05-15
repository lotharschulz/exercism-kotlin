val chromaticScaleSharps = listOf("A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#")
val chromaticScaleFlats  = listOf("A", "Bb", "B", "C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab")

class Scale(private val tonic: String) {

    private val tonicMajor = tonic.first().toUpperCase() + tonic.drop(1)

    private val chromatic: List<String> = when (tonicMajor) {
        in chromaticScaleSharps -> chromaticScaleSharps
        else -> chromaticScaleFlats
    }.run { dropWhile { it.toUpperCase() != tonic.toUpperCase() } + takeWhile { it.toUpperCase() != tonic.toUpperCase() } }

    fun chromatic() = chromatic

    fun interval(intervals: String): List<String> {
        val translatedIntervals = intervals.map { c: Char ->
            when (c) {
                'M' -> 2
                'm' -> 1
                'A' -> 3
                else -> throw IllegalArgumentException("Unknown character [$c]")
            }
        }
        return translatedIntervals.fold(emptyList<String>() to 0) { accumulator, translatedIntervalItem ->
            (accumulator.first + chromatic[accumulator.second]) to accumulator.second + translatedIntervalItem
        }.first
    }
}
