package day2

import org.junit.Assert.*
import org.junit.Test

class ChecksumKtTest {

    @Test
    fun it_should_detect_when_id_contains_letter_twice() {
        assertFalse(containsLetterTwice("abcdef"))
        assertTrue(containsLetterTwice("abbcde"))
    }

    @Test
    fun it_should_detect_when_id_contains_letter_thrice() {
        assertFalse(containsLetterThrice("abcdef"))
        assertFalse(containsLetterThrice("abbcde"))
        assertTrue(containsLetterThrice("abcccd"))
    }

    @Test
    fun it_should_compute_the_hash() {
        val inputs = listOf(
            "abcdef",
            "bababc",
            "abbcde",
            "abcccd",
            "aabcdd",
            "abcdee",
            "ababab"
        )
        val checksum = computeChecksum(inputs)
        assertEquals(12, checksum)
    }
}