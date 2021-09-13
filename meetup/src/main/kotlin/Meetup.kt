import java.time.DayOfWeek
import java.time.LocalDate

class Meetup(private val month: Int, private val year: Int) {
    private val monthDays = generateSequence(LocalDate.of(year, month, 1)) { localDate ->
        localDate.plusDays(1).takeIf { it.month.value == month }
    }

    fun day(dayOfWeek: DayOfWeek, schedule: MeetupSchedule): LocalDate = LocalDate.of(year, month,
        monthDays
            .filter { it.dayOfWeek == dayOfWeek }
            .let { days ->
                when(schedule){
                    MeetupSchedule.LAST -> days.last()
                    MeetupSchedule.TEENTH -> days.first { day ->
                        val teenthDayOfMonth = 13..19
                        day.dayOfMonth in teenthDayOfMonth
                    }
                    else -> days.drop(schedule.ordinal).first() // in MeetupSchedule.FIRST..MeetupSchedule.FOURTH
                }
            }.dayOfMonth
    )
}
