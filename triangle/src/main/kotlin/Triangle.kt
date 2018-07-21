class Triangle (x: Double, y: Double, z: Double) {
    constructor(x: Int, y: Int, z: Int) : this(x.toDouble(), y.toDouble(), z.toDouble())

    init {
//        println("x: $x, y: $y, z: $z")
//        println("$x + $y > $z: " + (x + y > z) )
        require(x > 0 && y > 0 && z > 0 )
            { "All three sides must be greater than 0, actually the side values are x: '$x', y: '$y', z: '$z'" }
        require(x + y > z && x + z > y && y + z > x )
            { "Two sides of the triangle must be greater than the third side, " +
                                                      "actually the side values are x: '$x', y: '$y', z: '$z'" }
    }

    val isEquilateral: Boolean = x == y && y == z
    val isIsosceles: Boolean = x == y || y == z || x == z
    val isScalene: Boolean = !isEquilateral && !isIsosceles
}