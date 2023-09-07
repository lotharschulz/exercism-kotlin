class BinarySearchTree<T : Comparable<T>> {

    data class Node<T>(val data: T, val left: Node<T>? = null, val right: Node<T>? = null)

    var root: Node<T>? = null

    fun insert(value: T) {
        root = root?.insert(value) ?: Node(value)
    }

    private fun Node<T>.insert(value: T): Node<T> = when {
        value <= this.data -> this.copy(left = this.left?.insert(value) ?: Node(value))
        else -> this.copy(right = this.right?.insert(value) ?: Node(value))
    }

    fun asSortedList(): List<T> {
        TODO("Delete this statement and write your own implementation.")
    }

    fun asLevelOrderList(): List<T> {
        TODO("Delete this statement and write your own implementation.")
    }
}