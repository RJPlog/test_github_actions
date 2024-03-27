import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Md5Tests {
    @Test
    fun testEmptyString() {
        val hash = md5("")
        assertEquals("d41d8cd98f00b204e9800998ecf8427e", hash)
    }

    @Test
    fun testSingleCharacter() {
        val hash = md5("a")
        assertEquals("0cc175b9c0f1b6a831c399e269772661", hash)
    }

    @Test
    fun testMultipleCharacters() {
        val hash = md5("Hello, World!")
        assertEquals("65a8e27d8879283831b664bd8b7f0ad4", hash)
    }
}
