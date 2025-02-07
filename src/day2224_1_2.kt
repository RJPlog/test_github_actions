// sudo apt-get update && sudo apt-get install kotlin
// kotlinc day2224_1_2.kt -include-runtime -d day2224_1_2.jar && java -jar -Xss515m day2224_1_2.jar

import java.io.File
import kotlin.math.*

fun aocDay2224(): Int {

  var w = 0
  var h = 0
  var x = -1
  var y = -1

  // store each wind in list (westWind, ....)
  var wW = mutableListOf<Pair<Int,Int>>()
  var nW = mutableListOf<Pair<Int,Int>>()
  var eW = mutableListOf<Pair<Int,Int>>()
  var sW = mutableListOf<Pair<Int,Int>>()

  File("day2224_puzzle_input.txt").forEachLine {
    w = it.length -2
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
  h = y

  var xS = Pair(0,-1)
  var xE = Pair(w-1,h-1)
  var allPath = mutableListOf<MutableList<Pair<Int,Int>>>()

  var startPath = mutableListOf(xS)
  allPath.add(startPath)
  
  // start moving in all posible directions (until first path reached end)
  for (t in 1..6) {// replace by while later
    var allPathNew = mutableListOf<MutableList<Pair<Int,Int>>>()
    allPath.forEach{
      var currPath = it
      var currX = currPath.last().first
      var currY = currPath.last().second
      
      // here is a problem: -t leads to coordinates outside rectangle -> for minus create a t* which you can add!


      // check up
      if (currY-1 >= 0 ) {
        if (!(wW.contains(Pair((currX + t)%w, currY-1)) || eW.contains(Pair((currX - t)%w, currY-1)) || nW.contains(Pair(currX, (currY-1- t) % h)) || sW.contains(Pair(currX, (currY-1 + t) % h)))) {
          var upPath = mutableListOf<Pair<Int,Int>>()
          upPath.addAll(currPath)
          upPath.add(Pair(currX, currY - 1))
        }
      }

      // check right
      if (currX+1 < w ) {

      }
      // check down
      if (currY+1 < h ) {
        if (!(wW.contains(Pair((currX + t)%w, currY+1)) || eW.contains(Pair((currX - t)%w, currY+1)) || nW.contains(Pair(currX, (currY+1- t) % h)) || sW.contains(Pair(currX, (currY+1 + t) % h)))) {
          var downPath = mutableListOf<Pair<Int,Int>>()
          downPath.addAll(currPath)
          downPath.add(Pair(currX, currY + 1))
          allPathNew.add(downPath)
        }
      }

      // check left
      if (currX-1 >= 0 ) {

      }

      // check wait
        if (!(wW.contains(Pair((currX + t)%w, currY)) || eW.contains(Pair((currX - t)%w, currY)) || nW.contains(Pair(currX, (currY- t) % h)) || nW.contains(Pair(currX, (currY + t) % h)))) {
          var downPath = mutableListOf<Pair<Int,Int>>()
          downPath.addAll(currPath)
          downPath.add(Pair(currX, currY))
          allPathNew.add(downPath)
        }

      
    }
    allPath.clear()
    allPath.addAll(allPathNew)
    println(allPath)
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
