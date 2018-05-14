fun Int.squared() = this * this

class Squares constructor(naturalNumber: Int) {
    val number = naturalNumber
    fun squareOfSum():Int{
        return (1..number).sum().squared()
        //return (1..number).sum().let { it * it }
        //return (1..number).sum() * (1..number).sum()
    }
    fun sumOfSquares():Int{
        return (1..number).sumBy { it * it }
        //return (1..number).sumBy(Int::squared)
    }
    fun difference():Int {
        return this.squareOfSum() - sumOfSquares()
    }
}