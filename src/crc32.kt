import java.util.zip.CRC32

// schreibe eine  Funktion die eine CRC32 berechnet
fun crc32(input: String): Long {
    val crc32 = CRC32()
    crc32.update(input.toByteArray())
    return crc32.value
}

fun main() {
    for (i in 'A'..'Z') {
        val crc = crc32(i.toString())
        println("CRC32 of $i is $crc")
    }
}
