import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class ArmstrongNumberTest {

    @Test
    fun `zero is an armstrong number`() = assertTrue(ArmstrongNumber.check(0))

    @Test
    fun `single digit numbers are armstrong numbers`() = assertTrue(ArmstrongNumber.check(5))

    @Test
    fun `there are no 2 digit armstrong numbers`() = assertFalse(ArmstrongNumber.check(10))

    @Test
    fun `three digit number that is an armstrong number`() = assertTrue(ArmstrongNumber.check(153))

    @Test
    fun `three digit number that is not an armstrong number`() = assertFalse(ArmstrongNumber.check(100))

    @Test
    fun `four digit number that is an armstrong number`() = assertTrue(ArmstrongNumber.check(9474))

    @Test
    fun `four digit number that is not an armstrong number`() = assertFalse(ArmstrongNumber.check(9475))

    @Test
    fun `seven digit number that is an armstrong number`() = assertTrue(ArmstrongNumber.check(9926315))

    @Test
    fun `seven digit number that is not an armstrong number`() = assertFalse(ArmstrongNumber.check(9926314))

    @Test
    fun `test getDigitsRecursive`() {
        assertEquals(listOf(5, 8, 3, 7), ArmstrongNumber.getDigitsRecursive(5837))
        assertEquals(listOf(4, 3, 2, 1), ArmstrongNumber.getDigitsRecursive(4321))
        assertEquals(listOf<Int>(), ArmstrongNumber.getDigitsRecursive(-1))
        assertEquals(listOf<Int>(0), ArmstrongNumber.getDigitsRecursive(0))
    }

    @Test
    fun `test getDigitsRecursiveAcc`() {
        val digits1 = listOf(5, 8, 3, 7)
        val result1 = mutableListOf<Int>()
        ArmstrongNumber.getDigitsRecursiveAcc(5837, result1)
        assertEquals(digits1, result1.toList())
        val digits2 = listOf<Int>()
        val result2 = mutableListOf<Int>()
        ArmstrongNumber.getDigitsRecursiveAcc(0, result2)
        assertEquals(digits2, result2.toList())
        val result3 = mutableListOf<Int>()
        ArmstrongNumber.getDigitsRecursiveAcc(-1, result3)
        assertEquals(digits2, result3.toList())
    }

    @Test
    fun `test getNumberOfDigitsLog`() {
        val one = 1
        assertEquals(one, ArmstrongNumber.getNumberOfDigitsLog(0))
        assertEquals(one, ArmstrongNumber.getNumberOfDigitsLog(1))
        assertEquals(one, ArmstrongNumber.getNumberOfDigitsLog(-1))
        assertEquals(4, ArmstrongNumber.getNumberOfDigitsLog(1243))
        assertEquals(6, ArmstrongNumber.getNumberOfDigitsLog(100000))
    }
}
