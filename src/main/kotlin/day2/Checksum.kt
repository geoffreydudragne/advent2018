package day2

import java.io.File

fun main(args: Array<String>) {
    val text = File("src/main/resources/day2/input.txt").readText()
    val ids = text.split("\n")
    println(computeChecksum(ids))
}

fun containsLetterTwice(id: String): Boolean {
    return id.groupingBy({ c -> c })
        .eachCount()
        .containsValue(2)
}

fun containsLetterThrice(id: String): Boolean {
    return id.groupingBy({ c -> c })
        .eachCount()
        .containsValue(3)
}

fun computeChecksum(ids: List<String>): Int {
    val with2Letters = ids.filter { id -> containsLetterTwice(id) }.count()
    val with3Letters = ids.filter { id -> containsLetterThrice(id) }.count()
    return with2Letters * with3Letters
}