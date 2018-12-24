package day4

import java.io.File

fun main(args: Array<String>) {
    val text = File("src/main/resources/day4/input.txt").readText()
    val records = text.split("\n")
    println(records.sorted())
}