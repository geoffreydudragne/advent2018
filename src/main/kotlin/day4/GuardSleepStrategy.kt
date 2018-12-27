package day4

import java.io.File

fun main(args: Array<String>) {
    val text = File("src/main/resources/day4/input.txt").readText()
    val records = text.split("\n")
    println(records.sorted())
}

class GuardSleepStrategy {

    fun parseGardRecord(records: List<String>): Collection<Guard> {
        val guards = HashMap<String, Guard>()

        var currentGuard = Guard()
        var currentShit = ArrayList<SleepPeriod>()
        var currentFallAsleepTime = 0
        for (record in records) {
            if (record.contains("begins shift")) {
                currentGuard.addShift(Shift(*currentShit.toTypedArray()))
                val guardNumber = getGuardNumberFromRecord(record)
                currentGuard = guards.computeIfAbsent(guardNumber) {Guard()}
                currentShit = ArrayList()
            } else if (record.contains("falls asleep")) {
                currentFallAsleepTime = getMinuteFromTimedRecord(record)
            } else if (record.contains("wakes up")) {
                val wakeUpTime = getMinuteFromTimedRecord(record) - 1
                currentShit.add(SleepPeriod(currentFallAsleepTime, wakeUpTime))
            }
        }
        return guards.values
    }
}

fun getMinuteFromTimedRecord(timedRecord: String) = timedRecord.slice(15..16).toInt()
fun getGuardNumberFromRecord(text: String): String {
    val regex = Regex("Guard #(\\d+) begins shift")
    val result = regex.find(text)
    return result!!.groupValues[1]
}