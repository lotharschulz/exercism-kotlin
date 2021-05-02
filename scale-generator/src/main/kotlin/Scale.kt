val chromaticScaleSharps = listOf("A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#")
val chromaticScaleFlats  = listOf("A", "Bb", "B", "C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab")

class Scale(private val tonic: String) {

    private val tonicMajor = tonic.first().toUpperCase() + tonic.drop(1)

    fun chromatic(): List<String> = when (tonicMajor) {
        in chromaticScaleSharps -> chromaticScaleSharps
        else -> chromaticScaleFlats
    }.run { dropWhile { it.toUpperCase() != tonic.toUpperCase() } + takeWhile { it.toUpperCase() != tonic.toUpperCase() } }


    fun interval(intervals: String): List<String> {
        TODO("Implement this function to complete the task")
    }

}
