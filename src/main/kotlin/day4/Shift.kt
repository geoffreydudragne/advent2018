package day4

class Shift(vararg val sleepPeriods: SleepPeriod) {
    fun sleptAtMinute(minute: Int): Boolean {
        return sleepPeriods.map { sleepPeriod -> sleepPeriod.begin <= minute && minute <= sleepPeriod.end }
            .reduce { a, b -> a || b }
    }

}
