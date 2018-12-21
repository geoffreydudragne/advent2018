package day1

import java.io.File

fun main(args: Array<String>) {
    val text = File("src/main/resources/day1/input.txt").readText()
    println(computeFrequencyFromText(text))
}

fun computeFrequencyFromText(text: String): Int {
    return text.split("\n")
        .map(String::toInt)
        .reduceRight(Int::plus);
}
