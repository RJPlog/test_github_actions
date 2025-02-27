import kotlin.math.*

fun fac(in1: Long): Long {
    if (in1 == 0L) return 1L
    else return in1 * fac(in1-1)
}

fun kOutOfn(n: Long, k: Long, p: Double): Double {
    var result = fac(n).toDouble()/(fac(k)*fac(n-k))
    result *= p.pow(k.toDouble())
    result *= (1-p).pow((n-k).toDouble())
    return result
}

fun main() {
    val hypothesis = listOf(0.0,0.1,0.15, 0.2, 0.25, 0.35, 0.4)
    var priori = mutableListOf<Double>()
    hypothesis.forEach{
        priori.add(1.0/hypothesis.size)
    }
    var sample = mutableListOf<Pair<Long,Long>>()
    sample.add(Pair(18L, 3L))
    sample.add(Pair(15L, 2L))
    sample.add(Pair(10L, 1L))
    sample.add(Pair(18L, 3L))
    sample.add(Pair(18L,3L))
   
    sample.forEach {
        var n = it.first
        var k = it.second
        var likelyhood = mutableListOf<Double>()
        var posteriori = mutableListOf<Double>()
        hypothesis.forEach {
            likelyhood.add(kOutOfn(n, k, it))
        }

        for (i in 0..likelyhood.size-1) {
            posteriori.add(priori[i] * likelyhood[i])
        }
        val norm = posteriori.sum()
        for (i in 0..posteriori.size-1) {
            posteriori[i] /= norm
        }
        println(posteriori)
        priori.clear()
        priori.addAll(posteriori)
    }
}
