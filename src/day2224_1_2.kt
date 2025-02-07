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
        'v' -> sW.add(Pair(x,y))
        '^' -> nW.add(Pair(x,y))
      }
      x += 1
    }
    y += 1
  }
  h = y

  println("w: $w, h: $h")
  var xS = Pair(0,-1)
  var xE = Pair(w-1,h-2)
  var allPath = mutableListOf<MutableList<Pair<Int,Int>>>()

  var startPath = mutableListOf(xS)
  allPath.add(startPath)
  
  // start moving in all posible directions (until first path reached end)
  for (t in 1..7) {// replace by while later
    var allPathNew = mutableListOf<MutableList<Pair<Int,Int>>>()
    allPath.forEach{
      var currPath = it
      var currX = currPath.last().first
      var currY = currPath.last().second
      
      var nextX = 0
      var nextY = 0
      var wX = 0
      var wY = 0
      // here is a problem: -t leads to coordinates outside rectangle -> for minus create a t* which you can add!


      // check up
      nextX = currX
      nextY = currY - 1
      if (nextX >= 0 && nextX < w && nextY  >= 0 && nextY < h) {
        wX = (nextX + t) % w
        wY = nextY 
        if (!wW.contains(Pair(wX, wY))) {
          wX = (nextX - t) % w
          if (wX< 0) wX = w + wX
          wY = nextY
          if (!eW.contains(Pair(wX, wY))) {
            wX = nextX
            wY = (nextY - t) % w
            if (wY < 0) wY = h + wY
            if (!nW.contains(Pair(wX, wY))) {
              wX = nextX
              wY = (nextY + t) % w
              if (!sW.contains(Pair(wX, wY))) {
          var downPath = mutableListOf<Pair<Int,Int>>()
          downPath.addAll(currPath)
          downPath.add(Pair(nextX, nextY))
          allPathNew.add(downPath)
              }
            }
          }
        }
      }

      // check right
      nextX = currX + 1
      nextY = currY 
      if (nextX >= 0 && nextX < w && nextY  >= 0 && nextY < h) {
        wX = (nextX + t) % w
        wY = nextY 
        if (!wW.contains(Pair(wX, wY))) {
          wX = (nextX - t) % w
          if (wX< 0) wX = w + wX
          wY = nextY
          if (!eW.contains(Pair(wX, wY))) {
            wX = nextX
            wY = (nextY - t) % w
            if (wY < 0) wY = h + wY
            if (!nW.contains(Pair(wX, wY))) {
              wX = nextX
              wY = (nextY + t) % w
              if (!sW.contains(Pair(wX, wY))) {
          var downPath = mutableListOf<Pair<Int,Int>>()
          downPath.addAll(currPath)
          downPath.add(Pair(nextX, nextY))
          allPathNew.add(downPath)
              }
            }
          }
        }
      }
      // check down
      nextX = currX
      nextY = currY + 1
      if (nextX >= 0 && nextX < w && nextY  >= 0 && nextY < h) {
        wX = (nextX + t) % w
        wY = nextY 
        if (!wW.contains(Pair(wX, wY))) {
          wX = (nextX - t) % w
          if (wX< 0) wX = w + wX
          wY = nextY
          if (!eW.contains(Pair(wX, wY))) {
            wX = nextX
            wY = (nextY - t) % w
            if (wY < 0) wY = h + wY
            if (!nW.contains(Pair(wX, wY))) {
              wX = nextX
              wY = (nextY + t) % w
              if (!sW.contains(Pair(wX, wY))) {
          var downPath = mutableListOf<Pair<Int,Int>>()
          downPath.addAll(currPath)
          downPath.add(Pair(nextX, nextY))
          allPathNew.add(downPath)
              }
            }
          }
        }
      }

      // check left
      nextX = currX - 1
      nextY = currY
      if (nextX >= 0 && nextX < w && nextY  >= 0 && nextY < h) {
        wX = (nextX + t) % w
        wY = nextY 
        if (!wW.contains(Pair(wX, wY))) {
          wX = (nextX - t) % w
          if (wX< 0) wX = w + wX
          wY = nextY
          if (!eW.contains(Pair(wX, wY))) {
            wX = nextX
            wY = (nextY - t) % w
            if (wY < 0) wY = h + wY
            if (!nW.contains(Pair(wX, wY))) {
              wX = nextX
              wY = (nextY + t) % w
              if (!sW.contains(Pair(wX, wY))) {
          var downPath = mutableListOf<Pair<Int,Int>>()
          downPath.addAll(currPath)
          downPath.add(Pair(nextX, nextY))
          allPathNew.add(downPath)
              }
            }
          }
        }
      }

      // check wait
      nextX = currX
      nextY = currY
      if (true ) {
        wX = (nextX + t) % w
        wY = nextY 
        if (!wW.contains(Pair(wX, wY))) {
          wX = (nextX - t) % w
          if (wX< 0) wX = w + wX
          wY = nextY
          if (!eW.contains(Pair(wX, wY))) {
            wX = nextX
            wY = (nextY - t) % w
            if (wY < 0) wY = h + wY
            if (!nW.contains(Pair(wX, wY))) {
              wX = nextX
              wY = (nextY + t) % w
              if (!sW.contains(Pair(wX, wY))) {
          var downPath = mutableListOf<Pair<Int,Int>>()
          downPath.addAll(currPath)
          downPath.add(Pair(nextX, nextY))
          allPathNew.add(downPath)
              }
            }
          }
        }
      }

      
    }
    allPathNew = allPathNew.distinct().toMutableList()

    allPathNew.forEach {
      if (it.last() == xE ) {
        println(it)
        return (it.size)
      }
    }


    allPath.clear()
    allPath.addAll(allPathNew)

  }
  allPath.forEach{
    println(it)
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

