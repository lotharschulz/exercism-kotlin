class Clock(private val hours: Int = 0, private val minutes: Int = 0) {
    private var h: Int = 0
    private var m: Int = 0

    init {
        normalize(hours, minutes)
    }

    private fun normalize(hours: Int, minutes: Int) {
        this.h = ((hours + minutes / 60) % 24)
            .let { if (minutes % 60 < 0) it - 1 else it }
            .let { if (it < 0) it + 24 else it }
        this.m = (minutes % 60)
            .let { if (it < 0) it + 60 else it }
    }

    @Override
    override fun equals(other: Any?): Boolean = other is Clock && h == other.h && m == other.m

    private fun Int.padZeroChars() = toString().padStart(length = 2, padChar = '0')

    override fun toString() = "${h.padZeroChars()}:${m.padZeroChars()}"

    fun subtract(minutes: Int) {
        m -= minutes
        normalize(h, m)
    }

    fun add(minutes: Int) {
        m += minutes
        normalize(h, m)
    }
}
