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
}