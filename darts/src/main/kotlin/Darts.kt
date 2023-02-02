import kotlin.math.abs
import kotlin.math.hypot

object Darts {

    fun score(x: Number, y: Number): Int {
        val deviation = hypot(abs(x.toDouble()), abs(y.toDouble()))
        return when {
            deviation <= 1 -> 10
            deviation <= 5 -> 5
            deviation <= 10 -> 1
            else -> 0
        }
    }
}
