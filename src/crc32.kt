import java.util.zip.CRC32

// füge eine funktoin hinzu, die eine MD5 hash erzeugt
fun md5(input: String): String {
    val md = java.security.MessageDigest.getInstance("MD5")
    val byteArray = md.digest(input.toByteArray())
    return byteArray.joinToString("") {
        "%02x".format(it)
    }
}

// schreibe eine  Funktion die eine CRC32 berechnet
fun crc32(input: String): Long {
    val crc32 = CRC32()
    crc32.update(input.toByteArray())
    return crc32.value
}

// gebe die Werte aus
fun main() {
    for (i in 'A'..'Z') {
        val crc = crc32(i.toString())
        val hash = md5(i.toString())
        println("CRC32 of $i is $crc, MD5 Hash ist: $hash")
    }
}
