// comment added

import org.junit.Test
import org.junit.Assert.assertEquals

import java.util.zip.CRC32

class Crc32Tests {

    @Test
    fun testEmptyString() {
        val crc = crc32("")
        println("testEmptyString: expected: 0L, was: $crc")
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
