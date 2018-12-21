package day2

import java.io.File

fun main(args: Array<String>) {
    val text = File("src/main/resources/day2/input.txt").readText()
    val ids = text.split("\n")
    println(computeChecksum(ids))
    println(findCommonPartOfCorrectIds(ids))
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

fun commonPartOfWords(id1: String, id2: String): String {
    var common = ""
    id1.forEachIndexed { index, char ->
        if (id2[index] == char) common += char
    }
    return common
}

fun findCommonPartOfCorrectIds(ids: List<String>): String {
    for (id1 in ids) {
        for (id2 in ids) {
            val commonPartOfIds = commonPartOfWords(id1, id2)
            if (id1.length - commonPartOfIds.length == 1) return commonPartOfIds
        }
    }
    throw RuntimeException("No correct result found")
}