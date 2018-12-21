package day1

import org.junit.Assert.assertEquals
import org.junit.Test

class FrequencyTest {
    @Test
    fun it_should_run () {
        println("hello world")
        val text = "+1\n" +
                "-2\n" +
                "3\n" +
                "1"
        val result = computeFrequencyFromText(text)
        assertEquals(3, result)
    }

    @Test
    fun it_should_find_first_frequency_attained_twice() {
        val input = listOf(3, 3, 4, -2, -4)
        val result = firstFrequencyAttainedTwice(input)
        assertEquals(10, result)
    }
}
