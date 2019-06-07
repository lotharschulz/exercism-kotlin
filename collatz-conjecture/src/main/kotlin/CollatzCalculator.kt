object CollatzCalculator {
    fun computeStepCount(n: Int): Int {
        require(n > 0) { "Only natural numbers are allowed" }
        var (counter:Int, result:Int) = divideBy2(n)

        while (result != 1 && result.isOdd())   {
            counter++
            val (c, r) = divideBy2(result * 3 + 1)
            result = r
            counter += c
        }
        return counter
    }

    private fun divideBy2(n: Int): Pair<Int, Int> {
        var i = n
        var cntr = 0
        while (i != 1 && i%2 == 0){
            i /= 2
            cntr++
        }
        return Pair(cntr,i)
    }

    private fun Int.isOdd(): Boolean = (this % 2 != 0)
}

fun main(args: Array<String>): Unit {
    println(CollatzCalculator.computeStepCount(12))
}
