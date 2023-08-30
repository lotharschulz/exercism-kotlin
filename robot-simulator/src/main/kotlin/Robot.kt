

class Robot(var gridPosition: GridPosition = GridPosition(0, 0), var orientation: Orientation = Orientation.NORTH) {

    fun simulate(instructions: String) {
        instructions.forEach { i ->
            when (i) {
                'R' -> turnRight()
                'L' -> turnLeft()
                'A' -> advance()
                else -> print("error")
            }
        }
    }

    private fun turnRight() =
        Orientation.values()[(orientation.ordinal + 1) % 4].also { orientation = it }

    private fun turnLeft() {
        orientation = if (orientation == Orientation.NORTH) {
            Orientation.WEST
        } else {
            Orientation.values()[(orientation.ordinal - 1)]
        }
    }

    private fun advance() {
        gridPosition =
            when (orientation) {
                Orientation.NORTH -> GridPosition(x = gridPosition.x, y = gridPosition.y + 1)
                Orientation.EAST -> GridPosition(x = gridPosition.x + 1, y = gridPosition.y)
                Orientation.SOUTH -> GridPosition(x = gridPosition.x, y = gridPosition.y - 1)
                Orientation.WEST -> GridPosition(x = gridPosition.x - 1, y = gridPosition.y)
            }
    }
}
