package day4

import org.assertj.core.api.Assertions
import org.junit.Test

class GuardSleepStrategyTest {

    @Test
    fun parseGardRecord() {
        val guardSleepStrategy = GuardSleepStrategy()
        val records = listOf(
            "[1518-11-01 00:00] Guard #10 begins shift",
            "[1518-11-01 00:05] falls asleep",
            "[1518-11-01 00:25] wakes up",
            "[1518-11-01 00:30] falls asleep",
            "[1518-11-01 00:55] wakes up",
            "[1518-11-01 23:58] Guard #99 begins shift",
            "[1518-11-02 00:40] falls asleep",
            "[1518-11-02 00:50] wakes up"
        )

        val guard10 = Guard()
        guard10.addShift(Shift(SleepPeriod(5,24), SleepPeriod(30,54)))
        val guard99 = Guard()
        guard99.addShift(Shift(SleepPeriod(40, 49)))

        Assertions.assertThat(guardSleepStrategy.parseGardRecord(records))
            .containsExactly(guard10, guard99)
    }

    @Test
    fun test_regexps() {
        val text = "Guard #10 begins shift"
        val regex = Regex("Guard #(\\d+) begins shift")
        val result = regex.find(text)
        result?.
    }
}