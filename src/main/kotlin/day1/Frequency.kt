package day1

import java.io.File

fun main(args: Array<String>) {
    val text = File("src/main/resources/day1/input.txt").readText()
    println(computeFrequencyFromText(text))
    println(firstFrequencyAttainedTwice(readInputs(text)))
}

fun computeFrequencyFromText(text: String): Int {
    val inputNumbers = readInputs(text)
    return inputNumbers
        .reduceRight(Int::plus)
}

private fun readInputs(text: String): List<Int> {
    return text.split("\n")
        .map(String::toInt)
}

fun firstFrequencyAttainedTwice(input: List<Int>): Int {
    val frequenciesAttained = HashSet<Int>()

    var current = 0
    while (true)
        for (number in input) {
            current += number
            if (frequenciesAttained.contains(current)) {
                return current
            }
            frequenciesAttained.add(current)
        }
}