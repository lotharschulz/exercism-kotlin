data class Item(val weight: Int, val value: Int)

fun knapsack(maximumWeight: Int, items: List<Item>): Int {
    if (maximumWeight == 0) return 0
    var maxValue = 0
    items.filter { it.weight <= maximumWeight }.forEach { item ->
        val subList = items.remove(item)
        val attempt = item.value + knapsack(maximumWeight - item.weight, subList)
        maxValue = maxOf(maxValue, attempt)
    }
    return maxValue
}

fun <T> List<T>.remove(item: T): List<T> {
    val l = this.toMutableList()
    l.remove(item)
    return l.toList()
}