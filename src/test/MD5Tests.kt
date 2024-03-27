import org.junit.Test
import org.junit.Assert.assertEquals

class Md5Tests {
    fun md5(input: String): String {
        val md = java.security.MessageDigest.getInstance("MD5")
        val byteArray = md.digest(input.toByteArray())
        return byteArray.joinToString("") {
            "%02x".format(it)
        }
    }
    
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
