import kotlin.system.measureNanoTime

object CollatzCalculator {

    fun computeStepCount(num: Int): Int {
        require(num >= 1) { "Only natural numbers are allowed" }
        return generateSequence(num) { n -> if (n.isOdd()) n * 3 + 1 else n / 2 }.indexOf(1)
    }
    private fun Int.isOdd(): Boolean = this.rem(2) != 0

    fun computeStepCount_alt(num: Int): Int {
        require(num > 0) { "Only natural numbers are allowed" }
        var result:Int = num
        var counter = 0

        while (result > 1){
            if (result.isOdd()){
                result = 3 * result +1
            }else{
                result /= 2
            }
            counter++
        }
        return counter
    }
}

fun main(args: Array<String>): Unit {
    // warm up
    CollatzCalculator.computeStepCount(500)
    CollatzCalculator.computeStepCount_alt(500)

    val n1 = 12
    println("computeStepCount($n1) takes ' ${measureNanoTime { CollatzCalculator.computeStepCount(n1) }} ' nano seconds.")
    println("computeStepCount_alt($n1) takes ' ${measureNanoTime { CollatzCalculator.computeStepCount_alt(n1) }} ' nano seconds.")
    val n2 = 16
    println("computeStepCount($n2) takes ' ${measureNanoTime { CollatzCalculator.computeStepCount(n2) }} ' nano seconds.")
    println("computeStepCount_alt($n2) takes ' ${measureNanoTime { CollatzCalculator.computeStepCount_alt(n2) }} ' nano seconds.")
    val n3 = 2000000000
    println("computeStepCount($n3) takes ' ${measureNanoTime { CollatzCalculator.computeStepCount(n3) }} ' nano seconds.")
    println("computeStepCount_alt($n3) takes ' ${measureNanoTime { CollatzCalculator.computeStepCount_alt(n3) }} ' nano seconds.")
}
