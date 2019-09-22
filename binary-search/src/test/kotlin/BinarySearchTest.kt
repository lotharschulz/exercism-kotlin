
import org.junit.Test
import kotlin.test.assertEquals

class BinarySearchTest {

    @Test
    fun findsTheItemInASingleElementList() {
        val inputList = listOf(6)
        val search = 6
        val expected = 0
        assertEquals(expected, BinarySearch.binSearchRecursive(inputList, search, 0, inputList.size))
        assertEquals(expected, BinarySearch.binSearchIterative(inputList, search))
    }

    @Test
    fun findsTheItemInTheMiddleOfAList() {
        val inputList = listOf(1, 3, 4, 6, 8, 9, 11)
        val search = 6
        val expected = 3
        assertEquals(expected, BinarySearch.binSearchRecursive(inputList, search, 0, inputList.size))
        assertEquals(expected, BinarySearch.binSearchIterative(inputList, search))
    }

    @Test
    fun findsTheItemAtTheBeginningOfAList() {
        val inputList = listOf(1, 3, 4, 6, 8, 9, 11)
        val search = 1
        val expected = 0
        assertEquals(expected, BinarySearch.binSearchRecursive(inputList, search, 0, inputList.size))
        assertEquals(expected, BinarySearch.binSearchIterative(inputList, search))
    }

    @Test
    fun findsTheItemAtTheEndOfAList() {
        val inputList = listOf(1, 3, 4, 6, 8, 9, 11)
        val search = 11
        val expected = 6
        assertEquals(expected, BinarySearch.binSearchRecursive(inputList, search, 0, inputList.size))
        assertEquals(expected, BinarySearch.binSearchIterative(inputList, search))
    }

    @Test
    fun findsValueInAListOfOddLength() {
        //assertEquals(9, BinarySearch.search(listOf(1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 634), 144))
        val inputList = listOf(1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 634)
        val search = 144
        val expected = 9
        assertEquals(expected, BinarySearch.binSearchRecursive(inputList, search, 0, inputList.size))
        assertEquals(expected, BinarySearch.binSearchIterative(inputList, search))
    }

    @Test
    fun findsValueInAListOfEvenLength() {
        val inputList = listOf(1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377)
        val search = 21
        val expected = 5
        assertEquals(expected, BinarySearch.binSearchRecursive(inputList, search, 0, inputList.size))
        assertEquals(expected, BinarySearch.binSearchIterative(inputList, search))
    }

    @Test
    fun identifiesThatAValueIsNotInTheList() {
        val inputList = listOf(1, 3, 4, 6, 8, 9, 11)
        val search = 7
        val expected = -1
        assertEquals(expected, BinarySearch.binSearchRecursive(inputList, search, 0, inputList.size))
        assertEquals(expected, BinarySearch.binSearchIterative(inputList, search))
    }

    @Test
    fun identifiesThatAValueSmallerThanTheSmallestListElementIsNotInTheList() {
        val inputList = listOf(1, 3, 4, 6, 8, 9, 11)
        val search = 0
        val expected = -1
        assertEquals(expected, BinarySearch.binSearchRecursive(inputList, search, 0, inputList.size))
        assertEquals(expected, BinarySearch.binSearchIterative(inputList, search))
    }

    @Test
    fun identifiesThatAValueLargerThanTheLargestListElementIsNotInTheList() {
        val inputList = listOf(1, 3, 4, 6, 8, 9, 11)
        val search = 13
        val expected = -1
        assertEquals(expected, BinarySearch.binSearchRecursive(inputList, search, 0, inputList.size))
        assertEquals(expected, BinarySearch.binSearchIterative(inputList, search))
    }

    @Test
    fun identifiesThatNothingCanBeFoundInAnEmptyList() {
        val inputList = emptyList<Int>()
        val search = 1
        val expected = -1
        assertEquals(expected, BinarySearch.binSearchRecursive(inputList, search, 0, inputList.size))
        assertEquals(expected, BinarySearch.binSearchIterative(inputList, search))
    }

}
