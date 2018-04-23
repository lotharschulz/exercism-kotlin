
import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond(initDate: LocalDateTime) {
    constructor(initDate: LocalDate) : this(initDate.atTime(0, 0))
    val date:LocalDateTime = initDate.plusSeconds(1000000000)
}