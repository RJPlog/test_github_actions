// sudo apt-get update && sudo apt-get install kotlin
// kotlinc day2224_1_2.kt -include-runtime -d day2224_1_2.jar && java -jar -Xss515m day2224_1_2.jar

import java.io.File
import kotlin.math.*

fun aocDay2224(): Int {

  var w = -2
  var h = -2
  var x = -1
  var y = -1

  // store each wind in list (westWind, ....)
  var wW = mutableListOf<Pair<Int,Int>>()
  var nW = mutableListOf<Pair<Int,Int>>()
  var eW = mutableListOf<Pair<Int,Int>>()
  var sW = mutableListOf<Pair<Int,Int>>()

  File("day2224_puzzle_input.txt").forEachLine {
    w = it.length
    x = -1
    it.forEach {
      when(it) {
        '<' -> wW.add(Pair(x,y))
        '>' -> eW.add(Pair(x,y))
        'v' -> nW.add(Pair(x,y))
        '^' -> sW.add(Pair(x,y))
      }
      x += 1
    }
    y += 1
  }
  
  // start moving in all posible directions (until first path reached end)
  for (i in 0..5) {// replace by while later
    
  }
  return -1
}

fun main() {

    var t1 = System.currentTimeMillis()

    println("--- Day 24: Blizzard Basin ---")

    var solution1 = aocDay2224()
    println("   the fewest number of minutes required to avoid the blizzards and reach the goal is $solution1")

    t1 = System.currentTimeMillis() - t1
    println("puzzle solved in ${t1} ms")
}  
