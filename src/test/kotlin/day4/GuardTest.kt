package day4

import org.junit.Assert.*
import org.junit.Test

class GuardTest {

    @Test
    fun guard_with_2_shifts_should_give_minute_spent_most_asleep() {
        val guard = Guard()
        guard.addShift(Shift(SleepPeriod(5, 24), SleepPeriod(30, 54)))
        guard.addShift(Shift(SleepPeriod(24, 28)))

        assertEquals(24, guard.minuteSpentAsleepMost())
    }
}