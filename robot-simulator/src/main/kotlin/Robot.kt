

class Robot(var gridPosition: GridPosition = GridPosition(0, 0), var orientation: Orientation = Orientation.NORTH) {

    fun simulate(instructions: String) {
        instructions.forEach { i ->
            when (i) {
                'R' -> turnRight()
                'L' -> print("L")
                'A' -> print("A")
                else -> print("error")
            }
        }
    }

    private fun turnRight() {
        orientation = Orientation.values()[(orientation.ordinal+1)%4]
    }
}
