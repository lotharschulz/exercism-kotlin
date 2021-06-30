import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import AffineCipher.findGreatestCommonDivisor
import AffineCipher.coprime
import AffineCipher.modularMultiplicativeInverse

class AffineCipherTest {

    @Test
    fun `encode yes`() = assertEquals("xbt", AffineCipher.encode("yes", 5, 7))

    @Test
    fun `encode no`() = assertEquals("fu", AffineCipher.encode("no", 15, 18))

    @Test
    fun `encode OMG`() = assertEquals("lvz", AffineCipher.encode("OMG", 21, 3))

    @Test
    fun `encode O M G`() = assertEquals("hjp", AffineCipher.encode("O M G", 25, 47))

    @Test
    fun `encode mindblowingly`() = assertEquals("rzcwa gnxzc dgt", AffineCipher.encode("mindblowingly", 11, 15))

    @Test
    fun `encode numbers`() = assertEquals("jqgjc rw123 jqgjc rw", AffineCipher.encode("Testing,1 2 3, testing.", 3, 4))

    @Test
    fun `encode deep thought`() = assertEquals("iynia fdqfb ifje", AffineCipher.encode("Truth is fiction.", 5, 17))

    @Test
    fun `encode all letters`() = assertEquals("swxtj npvyk lruol iejdc blaxk swxmh qzglf", AffineCipher.encode("The quick brown fox jumps over the lazy dog.", 17, 33))

    @Test
    fun `encode with a not coprime to m`() {
        assertFailsWith<IllegalArgumentException>("a and m must be coprime.") {
            AffineCipher.encode("This is a test.", 6, 17)
        }
    }

    @Test
    fun `decode exercism`() = assertEquals("exercism", AffineCipher.decode("tytgn fjr", 3, 7))

    @Test
    fun `decode a sentence`() = assertEquals("anobstacleisoftenasteppingstone", AffineCipher.decode("qdwju nqcro muwhn odqun oppmd aunwd o", 19, 16))

    @Test
    fun `decode numbers`() = assertEquals("testing123testing", AffineCipher.decode("odpoz ub123 odpoz ub", 25, 7))

    @Test
    fun `decode all the letters`() = assertEquals("thequickbrownfoxjumpsoverthelazydog", AffineCipher.decode("swxtj npvyk lruol iejdc blaxk swxmh qzglf", 17, 33))

    @Test
    fun `decode with no spaces in input`() = assertEquals("thequickbrownfoxjumpsoverthelazydog", AffineCipher.decode("swxtjnpvyklruoliejdcblaxkswxmhqzglf", 17, 33))

    @Test
    fun `decode with too many spaces`() = assertEquals("jollygreengiant", AffineCipher.decode("vszzm    cly   yd cg    qdp", 15, 16))

    @Test
    fun `decode with a not coprime to m`() {
        assertFailsWith<IllegalArgumentException>("a and m must be coprime.") {
            AffineCipher.decode("Test", 13, 5)
        }
    }

    @Test
    fun `greatest common divisor of 54 and 24`() {
        assertEquals(6, 54.findGreatestCommonDivisor(24))
    }

    @Test
    fun `12 and 77 a coprime`(){
        assertTrue(12.coprime(77))
        assertTrue(77.coprime(12))
    }

    @Test
    fun `15 and 25 are NOT coprime`(){
        assertFalse(15.coprime(25))
        assertFalse(25.coprime(15))
    }

    @Test
    fun `modular multiplicative inverse`(){
        assertEquals(23, 17.modularMultiplicativeInverse())
        assertEquals(9, 3.modularMultiplicativeInverse())
        assertEquals(11, 19.modularMultiplicativeInverse())
        assertEquals(7, 15.modularMultiplicativeInverse())
    }
}
