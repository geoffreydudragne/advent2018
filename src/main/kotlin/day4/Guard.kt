package day4

class Guard {
    private val shifts = ArrayList<Shift>()

    fun addShift(shift: Shift) {
        shifts.add(shift)
    }

    private class MinuteCount(val minute: Int, val count: Int)

    fun minuteSpentAsleepMost(): Int {
        val histogram = ArrayList<MinuteCount>()
        for (minute in 0..59) {
            val countsForMinute = shifts.filter { it.sleptAtMinute(minute) }.count()
            histogram.add(MinuteCount(minute, countsForMinute))
        }
        val minuteWithMaxCounts = histogram.maxBy(MinuteCount::count)
        return minuteWithMaxCounts!!.minute
    }

    fun totalMinutesSpentAsleep(): Int = shifts.sumBy(Shift::totalSleepTime)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Guard

        if (shifts != other.shifts) return false

        return true
    }

    override fun hashCode(): Int {
        return shifts.hashCode()
    }

    override fun toString(): String {
        return "Guard(shifts=$shifts)"
    }
}