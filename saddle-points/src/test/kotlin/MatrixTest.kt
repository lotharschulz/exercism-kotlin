
import org.junit.Test
import java.util.Collections.emptySet
import kotlin.test.assertEquals

class MatrixTest {

    @Test
    fun testCanIdentifySingleSaddlePoint() {
        val matrix = Matrix(listOf(
            listOf(9, 8, 7),
            listOf(5, 3, 2),
            listOf(6, 6, 7)
        ))

        val expectedSaddlePoints = setOf(MatrixCoordinate(1, 0))

        assertEquals(expectedSaddlePoints, matrix.saddlePoints)
    }

    @Test
    fun testCanIdentifyThatEmptyMatrixHasNoSaddlePoints() {
        val matrix = Matrix(listOf(emptyList()))

        val expectedSaddlePoints = emptySet<MatrixCoordinate>()

        assertEquals(expectedSaddlePoints, matrix.saddlePoints)
    }

    @Test
    fun testCanIdentifyLackOfSaddlePointsWhenThereAreNone() {
        val matrix = Matrix(listOf(
            listOf(1, 2, 3),
            listOf(3, 1, 2),
            listOf(2, 3, 1)
        ))

        val expectedSaddlePoints = emptySet<MatrixCoordinate>()

        assertEquals(expectedSaddlePoints, matrix.saddlePoints)
    }

    @Test
    fun testCanIdentifyMultipleSaddlePoints() {
        val matrix = Matrix(listOf(
            listOf(4, 5, 4),
            listOf(3, 5, 5),
            listOf(1, 5, 4)
        ))

        val expectedSaddlePoints = setOf(
            MatrixCoordinate(0, 1),
            MatrixCoordinate(1, 1),
            MatrixCoordinate(2, 1)
        )

        assertEquals(expectedSaddlePoints, matrix.saddlePoints)
    }

    @Test
    fun testCanIdentifySaddlePointInBottomRightCorner() {
        val matrix = Matrix(listOf(
            listOf(8, 7, 9),
            listOf(6, 7, 6),
            listOf(3, 2, 5)
        ))

        val expectedSaddlePoints = setOf(MatrixCoordinate(2, 2))

        assertEquals(expectedSaddlePoints, matrix.saddlePoints)
    }

    @Test
    fun testIndentifySaddlePoints(){
        val m = listOf(
                listOf(4, 5, 4),
                listOf(3, 5, 5),
                listOf(1, 5, 4)
        )

        val matrix = Matrix(m)

        val expectedSaddlePoints = setOf(
                MatrixCoordinate(0, 1),
                MatrixCoordinate(1, 1),
                MatrixCoordinate(2, 1)
        )

        assertEquals(expectedSaddlePoints, matrix.indentifySaddlePoints(setOf(5), m, listOf(5, 5, 5), listOf(1, 5, 4)))
    }

    @Test(expected = IllegalArgumentException::class)
    fun testEmptyIndentifySaddlePoints(){
        val m = listOf(emptyList<Int>())
        val matrix = Matrix(m)
        val expectedSaddlePoints:Set<MatrixCoordinate> = emptySet()
        assertEquals(expectedSaddlePoints, matrix.indentifySaddlePoints(emptySet(), m, emptyList(), emptyList()))
    }

    @Test
    fun testTransposeQuadraticMatrix(){
        val matrix = Matrix(listOf(emptyList()))

        val m: List<List<Int>> = listOf(
                listOf(8, 7, 9),
                listOf(6, 7, 6),
                listOf(3, 2, 5)
        )

        val expectedTransposedMatrix: List<List<Int>> = listOf(
                listOf(8, 6, 3),
                listOf(7, 7, 2),
                listOf(9, 6, 5)
        )

        assertEquals(expectedTransposedMatrix, matrix.transposeQuadraticMatrix(m))
    }

    @Test
    fun testTransposeSameQuadraticMatrix(){
        val matrix = Matrix(listOf(emptyList()))

        val m: List<List<Int>> = listOf(
                listOf(0, 0, 0),
                listOf(0, 0, 0),
                listOf(0, 0, 0)
        )

        assertEquals(m, matrix.transposeQuadraticMatrix(m))
    }

    @Test(expected = IllegalArgumentException::class)
    fun nonQuadraticMatrixAreIllegalForQuadraticTranspose(){
        val matrix = Matrix(listOf(emptyList()))

        val m: List<List<Int>> = listOf(
                listOf(8),
                listOf(6, 7)
        )

        val expectedTransposedMatrix: List<List<Int>> = listOf(emptyList())

        assertEquals(expectedTransposedMatrix, matrix.transposeQuadraticMatrix(m))
    }

    @Test(expected = IllegalArgumentException::class)
    fun listOfEmptyMatrixIsIllegalForQuadraticTranspose(){
        val matrix = Matrix(listOf(emptyList()))

        val m: List<List<Int>> = listOf(emptyList())

        val expectedTransposedMatrix: List<List<Int>> = listOf(emptyList())

        assertEquals(expectedTransposedMatrix, matrix.transposeQuadraticMatrix(m))
    }

    @Test(expected = IllegalArgumentException::class)
    fun emptyMatrixIsIllegalForQuadraticTranspose(){
        val matrix = Matrix(listOf(emptyList()))

        val m: List<List<Int>> = emptyList()

        val expectedTransposedMatrix: List<List<Int>> = listOf(emptyList())

        assertEquals(expectedTransposedMatrix, matrix.transposeQuadraticMatrix(m))
    }



}
