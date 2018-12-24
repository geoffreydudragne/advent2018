package day4

import java.util.*

class Shift(vararg val sleepPeriods: SleepPeriod) {
    fun sleptAtMinute(minute: Int): Boolean {
        return sleepPeriods.map { sleepPeriod -> sleepPeriod.begin <= minute && minute <= sleepPeriod.end }
            .reduce { a, b -> a || b }
    }

    fun totalSleepTime(): Int = sleepPeriods
        .map { sleepPeriod -> sleepPeriod.end - sleepPeriod.begin + 1 }
        .sum()



    override fun toString(): String {
        return "Shift(sleepPeriods=${Arrays.toString(sleepPeriods)})"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Shift

        if (!sleepPeriods.contentEquals(other.sleepPeriods)) return false

        return true
    }

    override fun hashCode(): Int {
        return sleepPeriods.contentHashCode()
    }
}
