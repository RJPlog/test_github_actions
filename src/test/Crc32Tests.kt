import org.junit.Test
import org.junit.Assert.assertEquals

import java.util.zip.CRC32

class Crc32Tests {
    /*
    fun crc32(input: String): Long {
        val crc32 = CRC32()
        crc32.update(input.toByteArray())
        return crc32.value
    } */

    @Test
    fun testEmptyString() {
        val crc = crc32("")
        assertEquals(0L, crc)
    }

    @Test
    fun testSingleCharacter() {
        val crc = crc32("A")
        assertEquals(3554254475L, crc)
    }

    @Test
    fun testMultipleCharacters() {
        val crc = crc32("Hello, World!")
        assertEquals(3964322768L, crc)
    }
}
