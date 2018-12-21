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
}