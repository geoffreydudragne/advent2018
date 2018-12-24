package day4

import org.junit.Test

import org.junit.Assert.*

class ShiftTest {

    @Test
    fun sleptAtMinute() {
        val shift = Shift(SleepPeriod(5, 10), SleepPeriod(15, 20))
        assertFalse(shift.sleptAtMinute(0))
        assertFalse(shift.sleptAtMinute(4))
        assertTrue(shift.sleptAtMinute(5))
        assertTrue(shift.sleptAtMinute(10))
        assertFalse(shift.sleptAtMinute(11))

        assertFalse(shift.sleptAtMinute(14))
        assertTrue(shift.sleptAtMinute(15))
        assertTrue(shift.sleptAtMinute(20))
        assertFalse(shift.sleptAtMinute(21))
    }
}