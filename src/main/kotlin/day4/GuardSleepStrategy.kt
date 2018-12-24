package day4

import java.io.File

fun main(args: Array<String>) {
    val text = File("src/main/resources/day4/input.txt").readText()
    val records = text.split("\n")
    println(records.sorted())
}

class GuardSleepStrategy {

    fun parseGardRecord(records: List<String>): Collection<Guard> {
        val guards = HashMap<Int, Guard>()

        var currentGuard = Guard()
        var currentShift = Shift()
        var currentBegin = 0
        var currentEnd = 0
        for (record in records) {
            if (record.contains("begins shift")) {
                currentGuard = Guard()
            }
        }
        return guards.values
    }
}