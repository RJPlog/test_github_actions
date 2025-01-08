import kotlin.math*

fun fac(in1: Int): Int {
    if (in1 == 0) return 1
    else return in1 * fac(in1-1)
}

fun kOutOfn(k: Int, n: Int), p: Double): Double {
    return fac(n).toDouble()/(fac(k)*fac(n-k)) * p.pow(k.toDouble) * (1-p).pow((n-k).toDouble())
}

fun main() {
  var n = 60
  var k = 10
	for (i in 0..1) {
        println("$i: ${kOutOfn(n, k, i.toDouble/10}")
    }
}
